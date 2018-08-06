<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="Search_Guest_div">
<form>
	<table height="Auto" cellspacing="5px">
    
    	<tr>
        <td>Guest Name</td>
        <td><input type="text"/></td>
        </tr>
        <tr>
        <td colspan="2" align="center">OR</td>
        </tr>
        <tr>
        <td>Room No</td>
        <td><input stype="text"/></td>
        </tr>
        <tr>
        <td colspan="2" align="right"><input type="submit" value="Search" onclick="searchGuest();"/></td>
        </tr>
    
	</table>
</form>
</div>

</body>
</html>