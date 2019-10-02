<%@ page import="absence.beans.LoginInfoBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String name = ((LoginInfoBeans) session.getAttribute("loginInfo")).getUserName();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>マイページ</h1>
<%=name%>さん
<form action="logout" method="get">
    <input type="submit" value="ログアウト">
</form>
</body>
</html>
