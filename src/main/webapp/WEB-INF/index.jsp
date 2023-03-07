<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Safe Travels </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1 class="text-center"> Welcome to Safe Travels   </h1>
    <p> <a href="/trip/new" class="btn btn-outline-primary">Add A trip </a></p>
    <table class="table table-striped table-bordered text-center">
        <thead class="table-dark">
        <tr>
            <th scope="col">Expense</th>
            <th scope="col">Vendor </th>
            <th scope="col">Amount </th>
            <th scope="col">Description</th>
            <th scope="col">Actions </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="trip" items="${allTrips}">
            <tr>
                <td><c:out value="${trip.name}"/></td>
                <td><c:out value="${trip.vendor}"/></td>
                <td><c:out value="${trip.amount}"/></td>
                <td><c:out value="${trip.description}"/></td
            </tr>

            <%--            <td>--%>
            <%--                <a href="/burger/${burger.id}/delete" class="btn btn-danger">Delete</a>--%>
            <%--            </td>--%>

            <td>
                <form action="/trip/${trip.id}" method="POST">
                    <input type="hidden" name="_method" value="delete"/>
                    <button class="btn btn-danger">Delete</button>
                </form>
                <a href="/trip/${trip.id}" class="btn btn-primary">Update</a>
            </td>

        </c:forEach>

        </tbody>
    </table>
</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>