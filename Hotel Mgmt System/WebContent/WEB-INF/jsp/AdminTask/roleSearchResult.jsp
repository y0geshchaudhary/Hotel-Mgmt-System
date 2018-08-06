<%@ include file="../common.jsp"%>
<style type="text/css">

tr {
	width: 15%;
}
/* 
#resultDiv table td {
	text-align: center;
}

#resultDiv table, td, th{
	border: 1px thin;
} */

</style>

<!-- <script type="text/javascript">
	$(document).ready(function() {
		/* var url = */$(".pagelinks a").each(function(index) {
			//alert(index);
			var url = $(this).attr("href");
			//alert(url);
			$(this).attr("href", "javascript:getOtherPage('" + url + "')");
			/* url = $(this).attr("href");*/
			//alert(url);
		});
	});

	function getOtherPage(urls) {
		$.get(urls, {
			data : "data"
		}, function(data) {
			$("#Search_Result").empty().html(data);
		}, "html");
	}
</script> -->
<!-- <div align="left"> -->
	<h1>Search Result</h1>

	<c:if test="${listSize eq 0}">
There is nothing to display.
</c:if>

	<c:if test="${listSize gt 0}">
<%-- 	
		<display:table export="false" name="${list}" uid="row" pagesize="5"
			requestURI="showNextPage.htm" defaultorder="descending"
			style="width:60%; border:1px; text-align:center;">
			<display:column property="roleId" title="Id" />
			<display:column property="roleDesc" title="Description" />
			<display:column value="Update/Delete" title="Update/Delete"
				href="javascript:UpdateRole('${row.roleId}')" />
		</display:table>
</div>
 --%>
	<table width="60%" border="1" align="left">
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>Update/Delete</th>
		</tr>
		<c:forEach items="${list}" var="role">
			<tr>
				<td>${role.roleId}</td>
				<td>${role.roleDesc}</td>
				<td><a href="javascript:UpdateRole('${role.roleId}')">Update/Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>