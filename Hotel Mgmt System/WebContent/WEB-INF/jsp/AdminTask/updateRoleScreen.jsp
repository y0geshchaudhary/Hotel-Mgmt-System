<%@ include file="../common.jsp"%>
<script type="text/javascript">
	$(document).ready(
			function(){
				$('#role').attr('action','<c:url value="UpdateDeleteRole.htm"/>');
			});
</script>
<c:if test="${roleFound}">
Selected Role is not Found.
</c:if>
<c:if test="${hasError eq true}">
There are some Errors. 
</c:if>

<div id="update_delete_div">
	<form:form modelAttribute="role" id="role">
		<table cellspacing="5px">
			<tr>
				<td height="40" colspan="2"
					style="text-align: center; font-size: 16px; font-weight: bold; font-family: Verdana, Geneva, sans-serif;">Update/Delete
					Role</td>
			</tr>
			<tr>
				<td>Role Id</td>
				<td><form:input path="roleId" readonly="true"/></td>
			</tr>
			<tr>
				<td>Role Description</td>
				<td><form:input path="roleDesc" />
					<form:errors path="roleDesc" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="button"
					value="Update"
					onclick="javascript:UpdateDeleteRole('Update','role');" /> <input
					type="button" value="Delete"
					onclick="javascript:UpdateDeleteRole('Delete','role');" /></td>
			</tr>
		</table>
	</form:form>
</div>