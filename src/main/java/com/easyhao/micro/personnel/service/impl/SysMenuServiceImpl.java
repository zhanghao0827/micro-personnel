package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SysMenu;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.mapper.SysMenuMapper;
import com.easyhao.micro.personnel.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    SysMenuMapper menuMapper;

    public List<SysMenu> selectMenusByUserId() {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.selectMenusByUserId(user.getUserId());
    }

    public List<SysMenu> selectMenuCollectionRole() {
        return menuMapper.selectMenuCollectionRole();
    }

    public List<SysMenu> selectMenuAll(){
        return menuMapper.selectMenuAll();
    }

    public List<Long> selectMenuIdsByRoleId(Long roleId){
        return menuMapper.selectMenuIdsByRoleId(roleId);
    }


}
