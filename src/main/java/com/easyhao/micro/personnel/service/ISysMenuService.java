package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SysMenu;

import java.util.List;

public interface ISysMenuService {

    List<SysMenu> selectMenusByUserId();

    List<SysMenu> selectMenuCollectionRole();

    List<SysMenu> selectMenuAll();

    List<Long> selectMenuIdsByRoleId(Long roleId);

}
