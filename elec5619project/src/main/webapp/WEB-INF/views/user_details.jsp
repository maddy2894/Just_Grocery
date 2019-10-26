<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/home.jsp" %>
<html>
  <head>
    <title>User-Profile</title>
    <style media="screen">
    th, td {
      padding: 15px;
      text-align: left;
    }
    table {
    }
    </style>
  </head>
  <body>
    <h3 align = "center">Just Grocery</h3>
    <br>
    <h3 align ="center">Profile Overview</h3>
    <p>${model.user}</p> 
    <form  action="user_details" method="post" >
    <table border="0" align="center" >
	<c:forEach items="${model.user}" var="prod">
      <tr>
        <td>First Name</td>
        <td>
          <input type="text" name="first_name" value="<c:out value="${prod.first_name}"/>"/>
        </td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td>
          <input type="text" name="last_name"  value="<c:out value="${prod.last_name}"/>"/>
        </td>
      </tr>
      <tr>
        <td>Email address</td>
        <td>
          <input type="email" name="email_id" value="<c:out value="${prod.email_id}"/>"/>
      </tr>
      <tr>
        <td>Password</td>
        <td>
          <input type="password" name="passwd"  value="<c:out value="${prod.passwd}"/>"/>
        </td>
      </tr>
      <tr>
        <td>Postcode</td>
        <td>
          <input type="text" name="post_code"  value="<c:out value="${prod.post_code}"/>"/>
        </td>
      </tr>
      <tr>
        <td>Mobile number</td>
        <td>
          <input type="text" name="mobile_no" value="<c:out value="${prod.mobile_no}"/>"/>
        </td>
      </tr>
      </c:forEach>
      <tr >
        <td></td>

        <td style="float: right;">
        <input type="submit" name="submit" value="Edit Profile"/>

        </td>
      </tr>
    </table>
    </form> 
    
  </body>
</html>
