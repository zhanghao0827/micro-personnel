package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SerEmail;

import java.util.List;

public interface SerEmailMapper {

    int insertEmail(SerEmail email);

    List<SerEmail> selectEmailList();

    int deleteEmailById(Long emailId);

}
