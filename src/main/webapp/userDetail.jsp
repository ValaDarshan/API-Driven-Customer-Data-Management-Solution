<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/form.css">
    <title>Create</title>
</head>

<body>
    <!-- <c:set  value="${detail}" var = "detail" /> -->
    <form class ="outerBox" action="add" method='post'>
        <h3>Enter Job Detail</h3>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter First name' name="first_name" />
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Last Name' name='last_name' />
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Street' name='street' />
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Address' name='address' />
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter City' name='city'  />
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter State' name='state'  />
            </div>
        </div>
        <div class ="formBox">
            <div class ="inputBox">
                <input type="text" placeholder='Enter Email' name='email'  />
            </div>
            <div class ="inputBox">
                <input type="text" placeholder='Enter Phone' name='phone'  />
            </div>
        </div>
        <button type='submit' class ='form_submit'>Submit</button>
    </form>
    
</body>

</html>