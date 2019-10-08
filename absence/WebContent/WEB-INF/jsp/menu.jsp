<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <div class="text-center mr-auto ml-auto mt-4 mb-4">
            <form action="inputabsenceresist" method="get">
                <button class="col-xl-5 col-md-7 col-8 btn btn-primary" type="submit">新規作成</button>
            </form>
        </div>

        <div class="text-center mr-auto ml-auto mb-4">
            <form action="dispabsencelist" method="post">
                <button class="col-xl-5 col-md-7 col-8 btn btn-outline-success waves-effect" type="submit">公欠履歴表示
                </button>
            </form>
        </div>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>
