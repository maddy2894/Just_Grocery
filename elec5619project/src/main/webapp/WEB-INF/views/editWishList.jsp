<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/bootstrap.jsp" %>
<html>
<head>
	<title>Edit WishList</title>
	<script>

	var same=0; 
	var listOfProducts;
	function addToCart(selectedValue ){
		listOfProducts = document.getElementById("listofProducts").value;
		console.log(listOfProducts);
		listOfProducts=listOfProducts.split(",")
		
		if(listOfProducts.length===0){
			if(selectedValue!=="Select"){
				listOfProducts+=selectedValue;}
		}
		else{
			
			for(var i=0;i<listOfProducts.length;i++){
				if(listOfProducts[i]===selectedValue || selectedValue==="products" ||selectedValue==="Select"){
					console.log("listOfProducts[i]",listOfProducts[i]);
					console.log("selectedValue",selectedValue);
					same=1;
					break;
				}	
				else{
					same=0;
				}
			}
			if(same==0){
				listOfProducts+= ","+selectedValue;
				
			}	
				
		}
		console.log('listOfProducts',listOfProducts); 
		document.getElementsByClassName("form-control")[1].innerHTML=listOfProducts;

  }

	
	</script>
	
</head>
<body>
<form action="saveEditedWishList" method="post" id="myForm">

<c:forEach items="${model.wishlistdetails}" var="wishlist">

<div class="wishlistName">
<label>Enter Wishlist's name:</label>
<input type="text" id="wishlistname" name="wishlistName" value="${wishlist.wishlist_name}" >

 <input type="hidden" id="newfield" name="oldwishlist_name" value="${wishlist.wishlist_name}"/>

<select name="product" id="product" onChange="document.getElementById('selectedValue').innerHTML = this.value;">
   <option value="Select">Select Products..</option>
  <c:forEach items="${model.retailers}" var="product">
    <option value="${product}">${product}</option>
</c:forEach>  
</select >
<div>Selected Product: <span id="selectedValue"></span></div>

<input type="button" onClick=" return addToCart(selectedValue.innerHTML) " value="Add to Cart"/ >

<div>
<p> Active or In Active?</p>
<select name="isActive" id="isActive">
   <option value="Select">Select...</option>
   <option value="active">Active</option>
   <option value="inactive">In Active</option>
</select >
</div>


<div class="input-group">
  <div class="input-group-prepend">
    <span class="input-group-text">Products Added</span>
  </div>
  <textarea class="form-control" id="listofProducts" name="form-control" aria-label="With textarea" >${wishlist.list_of_products}</textarea>
</div>
</div>
</c:forEach>


<input type="submit" value="Save WishList" >

</form>


</body>
</html>
