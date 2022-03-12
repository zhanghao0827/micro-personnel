package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.mapper.SysUserMapper;
import com.easyhao.micro.personnel.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper userMapper;

    public SysUser selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public int updateUserAvatar(SysUser user) {
        return userMapper.updateUserAvatar(user);
    }

    public List<SysUser> selectUserCollectionRole() {
        List<SysUser> users = userMapper.selectUserCollectionRole();
        for (SysUser user : users) {
            user.setPassword(null);
        }
        return users;
    }

    public int updateUserEnabled(SysUser user) {
        return userMapper.updateUserEnabled(user);
    }

    public int insertUser(SysUser user) {
        //密码加密处理
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        user.setAvatar("https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg");
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUserPassword(SysUser user) {
        return userMapper.updateUserPassword(user);
    }

    @Override
    public List<SysUser> selectUsersByPasswordExpired() {
        return userMapper.selectUsersByPasswordExpired();
    }

    @Override
    public int updateUser(SysUser user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<SysUser> selectUsersExceptSelf() {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.selectUsersExceptSelf(user.getUserId());
    }

}
