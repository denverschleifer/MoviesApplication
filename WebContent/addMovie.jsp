<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Java Web Programming: Add Movie</title>
		<meta name="description" content="This is a JSP example that demostrates how to use a form to add a new Movie to the database">
<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Add Movie</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<form action="AddMovie" method="post">
					<label for="Movie"><strong>Movie Title:</strong></label>
					<input name="movieTitle"><br>
					
					<label for="director"><strong>Director:</strong></label>
					<input name="director"><br>
					
					<label for=""><strong>Length In Minutes:</strong></label>
					<input name="lengthInMinutes"><br>
					
					<input type="submit" value="Add Movie">
				</form>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>