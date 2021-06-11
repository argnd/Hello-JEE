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