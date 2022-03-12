package com.easyhao.micro.personnel.controller.sys;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.easyhao.micro.personnel.entity.SysEmp;
import com.easyhao.micro.personnel.service.ISysEmpService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/sys/emp")
public class SysEmpController {

    @Autowired
    ISysEmpService empService;

    @PostMapping("/list")
    public List<SysEmp> list(@RequestBody SysEmp emp) {
        return empService.selectEmpList(emp);
    }

    @DeleteMapping("/{empId}")
    @Log(module = "员工管理", operContent = "删除")
    public JsonResult delete(@PathVariable Long empId) {
        if (empService.deleteEmpById(empId) == 1) {
            return JsonResult.success("员工删除成功！");
        }
        return JsonResult.error("员工删除失败！");
    }

    @PostMapping("/")
    @Log(module = "员工管理", operContent = "添加")
    public JsonResult insert(@RequestBody SysEmp emp) {
        if (empService.insertEmp(emp) == 1) {
            return JsonResult.success("员工添加成功！");
        }
        return JsonResult.error("员工添加失败！");
    }

    @PutMapping("/")
    @Log(module = "员工管理", operContent = "更新")
    public JsonResult update(@RequestBody SysEmp emp) {
        if (empService.updateEmp(emp) == 1) {
            return JsonResult.success("员工更新成功！");
        }
        return JsonResult.error("员工更新失败！");
    }

    /**
     * 下载文件，在Spring MVC中，返回ResponseEntity
     */
    @GetMapping("/export")
    @Log(module = "员工管理", operContent = "导出Excel")
    public ResponseEntity<byte[]> exportExcel() {
        List<SysEmp> empList = empService.selectEmpList(null);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), SysEmp.class, empList);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工列表.xls".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    @PostMapping("/import")
    @Log(module = "员工管理", operContent = "导入Excel")
    public JsonResult importExcel(MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(0);
        importParams.setHeadRows(1);
        List<SysEmp> list = ExcelImportUtil.importExcel(file.getInputStream(), SysEmp.class, importParams);
        int i = empService.insertEmpListByExcel(list);
        if (i > 0) {
            return JsonResult.success("Excel导入成功!");
        } else {
            return JsonResult.error("Excel导入失败!");
        }
    }


}
