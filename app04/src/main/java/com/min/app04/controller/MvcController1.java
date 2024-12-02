package com.min.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController1 {
  
  /*
   * MvcController1에서 요청 주소를 만드는 규칙
   * 1. Forward 는 중간 주소 /forward 를 사용한다.
   * 2. 모든 요청주소는 suffix=".do" 값을 가진다.
   */
  
  @RequestMapping(value="/forward/main.do") //.do가 붙어있으면 URLMapping
  public String main() {
    return "webdir1/main"; // ViewResolver에 의해서 "WEB-INF/webdir1/main.jsp" 경로로 이동한다.(forward 한다.)
  }
  
}
