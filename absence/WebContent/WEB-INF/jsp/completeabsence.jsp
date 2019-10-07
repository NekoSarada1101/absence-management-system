<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録完了</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-5">公欠登録完了</h4>
        <p class="text-center mb-5">公欠届を提出しました</p>

        <form action="menu" method="get">
            <div class="mr-auto ml-auto mb-4 text-center">
                <button class="btn btn-primary" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>
