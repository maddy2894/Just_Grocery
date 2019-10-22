<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home Page</title>
	<link href="${pageContext.request.contextPath }/resources/css/createwish_list-ps.css" rel="stylesheet">
</head>
<body>
<form value="/wishlist/newWishlist" method="post">
<label>Enter Wishlist's name:</label>
<input type="text" name="wishlistName">
<br/>
<input type="button" value="submit" >
</form>

</body>
</html>
