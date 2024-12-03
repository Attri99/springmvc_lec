package com.min.app04.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
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
    return "목록보기";
  }
  
}
