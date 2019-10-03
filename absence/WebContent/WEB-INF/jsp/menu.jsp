<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto">
        <div class="col-8 text-center mr-auto ml-auto mt-4 mb-4">
            <form action="inputabsenceresist" method="get">
                <button class="btn btn-primary" type="submit">新規作成</button>
            </form>
        </div>

        <div class="col-8 text-center mr-auto ml-auto mt-4 mb-4">
            <form action="dispabsencelist" method="post">
                <button class="btn btn-outline-success waves-effect" type="submit">公欠履歴表示</button>
            </form>
        </div>
    </article>
</div>

<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>
