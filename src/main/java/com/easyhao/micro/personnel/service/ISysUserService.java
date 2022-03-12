package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SysUser;

import java.util.List;

public interface ISysUserService {

    SysUser selectUserByUsername(String username);

    int updateUserAvatar(SysUser user);

    List<SysUser> selectUserCollectionRole();

    int updateUserEnabled(SysUser user);

    int insertUser(SysUser user);

    int updateUserPassword(SysUser user);

    List<SysUser> selectUsersByPasswordExpired();

    int updateUser(SysUser user);

    List<SysUser> selectUsersExceptSelf();
}
