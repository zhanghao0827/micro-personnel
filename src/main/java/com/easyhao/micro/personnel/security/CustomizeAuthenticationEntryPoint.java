package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.utils.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(401);
        PrintWriter out = response.getWriter();
        JsonResult error = JsonResult.error("访问失败!");
        if (e instanceof InsufficientAuthenticationException) {
            error.setMsg("请求失败，请登录或联系管理员！");
        }
        String json = new ObjectMapper().writeValueAsString(error);
        out.write(json);
        out.flush();
        out.close();
    }
}
