package com.easyhao.micro.personnel.controller.ser;

import com.easyhao.micro.personnel.entity.SerEmail;
import com.easyhao.micro.personnel.service.ISerEmailService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ser/email")
public class SerEmailController {

    @Autowired
    ISerEmailService emailService;

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/")
    @Log(module = "邮箱服务",operContent = "添加")
    public JsonResult insert(@RequestBody SerEmail email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("785896760@qq.com");
        message.setTo(email.getAddressee());
        message.setSubject(email.getEmailSubject());
        message.setText(email.getEmailText());
        message.setSentDate(new Date());
        try {
            javaMailSender.send(message);
            if (emailService.insertEmail(email) == 1) {
                return JsonResult.success("邮件发送成功,记录成功！");
            } else {
                return JsonResult.error("记录邮件失败！");
            }
        } catch (MailException e) {
            return JsonResult.error("邮件发送失败！");
        }
    }

    @GetMapping("/")
    public List<SerEmail> list() {
        return emailService.selectEmailList();
    }

    @DeleteMapping("/{emailId}")
    @Log(module = "邮箱服务",operContent = "删除")
    public JsonResult delete(@PathVariable Long emailId) {
        if (emailService.deleteEmailById(emailId) == 1) {
            return JsonResult.success("删除邮件成功！");
        }
        return JsonResult.error("删除邮件失败！");
    }
}
