<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/home.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JustGrocery</title>
</head>
	<body>
	<div class="container">
		<h3 align="center">
			<b>Just Grocery</b>
		</h3>
		<form:form class="form-horizontal" role="form">
			<div class="form-group">
				<h2 style="text-align: center; margin-top: 55px;">Search Products</h2>
			</div>
		</form:form>
		<form action="product/search" method="post" class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
	    </form>
	</div>
	
	
	</body>
</html>