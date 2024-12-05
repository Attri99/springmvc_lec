package com.min.app06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.app06.dto.ContactDto;
import com.min.app06.service.IContactService;

@RequestMapping(value="/contact")

@Controller // 컨트롤러가 사용하는 @Component 입니다.
public class ContactController { // service한테서 결과를 받아오고 jsp에게 forward 하는 역할

  @Autowired
  private IContactService contactService;
  
  @RequestMapping(value="/list.do")
  public String list(Model model) { // 모델의 선언은 컨트롤러 밑의 메소드의 매개변수에서만 선언이 가능하다.
    // 서비스로부터 연락처 목록을 받아온다.
    List<ContactDto> contacts = contactService.getAllContact();
    // JSP로 전달(forward)하기 위해서 Model에 저장한다.    
    model.addAttribute("contacts", contacts);
    // JSP로 전달
    return "contact/list";  //"WEB-INF/views/contact/list.jsp"
  }
 
}
