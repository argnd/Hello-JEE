<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 10/06/2021
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<div class="container">
    <%@ include file="/Vues/Header.jsp" %>
    <div class="row">
        <div class="col-md-6">
            <h2 class="h1-responsive font-weight-bold text-center my-4">List Category</h2>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listcat}" var="t"> <tr>
                    <th scope="row"><c:out value="${t.id}" /></th>
                    <td><c:out value="${t.name}" /></td>
                    <td><a href="<c:url value="/auth/removecategory?id=${t.id}"/>">remove</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%@ include file="/Vues/Footer.jsp" %>
</div>
</body>
</html>