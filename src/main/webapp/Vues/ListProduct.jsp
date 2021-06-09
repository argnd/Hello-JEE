<%--
  Created by IntelliJ IDEA.
  User: gando
  Date: 08/06/2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>HELlO</title>
        <link rel="stylesheet" href="../css/Base.css" media="screen" />
    </head>
    <body >
        <table>
        <c:forEach items="${liste}" var="t">
            <tr>
                <td><c:out value="${l.name}" /></td>
                <td><c:out value="${t.content}" /></td>
                <td><c:out value="${t.price}"/></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>