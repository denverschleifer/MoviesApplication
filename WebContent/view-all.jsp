<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Java Web Programming: Movie List</title>
		<meta name="description" content="This is a JSP page that shows how to output every
		movie in my Excel spreadsheet to a web page.">
<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Movie List</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<c:choose>
					<c:when test="${empty movies}">
						<p>Sorry, the list of movies is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="movie" items="${movies}">
							<div class="span3">
								<p><strong>Movie Title: </strong>${movie.movieTitle} <strong>Movie Director: </strong> ${movie.director} <strong>Movie Length in Minutes: </strong> ${movie.lengthInMinutes} </p>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>