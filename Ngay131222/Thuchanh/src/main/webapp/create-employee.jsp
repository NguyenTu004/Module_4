<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/13/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Create employee</h1>
    <form action="${pageContext.request.contextPath}/employee/create" method="post" class="form form-check-label">
        <label for="name">Name</label>
        <input type="text" name="name" id="name"><br>
        <label for="salary">Salary</label>
        <input type="number" name="salary" id="salary"><br>
        <button class="btn btn-primary" type="submit">Create</button>
        <button class="btn btn-primary" type="button">
            <a style="color:white;" href="${pageContext.request.contextPath}/employee/home">Back</a>
        </button>
    </form>
</div>
</body>
</html>
