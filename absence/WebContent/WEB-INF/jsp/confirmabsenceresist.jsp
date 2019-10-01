<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    AbsenceBeans absenceBeans = (AbsenceBeans) session.getAttribute("absenceBean");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録確認</title>
</head>
<body>
<h2>公欠登録確認</h2>
<p>以下の情報で登録しますか？</p>
<p>公欠日<%=(absenceBeans.getAbsenceDate()).toString()%>
</p>
<p>企業名<%=absenceBeans.getCompanyName()%>
</p>
<p>理由<%=absenceBeans.getReason()%>
</p>

<form action="insertabsenceresist" method="get">
    <input type="submit" value="登録する">
</form>
<form action="inputabsenceresist" method="get">
    <input type="submit" value="戻る">
</form>

</body>
</html>
