<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@ include file="/Vues/Header.jsp" %>
    <div class="row">
        <div class="col-md-6">
            <h2 class="h1-responsive font-weight-bold text-center my-4">Ajouter Category</h2>
            <form action="<c:url value="/auth/addcategory" />" method="post" class='bd-example'>
                <div class="mb-3">
                    <label for='name' class="form-label"> Name Produit: </label>
                    <input type='text' class="form-control" name='name' id='name'>
                </div>

                <div class='form'>
                    <input type='submit' class="btn btn-primary" value='submit'>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="/Vues/Footer.jsp" %>
</div>
</body>
</html>