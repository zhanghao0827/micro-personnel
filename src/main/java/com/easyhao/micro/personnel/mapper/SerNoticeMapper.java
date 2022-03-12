package com.easyhao.micro.personnel.mapper;

import com.easyhao.micro.personnel.entity.SerNotice;

import java.util.List;

public interface SerNoticeMapper {

    List<SerNotice> selectNoticeList(SerNotice notice);

    int insertNotice(SerNotice notice);

    int deleteNoticeById(Long noticeId);

    int updateNotice(SerNotice notice);
}
