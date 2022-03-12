package com.easyhao.micro.personnel.service.impl;

import com.easyhao.micro.personnel.entity.SerNotice;
import com.easyhao.micro.personnel.mapper.SerNoticeMapper;
import com.easyhao.micro.personnel.service.ISerNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerNoticeServiceImpl implements ISerNoticeService {

    @Autowired
    SerNoticeMapper noticeMapper;

    @Override
    public List<SerNotice> selectNoticeList(SerNotice notice) {
        return noticeMapper.selectNoticeList(notice);
    }

    @Override
    public int insertNotice(SerNotice notice) {
        return noticeMapper.insertNotice(notice);
    }

    @Override
    public int deleteNoticeById(Long noticeId) {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    @Override
    public int updateNotice(SerNotice notice) {
        return noticeMapper.updateNotice(notice);
    }

}
