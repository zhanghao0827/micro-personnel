package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    List<SysMenu> selectMenusByUserId(Long userId);

    //查询菜单对应的角色
    List<SysMenu> selectMenuCollectionRole();

    List<SysMenu> selectMenuAll();

    List<Long> selectMenuIdsByRoleId(Long roleId);
}
