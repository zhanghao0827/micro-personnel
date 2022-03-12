package com.easyhao.micro.personnel.controller.log;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.easyhao.micro.personnel.entity.LogLogin;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ILogLoginService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.utils.ip.IPv4ToLocationUtils;
import com.easyhao.micro.personnel.utils.ip.IPv4Utils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/log/login")
public class LogLoginController {

    @Autowired
    ILogLoginService loginService;

    @GetMapping("/")
    public List<LogLogin> loginList() {
        return loginService.selectLoginList();
    }

    @PostMapping("/")
    public JsonResult insert(HttpServletRequest request) {
        LogLogin login = new LogLogin();
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        // 获取客户端操作系统
        OperatingSystem os = userAgent.getOperatingSystem();
        String osName = os.getName();
        // 获取客户端浏览器
        Browser browser = userAgent.getBrowser();
        String browserName = browser.getName();
        if ("Chrome".equals(browser.getName())) {
            if (header.indexOf("QQBrowser") > 0) {
                browserName = "QQBrowser";
            }
        }
        login.setBrowser(browserName);
        login.setOs(osName);

        //获取IP和location
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        login.setUserName(user.getUserName());
        String ipv4;
        String cityInfo;
        try {
            ipv4 = IPv4Utils.getIPv4();
        } catch (Exception e) {
            return JsonResult.error("网络连接异常,获取IP失败！");
        }
        try {
            cityInfo = IPv4ToLocationUtils.getLocation(ipv4);
        } catch (Exception e) {
            return JsonResult.error("网络连接异常,定位失败！");
        }
        login.setIp(ipv4);
        login.setLocation(cityInfo);
        if (loginService.insertLogin(login) == 1) {
            return JsonResult.success("登录日志已保存！");
        }
        return JsonResult.error("登录日志保存失败！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportExcel() {
        List<LogLogin> loginList = loginService.selectLoginList();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), LogLogin.class, loginList);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("登录日志列表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
}
