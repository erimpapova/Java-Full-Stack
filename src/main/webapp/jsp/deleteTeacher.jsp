<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Results</title>
    <link rel="stylesheet" href="/TeachersWebApp/css/style.css">
</head>
<body>
    <div class="deleted_teacher">
        <h2>${intro}</h2>
        <table>
	        <tr>
	        	<td>ID:</td>
	        	<td>${deletedTeacher.id}</td>
	        </tr>
	        <tr>
	        	<td>Name:</td>
	        	<td>${deletedTeacher.fname}</td>
	        </tr>
	        <tr>
	        	<td>Surname:</td>
	        	<td>${deletedTeacher.sname}</td>
	        </tr>
        </table>
        <a href="/TeachersWebApp/index.jsp">
            <button class="BelowButton" type="button">Πίσω</button></a>
        
    </div>
</body>
</html>