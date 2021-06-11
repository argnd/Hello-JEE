<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Base.css" media="screen" />
        <script src="https://argnd.github.io/ProcessingJS/Processing.js"></script>
        <script src="${pageContext.request.contextPath}/scripts/Utils.js"></script>
        <title>JSP - JEE</title>
    </head>

    <body style="">
        <div class="header">
            <%= "Bienvenu... " %>
        </div>
        <%--header ends--%>
        <div class = "row">
            <div class="col-3 menu">
                <a href="${pageContext.request.contextPath}/Vues/login.html">Login</a>
                <br>
                <br>
                <a href="${pageContext.request.contextPath}/auth/basicinsert">Insert</a>
                <br>
                <br>
                <a href="${pageContext.request.contextPath}/auth/listproduct">List</a>
                <br>
                <br>
                <form action="${pageContext.request.contextPath}/add" method="post">
                    <button type="submit" name="btn1.0101" value="your_value" class="btn-link">TEST JPA</button>
                </form>
            </div>

            <div class="col-5 menu">
                <label for="maValeur"></label><input id="maValeur" type="number">
                <input type="button" onclick="location.href=showChosenIdProduct();return false" value="VALIDER" />
            </div>

            <div class="col-9">
                <canvas id="aquariumCanvas"></canvas>
                <script src="${pageContext.request.contextPath}/scripts/Aquarium.js"></script>
                <div class = "container">
                    <div class="wrapper">
                        <span class="marquee">90's Rock !!</span>
                    </div>
                </div>
            </div>
        </div>
        <%--row ends--%>
    </body>
</html>