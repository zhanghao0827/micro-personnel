package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SysRole;

import java.util.List;

public interface SysRoleMapper {

    List<SysRole> selectRolesByUserId(Long id);

    List<SysRole> selectRoleAll();

    int insertRole(SysRole role);

    int deleteRoleById(Long roleId);

    int updateRole(SysRole role);

}
