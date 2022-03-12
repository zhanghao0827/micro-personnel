package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.utils.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        JsonResult error = JsonResult.error(e.getMessage());//验证码错误！
        if (e instanceof LockedException) {
            error.setMsg("账户被锁定,请联系管理员");
        } else if (e instanceof CredentialsExpiredException) {
            error.setMsg("密码过期,请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            error.setMsg("账户过期,请联系管理员");
        } else if (e instanceof DisabledException) {
            error.setMsg("账户被禁用,请联系管理员");
        } else if (e instanceof BadCredentialsException) {
            error.setMsg("用户名或密码错误,请重新输入！");
        }
        String json = new ObjectMapper().writeValueAsString(error);
        out.write(json);
        out.flush();
        out.close();
    }
}
