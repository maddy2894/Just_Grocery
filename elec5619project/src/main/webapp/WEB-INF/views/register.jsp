<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/beauty.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>   
<head>
<title>Register</title></head>
<style>
	#error,#error1,#error2,#error3,#error4 {
	color:red;
	}
</style>
<script>
	window.onload=function() {
	var firstname = document.getElementById("firstid");
	firstname.onblur = function() {
		if (firstname.value == "" || firstname.value == " ") {
			var div = document.getElementById("error")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter firstname") );
		}
	}
	firstname.onfocus = function() {
		if (firstname.value != "" || firstname.value != " ") {
			var div = document.getElementById("error")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}	
		}
	}
	
	var lastname = document.getElementById("lastid");
	lastname.onblur = function() {
		if (lastname.value == "" || lastname.value == " ") {
			var div = document.getElementById("error1")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter lastname") );
		}
	}
	lastname.onfocus = function() {
		if (lastname.value != "" || lastname.value != " ") {
			var div = document.getElementById("error1")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}	
		}
	}
	
	var email = document.getElementById("emailid");
	email.onblur = function() {
		if (email.value == "" || email.value == " ") {
			var div = document.getElementById("error2")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}
			div.appendChild( document.createTextNode("Please enter email") );
		}
	}
	email.onfocus = function() {
		if (email.value != "" || email.value != " ") {
			var div = document.getElementById("error2")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}	
		}
	}
	
	var password = document.getElementById("passid");
	password.onblur = function() {
		if (password.value == "" || password.value == " ") {
			var div = document.getElementById("error3")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}
			div.appendChild( document.createTextNode("Please enter password") );
		}
	}
	password.onfocus = function() {
		if (password.value != "" || password.value != " ") {
			var div = document.getElementById("error3")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}	
		}
	}
	
	var confirmpass = document.getElementById("confirmid");
	confirmpass.onblur = function() {
		if (confirmpass.value == "" || confirmpass.value == " " || confirmpass.value == password.value) {
			var div = document.getElementById("error4")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}
			div.appendChild( document.createTextNode("password not matched") );
		}
	}
	confirmpass.onfocus = function() {
		if (confirmpass.value != "" || confirmpass.value != " " || confirmpass.value == password.value) {
			var div = document.getElementById("error4")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}	
		}
	}
	
	}
</script>

</style>
</head>
<body>
<h1>Register</h1>

<form action="/elec5619/home/register/register" method="post">
	FirstName:<input type="text" name="first_name" id="firstid"/>
	<div id="error"></div>
	<br/>
	LastName:<input type="text" name="last_name" id="lastid"/>
	<div id="error1"></div>
	<br/>
	Email:<input type="email" name="email_id" id="emailid">
	<div id="error2"></div>
	<br/>
	Password:<input type="password" name="passwd" id="passid">
	<div id="error3"></div>
	<br/>
	Confirm Password:<input type="password" name="confirmpassword" id="confirmid"><br/>
	<div id="error4"></div>
    <input type="submit" value="Register2"> 
</form>


</body>

</html>