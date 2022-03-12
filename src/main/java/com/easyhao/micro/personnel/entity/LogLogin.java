package com.easyhao.micro.personnel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

@ExcelTarget("LogLogin")
public class LogLogin implements Serializable {

    private static final long serialVersionUID = -5588167060347624506L;

    @Excel(name = "编号")
    private Long loginId;

    @Excel(name = "用户名称",width = 20)
    private String userName;

    @Excel(name = "登录IP",width = 20)
    private String ip;

    @Excel(name = "登录地点",width = 20)
    private String location;

    @Excel(name = "浏览器",width = 20)
    private String browser;

    @Excel(name = "操作系统",width = 20)
    private String os;

    @Excel(name = "登录时间", format = "yyyy-MM-dd HH:mm:ss", width = 30)
    private Timestamp loginTime;

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LogLogin{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", ip='" + ip + '\'' +
                ", location='" + location + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
