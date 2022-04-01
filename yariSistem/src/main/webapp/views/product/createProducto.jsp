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
	
		<c:if test="${product != null && !product.isValid() }">
			<div class="alert alert-danger">
				<p> Se encontraron errores al crear el producto</p>
			</div>
		</c:if>
		
		<form action="/customer/createProduct" method="post">
			<jsp:include page="/views/product/form.jsp"></jsp:include>
		</form>
	
	</main>
	
</body>
</html>