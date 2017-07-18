<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="utf-8">
<title>Family Tree</title>
</head>
<body>


	<div class="tree">
		<ul>
			<c:forEach var="people" items="${GreatGrandparents}">
				<li class="GreatGrandParents"><a href="nope.jsp"> <c:out
							value="${people.fname}"/> <br><br>
							<c:out value="${people.relation}"/><br> <br>
				</a> <br> <br>
			</c:forEach>


			<c:forEach var="people" items="${Grandparents}">
				<ul>
					<li class="Grandparents"><a href="nope.jsp"> <c:out
								value="${people.fname}" /> <br><br>
								<c:out value="${people.relation}"/><br>
							<br>
					</a> <br> <br>
			</c:forEach>

			<c:forEach var="people" items="${Parents}">
				<ul>
					<li class="Parents"><a href="nope.jsp"> <c:out
								value="${people.fname}"/><br><br> 
								<c:out value="${people.relation}"/><br>
							<br>
					</a> <br>
			</c:forEach>

			<c:forEach var="people" items="${You}">
				<ul>
					<li class="You"><a href="nope.jsp"> <c:out
								value="${people.fname}"/> <br><br>
								<c:out value="${people.relation}"/><br>
							<br>
					</a> <c:forEach var="people" items="${Children}">
							<ul>
								<li class="You"><a href="nope.jsp"> <c:out
											value="${people.fname}" /> <c:out value="${people.relation}"/> <br> <br>
								</a> <br> <br></li>
						</c:forEach>
			</c:forEach>
			</li>
			<c:forEach var="people" items="${Siblings}">
				<li class="Siblings"><a href="nope.jsp"> <c:out
							value="${people.fname}" /><br><br>
							<c:out value="${people.relation}"/> <br> <br>
				</a> <br> <br></li>
			</c:forEach>
		</ul>
	</div>

	<br>
	<br>
	<a href="index2.html" class="button">Go back</a>

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