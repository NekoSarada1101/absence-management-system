<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<AbsenceBeans> list = (ArrayList<AbsenceBeans>) session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>公欠履歴</title>
</head>
<body>
<h2>公欠履歴</h2>
<table>
    <thead>
    <tr>
        <th>公欠日</th>
        <th>企業名</th>
        <th>理由</th>
    </tr>
    </thead>
    <tbody>
    <%for(AbsenceBeans bean : list){%>
    <tr>
        <td><%=bean.getAbsenceDate()%></td>
        <td><%=bean.getCompanyName()%></td>
        <td><%=bean.getReason()%></td>
    </tr>
    <%}%>
    </tbody>
</table>

<form action="menu" method="post">
    <input type="submit" value="戻る">
</form>

</body>
</html>
