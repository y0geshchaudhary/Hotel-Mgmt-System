<%@ include file="../common.jsp" %>

<script type="text/javascript">

	$(document).ready(
	function()
	{	
		$("#roleDto").attr("action",'<c:url value="addRole.htm"></c:url>');	
	});

</script>
<c:if test="${haveError==true}">
There are some Errors.
<br/>
</c:if>

<div id="Add_Role_div">
  <form:form commandName="roleDTO" id="roleDTO" >
   <table cellspacing="5px">
  <tr>
    <td height="40" colspan="2" style="text-align: center; font-size: 16px; font-weight: bold; font-family: Verdana, Geneva, sans-serif;">Add Role</td>
    </tr>
  <tr>
    <td>Role Id</td>
    <td><form:input path="roleId"/></td>
    <td><form:errors path="roleId"/></td>
  </tr>
  <tr>
    <td>Role Description</td>
    <td><form:input path="roleDesc"/></td>
    <td><form:errors path="roleDesc"/></td>
  </tr>
  <tr>
    <td colspan="2" align="right"><input type="button" value="Add Role" onclick="javascript:addEntity('roleDTO')" /></td>
   </tr>
</table>
</form:form>

</div>