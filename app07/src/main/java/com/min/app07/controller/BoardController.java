package com.min.app07.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.app07.service.IBoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 필드로 선언된 IBoardService boardService에 자동으로 bean을 주입하기 위한 생성자입니다.
@RequestMapping(value="/board")
@Controller
public class BoardController {
  
  private final IBoardService boardService;
  
  @RequestMapping(value="/list.do")
  public String list(HttpServletRequest request, Model model) {
    
    // 목록 서비스(getBoardList)로부터 결과를 받아옵니다.
    Map<String, Object> map = boardService.getBoardList(request);    
    
    // JSP로 전달할 목록과 전체 목록의 개수를 model에 저장한다.
    model.addAttribute("boardList", map.get("boardList"));
    model.addAttribute("boardCount", map.get("boardCount"));
    
    return "board/list";
  }
  
  @RequestMapping(value="/detail.do")
  public String detail(@RequestParam(name="boardId", required=false, defaultValue = "0") int boardId, Model model) {
   
    // 상세 서비스로부터 상세 정보를 받아온 뒤 해당 정보를 JSP로 전달할 수 있도록 model에 저장합니다.
    model.addAttribute("");
    return "board/detail";
  }
}
