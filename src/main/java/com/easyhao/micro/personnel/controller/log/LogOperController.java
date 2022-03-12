package com.easyhao.micro.personnel.controller.log;

import com.easyhao.micro.personnel.entity.LogOper;
import com.easyhao.micro.personnel.service.ILogOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log/oper")
public class LogOperController {

    @Autowired
    ILogOperService operService;

    @GetMapping("/")
    public List<LogOper> list() {
        return operService.selectOperList();
    }

}
