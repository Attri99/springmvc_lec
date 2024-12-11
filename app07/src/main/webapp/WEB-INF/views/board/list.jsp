<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<style>
.list-wrap {
  width: 500px;
  margin: 0 auto;
}
</style>

</head>
<body>

  <div class="list-wrap">
    <h1>Board List</h1>
    <div>
      <a href="${contextPath}/board/list.do?sort=DESC"> 최신순</a> | <a href="${contextPath}/board/list.do?sort=ASC"> 과거순</a>
    </div>
    
    <table>
      <thead>
        <tr>
          <td><input type="checkbox"></td>
          <td>제목</td>
          <td>작성자</td>
          <td>작성일자</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${boardList}" var="b">
          <tr>
            <td><input type="checkbox"></td>
            <td><a href="${contextPath}/board/detail.do?boardId=${b.boardId}">${b.title}</a></td>
            <td>${b.userDto.usrName}</td>
            <td><fmt:formatDate value="${b.createDt}"
                pattern="yyyy-MM-dd" /></td>
          </tr>
        </c:forEach>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="4">전체 ${boardCount}개 게시글</td>
        </tr>
      </tfoot>
    </table>
  </div>

</body>
</html>