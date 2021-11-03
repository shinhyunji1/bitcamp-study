<%@page import="com.eomcs.pms.domain.Member"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원목록</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">

  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../bootstrap/dist/bootstrap.css"></script>
  
  <style>
  .container {
    xborder: 1px solid red;
    width: 640px;
  }
  </style>
  
</head>
<body>
<div class="container">
<h1>회원 목록(MVC + EL + JSTL + Bootstrap)</h1>
<a href='form' class="btn btn-outline-primary btn-sm">새회원</a><br>
<table class="table table-hover">
<thead>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
    <th>전화</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<% 
Collection<Member> memberList = (Collection<Member>) request.getAttribute("memberList");

for (Member member : memberList) {
%>
<tr>
    <td><%=member.getNo()%></td>
    <td><a href='detail?no=<%=member.getNo()%>'><%=member.getName()%></a></td> 
    <td><%=member.getEmail()%></td> 
    <td><%=member.getTel()%></td> 
    <td><%=member.getRegisteredDate()%></td>
</tr>
<%} %>
</tbody>
</table>
</div><!-- .container -->
</body>
</html>