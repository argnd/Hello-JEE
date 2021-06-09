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
<h1><%= "Bienvenu sur MA PAGe §§! " %></h1>

<h2>
    <a href="${pageContext.request.contextPath}/Vues/login.html">Login</a>
    <br>
</h2>
<p>
    <a href="${pageContext.request.contextPath}/auth/basicinsert">Insert</a>
    <br>
</p>
<p>
    <a href="${pageContext.request.contextPath}/auth/listproduct">List</a>
    <br>
</p>

<form action="${pageContext.request.contextPath}/auth/addCategory" method="post">
    <button type="submit" name="btn1.0101" value="your_value" class="btn-link">TEST JPA</button>
</form>


<p>
    <label for="maValeur"></label><input id="maValeur" type="number">
    <br>
</p>
<input type="button" onclick="location.href=showChosenIdProduct();return false" value="VALIDER" />
<br>
<canvas id="aquariumCanvas"></canvas>
<script src="${pageContext.request.contextPath}/scripts/Aquarium.js"></script>
<div class = "container">
    <div class="wrapper">
        <span class="marquee">90's Rock !!</span>
    </div>
</div>
</body>
</html>