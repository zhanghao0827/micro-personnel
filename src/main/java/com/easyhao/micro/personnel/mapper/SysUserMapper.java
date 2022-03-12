package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SysUser;

import java.util.List;

public interface SysUserMapper {

    /**/
    SysUser selectUserByUsername(String username);

    int updateUserAvatar(SysUser user);

    List<SysUser> selectUserCollectionRole();

    int updateUserEnabled(SysUser user);

    int insertUser(SysUser user);

    int updateUserPassword(SysUser user);

    List<SysUser> selectUsersByPasswordExpired();

    int updateUser(SysUser user);

    List<SysUser> selectUsersExceptSelf(Long userId);
}
