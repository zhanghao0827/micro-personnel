package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysRoleService;
import com.easyhao.micro.personnel.service.ISysUserRoleService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    ISysRoleService roleService;

    @Autowired
    ISysUserRoleService userRoleService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        SysUser user = (SysUser) authentication.getPrincipal();
        //如果把密码设为空，那么(SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal().getPassword(),也为空
        //使用@JsonIgnore
//        user.setPassword(null);
        JsonResult ajaxResult = JsonResult.success("登录成功！", user);
        String json = new ObjectMapper().writeValueAsString(ajaxResult);
        out.write(json);
        out.flush();
        out.close();
    }
}
