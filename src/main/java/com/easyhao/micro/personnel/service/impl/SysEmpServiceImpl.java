package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SysEmp;
import com.easyhao.micro.personnel.mapper.SysEmpMapper;
import com.easyhao.micro.personnel.service.ISysDeptService;
import com.easyhao.micro.personnel.service.ISysEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysEmpServiceImpl implements ISysEmpService {

    @Autowired
    SysEmpMapper empMapper;

    @Autowired
    ISysDeptService deptService;

    @Override
    public List<SysEmp> selectEmpList(SysEmp emp) {
        return empMapper.selectEmpList(emp);
    }

    @Override
    public int deleteEmpById(Long empId) {
        return empMapper.deleteEmpById(empId);
    }

    @Override
    public int insertEmp(SysEmp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public int updateEmp(SysEmp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public int insertEmpListByExcel(List<SysEmp> emps) {
        for (SysEmp emp : emps) {
            Long deptId = deptService.selectDeptIdByDeptName(emp.getDept().getDeptName());
            emp.setDeptId(deptId);
        }
        //集合添加到数据库
        return empMapper.insertEmpList(emps);
    }

}
