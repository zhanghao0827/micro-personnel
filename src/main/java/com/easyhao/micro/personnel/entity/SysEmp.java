package com.easyhao.micro.personnel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@ExcelTarget("SysEmp")
public class SysEmp implements Serializable {

    private static final long serialVersionUID = 1686636778395502136L;

    @Excel(name = "员工编号")
    private Long empId;

    @ExcelIgnore
    private Long deptId;

    @Excel(name = "员工姓名")
    private String empName;

    @ExcelEntity
    private SysDept dept;

    @Excel(name = "性别")
    private String gender;

    @Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20)
    private Date birthday;

    @Excel(name = "籍贯", width = 20)
    private String nativePlace;

    @Excel(name = "民族")
    private String nation;

    @Excel(name = "身份证号码", width = 30)
    private String idCard;

    @Excel(name = "手机号码", width = 20)
    private String phone;

    @Excel(name = "邮箱", width = 25)
    private String email;

    @Excel(name = "学位")
    private String degree;

    @Excel(name = "职位", width = 20)
    private String position;

    @Excel(name = "任职时间", format = "yyyy-MM-dd", width = 20)
    private Date workTime;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss", width = 25)
    private Timestamp createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss", width = 25)
    private Timestamp updateTime;

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysEmp{" +
                "empId=" + empId +
                ", deptId=" + deptId +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", nativePlace='" + nativePlace + '\'' +
                ", nation='" + nation + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", workTime=" + workTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
