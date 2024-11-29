package com.min.app03.controller;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController3 {

  
  @RequestMapping(value="/webdir3/main")
  public String main() {
    return "webdir3/main";
  }
  
  @RequestMapping(value="/webdir3/req1")
  public String req1() {
    return "webdir3/req1";
  }
  
  /*
   * Query String
   * Query String 이란 URL의 ? 뒤에 추가된 파라미터를 의미한다.
   */
  
  /*
   * Query String 처리하기 1
   * HttpServletRequest 활용하기
   * 모든 요청에 관한 정보는 HttpServletRequset 인터페이스가 담당한다.
   * Query String은 Parameter 형태로 HttpServletRequest 인터페이스 객체에 저장되어 있다.
   * getParameter() 또는 getParameterValues() 메소드를 이용해 Parameter를 확인할 수 있다.
   * getParameter() 메소드는 String을 반환하고, getParameterValues() 메소드는 String[]을 반환한다.
   * 
   */
  
  // Query String : sort=ASC&page=1
  @RequestMapping(value="/webdir3/req2")
  public String req2(HttpServletRequest request) {
    String sort = request.getParameter("sort");
    int page = Integer.parseInt(request.getParameter("page"));
    System.out.println(sort + ", " + page);
    return "webdir3/req2";
    }
  
  // Query String : flowers=ROSE&flowers=TULIP
  @RequestMapping(value="/webdir3/req3")
  public String req3(HttpServletRequest request) {
    String[] flowers = request.getParameterValues("flowers");
    System.out.println(Arrays.toString(flowers));
    return "webdir3/req3";
  }
  
  //QueryString : 없음
  @RequestMapping(value="/webdir3/req4")
  public String req4(HttpServletRequest request) {
    
    // 전달되지 않은 Parameter를 꺼내면 null 이 반환된다.
    String sort = request.getParameter("sort");
    
    // 전달되지 않은 Parameter에 디폴트 값을 적용할 수 있다.
    // Parameter page가 전달되지 않는다면 "1"을 디폴트 값으로 사용하도록 설정한다.
    
    // Parameter page를 Optional에 담는다. Parameter page는 ofNullable() 메소드로 담았기 때문에 없어도 오류가 발생하지 않는다.
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
   
    // Optional 에 담은 Parameter page를 꺼낸다. 이때 Parameter page가 없으면 "1"을 꺼낸다.
    int page = Integer.parseInt(opt.orElse("1"));
    
    System.out.println(sort + ", " + page);
    
    return "webdir3/req4";
  }
  
  /*
   * Query String 처리하기 2
   * @RequestParam Annotation 활용하기
   * 각 Parameter마다 @RequestParam Annotation을 추가하여 Parameter를 직접 변수로 받을 수 있음.
   * Parameter의 필수 여부와 디폴트 값 설정을 할 수 있다.
   * @RequestParam Annotation은 생략도 할 수 있다. 생략하면 선언된 변수로 추론하여 값을 받는다.
   * 
   */
}
