package com.min.app07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app07.dao.IBoardDao;

@SpringJUnitConfig(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
                                  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
    
    )




class BoardDaoTest {

  // Spring Container에 저장된 IBoardDao 타입의 bean 가져오기
  @Autowired
  private IBoardDao boardDao;
  
  @Test
  void 목록테스트() {
    // 두 번째 항목의 contents="대방어, 광어, 우럭 매운탕" 인지 테스트    
    
    assertEquals(true, boardDao.selectBoardList().get(1).getContents().startsWith("대방어"));
  }

}
