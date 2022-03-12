package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.mapper.SysUserRoleMapper;
import com.easyhao.micro.personnel.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    SysUserRoleMapper userRoleMapper;

    @Transactional
    public boolean updateUserRole(Long userId, Long[] roleIds) {
        userRoleMapper.deleteUserRoleByUserId(userId);
        return userRoleMapper.insertUserRole(userId, roleIds) == roleIds.length;
    }

    @Override
    public int insertUserRole(Long userId, Long[] roleIds) {
        return userRoleMapper.insertUserRole(userId, roleIds);
    }


}
