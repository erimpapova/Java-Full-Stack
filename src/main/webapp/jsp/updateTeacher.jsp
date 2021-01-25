<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Αλλαγή στοιχείων καθηγητή</title>
    <link rel="stylesheet" href="/TeachersWebApp/css/style.css">
</head>
<body>

    <div class="update-teacher">

        <h2>${intro}</h2>
        <form method="POST" action="/TeachersWebApp/TeacherUpdateController?id=${teacher2Update.id}"> 
            <table>
	        <tr>
	        	<td>ID:</td>
	        	<td> <input type="text" value= "${teacher2Update.id}" readonly></td>
	        </tr>
	        <tr>
	        	<td>Όνομα:</td>
	        	<td><input type="text" name = "fnameUpdate" value= "${teacher2Update.fname}" required maxlength="50" pattern="^[a-zA-Z\u0370-\u03ff\u1f00-\u1fff]+$"></td>
	        </tr>
	        <tr>
	        	<td>Επίθετο:</td>
	        	<td><input type="text" name = "snameUpdate" value= "${teacher2Update.sname}" required maxlength="50" pattern="^[a-zA-Z\u0370-\u03ff\u1f00-\u1fff]+$"></td>
	        </tr>
        </table>
            <button class="BelowButton" type="submit">Ενημέρωση</button>
            <a href="/TeachersWebApp/index.jsp">
            <button class="BelowButton" type="button">Ακύρωση</button></a>
        </form>

        
        
    </div>

    
</body>
</html>