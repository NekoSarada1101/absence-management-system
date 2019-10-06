<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    AbsenceBeans absenceBeans = (AbsenceBeans) session.getAttribute("absenceBeans");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録確認</title>
    <link rel="stylesheet" href="css/resist.css">
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">公欠登録確認</h4>
        <p class="text-center">以下の情報で登録しますか？</p>
        <table class="col-10 mr-auto ml-auto table">
            <tr class="row">
                <th class="col-3">公欠日</th>
                <td class="col-9"><%=absenceBeans.getAbsenceDate()%>
                </td>
            </tr>
            <tr class="row">
                <th class="col-3">企業名</th>
                <td class="col-9"><%=absenceBeans.getCompanyName()%>
                </td>
            </tr>
            <tr class="row">
                <th class="col-3">理由</th>
                <td class="col-9"><%=absenceBeans.getReason()%>
                </td>
            </tr>
        </table>

        <form action="insertabsenceresist" method="get">
            <div class="col-9 mr-auto ml-auto mb-1 text-center">
                <button class="btn btn-primary" type="submit">登録する</button>
            </div>
        </form>

        <form action="inputabsenceresist" method="get" class="float-right back">
            <div>
                <button class="btn btn-outline-warning waves-effect" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>





