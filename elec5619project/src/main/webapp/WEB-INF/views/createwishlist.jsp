<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home Page</title>
	<link href="${pageContext.request.contextPath }/resources/css/createwish_list-ps.css" rel="stylesheet">	
	 <style>
	 #error,#errorlogin{
	  color:red;
	 
	 }
	 </style>
	<script>
	window.onload=function(){
		var wishlistname=document.getElementById("wishlistname");
		wishlistname.onblur = function() {
			if (wishlistname.value == "" || wishlistname.value == " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				div.appendChild( document.createTextNode("Please enter WishlistName") );
			}
		}
		wishlistname.onfocus = function() {
			if (wishlistname.value != "" || wishlistname.value != " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}	
			}
		}
		
	}
		var products = [];
	 
		function addToCart(selectedValue ){
		var same=0;
		console.log(selectedValue);
		
		if(products.length===0){
			if(selectedValue!=="Select"){
				products.push(selectedValue);
				}
		}else{
			
			for(var i=0;i<products.length;i++){
				if(products[i]===selectedValue || selectedValue==="products" ||selectedValue==="Select"){
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
		document.getElementsByClassName("form-control")[1].innerHTML=products;

 	 }
		
		function sub()
		{
			var wishlistname=document.getElementById("wishlistname");
			var div = document.getElementById("errorlogin");
			

			if (wishlistname.value == "" || wishlistname.value == " " ) {
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				div.appendChild( document.createTextNode("Please enter Wishlist Name") );
				return false;
			} else {
				console.log("valid");
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				return true;
			}
			
		}

  </script>	
</head>
<body>

		<div class="container">
		<form action="saveWishlist" method="post" id="myForm" onsubmit="return sub();">
		<div class="wishlistName">
		<label>Enter Wishlist's name:</label>
		<input type="text" id="wishlistname" name="wishlistName" >
		</div>
		<div id="error" style="text-align: center"></div>
		<br/>

        <label>Enter Products</label>
		<select name="product" class="btn btn-outline-dark" class="form-control" id="exampleFormControlSelect1"  onChange="document.getElementById('selectedValue').innerHTML = this.value;">
		   	  <option value="Select">Select Products..</option>
			  <c:forEach items="${model.products}" var="product">
		      	 <option value="${product}">${product}</option>
		      </c:forEach>  
		</select >
		<input type="button"  class="btn btn-outline-dark" onClick=" return addToCart(selectedValue.innerHTML)" value="Add to Cart" >

		<div><span id="selectedValue"></span></div>

			

			<div class="input-group" style="margin-top:50px;">
  				<div class="input-group-prepend">
   				<span class="input-group-text" style="height: 280px;">Cart</span>
  				</div>
  				<textarea class="form-control" name="productList" aria-label="With textarea"></textarea>
			</div>


			<label>${model.retailers}</label>

			<input type="submit"  style="margin-left: 460px;margin-top: 110px"; class="btn btn-outline-dark" value="Save Wishlist" >
			<div id="errorlogin" style="text-align: center"></div>
		 </form>

		</div>
</body>
</html>
