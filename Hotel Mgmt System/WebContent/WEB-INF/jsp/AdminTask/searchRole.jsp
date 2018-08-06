<%@ include file="../common.jsp" %>

<script type="text/javascript">

	$(document).ready(
	function()
	{	
		$("#roleDTO").attr("action",'<c:url value="searchRoles.htm"></c:url>');	
	});

</script>

<div id="Search_Role_div">

<form:form modelAttribute="roleDTO" id="roleDTO"  onsubmit="return false;">
	<table>
	
		<tr>
		<td>Role Id:</td>
		<td><form:input path="roleId"/></td>
		</tr>
		<tr><td colspan="2" align="right"><input type="button" value="Search" onclick="javascript:SearchRolesOrEmployee('roleDTO')"></td></tr>
	
	</table>
</form:form>
</div>
<div id="Search_Result" align="center"></div>