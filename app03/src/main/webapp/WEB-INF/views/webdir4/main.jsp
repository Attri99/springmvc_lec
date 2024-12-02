<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1.0">
<title>form submit</title>
</head>
<body>
  <%-- 요청 만들기 2 : <form> 태그의 submit (get, post 방식을 선택할 수 있다. --%>
  <%--
    action : 요청 주소 작성
    method : 요청 메소드 작성 
      1) 요청 메소드 작성한다.
      2) get, post 방식을 사용한다.
      3) 디폴트는 get 방식
      4) 모든 요청은 Query String 방식의 요청으로 처리된다.
      5) get 방식으로 처리하면 요청 주소에 요청 파라미터가 노출된다.
      6) post 방식으로 처리하면 요청 주소에 요청 파라미터가 노출되지 않는다. (보안에 좋다, 대신 약간 느림)
     --%>
<form action="<%=request.getContextPath()%>/webdir4/req1" method="get">
   
  <%-- 입력 상자(text, number, email, url, password) --%>
  <input type="text" name="a"><br/>
  <input type="number" name="b"><br/>
  <input type="email" name="c"><br/>
  <input type="url" name="d"><br/>
  <input type="password" name="e"><br/>
  <input type="date" name="f"><br/>

  <%-- 서브밋(action에 작성된 주소로 모든 입력 요소들을 보낸다.) --%>
  <button type="submit">서브밋</button>
    
</form>

<hr/>

  <form action="<%=request.getContextPath()%>/webdir4/req2" method="get">
    
    <%-- 모든 선택 상자는 선택했을 경우 디폴트 value="on"을 가진다. --%>
    
    <%-- 선택 상자 : 다중 선택이 가능한 checkbox(같은 name으로 보내기) - 디폴트 value="on"을 사용할 수 없다. --%>
      <input type="checkbox" name="flowers" id="rose" value="rose">
      <label for="rose">장미</label>
      <input type="checkbox" name="flowers" id="tulip" value="tulip">
      <label for="tulip">튤립</label>
      <br/>
            
    <%-- 선택 상자 : 다중 선택이 가능한 checkbox(다른 name으로 보내기) - 디폴트 value="on"을 사용할 수 있다. --%>  
      <input type="checkbox" name="kbs" id="kbs">
      <label for="kbs">kbs</label>
      <input type="checkbox" name="mbc" id="mbc">
      <label for="mbc">mbc</label>
      <input type="checkbox" name="sbs" id="sbs">
      <label for="sbs">sbs</label>
      <br/>  
    
    <%-- 선택 상자 : 단일 선택만 가능한 radio --%>
    <input type="radio" name="choice" id="yes">
    <label for="yes">yes</label>
    <input type="radio" name="choice" id="no">
    <label for="no">no</label>
    
    <button type="submit">서브밋</button>
  </form>  
  <hr/>
  
  <form action="<%=request.getContextPath()%>/webdir4/req3" method="get">
  
  <%-- 모든 목록 요소는 <option> 태그의 내부 텍스트(textContent)가 value로 전달된다 --%>
  <%-- <option> 태그에 value 속성을 추가하면 value 속성 값이 전달된다. --%>
  
  <%-- 선택 요소 : select 태그와 option 태그 --%>
  <select>
    <option>seoul</option>
    <option>jeju</option>
  </select>
  <br/>
  
  <%-- 콤보 요소 : input 태그와 datalist 태그 --%>
  <input type="text" name="domain" list="domain-list">
  <datalist id="domain-list">
    <option value="naver">naver.com</option>
    <option value="kakao">kakao.com</option>
  </datalist>  
  <br/>
  
  <%-- 다중 라인 입력 요소 : <textarea> 태그 --%>
  <textarea name="content"></textarea>
  <br/>
  
  <%-- 서브밋(action에 작성된 주소로 모든 입력 요소들을 보낸다.) --%>
  <button type="submit">서브밋</button>
  
  
  </form>
</body>
</html>