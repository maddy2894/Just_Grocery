<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
	<div style="margin-top: 65px;" class="container">
	
		<h2 style="text-align:center;">JustGrocery</h2>
		<div class="card mb-3" style="max-width: 100%;">
		  <div class="row no-gutters">
		    <div class="col-md-4">
		      <img src="<c:url value="/resources/images/comp.jpeg" />" class="card-img" alt="...">
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
		      </div>
		    </div>
		  </div>
		  <br>
		  <hr>
		  <br>
		  <div class="row no-gutters">
		    <div class="col-md-8">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
		      </div>
		    </div>
		    <div class="col-md-4">
		      <img src="<c:url value="/resources/images/admin.jpeg" />" class="card-img" alt="...">
		    </div>
		  </div>
		  <div class="row no-gutters">
		    <div class="col-md-4">
		      <img src="<c:url value="/resources/images/admin_temp.jpeg" />" class="card-img" alt="...">
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	</body>
</html>
