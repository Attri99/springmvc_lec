package com.min.app10.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * 목록 서비스에서 사용하는 PageUtil 클래스
 */
@Component
@Getter
public class PageUtil {

   private int page; // 페이지 번호(요청 파라미터, 디폴트1)
   private int display; // 한 페이지에 표시할 목록의 개수 (요청 파라미터, 디폴트 20)
   private int offset; // 각 페이지마다 표시할 게시글의 시작 번호
   
   private int total; // 전체 목록의 개수 (SELECT 문 실행)
   private int totalPage; // 전체 페이지의 개수(total과 display에 의해서 계산)
   /**
    * 서비스로부터 page와 display와 total의 정보를 받아온 뒤 페이징 처리에 필요한 모든 값을 처리하는 메소드
    * @param page 현재 페이지 번호
    * @param display 현재 페이지에 표시할 목록의 개수
    * @param total 전체 목록의 개수
    */
   
   public void setPaging(int page, int display, int total) {
     this.page= page;
     this.display= display;
     offset = (page -1) * display;
     
     totalPage = (int)Math.ceil((double)total / display);
   }
   
  
   
}
