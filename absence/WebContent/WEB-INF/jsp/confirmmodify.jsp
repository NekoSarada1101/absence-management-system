<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    AbsenceBeans modifyBeans = (AbsenceBeans) session.getAttribute("modifyAbsenceBeans");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修正確認</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">公欠修正確認</h4>
        <p class="text-center">以下の情報で修正しますか？</p>

        <table class="col-10 mr-auto ml-auto table">
            <tr class="row">
                <th class="col-3">公欠日</th>
                <td class="col-9"><%=modifyBeans.getAbsenceDate()%>
                </td>
            </tr>
            <tr class="row">
                <th class="col-3">企業名</th>
                <td class="col-9"><%=modifyBeans.getCompanyName()%>
                </td>
            </tr>
            <tr class="row">
                <th class="col-3">理由</th>
                <td class="col-9"><%=modifyBeans.getReason()%>
                </td>
            </tr>
        </table>

        <form action="updatemodify" method="get">
            <div class="col-9 mr-auto ml-auto mb-4 text-center">
                <button class="btn btn-primary" type="submit">修正する</button>
            </div>
        </form>

        <form action="modify" method="get" class="float-right back">
            <div>
                <button class="btn btn-outline-secondary waves-effect" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>