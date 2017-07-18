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
							value="${people.fname}" /> <br> <br> <c:out
							value="${people.relation}" /><br> <br>
				</a> <br>
			</c:forEach>


			<ul>
				<c:forEach var="people" items="${Grandparents}">
					<li class="Grandparents"><a href="nope.jsp"> <c:out
								value="${people.fname}" /> <br> <br> <c:out
								value="${people.relation}" /><br> <br>
					</a> <br>
				</c:forEach>

				<ul>
					<c:forEach var="people" items="${Parents}">
						<li class="Parents"><a href="nope.jsp"> <c:out
									value="${people.fname}" /><br> <br> <c:out
									value="${people.relation}" /><br> <br>
						</a> <br>
					</c:forEach>

					<ul>
						<c:forEach var="people" items="${You}">
							<li class="You"><a href="nope.jsp"> <c:out
										value="${people.fname}" /> <br> <br> <c:out
										value="${people.relation}" /><br> <br>
							</a> <c:forEach var="people" items="${Children}">
									<ul>
										<li class="Children"><a href="nope.jsp"> <c:out
													value="${people.fname}" /> <c:out
													value="${people.relation}" /> <br> <br>
										</a> <br> <br></li>
								</c:forEach>
						</c:forEach>
					</ul>
					<c:forEach var="people" items="${Sibling}">
						<li class="Siblings"><a href="nope.jsp"> <c:out
									value="${people.fname}" /><br> <br> <c:out
									value="${people.relation}" /> <br> <br>
						</a> <br> <br></li>
					</c:forEach>
				</ul>
				<c:forEach var="people" items="${AuntsUncles}">
						<li class="Siblings"><a href="nope.jsp"> <c:out
									value="${people.fname}" /><br> <br> <c:out
									value="${people.relation}" /> <br> <br>
						</a> <br> <br></li>
						</c:forEach>
	</div>

	<br>
	<br>
	<a href="index2.html" class="button">Go back</a>

</body>


</html>


