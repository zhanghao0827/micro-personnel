package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.LogLogin;

import java.util.List;

public interface LogLoginMapper {

    int insertLogin(LogLogin login);

    List<LogLogin> selectLoginList();
}
