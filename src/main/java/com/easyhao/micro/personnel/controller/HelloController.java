package com.easyhao.micro.personnel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/sys/user/hello")
    public String sysUserHello() {
        return "sysUserHello";
    }

    @GetMapping("/sys/role/hello")
    public String sysRoleHello() {
        return "sysRoleHello";
    }

    @GetMapping("/sys/menu/hello")
    public String sysMenuHello() {
        return "sysMenuHello";
    }

    @GetMapping("/sys/emp/hello")
    public String sysEmpHello() {
        return "sysEmpHello";
    }

    @GetMapping("/serve/task/hello")
    public String serveTaskHello() {
        return "serveTaskHello";
    }

    @GetMapping("/serve/notice/hello")
    public String serveNoticeHello() {
        return "serveNoticeHello";
    }

    @GetMapping("/log/login/hello")
    public String logLoginHello() {
        return "logLoginHello";
    }

    @GetMapping("/log/oper/hello")
    public String logOperHello() {
        return "logOperHello";
    }
}
