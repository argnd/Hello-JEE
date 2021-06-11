<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Produit</title>
</head>
<body>
<div class="container">
    <%@ include file="/Vues/Header.jsp" %>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-8">
            <h2 class="h1-responsive font-weight-bold text-center my-4">List Product</h2>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">content</th>
                    <th scope="col">price</th>
                    <th scope="col">category</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listprod}" var="t"> <tr>
                    <th scope="row"><c:out value="${t.id}" /></th>
                    <td><c:out value="${t.name}" /></td>
                    <td><c:out value="${t.content}" /></td>
                    <td><c:out value="${t.price}" /></td>
                    <td><c:out value="${t.cat.name}" /></td>
                    <td><a href="<c:url value="/auth/removeproduct?id=${t.id}"/>">remove</a></td>
<%--                    <td><a href="<c:url value="/auth/?id=${t.id}"/>">view</a></td>--%>
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