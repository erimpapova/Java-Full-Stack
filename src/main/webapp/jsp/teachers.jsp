<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Αποτελέσματα Αναζήτησης</title>
    <link rel="stylesheet" href="/TeachersWebApp/css/style.css">
</head>
<body>
    <div class="teachers_found">
    <h2>${intro}</h2>

        <table>
	        <tr>
		        <c:if test="${not empty teachers}">
	     			<th>ID</th>
		        	<th>Όνομα</th>
		        	<th>Επίθετο</th>
		        	<th>Διαγραφή</th>
		        	<th>Ενημέρωση</th>
				</c:if>
	        </tr>
	        <c:forEach var = "row" items =  "${teachers}">
	        	<tr>
	        		<td>${row.id}</td>
		        	<td>${row.fname}</td>
                    <td>${row.sname}</td>
                    <td><a href="/TeachersWebApp/TeacherDeleteController?id=${row.id}">
                    	<img src="/TeachersWebApp/img/delete-sign.png" width=23px;></a>
                    </td>
                    <td><a href="/TeachersWebApp/PrepareTeacherUpdateController?id=${row.id}">
                    	<img src="/TeachersWebApp/img/update.jpg" width=18px;></a>
	        	</tr>
	        </c:forEach>
        </table>
         <a href="/TeachersWebApp/index.jsp"> 
         	<button class="BelowButton" type="button">Πίσω</button>
         </a>
       
    </div>
</body>
</html>

