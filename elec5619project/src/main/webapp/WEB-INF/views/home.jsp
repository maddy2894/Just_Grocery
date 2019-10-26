<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/beauty.jsp" %>
<html>   
<head>
<title>Home</title>
<style>
		#error,#error1,#errorlogin {
		color: red;
		}
		
	</style>
	<script>
	window.onload = function() {
		var searchInput = document.getElementById("usid");
		var passInput= document.getElementById("passid");
		searchInput.onblur = function() {
			if (searchInput.value == "" || searchInput.value == " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				div.appendChild( document.createTextNode("Please enter username") );
			}
		}
		passInput.onblur = function() {
			if (passInput.value == "" || passInput.value == " ") {
				var divp = document.getElementById("error1")
				while( divp.firstChild ) {
				    divp.removeChild( divp.firstChild );
				}
				divp.appendChild( document.createTextNode("Please enter password") );
			}
		}
		searchInput.onfocus = function() {
			if (searchInput.value != "" || searchInput.value != " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}	
			}
		}
		passInput.onfocus = function() {
			if (passInput.value != "" || passInput.value != " ") {
				var divp = document.getElementById("error1")
				while( divp.firstChild ) {
				    divp.removeChild( divp.firstChild );
				}	
			}
		}
	}
	function sub()
	{
		var searchInput = document.getElementById("usid");
		var passInput= document.getElementById("passid");
		var div = document.getElementById("errorlogin");

		if (passInput.value == "" || passInput.value == " " || searchInput.value == "" || searchInput.value == " ") {
			console.log("invalid");
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter username/password") );
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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
		<script type="text/javascript" 
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" 
			src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
		<style>
			#error {
			color: red;
			}
		</style>
		<script>
			function validateSearch() {
				var searchInput = document.getElementById("search");
				var productList = ["tomato", "milk", "bread"];
				if (productList.indexOf(searchInput.value.toLowerCase()) > -1) {
					return true;
				} else {
					var div = document.getElementById("error")
					while( div.firstChild ) {
					    div.removeChild( div.firstChild );
					}
					div.appendChild( document.createTextNode("Sorry, we do not have any details about the product") );
					return false;
				}
			}
			
			window.onload = function() {
				var searchInput = document.getElementById("search");
				searchInput.onblur = function() {
					if (searchInput.value == "" || searchInput.value == " ") {
						var div = document.getElementById("error")
						while( div.firstChild ) {
						    div.removeChild( div.firstChild );
						}
						div.appendChild( document.createTextNode("Please enter a product") );
					}
				}
				searchInput.onfocus = function() {
					if (searchInput.value != "" || searchInput.value != " ") {
						var div = document.getElementById("error")
						while( div.firstChild ) {
						    div.removeChild( div.firstChild );
						}	
					}
				}
			}
		</script>
		<title>Home</title>
	</head>
	<body>
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="/elec5619/product">JustGrocery</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="/elec5619">Home</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/elec5619/hello">WishList</a>
		      </li>
		       <li class="nav-item">
		        <a class="nav-link" href="/elec5619/basket">Basket</a>
		      </li>
		    </ul>
		    <form action="product/search" method="post" modelAttribute="search" onsubmit="return validateSearch()" class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2" path="search" name="search" id="search" placeholder="Search" aria-label="Search"/>
		      <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
		      <br/>
		    </form>
		    <div id="error"> </div>
		  </div>
		</nav>
		
		<script type="text/javascript">
		$( function() {
		    var availableProducts = [
		      "Milk",
		      "Bread",
		      "Tomato",
		      "Tim Tam",
		      "Potato",
		      "Smiths Thinly Cut",
		      "KitKat",
		      "CCs Doritos",
		      "Cheese",
		    ];
		    $( "#search" ).autocomplete({
		      source: availableProducts
		    });
		  } );
		</script>
	</body>
</html>

<h1>Login</h1>
<form action="/elec5619/home/login" onsubmit="return sub();" method="post">  
    Email:<input type="email" name="email_id" id="usid" />
    <div id="error"> </div>
    <br/>  
    Password:<input type="password" name="passwd" id="passid"/>
    <div id="error1"> </div>
    <br/>  
    <input type="submit" value="login"/> 
    <div id="errorlogin"></div> 
</form>
<p> ${model}</p>
 <form action="/elec5619/home/register/" method="post">
 	<input type="submit" value="register"/>
 </form>
 


</div>
</body> 
</html> 