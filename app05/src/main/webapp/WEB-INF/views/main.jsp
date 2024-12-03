<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
</head>
<body>
  
  <%--로그인 화면 --%>
  <form action="${contextPath}/user/login.do" method="POST">
    <input type="text" name="id"><br/>
    <input type ="password" name="pw"><br/>
    <button type="submit">로그인</button>
  </form>
</body>
</html>