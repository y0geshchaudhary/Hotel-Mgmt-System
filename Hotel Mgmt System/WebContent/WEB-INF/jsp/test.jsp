<%@ include file="common.jsp"%>
<script type="text/javascript">

$(document).ready(function(){
	/* var url = */ $(".pagelinks a").each(function(index){
		//alert(index);
		var url = $(this).attr("href");
		//alert(url);
		$(this).attr("href","javascript:getOtherPage('"+url+"')");
		/* url = $(this).attr("href");*/
		//alert(url);
		
	});
});

function getOtherPage(urls){
	$.get(urls, {data:"data"}, function(data){
	$("#BottomWindow").empty().html(data);
	},"html");
}
</script>



<table style="width: 100%; border: 1px;">
	<tr style="width: 100%;" align="left">
		<td>SEARCH RESULT</td>
	</tr>
	<tr align="left">
		<td><display:table name="${list}" export="true" id="row"
				pagesize="5" requestURI="showNextPage.htm" defaultorder="ascending">
				<div style="overflow: auto;">
					<display:caption>
						<c:out value="${caption}" />
					</display:caption>
					<display:column property="name" title="Name"
						style="text-align:center;" />
					<display:column property="age" title="Age"
						style="text-align:center;" />
					<display:column property="phn" title="Phone No."
						style="text-align:center;" />
					<display:column property="address" title="Address"
						style="text-align:center;" />
					<display:column property="sports" title="Sports"
						style="text-align:center;" />
				</div>
			</display:table></td>
	</tr>
</table>