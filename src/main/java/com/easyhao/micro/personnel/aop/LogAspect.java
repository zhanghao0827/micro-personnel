package com.easyhao.micro.personnel.aop;


import com.easyhao.micro.personnel.entity.LogOper;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ILogOperService;
import com.easyhao.micro.personnel.utils.ip.IPv4ToLocationUtils;
import com.easyhao.micro.personnel.utils.ip.IPv4Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Autowired
    ILogOperService operService;

    /**
     * 统一定义切点
     */
    @Pointcut("@annotation(com.easyhao.micro.personnel.aop.Log)")
    public void logPointCut() {
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint) throws Exception {
        Log log = getLog(joinPoint);
        LogOper oper = saveOper(log, "成功");
        operService.insertOper(oper);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) throws Exception {
        Log log = getLog(joinPoint);
        LogOper oper = saveOper(log, "失败");
        operService.insertOper(oper);
    }

    public static Log getLog(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    return method.getAnnotation(Log.class);
                }
            }
        }
        return null;
    }

    public static LogOper saveOper(Log log, String status) throws Exception {
        LogOper oper = new LogOper();
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (log != null) {
            oper.setOperModule(log.module());
            oper.setOperContent(log.operContent());
            oper.setUserName(user.getUserName());
            oper.setOperStatus(status);
            oper.setOperIp(IPv4Utils.getIPv4());
            oper.setOperLocation(IPv4ToLocationUtils.getLocation(IPv4Utils.getIPv4()));
        }
        return oper;
    }
}
