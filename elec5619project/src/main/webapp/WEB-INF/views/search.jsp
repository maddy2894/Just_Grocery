<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
	<title>JustGrocery</title>
</head>
<body>
	<div class="container">
		<h1>
			Comparison Page  
		</h1>
		<h3>Search Result</h3>
		<div class="card-deck">
			<c:forEach items="${model.products}" var="prod">
			  <div class="card" style="min-width: 300px; margin-bottom: 5px;">
			    <img src="${prod.product_image}" style="width: 99%; margin-left:1px;" class="card-img-top" alt="...">
			    <div class="card-body">
			      <h3 class="card-title"><c:out value="${prod.product_name}"/></h3>
			      <h5>Price: $<c:out value="${prod.price}"/> </h5>
			      <c:choose>
					   <c:when test="${prod.retailer.name.equals('Woolworths')}"><p style="color: green"><c:out value="${prod.retailer.name}"/> </p></c:when>
					   <c:when test="${prod.retailer.name.equals('Coles')}"><p style="color: red"><c:out value="${prod.retailer.name}"/> </p></c:when>
					   <c:when test="${prod.retailer.name.equals('Aldi')}"><p style="color: blue"><c:out value="${prod.retailer.name}"/> </p></c:when>
				  </c:choose>
			    </div>
			    <div class="card-footer">
			      <small>Location: <c:out value="${prod.retailer.location}"/> </small>
			      <button style="float:right;" type="submit" class="btn btn-outline-dark"><span class="fa fa-plus"></span></button>
			    </div>
			  </div>
			
			<%-- <c:out value="${prod.price_date}"/><i>||||<c:out value="${prod.product_id}"/></i><i>||||<c:out value="${prod.retailer_id}"/></i><i>||||<c:out value="${prod.product_name}"/></i><i>||||<c:out value="${prod.price}"/></i><br><br> --%>
			</c:forEach>
		</div>
	</div>
</body>
</html>

