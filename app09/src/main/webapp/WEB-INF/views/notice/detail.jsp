<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>Notice Detail</title>
</head>
<body>
  
  <div>작성일시 <fmt:formatDate value="${n.createdAt}" pattern="yyyy-MM-dd a hh:mm:ss"/></div>
  
  <div>
    <h4>첨부 파일</h4>
    <c:forEach items="${attachList}" var="a">
      <div><a href="">${a.originalFilename}</a></div>
    </c:forEach>
  
  </div>
  
  
  <h1>${n.noticeTitle}</h1>
  <pre>${n.noticeContents}</pre>

</body>
</html>