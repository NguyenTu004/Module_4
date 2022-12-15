<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/12/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<body>
    <div class="container">
        <form action="${pageContext.request.contextPath}/moneyChange" method="post">
        <label for="usd">USD</label>
        <input type="number" name="usd" id="usd"><br>
        <button class="btn btn-primary" type="submit">Submit</button>
        </form>
        <label for="vnd">VND</label>
        <input type="number" name="vnd" id="vnd" value="${amount}"><br>
    </div>
</body>
</html>
