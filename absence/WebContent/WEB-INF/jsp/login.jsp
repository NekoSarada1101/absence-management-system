<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String error = (String) session.getAttribute("error");
    if (error == null) {
        error = "";
    }
    session.removeAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ログイン</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/mypage.css" rel="stylesheet">
</head>
<body class="light-blue lighten-5">
<header class="w-100 p-1 mb-5 z-depth-1 blue-gradient text-white">
    <img src="img/absence.png" alt="公欠管理システムアイコン">
</header>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">学生ログイン</h4>

        <form action="auth" method="post">
            <div class="md-form col-8 mr-auto ml-auto p-0">
                <input type="text" id="form1" class="form-control" maxlength="7" name="id" autofocus required>
                <label for="form1">学籍番号</label>
            </div>

            <div class="md-form col-8 mr-auto ml-auto p-0">
                <input type="password" id="form2" class="form-control" name="password" required>
                <label for="form2">パスワード</label>
                <p class="mt-4 mb-5 text-danger"><%=error %>
                </p>
            </div>

            <div class="col-8 text-center mr-auto ml-auto mb-4">
                <button class="btn btn-primary" type="submit">ログイン</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp"%>

</body>
</html>
