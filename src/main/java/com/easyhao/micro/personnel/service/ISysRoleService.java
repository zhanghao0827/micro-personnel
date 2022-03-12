package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SysRole;

import java.util.List;

public interface ISysRoleService {

    List<SysRole> selectRolesByUserId(Long id);

    List<SysRole> selectRoleAll();

    int insertRole(SysRole role);

    int deleteRoleById(Long roleId);

    int updateRole(SysRole role);

}
