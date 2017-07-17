<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body style="margin: auto;width: 50%;padding: 10px;align-items:center;background-image: url('https://static.pexels.com/photos/56875/tree-dawn-nature-bucovina-56875.jpeg');">
	<c:choose>
		<c:when test="${result}">
			All members have been deleted.
		</c:when>
		<c:otherwise>
			<p>No person found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>
	<a href="index.html">Go back</a>
	<br>

</body>
</html>