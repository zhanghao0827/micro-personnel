package com.easyhao.micro.personnel.controller;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class WeChatController {

    @Autowired
    ISysUserService userService;

    @GetMapping("/users")
    public List<SysUser> list(){
        return userService.selectUsersExceptSelf();
    }
}
