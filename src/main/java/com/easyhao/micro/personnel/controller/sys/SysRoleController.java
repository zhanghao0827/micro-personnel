package com.easyhao.micro.personnel.controller.sys;

import com.easyhao.micro.personnel.entity.SysRole;
import com.easyhao.micro.personnel.service.ISysRoleMenuService;
import com.easyhao.micro.personnel.service.ISysRoleService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    ISysRoleService roleService;

    @Autowired
    ISysRoleMenuService roleMenuService;

    @GetMapping("/")
    public List<SysRole> roleAll() {
        return roleService.selectRoleAll();
    }

    @PostMapping("/")
    @Log(module = "角色管理", operContent = "添加")
    public JsonResult insert(@RequestBody SysRole role) {
        if (roleService.insertRole(role) == 1) {
            return JsonResult.success("角色添加成功！");
        }
        return JsonResult.error("角色添加失败！");
    }

    @DeleteMapping("/{roleId}")
    @Log(module = "角色管理", operContent = "删除")
    public JsonResult delete(@PathVariable Long roleId) {
        if (roleService.deleteRoleById(roleId) == 1) {
            return JsonResult.success("角色删除成功！");
        }
        return JsonResult.error("角色删除失败！");
    }

    @PutMapping("/")
    @Log(module = "角色管理", operContent = "更新")
    public JsonResult update(@RequestBody SysRole role) {
        if (roleService.updateRole(role) == 1) {
            return JsonResult.success("角色更新成功！");
        }
        return JsonResult.error("角色更新失败！");
    }

    /**
     * 更新sys_role_menu
     */
    @PutMapping("/role_menu")
    @Log(module = "角色管理", operContent = "更新角色对应菜单")
    public JsonResult updateRoleMenu(Long roleId, Long[] menuIds) {
        if (roleMenuService.updateRoleMenu(roleId, menuIds)) {
            return JsonResult.success("角色菜单更新成功！");
        }
        return JsonResult.error("角色菜单更新失败！");
    }

}
