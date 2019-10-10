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
    <title>修正・削除選択画面</title>
</head>
<body class="light-blue lighten-5">
<%@include file="/WEB-INF/jsp/mypage.jsp" %>

<div class="container p-0">
    <article class="border rounded col-12 mr-auto ml-auto bg-white">
        <h4 class="text-center mt-4 mb-4">修正・削除</h4>

        <div id="table">
            <table class="col-10 mr-auto ml-auto table table-hover">
                <thead>
                <tr class="row">
                    <th class="col-3" scope="col">公欠日</th>
                    <th class="col-3" scope="col">企業名</th>
                    <th class="col-4" scope="col">理由</th>
                    <th class="col-2" scope="col">修正・削除</th>
                </tr>
                </thead>
                <tbody class="list">

                <%--履歴データを表示--%>
                <%for (int i = 0; i < list.size(); i++) {%>
                <tr class="row">
                    <td class="col-3"><%=list.get(i).getAbsenceDate()%>
                    </td>
                    <td class="col-3"><%=list.get(i).getCompanyName()%>
                    </td>
                    <td class="col-4"><%=list.get(i).getReason()%>
                    </td>
                    <td class="col-2">
                        <form method="post" action="modify">
                            <input type="hidden" name="modifyAbsence" value="<%=i%>">
                            <div class="text-center">
                                <button type="submit"
                                        class="btn btn-outline-warning waves-effect pr-4 pl-4 pt-1 pb-1 mr-auto ml-auto">
                                    修正
                                </button>
                            </div>
                        </form>
                        <form method="post" name="form1" action="confirmdelete">
                            <input type="hidden" name="deleteAbsence" value="<%=i%>">
                            <div class="text-center mt-2">
                                <button type="submit" class="btn btn-link pr-4 pl-4 mr-auto ml-auto mt-n3"><p class="text-danger">削除</p></button>
                            </div>
                        </form>
                    </td>
                </tr>
                <%}%>

                </tbody>
            </table>
        </div>

        <form action="menu" method="get" class="text-right mr-1 mb-4">
            <div>
                <button class="btn btn-outline-secondary waves-effect" type="submit">戻る</button>
            </div>
        </form>
    </article>
</div>

<%@include file="/WEB-INF/jsp/script.jsp" %>

</body>
</html>
