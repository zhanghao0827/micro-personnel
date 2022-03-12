package com.easyhao.micro.personnel.controller.sys;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysUserRoleService;
import com.easyhao.micro.personnel.service.ISysUserService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    ISysUserService userService;

    @Autowired
    ISysUserRoleService userRoleService;


    @GetMapping("/")
    public List<SysUser> userWithRole() {
        return userService.selectUserCollectionRole();
    }

    @PostMapping("/")
    @Log(module = "用户管理",operContent = "添加")
    public JsonResult insert(@RequestBody SysUser user) {
        System.out.println("user = " + user);
        if (userService.insertUser(user) == 1) {
            return JsonResult.success("用户添加成功！");
        }
        return JsonResult.error("用户添加失败！");
    }

    @PutMapping("/user_role")
    @Log(module = "角色管理",operContent = "更新用户对应角色")
    public JsonResult updateUserRole(Long userId, Long[] roleIds) {
        if (userRoleService.updateUserRole(userId, roleIds)) {
            return JsonResult.success("用户角色更新成功！");
        }
        return JsonResult.error("用户角色更新失败！");
    }

    @PutMapping("/enabled")
    @Log(module = "用户管理",operContent = "更新角色状态")
    public JsonResult updateUserEnabled(@RequestBody SysUser user) {
        if (userService.updateUserEnabled(user) == 1) {
            return JsonResult.success("用户状态更新成功！");
        }
        return JsonResult.error("用户状态更新失败！");
    }

    @GetMapping("/info")
    public SysUser info(Authentication authentication) {
        return ((SysUser) authentication.getPrincipal());
    }


}
