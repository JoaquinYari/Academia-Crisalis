<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crisalis</title>
</head>
<body>
	
	
	<main class="container">
	
		<c:if test="${person != null && !person.isValid() }">
			<div class="alert alert-danger">
				<p> Se encontraron errores al editar el cliente</p>
			</div>
		</c:if>
		
		<form action="/customer/editPerson" method="post">
			<jsp:include page="/views/customer/formPerson.jsp"></jsp:include>
		</form>
	
	</main>
	
</body>
</html>