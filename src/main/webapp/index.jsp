<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/Base.css" media="screen" />
        <script src="https://argnd.github.io/ProcessingJS/Processing.js"></script>
        <script src="scripts/Utils.js"></script>
        <title>JSP - JEE</title>
    </head>

    <body style="">
        <h1><%= "Bienvenu sur MA PAGe §§! " %></h1>
        <p>
            <a href="auth/hello">Hello Servlet</a>
            <br>
        </p>
        <p>
            <a href="auth/basicinsert">Insert</a>
            <br>
        </p>
        <p>
            <a href="auth/listproduct">List</a>
            <br>
        </p>
        <p>
            <a href="http://localhost:8080/Hello_JavaEE_war_exploded/Vues/login.html">Login</a>
            <br>
        </p>
        <p>
            <label for="maValeur"></label><input id="maValeur" type="number">
            <br>
        </p>
            <input type="button" onclick="location.href=showChosenIdProduct();return false" value="VALIDER" />
            <br>
        <canvas id="aquariumCanvas"></canvas>
        <script src="scripts/Aquarium.js"></script>
        <div class = "container">
            <div class="wrapper">
                <span class="marquee">90's Rock !!</span>
            </div>
        </div>
    </body>
</html>