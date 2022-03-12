package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SysEmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysEmpMapper {

    List<SysEmp> selectEmpList(SysEmp emp);

    int deleteEmpById(Long empId);

    int insertEmp(SysEmp emp);

    int updateEmp(SysEmp emp);

    int insertEmpList(@Param("emps") List<SysEmp> emps);

}
