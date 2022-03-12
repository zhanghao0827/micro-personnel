package com.easyhao.micro.personnel.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class LogOper {

    private Long operId;
    private String operModule;
    private String operContent;
    private String userName;
    private String operIp;
    private String operLocation;
    private String operStatus;
    private Timestamp operTime;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperModule() {
        return operModule;
    }

    public void setOperModule(String operModule) {
        this.operModule = operModule;
    }

    public String getOperContent() {
        return operContent;
    }

    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        return "LogOper{" +
                "operId=" + operId +
                ", operModule='" + operModule + '\'' +
                ", operContent='" + operContent + '\'' +
                ", userName='" + userName + '\'' +
                ", operIp='" + operIp + '\'' +
                ", operLocation='" + operLocation + '\'' +
                ", operStatus='" + operStatus + '\'' +
                ", operTime=" + operTime +
                '}';
    }
}
