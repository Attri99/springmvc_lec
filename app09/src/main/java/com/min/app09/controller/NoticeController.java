package com.min.app09.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  
  @RequestMapping(value="/regist.do", method=RequestMethod.POST)
  public String regist(MultipartHttpServletRequest multipartRequest, RedirectAttributes redirectAttributes) {
    
    redirectAttributes.addFlashAttribute("msg", noticeService.registNotice(multipartRequest));
    return "redirect:/noitce/list.do";
  }
  
  @RequestMapping(value="/detail.do")
  public String detail(int noticeId, Model model) {
    Map<String, Object> map = noticeService.getNoticeById(noticeId) ;
    model.addAttribute("n", map.get("n"));
    model.addAttribute("attachList", map.get("attachList"));
    return "notice/detail";
  }
  
}
