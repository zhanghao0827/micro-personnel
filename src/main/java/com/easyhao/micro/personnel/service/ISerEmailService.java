package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SerEmail;

import java.util.List;

public interface ISerEmailService {

    int insertEmail(SerEmail email);

    List<SerEmail> selectEmailList();

    int deleteEmailById(Long emailId);

}
