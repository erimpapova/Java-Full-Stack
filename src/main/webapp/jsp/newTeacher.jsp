
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Καθηγητής</title>
    <link rel="stylesheet" href="/TeachersWebApp/css/style.css">
</head>
<body>
    <div>
        <h2>${intro}</h2>
        <table>
	        <tr>
	        	<td>Id:</td>
	        	<td>${insertedTeacher.id}</td>
	        </tr>
	        <tr>
	        	<td>Name:</td>
	        	<td>${insertedTeacher.fname}</td>
	        </tr>
	        <tr>
	        	<td>Surname:</td>
	        	<td>${insertedTeacher.sname}</td>
	        </tr>
        </table>
         <a href="/TeachersWebApp/index.jsp">
            <button class="BelowButton" type="button">Πίσω</button></a>
    </div>
</body>
</html>