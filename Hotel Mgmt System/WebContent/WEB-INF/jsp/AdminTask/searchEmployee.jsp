<%@ include file="../common.jsp" %>

<script type="text/javascript">

	$(document).ready(
			function(){
				$('#employeeDTO').attr('action','<c:url value="searchEmployee.htm"></c:url>');
			});
</script>

<div id="Search_Employee_id">
<form:form modelAttribute="employeeDTO" id="employeeDTO">
	<table>
		<tr>
			<td>Employee Id:</td>
			<td><form:input path="employeeId"></form:input></td>
		</tr>
		<tr><td align="center" colspan="2">OR</td></tr>
		<tr>
			<td>Employee Name:</td>
			<td><form:input path="employeeName"></form:input></td>
		</tr>
		<tr><td colspan="2" align="right"><input type="button" value="Search" onclick="javascript:SearchRolesOrEmployee('employeeDTO');"/></td></tr>
	</table>
</form:form>
</div>
<div id="Search_Result" align="center"></div>