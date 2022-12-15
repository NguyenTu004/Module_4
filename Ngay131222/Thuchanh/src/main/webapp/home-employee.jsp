<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/13/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
    <div class="container" >
        <h1>List Employee</h1>
        <button ><a href="${pageContext.request.contextPath}/employee/create-form">Create</a></button>
        <table class="table table-hover" >
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listEmployees}" var="e">
                <tr>
                    <td><c:out value="${e.id}"/></td>
                    <td><c:out value="${e.name}"/></td>
                    <td><c:out value="${e.salary}"/></td>
                    <td>
                        <button class="btn btn-primary" type="button">
                            <a style="color:white;" href="${pageContext.request.contextPath}/employee/update-form/${e.id}">
                                Update</a>
                        </button>
                        <button class="btn btn-primary" type="button">
                            <a style="color:white;" href="${pageContext.request.contextPath}/employee/delete-form/${e.id}">
                                Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<%--    modal  --%>
    <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Show a second modal and hide this one with the button below.
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal" data-bs-dismiss="modal">Open second modal</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
