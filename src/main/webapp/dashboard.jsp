
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/user.css">
    <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <title>Document</title>
</head>
<body>
    <a href="/create"><button class="createEmp">Add Employee</button></a>
    <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%" >
        <thead>
            <tr>
                <th>Sr No.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Street</th>
                <th>Email</th>
                <th>Phone No</th>
                <th>Action</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="emp" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${emp.first_name}</td>
                    <td>${emp.last_name}</td>
                    <td>${emp.address}</td>
                    <td>${emp.city}</td>
                    <td>${emp.state}</td>
                    <td>${emp.street}</td>
                    <td>${emp.email}</td>
                    <td>${emp.phone}</td>
                    <td><a href="/edit/${emp.uuid}"><button class="action" style="background-color: greenyellow;">Edit</button></a><a href="/delete/${emp.uuid}"><button class="action" style="background-color: red;">Delete</button></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
<script>
    $(document).ready(function() {
	//Only needed for the filename of export files.
	//Normally set in the title tag of your page.
	document.title='Simple DataTable';
	// DataTable initialisation
	$('#example').DataTable();
});
</script>