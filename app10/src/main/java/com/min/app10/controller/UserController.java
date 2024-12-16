package com.min.app10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
  
  @RequestMapping(value="/user/list.do")
  public String list(Model model) {
    
    return "user/list";
  }
  
}
