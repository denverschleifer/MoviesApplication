<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Java Web Programming: Search</title>
		<meta name="description" content="This is a JSP page for a simple search">
<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Search</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<form action="Search" method="post">
					<label for="movieTitle"><strong>Search by Movie Title:</strong></label>
					<input name="movieTitle">
					<input type="submit" value="Search!">
				</form>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>