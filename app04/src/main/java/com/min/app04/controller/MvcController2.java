package com.min.app04.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.app04.vo.Person;

@Controller
public class MvcController2 {
  
  private List<Person> people = new ArrayList<Person>();
  
  @RequestMapping(value="/redirect/main.do")
  public String main() {
    return "/webdir2/main";
  }
  
  @RequestMapping(value="/redirect/insert.do", method=RequestMethod.POST)
  public String insert(Person person) {
    people.add(person);
    return "redirect:/redirect/list.do"; // redirect는 주소로 이동
  }
  
  @RequestMapping(value="/redirect/list.do")
  public String list(Model model){
    model.addAttribute("people", people);
    return "webdir2/list"; // forward (Model에 저장한 people 속성을 list.jsp로 전달한다.
  }
  
}
