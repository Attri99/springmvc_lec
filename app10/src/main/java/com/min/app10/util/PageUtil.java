package com.min.app10.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * 모든 목록 서비스에서 사용하는 PageUtil 클래스
 */
@Component
@Getter
public class PageUtil {

   private int page; // 페이지 번호(요청 파라미터, 디폴트1)
   private int display; // 한 페이지에 표시할 목록의 개수 (요청 파라미터, 디폴트 20)
   private int offset; // 각 페이지마다 표시할 게시글의 시작 번호
   
   private int total; // 전체 목록의 개수 (SELECT 문 실행)
   private int totalPage; // 전체 페이지의 개수(total과 display에 의해서 계산)
   private int beginPage; // 각 블록의 시작 페이지(page와 pagePerBlock에 의해서 계산되는 항목)
   private int endPage;
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
     
     int pagePerBlock = 10;
     totalPage = (int)Math.ceil((double)total / display);
     beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
     endPage = Math.min(beginPage + pagePerBlock - 1, totalPage);
   }
   
   /**
    * 호출한 서비스로 페이지 이동 링크를 문자열 형식으로 반환하는 메소드
    * @param requestURI 서비스가 동작하는 요청 주소
    * @return 문자열 형식의 페이지 이동 링크
    */
   
   public String getPaging(String requestURI) {
     
     StringBuilder builder = new StringBuilder();
     
     // <style></style>
     builder.append("<style>");
     builder.append(".paging{display : flex; justify-content: space-between; width: 520px; margin: 0 auto; }");
     builder.append(".paging button {display : block; border: none; background-color: #fff; text-align: center; width: 40px; height: 20px; line-height: 20px; }");
     builder.append(".paging .disabled-button { color: silver; }");
     builder.append(".paging.focus-page { color: limegreen; }");
     builder.append("</style>");
     
     // <div class="paging">
     builder.append("<div class = \"paging\">");
     
     // 이전 블록
     // 1. 링크 없음 : <button type="button" class="disabled-button">&lt;</button>
     
     // 2. 링크 있음 : <button type="button" onclick="location.href='/app10/user/list.do?page=10'">&lt;</button>
     if(beginPage == 1)
       builder.append("<button type=\"button\" style=\"color: silver;\">&lt;</button>");
     else
       builder.append("<button type=\"button\" onclick=\"location.href='"+ requestURI + "?page=" +(beginPage - 1) + "'\">&lt;</button>");
     
     // 1 2 3 4 5 6 7 8 9 10
     // <button type="button" onclick="location.href='/app10/user/list.do?page=1'">1</button>
     // <button type="button" onclick="location.href='/app10/user/list.do?page=2'">2</button>
     // <button type="button" onclick="location.href='/app10/user/list.do?page=3'">3</button>
     for(int p = beginPage; p <= endPage; p++) {
       if(p == page) {
         builder.append("<button type=\"button\" onclick=\"location.href='" + requestURI + "?page=" + p + "'\" class=\"focus-page\">" + p + "</button>");
       } else {
         builder.append("<button type=\"button\" onclick=\"location.href='" + requestURI + "?page=" + p +"'\">" + p +"</button>");
       }
     }
     
     // 다음 블록 >
     // 1. 링크 없음 : <button type="button" class="disabled-button">&gt;</button>
     // 2. 링크 있음 : <button type="button" onclick="location.href='/app10/user/list.do?page=11'">&gt;</button>
     if(endPage == totalPage)
       builder.append("<button type=\"button\" class=\"disabled-button\">&gt;</button>");
     else
       builder.append("<button type=\"button\" onclick=\"location.href='"+ requestURI +"?page=" + (endPage + 1) + "'\">&gt;</button>");
     
     // <div>
     builder.append("</div>");
     
   
   return builder.toString();
   }
   
}
