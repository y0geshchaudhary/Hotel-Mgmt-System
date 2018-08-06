
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Main Page</title>
<%@ include file="common.jsp" %>

<style>

#mainDiv{
	/*height:auto;
	 width:700px !important; */
	padding-left:20px;
	width:100%;
	height:100%;
}

#BottomWindow {
	padding-top: 5%;
	padding-left: 5%;
}

.menuHeader 
{
	width: 525px;
   	height: 35px;
    font-size: 16px;
    font-family: Tahoma, Geneva, sans-serif;
    font-weight: bold;
    background-color: #B071B3;
}

.menuHeader ul {
	height: auto;
	padding: 8px 0px;
	margin: 0px;
	font-size: 18;
}

body {
	/* background-color: #C9F; */
	width: auto;
	background-position: 100% 100%;
}

.menuHeader  li {
	display: inline;
	text-decoration:none;
	font-size: 16px;
	width: 200px;
	text-align:left;
	padding-right: 50px;
	padding-left: 50px;
}
.menuHeader a {
	text-decoration:none;
	color:#000;

}

#HeaderSubMenu{
	height: auto;
	width: 150px;
	float: left;
	width: 12%;	
/*	border-color:#000;
	border-style:dotted;*/	
}
#BottomWindow{
	height: auto;
	width: auto;
	padding-top: 10px;
	padding-left: 10px;
	float:left;
	width: 85%;
	/*border-color:#000;
	border-style:dotted;*/	

}

</style>
</head>

<body>
<div id='mainDiv'>
  
  	<div><h1 align="left"><strong>HOTEL MGMT SYSTEM</strong></h1></div>
  
    <div class="menuHeader">
    	<ul>
      		<li><a href="javascript:guestSubMenu();">Guest</a></li>
      		<li><a href="javascript:roomSubMenu();">Rooms</a></li>
      		<!-- <li><a href="javascript:employeeSubMenu();">Employee</a></li>
       		<li><a href="javascript:inventorySubMenu();">Inventory</a></li> -->
       		<li><a href="javascript:adminTaskSubMenu();">Admin Task</a></li>
       		
    	</ul>
    </div>
    
  <div id="HeaderSubMenu"></div>
    
   <div id="BottomWindow"></div>
   
</div>
</body>
</html>
 