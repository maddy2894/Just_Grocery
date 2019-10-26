<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/home.jsp" %>
<html>
<head>
	<title>Insert Products</title>
</head>
<body>
	<h3 align = "center">Just Grocery</h3>
    <br>
    <h3 align ="center">Insert Products</h3>
    
    <form  action="add_product" method="post" >
    <table border="1" align="center" >

      <tr>
        <td>Unique ID</td>
        <td>
          <input type="text" name="id" value=""/>
        </td>
      </tr>
      <tr>
        <td>Price Date</td>
        <td>
          <input type="text" name="price_date" tooltip="yyyy-mm-dd" value="${date}"/>
        </td>
      </tr>
      <tr>
        <td>Product ID</td>
        <td>
          <input type="text" name="product_id" value=""/>
        </td>
      </tr>
      <tr>
        <td>Retailer ID</td>
        <td>
          <input type="text" name="retailer_id" value=""/>
        </td>
      </tr>
      <tr>
        <td>Product Name</td>
        <td>
          <input type="text" name="product_name" value="" />
        </td>
      </tr>
      <tr>
        <td>Price</td>
        <td>
          <input type="text" name="price" value=""/>
        </td>
      </tr>
      <tr >
        <td></td>

        <td style="float: right;">
          <input type="submit" value="Add" />
        </td>
      </tr>
    </table>
    </form>
</body>
</html>