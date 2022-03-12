package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.entity.SysRole;
import com.easyhao.micro.personnel.entity.SysUser;
import com.easyhao.micro.personnel.service.ISysRoleService;
import com.easyhao.micro.personnel.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ISysUserService userService;

    @Autowired
    ISysRoleService roleService;

    /**
     * <p>authentication.getPrincipal()的结果就是此方法返回值</p>
     * <p>1.查询数据库判断用户名是否存在，如果不存在就会抛出UsernameNotFoundException</p>
     * <p>2.把查询出来的密码进行解析，或者直接把密码放入构造方法中</p>
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<SysRole> roles = roleService.selectRolesByUserId(user.getUserId());
        user.setRoles(roles);
        return user;
        /**
         *  return new User(user.getUserName(),user.getPassword(),....);
         *  返回自带User对象，
         *  SysUser user = (SysUser) authentication.getPrincipal();
         *  会发生类似转化异常
         *  即SysUser和User不能相互转化
         *  因为在前端要使用SysUser更多的数据，所以SysUser实现UserDetails接口
         *  不使用自带User对象  (没有userID,nickName.....)
         *     private String password;
         *     private final String username;
         *     private final Set<GrantedAuthority> authorities;
         *     private final boolean accountNonExpired;
         *     private final boolean accountNonLocked;
         *     private final boolean credentialsNonExpired;
         *     private final boolean enabled;
         *
         */
    }
}
