package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.mapper.SysRoleMenuMapper;
import com.easyhao.micro.personnel.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {

    @Autowired
    SysRoleMenuMapper roleMenuMapper;

    @Transactional
    public boolean updateRoleMenu(Long roleId, Long[] menuIds) {
        //roleId为空即不需要删除，i=0
        roleMenuMapper.deleteRoleMenuByRoleId(roleId);
        return roleMenuMapper.insertRoleMenu(roleId, menuIds) == menuIds.length;
    }

}
