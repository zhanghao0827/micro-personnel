package com.easyhao.micro.personnel.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysUserRoleService;
import com.easyhao.micro.personnel.service.ISysUserService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.utils.bean.RegisterBean;
import com.easyhao.micro.personnel.utils.sms.CodeUtils;
import com.easyhao.micro.personnel.utils.sms.SendSms;
import com.easyhao.micro.personnel.utils.sms.SmsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class IgnoreController {

    @Autowired
    ISysUserService userService;

    @Autowired
    ISysUserRoleService userRoleService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(112, 36, 4, 30);
        String code = captcha.getCode();
        System.out.println("code = " + code);
        request.getSession().setAttribute("verify_code", code);
        captcha.write(response.getOutputStream());
    }

    @GetMapping("/sms")
    public JsonResult sms(String photo) {
        String code = CodeUtils.getCode();
        SmsBean smsBean = SendSms.sendSms(photo, code);
        if ("OK".equals(smsBean.getCode())) {
            stringRedisTemplate.opsForValue().set("code", code, 60, TimeUnit.SECONDS);
            return JsonResult.success("验证码发送成功！");
        }
        return JsonResult.error("验证码发送失败！");
    }

    @PostMapping("/register")
    public JsonResult insertUser(@RequestBody RegisterBean register) {
        String code = stringRedisTemplate.opsForValue().get("code");
        if (code == null) {
            return JsonResult.error("验证码已失效，请重新发送！");
        }
        if (!code.equals(register.getCode())) {
            return JsonResult.error("验证码错误！");
        }
        SysUser user = new SysUser();
        user.setUserName(register.getUserName());
        user.setNickName(register.getNickName());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        user.setPhone(register.getPhone());
        if (userService.insertUser(user) == 1) {
            Long[] roleIds = {1L};
            userRoleService.insertUserRole(user.getUserId(), roleIds);
            return JsonResult.success("注册成功！");
        } else {
            return JsonResult.error("注册失败！");
        }
    }

}
