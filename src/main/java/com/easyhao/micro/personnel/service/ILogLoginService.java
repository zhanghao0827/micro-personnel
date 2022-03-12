package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.LogLogin;

import java.util.List;

public interface ILogLoginService {

    int insertLogin(LogLogin login);

    List<LogLogin> selectLoginList();
}
