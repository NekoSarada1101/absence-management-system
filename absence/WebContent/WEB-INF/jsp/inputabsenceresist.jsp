<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録</title>
</head>
<body>
<h2>公欠登録</h2>
<form action="confirmabsenceresist" method="post">
    <p>公欠年月日
        <input type="date" value="2019-10-11" name="date"></p>
    <p>企業名<input type="text" name="name"></p>
    <p>理由<input type="text" name="reason"></p>
    <p><input type="submit" value="登録"></p>
</form>
<form action="menu" method="post">
    <input type="submit" value="戻る">
</form>
</body>
</html>
