package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SysDept;
import com.easyhao.micro.personnel.mapper.SysDeptMapper;
import com.easyhao.micro.personnel.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    SysDeptMapper deptMapper;

    @Override
    public List<SysDept> selectDeptAll() {
        return deptMapper.selectDeptAll(0L);
    }

    @Override
    @Transactional
    public int insertDept(SysDept dept) {
        dept.setParentId(dept.getDeptId());
        dept.setAncestors(dept.getAncestors() + "," + dept.getDeptId());
        return deptMapper.insertDept(dept);
    }

    @Override
    public int deleteDeptById(Long deptId) {
        return deptMapper.deleteDeptById(deptId);
    }

    @Override
    public int updateDept(SysDept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public int hasEmpByDeptId(Long deptId) {
        return deptMapper.hasEmpByDeptId(deptId);
    }

    @Override
    public List<SysDept> selectDeptIdAndDeptName() {
        return deptMapper.selectDeptIdAndDeptName();
    }

    @Override
    public Long selectDeptIdByDeptName(String deptName) {
        return deptMapper.selectDeptIdByDeptName(deptName);
    }


}
