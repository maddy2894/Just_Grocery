<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>   
<head>
<title>Logsuccess</title></head>
   
<body>
<p> log successfull. </p>
<form action="/elec5619/logout" method="post">
<input type="submit" class="btn btn-outline-dark"  value="Logout">
</form>
</body>