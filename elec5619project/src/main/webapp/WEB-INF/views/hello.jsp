<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>JustGrocery</title>
</head>
<body>
<h1>
	Comparison Page  
</h1>

<P> The time on the server is ${model.now}. </P>
<h3>Product Prices are:</h3>
<c:forEach items="${model.retailers}" var="prod">
<c:out value="${prod.price_date}"/><i>||||<c:out value="${prod.product_id}"/></i><i>||||<c:out value="${prod.retailer_id}"/></i><i>||||<c:out value="${prod.product_name}"/></i><i>||||<c:out value="${prod.price}"/></i><br><br>
</c:forEach>
</body>
</html>

