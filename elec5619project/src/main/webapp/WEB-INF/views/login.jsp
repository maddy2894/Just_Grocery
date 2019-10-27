<%@ include file="/WEB-INF/views/include_login.jsp" %>
<html>   
<head>
<title>Login</title>
<style>
		#error,#error1,#errorlogin {
		color: red;
		}
		body {
		background-image: url("https://www.nycfoodpolicy.org/wp-content/uploads/2018/05/shutterstock_418522381-2.jpg");
        background-repeat:no-repeat;
        background-size:cover;
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
				div.appendChild( document.createTextNode("Please enter email address") );
			}
		}
		passInput.onblur = function() {
			if (passInput.value == "" || passInput.value == " " ) {
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
			if (passInput.value != "" || passInput.value != " " ) {
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
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter email address/password") );
			return false;
		} else {
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			return true;
		}
		
	}
	</script>
</head>
   
<body>
<div class="container" style="margin-left:465px;margin-top:100px; max-width:750px">



<h1>Login</h1>
<form action="/elec5619/login" onsubmit="return sub();" method="post">
	<div class="form-group" >
	<label for="InputEmail">Email address</label>
	<input type="email" class="form-control" style="width:240px" name="email_id" id="usid"  placeholder="Enter email">
	</div>  
    <div id="error"> </div>
	<div class="form-group">
    <label for="InputPassword">Password</label>
    <input  type="password" class="form-control" style="width:240px" name="passwd" id="passid" minlength="8" placeholder="Password">
    <!-- <small id="passwordHelpInline" class="text-muted"> Must be 8-20 characters long.</small> -->
    </div>
    <div id="error1"> </div>
    <input type="submit" class="btn btn-outline-dark" value="Login" /> 
    <div id="errorlogin"></div> 
</form>
<p style="color:red">${model}</p>
 <form action="/elec5619/register" method="GET">
 	<small>new to JustGrocery?</small>
 	<input type="submit" class="btn btn-outline-dark" value="Register"/>
 </form>
</div>	
</body> 
</html> 