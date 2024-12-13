package com.min.app09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.app09.dao.INoticeDao;
import com.min.app09.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 컨트롤러가 service를 사용할수 있도록 붙여줌
public class NoticeServiceImpl implements INoticeService {

  private final INoticeDao noticeDao;

  @Override
  public List<NoticeDto> getNoticeList() {
    
    return noticeDao.selectNoticeList();
  }
  

}
