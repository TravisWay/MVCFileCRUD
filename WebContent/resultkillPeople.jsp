<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>View</title>
  </head>
  <body>	
  
  <c:choose>
		<c:when test="${result}">
			
	This Member is now deleted from the Family Tree
		</c:when>
		<c:otherwise>
		
			<p>No person found</p>
		</c:otherwise>
	</c:choose>
	<br><br><br>
  <a href="index.html">Go back</a>
  <br>
  
  </body>
</html>