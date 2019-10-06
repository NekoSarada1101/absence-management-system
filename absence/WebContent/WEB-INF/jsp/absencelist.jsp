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
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">履歴</h4>

        <div id="table">
            <div class="text-right mr-2"><input class="search" placeholder="Search"/></div>
            <table class="col-10 mr-auto ml-auto table table-hover">
                <thead>
                <tr class="row">
                    <th class="sort col-3" data-sort="date" scope="col">公欠日</th>
                    <th class="sort col-4" data-sort="name" scope="col">企業名</th>
                    <th class="sort col-5" data-sort="reason" scope="col">理由</th>
                </tr>
                </thead>
                <tbody class="list">
                <%for (AbsenceBeans bean : list) {%>
                <tr class="row">
                    <td class="date col-3"><%=bean.getAbsenceDate()%>
                    </td>
                    <td class="name col-4"><%=bean.getCompanyName()%>
                    </td>
                    <td class="reason col-5"><%=bean.getReason()%>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>

        <form action="menu" method="get" class="text-right mr-1 mb-4">
            <div>
                <button class="btn btn-outline-warning waves-effect" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

<%--List.js--%>
<script src="//cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>
<script>
    var options = {
        valueNames: ['date', 'name', 'reason']
    };
    var userList = new List('table', options);
    userList.sort('date', {order: 'desc'});
</script>
<style>
    .sort.desc:after {
        content: "▼";
    }

    .sort.asc:after {
        content: "▲";
    }
</style>
</body>
</html>
