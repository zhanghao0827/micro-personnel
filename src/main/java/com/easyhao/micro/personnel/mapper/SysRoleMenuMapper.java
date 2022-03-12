package com.easyhao.micro.personnel.mapper;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {

    int deleteRoleMenuByRoleId(Long roleId);

    int insertRoleMenu(@Param("roleId") Long roleId, @Param("menuIds") Long[] menuIds);
}
