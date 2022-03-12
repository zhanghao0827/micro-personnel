package com.easyhao.micro.personnel.controller;

import com.easyhao.micro.personnel.entity.SysMenu;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysMenuService;
import com.easyhao.micro.personnel.service.ISysUserService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.utils.FastDFSUtils;
import com.easyhao.micro.personnel.utils.bean.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 只要用户认证就可以访问接口
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${nginx.host}")
    String nginxHost;

    @Autowired
    ISysUserService userService;

    @Autowired
    ISysMenuService menuService;

    @GetMapping("/hello")
    public void hello(Authentication authentication) {
        System.out.println((SysUser) authentication.getPrincipal());
        System.out.println(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @GetMapping("/menu")
    public List<SysMenu> menu() {
        return menuService.selectMenusByUserId();
    }

    @PostMapping("/avatar")
    public JsonResult updateUserAvatar(MultipartFile file, Authentication authentication) {
        SysUser user = (SysUser) authentication.getPrincipal();
        String fileId = FastDFSUtils.upload(file);
        String url = nginxHost + fileId;  //文件访问路径
        user.setAvatar(url);
        if (userService.updateUserAvatar(user) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities()));
            return JsonResult.success("头像更新成功！", url);
        }
        return JsonResult.error("头像更新失败！");
    }

    @GetMapping("/avatar")
    public JsonResult getAvatar(Authentication authentication) {
        SysUser user = (SysUser) authentication.getPrincipal();
        if (user != null) {
            return JsonResult.success("头像更新成功！", user.getAvatar());
        }
        return JsonResult.error("头像更新失败！");
    }

    @PutMapping("/password")
    public JsonResult updatePassword(@RequestBody PasswordBean password) {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //1.校验原始密码
        if (!passwordEncoder.matches(password.getOriginalPassword(), user.getPassword())) {
            return JsonResult.error("原始密码错误！");
        }
        //2.检验确认密码
        String newPassword = passwordEncoder.encode(password.getNewPassword());
        if (!passwordEncoder.matches(password.getConfirmPassword(), newPassword)) {
            return JsonResult.error("密码不一致！");
        }
        user.setPassword(newPassword);
        if (userService.updateUserPassword(user) == 1) {
            return JsonResult.success("密码修改成功,请重新登录！");
        }
        return JsonResult.error("密码修改失败！");
    }


}
