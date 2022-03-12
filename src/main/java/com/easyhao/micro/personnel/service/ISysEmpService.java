package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SysEmp;

import java.util.List;

public interface ISysEmpService {

    List<SysEmp> selectEmpList(SysEmp emp);

    int deleteEmpById(Long empId);

    int insertEmp(SysEmp emp);

    int updateEmp(SysEmp emp);

    int insertEmpListByExcel(List<SysEmp> emps);
}
