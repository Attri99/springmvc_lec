package com.min.app04.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.app04.vo.Person;

@Controller
public class MvcController1 {
  
  /*
   * MvcController1에서 요청 주소를 만드는 규칙
   * 1. Forward 는 중간 주소 /forward 를 사용한다.
   * 2. 모든 요청주소는 suffix=".do" 값을 가진다.
   */
  
  /*
   * Forward
   * 1. 요청을 그대로 전달하는 방식
   * 2. 요청에 포함된 요청 파라미터들도 함께 전달됨
   * 3. Spring MVC project의 기본 이동 방식
   * 4. SELECT 문의 결과를 전달할 때 사용한다.
   * 
   */
  
  @RequestMapping(value="/forward/main.do") //.do가 붙어있으면 URLMapping
  public String main() {
    return "webdir1/main"; // ViewResolver에 의해서 "WEB-INF/webdir1/main.jsp" 경로로 이동한다.(forward 한다.)
  }
  
  @RequestMapping(value="/forward/link.do")
  public String forward(
      HttpServletRequest request  // 모든 요청을 처리하는 HttpServletRequest 인터페이스
    , Model model                 // Spring 에서 사용하는 속성(Attribute) 저장용 인터페이스, forward할 데이터 저장할때 쓰는 것
  ) {
    
    // HttpServletRequest request에 전달할 데이터를 속성(Attribute)의 형식으로 저장할 수 있다.
    request.setAttribute("email", "user@gmail.com");
    
    // Model model 에 전달할 데이터를 속성(Attribute)의 형식으로 저장할 수 있다. Spring은 Model을 사용하는 것을 추천한다.
    model.addAttribute("address", "서울특별시 강남구 강남대로");
    
    // Map 을 전달한다.
    model.addAttribute("contact", Map.of("tel", "02-123-1234", "mobile", "010-1234-1234"));
    
    // Person 인스턴스를 전달한다.
    Person person = new Person();
    person.setName("홍길동");
    person.setAge(20);
    model.addAttribute("person", person);
    
    // List를 전달한다.
    model.addAttribute("hobbies", Arrays.asList("청소", "요리", "음악 감상"));
    
    // List<person>을 전달한다.
    Person p1 = new Person(); p1.setName("민지"); p1.setAge(20);
    Person p2 = new Person(); p2.setName("희지"); p2.setAge(30);
    model.addAttribute("people", Arrays.asList(p1, p2));
    
    return "webdir1/forward"; // "WEB-INF/webdir1/forward.jsp" 경로로 요청이 전달된다.
  }
}
