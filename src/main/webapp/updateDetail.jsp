<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
    <title>Update</title>
</head>

<body>
    <c:set  value="${detail}" var = "detail" />
    <form class ="outerBox" action="../update/${detail.uuid}" method='post'>
        <h3>Enter Job Detail</h3>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter First name' name="first_name" value="${detail.first_name}"/>
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Last Name' name='last_name' value="${detail.last_name}"/>
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Street' name='street' value="${detail.street}"/>
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Address' name='address' value="${detail.address}"/>
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter City' name='city'  value="${detail.city}"/>
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter State' name='state' value="${detail.state}" />
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter Email' name='email'  value="${detail.email}"/>
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Phone' name='phone'  value="${detail.phone}"/>
            </div>
        </div>
        <button type='submit' class ='form_submit'>Submit</button>
    </form>
    
</body>

</html>