package com.easyhao.micro.personnel;

import com.easyhao.micro.personnel.entity.LogLogin;
import com.easyhao.micro.personnel.entity.SerEmail;
import com.easyhao.micro.personnel.entity.SysMenu;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.mapper.SysUserMapper;
import com.easyhao.micro.personnel.service.impl.LogLoginServiceImpl;
import com.easyhao.micro.personnel.service.impl.SysMenuServiceImpl;
import com.easyhao.micro.personnel.service.ISerEmailService;
import com.easyhao.micro.personnel.service.ISerNoticeService;
import com.easyhao.micro.personnel.service.ISysUserService;
import com.easyhao.micro.personnel.utils.ip.IPv4ToLocationUtils;
import com.easyhao.micro.personnel.utils.ip.IPv4Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class MicroPersonnelApplicationTests {

    @Autowired
    SysMenuServiceImpl menuService;

    @Autowired
    LogLoginServiceImpl loginService;

    @Test
    void contextLoads() {
        List<SysMenu> menus = menuService.selectMenuCollectionRole();
        for (SysMenu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    public void test() {
        LogLogin logLogin = new LogLogin();
        logLogin.setUserName("张昊");
        logLogin.setIp("127.0.0.1");
        logLogin.setLocation("江苏徐州");
        int i = loginService.insertLogin(logLogin);
        System.out.println(i);
    }

    @Test
    public void test1() {
        System.out.println(new Date(System.currentTimeMillis()));
    }

    @Test
    public void test2() {
        List<LogLogin> logLogins = loginService.selectLoginList();
        for (LogLogin logLogin : logLogins) {
            System.out.println(logLogin);
        }
    }

    @Test
    public void test3() throws Exception {
        String cityInfo = IPv4ToLocationUtils.getLocation("223.107.53.63");
        System.out.println(cityInfo);
    }

    @Test
    public void test4() throws Exception {
        String ipv4 = IPv4Utils.getIPv4();
        System.out.println(ipv4);
        String cityInfo = IPv4ToLocationUtils.getLocation(ipv4);
        System.out.println(cityInfo);
    }

    @Test
    public void test5() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean b = passwordEncoder.matches("1234", "$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe");
        System.out.println(b);
    }

    @Autowired
    ISerNoticeService noticeService;

    @Autowired
    ISerEmailService emailService;

    @Test
    public void test7() {
        List<SerEmail> emails = emailService.selectEmailList();
        for (SerEmail email : emails) {
            System.out.println(email);
        }
    }

    @Autowired
    ISysUserService userService;

    @Test
    public void test8() {
        List<SysUser> users = userService.selectUsersByPasswordExpired();
        for (SysUser user : users) {
            System.out.println(user);
        }
    }

    @Autowired
    SysUserMapper userMapper;

    @Test
    public void test9() {
        SysUser user = new SysUser();
        user.setUserName("xiaowang");
        user.setNickName("小王");
        user.setPassword("123");
        user.setEmail("818818@qq.com");
        user.setPhone("18114970827");
        userMapper.insertUser(user);
        System.out.println("user = " + user);
    }
}
