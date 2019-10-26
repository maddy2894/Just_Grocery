<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/bootstrap.jsp" %>
<html>
<head>
	<title>Home Page</title>
	<link href="${pageContext.request.contextPath }/resources/css/createwish_list-ps.css" rel="stylesheet">	
	 <style>
	 #product{
	border-radius: 25px;
	background: lightslategrey;
	padding: 20px;
	width: 200px;
	height: 61px;
	color:white;
}
	 
	 </style>
	<script>
	var products = [];
	 
	function addToCart(selectedValue ){
		var same=0;
		console.log(selectedValue);
		
		if(products.length===0){
			if(selectedValue!=="Select"){
				products.push(selectedValue);}
		}
		else{
			
			for(var i=0;i<products.length;i++){
				if(products[i]===selectedValue || selectedValue==="products" ||selectedValue==="Select"){
					console.log("products",products[i]);
					console.log("selectedValue",selectedValue);
					same=1;
					break;
				} else{
					same=0;
				}
			}
			if(same===0){
				products.push(selectedValue);
				
			}	
			
			
			
		}
		console.log('products',products); 
		document.getElementsByClassName("form-control")[1].innerHTML=products;

  }

	
	</script>	
</head>
<body>

<form action="saveWishlist" method="post" id="myForm">
<div class="wishlistName">
<label>Enter Wishlist's name:</label>
<input type="text" id="wishlistname" name="wishlistName" >
</div>
<br/>

  <select name="product" id="product"  onChange="document.getElementById('selectedValue').innerHTML = this.value;">
   <option value="Select">Select Products..</option>
  <c:forEach items="${model.retailers}" var="product">
    <option value="${product}">${product}</option>
</c:forEach>  
</select >

<div>Selected Product: <span id="selectedValue"></span></div>

<input type="button" onClick=" return addToCart(selectedValue.innerHTML)" value="Add to Cart" >

<div class="input-group">
  <div class="input-group-prepend">
    <span class="input-group-text">With textarea</span>
  </div>
  <textarea class="form-control" name="form-control" aria-label="With textarea"></textarea>
</div>


<label>${model.retailers}</label>

<input type="submit" value="submit" >
</form>



</body>
</html>
