package com.easyhao.micro.personnel.controller.sys;

import com.easyhao.micro.personnel.entity.SysDept;
import com.easyhao.micro.personnel.service.ISysDeptService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Autowired
    ISysDeptService deptService;

    @GetMapping("/")
    public List<SysDept> list() {
        return deptService.selectDeptAll();
    }

    @GetMapping("/idAndName")
    public List<SysDept> deptIdAndName() {
        return deptService.selectDeptIdAndDeptName();
    }

    @PostMapping("/")
    @Log(module = "部门管理", operContent = "添加")
    public JsonResult insert(@RequestBody SysDept dept) {
        if (deptService.insertDept(dept) == 1) {
            return JsonResult.success("添加部门成功！");
        }
        return JsonResult.error("添加部门失败！");
    }


    @DeleteMapping("/{deptId}")
    @Log(module = "部门管理", operContent = "删除")
    public JsonResult delete(@PathVariable Long deptId) {
        //先判断该部门下是否存在员工
        if (deptService.hasEmpByDeptId(deptId) > 0) {
            return JsonResult.error("该部门存在员工，无法删除！");
        }
        if (deptService.deleteDeptById(deptId) == 1) {
            return JsonResult.success("部门删除成功！");
        }
        return JsonResult.error("部门删除失败！");
    }

    @PutMapping("/")
    @Log(module = "部门管理", operContent = "更新")
    public JsonResult update(@RequestBody SysDept dept) {
        if (deptService.updateDept(dept) == 1) {
            return JsonResult.success("更新部门成功！");
        }
        return JsonResult.error("更新部门失败！");
    }


}
