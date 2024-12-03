<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>Person list</title>
<script>
  
  //Model에 저장된 속성(Attribute) msg1 확인해 본다. 확인된다면 전달이 된 것이고, 아니라면 안 된 것이다.
  const msg1 = '${msg1}';
  alert ('msg1 : ' + msg1);
  
  // 

</script>
</head>
<body>
  
  <%-- 속성을 만드는 태그(Attribute) --%>
  <%-- var 태그 속성 : 속성의 이름을 작성한다. value 태그 속성 : 속성의 값을 저장한다. --%>
  <c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
  <div>
    <a href="${contextPath}/redirect/main.do">이동하러 가기</a>
  </div>
  
  <%-- 속성 people 반복 태그로 출력하기 --%>
  <c:forEach var="person" items="${people}">
    <div>
      <div>${person.name}</div>
      <div>${person.age}</div>
    </div>  
  </c:forEach>
  
</body>
</html>