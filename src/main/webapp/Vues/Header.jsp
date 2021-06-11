<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/listproduct" />">  List Produits </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/addproduct" />">Ajout un produit </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/listcategory" />">  List Category </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/addcategory" />">Ajouter Category </a></li>
        </ul>
    </div>

</nav>
</body>
</html>