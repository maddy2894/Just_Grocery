<%@ include file="/WEB-INF/views/include.jsp" %>
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
    
    <form  action="/user_profile" method="post" >
    <table border="0" align="center" >

      <tr>
        <td>First Name</td>
        <td>
          <input type="text" name="first_name" value= <c:out value="${user_data.get(0)}"/>>
        </td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td>
          <input type="text" name="last_name" value= <c:out value="${user_data.get(1)}"/>>
        </td>
      </tr>
      <tr>
        <td>Email address</td>
        <td>
          <input type="email" name="email_id" value= <c:out value="${user_data.get(2)}"/>>
        </td>
      </tr>
      <tr>
        <td>Password</td>
        <td>
          <input type="password" name="password" value= <c:out value="${user_data.get(3)}"/>>
        </td>
      </tr>
      <tr>
        <td>Postcode</td>
        <td>
          <input type="text" name="postcode" value= <c:out value="${user_data.get(5)}"/>>
        </td>
      </tr>
      <tr>
        <td>Mobile number</td>
        <td>
          <input type="text" name="mobile_no" value= <c:out value="${user_data.get(6)}"/>>
        </td>
      </tr>
      <tr >
        <td></td>

        <td style="float: right;">
          <button>Edit Profile</button>
        </td>
      </tr>
    </table>
    </form>
  </body>
</html>
