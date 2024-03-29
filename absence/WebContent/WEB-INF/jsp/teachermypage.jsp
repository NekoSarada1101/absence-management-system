<%@ page import="absence.beans.TeacherBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String name = ((TeacherBeans) session.getAttribute("teacherBeans")).getTeacherName();
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
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<header class="w-100 p-1 mb-5 z-depth-1 purple-gradient header sticky-top">
    <a href="teachermenu"><img src="img/absence.png" alt="公欠管理システムアイコン"></a>
    <p class="ml-2"><%=name%>先生</p>
    <form action="logout" method="get" class="text-right">
        <button class="btn btn-blue-grey p-2 logout" type="submit">ログアウト</button>
    </form>
</header>
</body>
</html>
