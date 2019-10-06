<%@ page import="absence.beans.LoginInfoBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String name = ((LoginInfoBeans) session.getAttribute("loginInfo")).getUserName();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>トップ</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/mypage.css" rel="stylesheet">
</head>
<body>
<header class="w-100 p-1 mb-5 z-depth-1 blue-gradient header">
    <a href="menu"><img src="img/absence.png" alt="公欠管理システムアイコン"></a>
    <p class="ml-2"><%=name%>さん</p>
    <form action="logout" method="get" class="text-right">
        <button class="btn btn-blue-grey logout" type="submit">ログアウト</button>
    </form>
</header>
</body>
</html>
