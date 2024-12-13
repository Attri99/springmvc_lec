package com.min.app09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.app09.service.INoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/notice")
@Controller
public class NoticeController {

  private final INoticeService noticeService;
  
  @RequestMapping(value="/list.do")
  public String list(Model model) {
    
    model.addAttribute("noticeList", noticeService.getNoticeList());
    return "notice/list";
  }
  
  @RequestMapping(value="/write.do")
  public String write() {
    return "notice/write";
  }
}
