package com.easyhao.micro.personnel.security;

import com.easyhao.micro.personnel.entity.SysMenu;
import com.easyhao.micro.personnel.entity.SysRole;
import com.easyhao.micro.personnel.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    SysMenuServiceImpl menuService;

    /**
     * url不匹配，判断是否登录，只要登陆就可以访问，例如: /menu (只要登录就可以获取菜单)
     * <p>不需要做权限处理</p>
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<SysMenu> menus = menuService.selectMenuCollectionRole();
        for (SysMenu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<SysRole> roles = menu.getRoles();
                String[] rolesString = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    rolesString[i] = roles.get(i).getRoleKey();
                }
                return SecurityConfig.createList(rolesString);
            }
        }
        //没有匹配，返回一个标记
        return SecurityConfig.createList("noMatcher_flag");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
