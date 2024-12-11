package com.min.app07.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.min.app07.dao.IBoardDao;
import com.min.app07.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 필드로 선언된 IBoardDao boardDao에 자동으로 bean을 주입하기 위한 생성자입니다.
@Service // 서비스에서 사용하는 @Component입니다. Spring Container에 IBoardService 타입의 bean이 생성됩니다.
public class BoardServiceImpl implements IBoardService{

  private final IBoardDao boardDao;
  
  @Override
  public Map<String, Object> getBoardList(HttpServletRequest request) {
    
    // 요청 파라미터 (sort가 전달되지 않으면 DESC를 사용합니다.)
    Optional<String> opt = Optional.ofNullable(request.getParameter("sort"));
    String sort = opt.orElse("DESC");
   
    // 목록 가져오기
    List<BoardDto> boardList = boardDao.selectBoardList(sort);
    
    // 전체 목록의 개수 가져오기
    int boardCount = boardDao.selectBoardCount();
    
    // 목록과 전체 목록의 개수 Map으로 반환하기
    return Map.of("boardList", boardList, "boardCount", boardCount);
  }
  
}
