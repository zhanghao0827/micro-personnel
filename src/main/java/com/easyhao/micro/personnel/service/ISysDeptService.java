package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SysDept;

import java.util.List;

public interface ISysDeptService {

    List<SysDept> selectDeptAll();

    int insertDept(SysDept dept);

    int deleteDeptById(Long deptId);

    int updateDept(SysDept dept);

    int hasEmpByDeptId(Long deptId);

    List<SysDept> selectDeptIdAndDeptName();

    Long selectDeptIdByDeptName(String deptName);
}
