<%@ include file="../common.jsp" %>
<script type="text/javascript">

	$(document).ready(function()
	{
		$("#guestDto").attr("action",
				'<c:url value="/addGuest.htm"></c:url>');	
	});

</script>

<div id="Add_Guest_div">
<form:form commandName="guestDto" id="guestDto" >
	<table height="312" cellspacing="5px">
		<tr>
        <td height="40" colspan="2" align="center" style="font-family:Verdana, Geneva, sans-serif;font-size:16px;font-weight:bold" >ADD NEW GUEST</td>
        </tr>
        <td>Name</td>
        <td><form:input path="guestName"/></td>
        <td><form:errors path="guestName"/></td>
        </tr>
         <%-- <tr>
        <td>ID No.</td>
        <td><form:input path=""/></td>
        </tr> --%>
         <tr>
        <td>Phone No.</td>
        <td><form:input path="phnNo"/></td>
        <td><form:errors path="phnNo"/></td>
        </tr>
        <tr>
        <td>Address</td>
        <td><form:input path="address"/></td>
        <td><form:errors path="address"/></td>
        </tr>
        <tr>
        <td>No. of Guest</td>
        <td><form:input path="noOfGuest"/></td>
        <td><form:errors path="noOfGuest"/></td>
        </tr>
        <tr>
        <td>Room No.</td>
        <td><form:input path="room"/></td>
        <td><form:errors path="room"/></td>
        </tr>
        <tr>
        <td>Check-In Date</td>
        <td><form:input path="checkInDate"/></td>
        <td><img src="" width="15px" height="15px"/></td>
        <td><form:errors path="checkInDate"/></td>
        </tr>
        <tr>
        <td>Check-Out Date</td>
        <td><form:input path="checkOutDate"/></td>
        <td><img src="" width="15px" height="15px"/></td>
        <td><form:errors path="checkOutDate"/></td>
        </tr>
        <tr>
        <td colspan="2" align="right"><input type="button" value="Add Guest" onclick="javascript:addEntity('guestDto');"/></td>
        </tr>
    </table>
</form:form>
</div>
<!-- </body>
</html> -->