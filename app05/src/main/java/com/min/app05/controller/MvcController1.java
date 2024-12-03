package com.min.app05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController1 {
  
  
  
  @RequestMapping(value="/")
  public String main() {
    return "main";
  }
  
  @RequestMapping(value="/user/login.do", method=RequestMethod.POST)
  public String login(
      HttpServletRequest request // 모든 요청 정보(요청 파라미터, 세션)를 관리하는 인터페이스
  ) {
   // 요청 파라미터 받기 
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
   
   // 세션 꺼내기 (세션은 서버 측에 존재하는 저장소)
   HttpSession session = request.getSession();
   
   // 세션 아이디를 확인해 본다. (브라우저의 쿠키 : F12-Application-Cookies에서 JSESSIONID 쿠키로 사용자에게 전달되어 저장된다.)
   System.out.println(session.getId());
   
   
   
   // 로그인이 완료된 후 다시 main.jsp로 이동한다.
   
    return "main";
  }
  
  
}
