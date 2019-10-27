<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>


<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ include file="/WEB-INF/views/home.jsp" %>
  
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart0 = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:330,
	title: {
		text: "User Login Info"
	},
	axisX: {
		title: "Users Email Address"
	},
	axisY: {
		title: "Number Of Logs"
	},
	data: [{
		type: "column",
		yValueFormatString: "#,##0 ",
		dataPoints: ${model.login_details_id}}]
});

var chart1 = new CanvasJS.Chart("chartContainer1", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:330,
	title: {
		text: "Product Searched Info"
	},
	axisX: {
		title: "Product"
	},
	axisY: {
		title: "Number of searches"
	},
	data: [{
		type: "column",
		yValueFormatString: "#,##0 ",
		dataPoints: ${model.product_info}}]
});


var chart2 = new CanvasJS.Chart("chartContainer2", {
	theme: "light2",
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:330,
	title: {
		text: "Logs per Month "
	},
	axisX: {
		title: "Month"
	},
	axisY: {
		title: "Logs"
	},
	data: [{
		type: "line",
		yValueFormatString: "#,##0 ",
		dataPoints : ${model.number_of_logs}} ]
});

var chart3 = new CanvasJS.Chart("chartContainer3", {
	theme: "light2",
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:330,
	title: {
		text: "Product search by day"
	},
	axisX: {
		title: "Day"
	},
	axisY: {
		title: "Searches"
	},
	data: [{
		type: "line",
		yValueFormatString: "#,##0 ",
		dataPoints : ${model.search_by_day} }]
});
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
chart0.render();
chart1.render();
chart2.render();
chart3.render();
}
</script>
</head>
<body>
<div class= "container">
<div style="width: 100%; display: table;">
	    <div style="display: table-row">
		<!-- <div id="chartContainer" style="display: table-cell; width: 50%;"></div> -->
		<div id="chartContainer" style="height: 360px; width: 40%;display: table-cell;"></div>
		<div id="chartContainer1" style="height: 360px; width: 40%;display: table-cell;"></div>
		</div>
		<div style="display: table-row">
		<div id="chartContainer2" style="height: 360px; width: 40%;display: table-cell;"></div>
		<div id="chartContainer3" style="height: 360px; width: 40%;display: table-cell;"></div>
		
		</div>
</div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
 <form action="add_product" method="get">
 <input class="btn btn-primary" type="submit" name="add_product" value="Add Product"/>
 </form>
  <form action="add_retailer" method="get">
 <input class="btn btn-primary" type="submit" name="add_retailer" value="Add Retailer"/>
 </form>
</body>
</html>                              