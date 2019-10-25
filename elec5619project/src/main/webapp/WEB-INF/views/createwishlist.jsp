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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.min.css">
	 
	<script>
	var products = [];
	var same=0; 
	function addToCart(selectedValue ){
		console.log(selectedValue);
		
		if(products.length===0){
			if(selectedValue!=="Select"){
				products.push(selectedValue);}
		}
		else{
			
			for(var i=0;i<products.length;i++){
				if(products[i]===selectedValue || selectedValue==="products" ||selectedValue==="Select"){
					console.log("products[i]",products[i]);
					console.log("selectedValue",selectedValue);
					same=1;
				}	
				else{
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

<form action="savedWishlist" method="post" id="myForm">
<div class="wishlistName">
<label>Enter Wishlist's name:</label>
<input type="text" id="wishlistname" name="wishlistName" >
</div>
<br/>

 
  <select name="product" id="product" onChange="document.getElementById('selectedValue').innerHTML = this.value;">
   <option value="Select">Select products..</option>
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

<input type="submit" value="submit" >
</form>

<table>



</table>






</body>
</html>
