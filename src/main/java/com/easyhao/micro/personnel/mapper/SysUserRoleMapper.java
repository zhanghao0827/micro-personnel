package com.easyhao.micro.personnel.mapper;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {

    int deleteUserRoleByUserId(Long userId);

    int insertUserRole(@Param("userId") Long userId, @Param("roleIds") Long[] roleIds);

}
