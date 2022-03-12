package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SerEmail;
import com.easyhao.micro.personnel.mapper.SerEmailMapper;
import com.easyhao.micro.personnel.service.ISerEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerEmailServiceImpl implements ISerEmailService {

    @Autowired
    SerEmailMapper emailMapper;


    @Override
    public int insertEmail(SerEmail email) {
        return emailMapper.insertEmail(email);
    }

    @Override
    public List<SerEmail> selectEmailList() {
        return emailMapper.selectEmailList();
    }

    @Override
    public int deleteEmailById(Long emailId) {
        return emailMapper.deleteEmailById(emailId);
    }

}
