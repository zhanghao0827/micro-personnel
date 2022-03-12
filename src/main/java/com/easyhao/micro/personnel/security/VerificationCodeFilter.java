package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.utils.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class VerificationCodeFilter extends GenericFilter {

    private static final long serialVersionUID = -5838487760053785952L;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if ("POST".equals(request.getMethod()) && "/doLogin".equals(request.getServletPath())) {
            //登录请求
            String code = request.getParameter("code");
            String verifyCode = (String) request.getSession().getAttribute("verify_code");
            if (verifyCode == null || code == null || "".equals(code) || !verifyCode.equalsIgnoreCase(code)) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(new ObjectMapper().writeValueAsString(JsonResult.error("验证码错误！")));
                out.flush();
                out.close();
                return;
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
