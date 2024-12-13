package com.min.app09.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.app09.dto.NoticeDto;

public interface INoticeService {

  List<NoticeDto> getNoticeList();
  String registNotice(MultipartHttpServletRequest multipartRequest);
  Map<String, Object> getNoticeById(int noticeId);
}
