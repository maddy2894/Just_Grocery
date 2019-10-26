<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/bootstrap.jsp" %>
<html>
<head>
	<title>Wishlist Page</title>
	<link href="${pageContext.request.contextPath }/resources/css/wish_list.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</head>
<body>
  <div class="container">
   <h2 class="name">WishList</h2>
   <form action="newWishlist" method="post">
   
    <input type="button" class="btn btn-outline-dark" onclick="location.href='/elec5619/wishlist/newWishlist'" value="+New Wishlist">

   </form>
   	
   	<form action="editWishList", method="post">
     <div class="card-deck" style="width:100%">
     <c:forEach items="${model.wishlists}" var="wishlist">
     
     <%-- <c:out value="${wishlist.wishlist_name}"/> --%>
     <div class="card" style="width: 18rem;">
  		<img src="<c:url value="/resources/images/cart.png" />" style="width: 99%; margin-left:1px;" class="card-img-top" alt="...">
  	 <div class="card-body">
     <h5 name="wishlist_name" class="card-title">${wishlist.wishlist_name}</h5>
     
     <input type="hidden" id="newfield" name="wishlist_name" value="${wishlist.wishlist_name}"/>
     <p class="card-text">${wishlist.list_of_products }</p>
     
   	 <input type="submit" class="btn btn-outline-dark"  value="Modify or Delete">
  		
 	 	</div>
		</div>
     
   
   </c:forEach>
   </div>
   </form>
  
   
   </div>
</body>
</html>
