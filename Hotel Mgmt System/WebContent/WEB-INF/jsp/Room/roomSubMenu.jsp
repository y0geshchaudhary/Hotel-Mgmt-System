<%@ include file="../common.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$('a').css({'color': '#000'});
	$('#roomSubMenu').css({'height':'auto','background-color': '#B071B3'});
	//$('#guestSubMenu .subMenu').css({'text-decoration':'line-through'});
	$('#roomSubMenu a').css({'display':'block','text-decoration':'none','text-align':'left','font-weight':'bold'});	
	$('#guestInnerSubMenu a').css({'font-weight':'normal','margin-bottom':'3px','margin-left':'10px'});
	$('.subMenu a').css({'margin-bottom':'10px'});
	$('#guestInnerSubMenu').hide();
	$('.subMenu').css({'margin-left':'10px'});
	/* $('#guest a').css({'margin-bottom':'0px'}) */
});

</script>

<div id='roomSubMenu' width="100%" border="0">

<div class="subMenu"><a href="javascript:updateRoom()">Update Room</a></div>
<div class="subMenu"><a href="javascript:viewRoomStatus()">View Room Status</a></div>

</div>


