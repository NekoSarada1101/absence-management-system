<%@ page import="absence.beans.HomeroomBeans" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<HomeroomBeans> homeroomList = (List<HomeroomBeans>) session.getAttribute("homeroomlist");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/teachermypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-lg-6 col-md-8 col-sm-10 col-10 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">クラス選択</h4>

        <%for (HomeroomBeans bean : homeroomList) {%>

        <div class="text-center mr-auto ml-auto mt-4 mb-4">
            <form action="teacherdisplist" method="post">
                <button class="col-xl-5 col-md-7 col-8 btn btn-link" type="submit"
                        value="<%=bean.getClassCode()%>" name="classcode"><%=bean.getCourseName() + bean.getGrade() + bean.getClassName()%>
                </button>
            </form>
        </div>
        <%}%>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>
