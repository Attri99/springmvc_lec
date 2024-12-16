<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>User List</title>
<style>
  .wrap{
    width: 700px;
    margin: 0 auto;
    
  }
  .wrap h1{
    text-align: center;
  }
  .wrap table{
    border: 1px solid silver;
    border-collapse: collapse;
    width: 100%;
   }
   .wrap thead td{
    text-align: center;
    font-weight: 700;
   }
   .wrap td{
    border: 1px solid silver;
   }
   .wrap td:nth-of-type(1) {width: 80px;}
   .wrap td:nth-of-type(2) {width: 80px;}
   .wrap td:nth-of-type(3) {width: 100px;}
   .wrap td:nth-of-type(4) {width: 100px;}
   .wrap td:nth-of-type(5) {width: 140px;}
   .wrap td:nth-of-type(6) {width: 100px;}
   .wrap td:nth-of-type(7) {width: 100px;}
   
   

</style>
</head>
<body>
  
  <div class="wrap">
    <h1>회원 목록</h1>
    <table>
      <caption>총 ${total}명</caption>
      <thead>
       <tr>
        <td>순번</td>
        <td>Id</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>Email</td>
        <td>Gender</td>
        <td>IpAddress</td>
       </tr>
      </thead>
      <tbody>
        <c:if test="${empty users}">
          <tr>
            <td colspan="7">등록된 회원이 없습니다.</td>
          </tr>
        </c:if>
        <c:if test="${not empty users}">
          <c:forEach items="${users}" var="user">
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.gender}</td>
            <td>${user.ipAddress}</td>
          </c:forEach>
        </c:if>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="7">페이지 표시</td>
        </tr>
      </tfoot>
    </table>
  </div>
  
</body>
</html>