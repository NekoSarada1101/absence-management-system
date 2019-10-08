<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    //今日の日付を公欠日の初期値にする
    String date = (String) request.getAttribute("date");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">公欠登録</h4>

        <form action="confirmabsenceresist" method="post">
            <%--公欠年月日入力フォーム--%>
            <div class="md-form col-8 mr-auto ml-auto p-0">
                <input type="date" value="<%=date%>" id="form3" class="form-control" name="date" autofocus required>
                <label for="form3">公欠年月日</label>
            </div>

            <%--企業名入力フォーム--%>
            <div class="md-form col-8 mr-auto ml-auto p-0">
                <input type="tel" id="form4" class="form-control" maxlength="100" name="name" required>
                <label for="form4">企業名</label>
            </div>

            <%--理由入力フォーム--%>
            <div class="md-form col-8 mr-auto ml-auto p-0">
                <textarea id="form5" class="md-textarea form-control" maxlength="200" name="reason" required></textarea>
                <label for="form5">理由</label>
            </div>

            <div class="col-9 mr-auto ml-auto mb-4 text-center">
                <button class="btn btn-primary" type="submit">登録</button>
            </div>
        </form>

        <form action="menu" method="get" class="float-right back">
            <div>
                <button class="btn btn-outline-warning waves-effect" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>
