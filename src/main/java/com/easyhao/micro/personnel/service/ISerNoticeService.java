package com.easyhao.micro.personnel.service;

import com.easyhao.micro.personnel.entity.SerNotice;

import java.util.List;

public interface ISerNoticeService {

    List<SerNotice> selectNoticeList(SerNotice notice);

    int insertNotice(SerNotice notice);

    int deleteNoticeById(Long noticeId);

    int updateNotice(SerNotice notice);

}
