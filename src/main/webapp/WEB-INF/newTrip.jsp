<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Vacay Time </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1> Book your next vacation  </h1>
    <form:form action="/trip/new" method="POST" modelAttribute="newTrip"  >
        <div class="mb-3">
            <form:label for="name" class="form-label" path="name">Expense Name :</form:label>
            <form:input style="width:250px;" type="text" class="form-control" id="name" aria-describedby="name" path="name"/>
            <form:errors path="name" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="vendor" class="form-label" path="vendor">Vendor:</form:label>
            <form:input style="width:250px;" type="text" class="form-control" id="vendor" aria-describedby="vendor" path="vendor"/>
            <form:errors path="vendor" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="amount" class="form-label" path="amount">Amount:</form:label>
            <form:input style="width:250px;" type="number" class="form-control" id="amount" aria-describedby="amount" path="amount"/>
            <form:errors path="amount" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="description" class="form-label" path="description">Description:</form:label>
            <form:input style="width:250px;" type="text" class="form-control" id="description" aria-describedby="description" path="description"/>
            <form:errors path="description" class="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary">Add Trip </button>
    </form:form>
</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
