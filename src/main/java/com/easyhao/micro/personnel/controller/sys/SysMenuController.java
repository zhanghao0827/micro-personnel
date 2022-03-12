package com.easyhao.micro.personnel.controller.sys;

import com.easyhao.micro.personnel.entity.SysMenu;
import com.easyhao.micro.personnel.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    ISysMenuService menuService;

    @GetMapping("/")
    public List<SysMenu> menuAll() {
        return menuService.selectMenuAll();
    }

    @GetMapping("/{roleId}")
    public List<Long> menuIds(@PathVariable Long roleId) {
        return menuService.selectMenuIdsByRoleId(roleId);
    }

}
