package com.min.app04.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.app04.vo.Person;

@Controller
public class MvcController2 {
  
  private List<Person> people = new ArrayList<Person>();
  
  @RequestMapping(value="/redirect/main.do")
  public String main() {
    return "/webdir2/main";
  }
  
  @RequestMapping(value="/redirect/insert.do", method=RequestMethod.POST)
  public String insert(
      Person person   // 사용자가 입력한 정보가 커맨드 객체 Person person에 저장된다.
    , Model model                           // Model에 저장된 속성은 forward할 때만 전달된다. redirect 할 때는 전달되지 않는다.
    , RedirectAttributes redirectAttributes // RedirectAttributes에 저장된 플래시 속성(Flash Attribute)은 redirect할 때 전달된다.
   ) {
    
    // 사용자가 입력한 정보를 List에 저장한다.
    boolean result = people.add(person);
    
    // 입력 성공 유무를 Model에 속성(Attribute)으로 저장해 본다. 사실 소용없는 행동
    model.addAttribute("msg1", result ? "등록 성공" : "등록 실패");
    
    // 입력 성공 유무를 RedirectAttributes에 플래시 속성(Flash Attribute)으로 저장해 본다.
    redirectAttributes.addFlashAttribute("msg2", result ? "등록 성공" : "등록 실패");
    
    return "redirect:/redirect/list.do"; // people 목록을 보여주는 요청을 수행한다.
  }
  
  @RequestMapping(value="/redirect/list.do")
  public String list(Model model){
    model.addAttribute("people", people);
    return "webdir2/list"; // forward (Model에 저장한 people 속성을 list.jsp로 전달한다.
  }
  
}
