<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Detail</title>
</head>
<body>

  <h1>${contact.last_name} 연락처</h1>

  <form>
  
    <div>
      <label for="contact_id">CONTACT ID</label>
      <input type="text" name ="contact_id" id="contact_id" value="${contact.last_name}" readonly>
    </div>
    
    <div>
      <label for="last_name">LAST NAME</label>
      <input type="text" name ="last_name" id= "last_name" value="${contact.last_name}">
    </div>
    
    <div>
      <label for="first_name">FIRST NAME</label>
      <input type="text" name ="fitst_name" id="first_name" value="${contact.first_name}">
    </div>
    
    <div>
      <label for="email">EMAIL</label>
      <input type="text" name ="email" id= "email" value="${contact.email}">
    </div>
    
    <div>
      <label for="mobile">MOBILE</label>
      <input type="text" name ="mobile" id= "mobile" value="${contact.mobile}">
    </div>
  
  </form>






</body>
</html>