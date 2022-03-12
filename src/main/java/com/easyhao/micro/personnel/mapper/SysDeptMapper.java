package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SysDept;

import java.util.List;

public interface SysDeptMapper {

    List<SysDept> selectDeptAll(Long deptId);

    int insertDept(SysDept dept);

    int deleteDeptById(Long deptId);

    int updateDept(SysDept dept);

    //部门是否存在员工
    int hasEmpByDeptId(Long deptId);

    List<SysDept> selectDeptIdAndDeptName();

    Long selectDeptIdByDeptName(String deptName);
}
