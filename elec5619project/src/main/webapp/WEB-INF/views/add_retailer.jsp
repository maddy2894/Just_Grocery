<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/home.jsp" %>
<html>
<head>
	<title>Insert Products</title>
</head>
<body>
	<h3 align = "center">Just Grocery</h3>
    <br>
    <h3 align ="center">Add Retailer</h3>
    
    <form  action="add_retailer" method="post" >
    <table border="1" align="center" >

      <tr>
        <td>Unique ID</td>
        <td>
          <input type="text" name="id" value=""/>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td>
          <input type="text" name="name"  value=""/>
        </td>
      </tr>
      <tr>
        <td>Contact</td>
        <td>
          <input type="text" name="contact" value=""/>
        </td>
      </tr>
      <tr>
        <td>Tag</td>
        <td>
          <input type="text" name="tag" value=""/>
        </td>
      </tr>
      <tr>
        <td>Location</td>
        <td>
          <input type="text" name="location" value="" />
        </td>
      </tr>
      <tr>
        <td>Postcode</td>
        <td>
          <input type="text" name="postcode" value=""/>
        </td>
      </tr>
      <tr >
        <td></td>

        <td style="float: right;">
          <input type="submit" value="Add Retailer" />
        </td>
      </tr>
    </table>
    </form>
    
   </body>
</html>   