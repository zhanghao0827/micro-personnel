package com.easyhao.micro.personnel.quartz;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

public class SentEmailJob extends QuartzJobBean {

    /**
     * <b>这个类并不是Spring工厂所管理(实例化)的，不能直接注入@Autowired</b>
     * 注意不能直接用@Autowired注入ISysUserService
     * 需要提供对应的setter方法，在JobDetailFactoryBean中传入
     */
    ISysUserService userService;

    JavaMailSender javaMailSender;

    public void setUserService(ISysUserService userService) {
        this.userService = userService;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<SysUser> users = userService.selectUsersByPasswordExpired();
        for (SysUser user : users) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("785896760@qq.com");
            message.setTo(user.getEmail());
            message.setSubject("微人事网站温馨提示");
            message.setText("尊敬的" + user.getNickName() + "：您的账号:" + user.getUserName() + ",已经超过一个月没有修改密码，为了您的账号安全请及时修改密码！");
            message.setSentDate(new Date());
            javaMailSender.send(message);
        }
    }
}
