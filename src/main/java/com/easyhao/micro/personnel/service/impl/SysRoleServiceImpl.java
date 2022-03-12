package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SysRole;
import com.easyhao.micro.personnel.mapper.SysRoleMapper;
import com.easyhao.micro.personnel.mapper.SysRoleMenuMapper;
import com.easyhao.micro.personnel.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    SysRoleMapper roleMapper;

    @Autowired
    SysRoleMenuMapper roleMenuMapper;

    public List<SysRole> selectRolesByUserId(Long id){
        return roleMapper.selectRolesByUserId(id);
    }

    public List<SysRole> selectRoleAll() {
        return roleMapper.selectRoleAll();
    }

    public int insertRole(SysRole role) {
        if (!role.getRoleKey().startsWith("ROLE_")) {
            role.setRoleKey("ROLE_" + role.getRoleKey());
        }
        return roleMapper.insertRole(role);
    }

    @Transactional
    public int deleteRoleById(Long roleId) {
        roleMenuMapper.deleteRoleMenuByRoleId(roleId);
        return roleMapper.deleteRoleById(roleId);
    }

    public int updateRole(SysRole role) {
        if (!role.getRoleKey().startsWith("ROLE_")) {
            role.setRoleKey("ROLE_" + role.getRoleKey());
        }
        return roleMapper.updateRole(role);
    }
}
