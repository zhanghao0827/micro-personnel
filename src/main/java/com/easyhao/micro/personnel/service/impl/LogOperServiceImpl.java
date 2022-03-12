package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.LogOper;
import com.easyhao.micro.personnel.mapper.LogOperMapper;
import com.easyhao.micro.personnel.service.ILogOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogOperServiceImpl implements ILogOperService {

    @Autowired
    LogOperMapper operMapper;

    @Override
    public int insertOper(LogOper oper) {
        return operMapper.insertOper(oper);
    }

    @Override
    public List<LogOper> selectOperList() {
        return operMapper.selectOperList();
    }

}
