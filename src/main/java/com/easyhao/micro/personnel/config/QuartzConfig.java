package com.easyhao.micro.personnel.config;

import com.easyhao.micro.personnel.quartz.SentEmailJob;
import com.easyhao.micro.personnel.service.ISysUserService;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Autowired
    ISysUserService userService;

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 配置任务
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        JobDataMap map = new JobDataMap();
        map.put("userService", userService);
        map.put("javaMailSender", javaMailSender);
        bean.setJobDataMap(map);
        bean.setJobClass(SentEmailJob.class);
        return bean;
    }

    /**
     * 配置触发器
     */
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        bean.setCronExpression("0 14 10 * * ?");
        return bean;
    }

    /**
     * 配置调度器
     */
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerFactoryBean().getObject());
        return bean;
    }
}
