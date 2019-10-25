<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>

<p>Saved Successfully</p>
<p>"${model.productList}"</p>
<p>"${model.wishlistname}"</p>

<tr>Product Name</tr>


<c:forEach items="${model.productList}" var="product">
  <br/>
    <tr>      
        <td>${product}</td>
        <br/>
    </tr>
</c:forEach>



</body>
</html>
