package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.LogLogin;
import com.easyhao.micro.personnel.mapper.LogLoginMapper;
import com.easyhao.micro.personnel.service.ILogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogLoginServiceImpl implements ILogLoginService {

    @Autowired
    LogLoginMapper loginMapper;

    public int insertLogin(LogLogin login) {
        return loginMapper.insertLogin(login);
    }

    public List<LogLogin> selectLoginList() {
        return loginMapper.selectLoginList();
    }
}
