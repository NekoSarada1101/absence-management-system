<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
</head>
<body>
<h1>公欠管理システム</h1>

<h2>学生ログイン</h2>
<form action="Auth" method="post">
    <input type="text" name="id">
    <input type="password" name="password">

    <input type="submit" value="ログイン">
</form>

</body>
</html>