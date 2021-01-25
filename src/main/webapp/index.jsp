<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teachers App</title>
    <link rel="stylesheet" href="/TeachersWebApp/css/style.css">
</head>
<body>
	<h1>Εφαρμογή διαχείρισης καθηγητών </h1>
	<h4>(by Evelina Rimpapova)</h4>
	<h2>Καλώς ήρθατε στην εφαρμογή διαχείρισης καθηγητών!</h2>
	<p>Μπορείτε να:</p>
		<ol>
			<li>Αναζητήσετε καθηγητές</li>
			<li>Εισάγετε καθηγητές</li>
			<li>Ενημερώσετε καθηγητές</li>
			<li>Διαγράψετε καθηγητές</li>
		</ol>
	

	
    <div class="find-teacher">
        <p>Για αναζήτηση, ενημέρωση και διαγραφή καθηγητή, δώστε το επίθετο εδώ:</p>
        <form method="GET" action="/TeachersWebApp/TeacherSearchController"> 
            <input type="text" name="teacher_surname" placeholder="Επίθετο...">
            <button  class="RightButton" type="submit">Αναζήτηση</button>
        </form>
        
        <p>Εναλλακτικά, μπορείτε να κάνετε αναζήτηση και εδώ:
         <a href="/TeachersWebApp/TeachersApp.html">
            <button class="BelowButton" type="button">Restfull App</button></a></p>
        
    </div>

    <div class="insert-teacher">
        <p>Για εισαγωγή καθηγητή, δώστε τα στοιχεία εδώ:</p>
        <form method="POST" action="/TeachersWebApp/TeacherInsertController">
	        <table>
	        	<tr><td>
	        		<input type="text" name="teacher_id" placeholder="id" required pattern="[0-9]+">
	        	</td></tr>
	        	<tr><td>
	                 <input type="text" name="teacher_firstname" placeholder="Όνομα" required maxlength="50" pattern="^[a-zA-Z\u0370-\u03ff\u1f00-\u1fff]+$">
	        	</td></tr>
	        	<tr><td>
	        	      <input type="text" name="teacher_lastname" placeholder="Επίθετο" required  maxlength="50" pattern="^[a-zA-Z\u0370-\u03ff\u1f00-\u1fff]+$">
	        	</td></tr>
	        	<tr><td>
					<button class="BelowButton" type="submit">Εισαγωγή</button>
	        	</td></tr>
	        </table>   
        </form>
    </div>
</body>
</html>