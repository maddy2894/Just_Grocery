<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Edit WishList</title>
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
		document.getElementsByClassName("form-control")[1].innerHTML=listOfProducts;

 	 }
	function sub()
	{
		var wishlistname=document.getElementById("wishlistname");
		var div = document.getElementById("errorlogin");
		

		if (wishlistname.value == "" || wishlistname.value == " " ) {
			if( div.firstChild ) {
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

	<form action="saveEditedWishList" method="post" id="myForm" onsubmit="return sub();">

		<c:forEach items="${model.wishlistdetails}" var="wishlist">

		<div class="wishlistName" style="text-align:center">
		<label>Enter Wishlist's name:</label>
		<input type="text" id="wishlistname" name="wishlistName" value="${wishlist.wishlist_name}" >
		 <div id="error" style="text-align: center"></div>
		 <input type="hidden" id="newfield" name="oldwishlist_name" value="${wishlist.wishlist_name}"/>
		 
		</div>
		
		<label>Enter Products</label>

		<select name="product" class="btn btn-outline-dark" class="form-control" id="exampleFormControlSelect1"  onChange="document.getElementById('selectedValue').innerHTML = this.value;">
		   <option value="Select">Select Products..</option>
		  <c:forEach items="${model.retailers}" var="product">
		    <option value="${product}">${product}</option>
		</c:forEach>  
		</select >
		<input type="button" class="btn btn-outline-dark" onClick=" return addToCart(selectedValue.innerHTML) " value="Add to Cart"/ >
		<div>Selected Product: <span id="selectedValue"></span></div>
		<div>
		


		<div class="input-group" style="margin-top:50px;">
		  <div class="input-group-prepend">
		    <span class="input-group-text" style="height: 280px;">Cart</span>
		  </div>
		  <textarea class="form-control" id="listofProducts" name="form-control" aria-label="With textarea" >${wishlist.list_of_products}</textarea>
		</div>
		
		</c:forEach>
		
		<div style="margin-top:10px;">
		<label> Delete?</label>
		<select name="isActive" class="btn btn-outline-dark" class="form-control" id="exampleFormControlSelect1">
		   <option value="Select">Select...</option>
		   <option value="active">No</option>
		   <option value="inactive">Yes</option>
		</select >
		</div>


		<input type="submit"  style="margin-left: 460px;margin-top: 110px;" class="btn btn-outline-dark" value="Save WishList" >
        <div id="errorlogin" style="text-align: center"></div>
	</form>

	</div>
</body>
</html>
