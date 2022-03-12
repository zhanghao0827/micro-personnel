package com.easyhao.micro.personnel.service;

public interface ISysUserRoleService {

    boolean updateUserRole(Long userId, Long[] roleIds);

    int insertUserRole(Long userId, Long[] roleIds);
}
