package com.min.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // 요청과 응답을 처리하는 컨트롤러
public class MvcController1 {

  /* 메소드 == 하나의 요청과 응답을 처리하는 단위 */
  /*
   * 반환타입
   *   1) String        : 사용자에게 보여 줄 (응답할) JSP 의 경로와 이름을 작성한다.
   *   2) void          : 요청한 주소를 JSP 경로와 이름으로 인식한다.
   *   3) ModelAndView  : 
   *   4) ...
   *   
   * 메소드명
   *   아무 의미가 없다.
   * 
   * 매개변수
   *   1) 요청과 응답을 처리하기 위한 각종 클래스나 변수를 선언한다.
   *   2) 주요 매개변수
   *     (1) HttpServletRequest 인터페이스  : 요청을 처리할 수 있는 인터페이스
   *     (2) HttpServletResponse 인터페이스 : 응답을 처리할 수 있는 인터페이스
   *     (3) Model 인터페이스               : 응답 데이터를 저장할 수 있는 인터페이스
   *     (4) HttpSession 인터페이스         : 세션을 처리할 수 있는 인터페이스
   */

   /*
    * @RequestMapping
    * 
    * 1. 요청 주소와 요청 메소드를 작성하는 Annotation
    * 2. 요청 주소
    *   1) value="/"  : Context Path 요청을 의미한다. (대표주소로 들어가면 저 주소를 보여주자) http://127.0.0.1:8080/app03
    *   2) value="/list" : /list 요청을 의미한다. http://127.0.0.1:8080/app03  
    *   3) value={"/list", "/list.do"} : 2개 이상의 요청을 의미한다.  http:// 127.0.0.1:8080/app03
    *   
    *   
    * 3. 요청 메소드
    *   1) method=RequestMethod.GET : GET 방식을 의미한다. (디폴트)
    *   2) method=RequestMethod.POST : POST 방식을 의미한다.
    *  
    */

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String welcome() {
    return "webdir1/index"; // return "/webdir1/index/"로 작성해도 스프링이 올바르게 해석해 준다.
    /*
     * return "webdir1/index"; 해석해보기
     * 
     * 1. 리턴 값 "index" 는 ViewResolver 에게 전달됩니다.
     *    (DispatcherServlet : servlet-context.xml 에 ViewResolver가 정의되어 있다.)
     * 2. ViewResolver는 "index" 앞에 "/WEB-INF/views/" 문자열을 추가합니다. (prefix)
     * 3. ViewResolver는 "index" 뒤에 ".jsp" 문자열을 추가합니다. (suffix)
     * 4. ViewResolver는 완성된 최종 view로 이동합니다.
     *    (최종 View의 모습 : "/WEB-INF/views/webdir1/index")
     * 
     */
  }
  
  
  @RequestMapping(value="/webdir1/list", method = RequestMethod.GET)
  public void letsgo() {
    // 반환타입이 void 이므로 요청 주소 "/webdir1/list"를 사용자에게 보여줄 JSP 경로와 이름으로 해석한다.
    // ViewResolver 에 의해서 최종 경로는 "/WEB-INF/views/webdir1/list.jsp"가 됩니다.
  }
  
  
  @RequestMapping(value="/board/view") // method를 생략하면 GET 방식으로 동작한다.
  public ModelAndView gogogo() {
    
    ModelAndView mav = new ModelAndView();
    mav.setViewName("webdir1/detail"); // 사용자에게 보여줄 JSP의 경로와 이름. ViewResolver에 의해 처리된다.
    mav.addObject("number", 10);  // JSP로  number = 10이라는 값을 전달합니다.
    return mav;
  }
}
