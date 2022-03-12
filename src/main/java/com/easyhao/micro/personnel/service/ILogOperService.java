package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.LogOper;

import java.util.List;

public interface ILogOperService {

    int insertOper(LogOper oper);

    List<LogOper> selectOperList();
}
