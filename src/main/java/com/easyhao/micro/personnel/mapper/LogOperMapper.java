package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.LogOper;

import java.util.List;

public interface LogOperMapper {

    int insertOper(LogOper oper);

    List<LogOper> selectOperList();
}
