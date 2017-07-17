<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--  <link href="style.css" rel="stylesheet">-->
<meta charset="utf-8">
<title>Family Tree</title>
</head>
<body>

	<c:forEach var="people" items="${all}">
        Relation: ${people.key}  - People: ${people.value}
    </c:forEach>
	<div class="tree">
		<ul>
			<li><a href="nope.jsp"><c:forEach var="people"
						items="${GreatGrandparents}">
						<c:out value="${people.fname}" />
						<br>
						<br>
					</c:forEach></a>
				<ul>
					<li><a href="#"><c:forEach var="people"
								items="${Grandparents}">
								<c:out value="${people.fname}" />
								<br>
								<br>
							</c:forEach></a>
						<ul>
							<li><a href="nope.jsp"><c:forEach var="people"
										items="${Parents}">
										<c:out value="${people.fname}" />
										<br>
										<br>
									</c:forEach></a>
								<ul>
									<li><a href="nope.jsp"><c:forEach var="people"
												items="${You}">
												<c:out value="${people.fname}" />
												<br>
												<br>
											</c:forEach></a>
											</li>
											<li>
											<a href="nope.jsp"><c:forEach var="people"
												items="${Siblings}">
												<c:out value="${people.fname}" />
												<br>
												<br>
											</c:forEach></a>
											</li>
										<ul>
											<li><a href="nope.jsp"><c:forEach var="people"
														items="${Children}">
														<c:out value="${people.fname}" />
														<br>
														<br>
													</c:forEach></a> <a href="index.html">Go back</a>
	</div>
</body>
</html>


<%-- <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty all}">
			<c:forEach var="people" items="${all}">
				<c:out value="${people.relation}" /><br>
				<c:out value="${people.fname}" /><br>
				<c:out value="${people.lname}" /><br>
				<c:out value="${people.age}" /><br>
				<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No person found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>
	<a href="index.html">Go back</a>
</body>
</html> --%>