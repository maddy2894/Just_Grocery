<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Wishlist Page</title>
	<link href="${pageContext.request.contextPath }/resources/css/wish_list.css" rel="stylesheet">
</head>
<body>
   <h2 class="name">Just Grocery</h2>
   <h3 class="name">Wishlist</h3>
   
   <input type="button" onclick="location.href='/elec5619/wishlist/newWishlist'" value="+New Wishlist">
</body>
</html>
