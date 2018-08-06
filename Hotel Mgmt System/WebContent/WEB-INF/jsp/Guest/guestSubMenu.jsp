<%@ include file="../common.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$('a').css({'color': '#000'});
	$('#guestSubMenu').css({'height':'auto','background-color': '#B071B3'});
	$('#guestSubMenu a').css({'display':'block','text-decoration':'none','text-align':'left','font-weight':'bold'});	
	$('#guestInnerSubMenu a').css({'font-weight':'normal','margin-bottom':'3px','margin-left':'10px'});
	$('.subMenu a').css({'margin-bottom':'10px'});
	$('#guestInnerSubMenu').hide();
	$('.subMenu').css({'margin-left':'10px'});
	
});

</script>

<div id='guestSubMenu' width="100%" border="0">

<div id='guest' onClick="showInnerMenu('guestInnerSubMenu')" class="subMenu"><a href="#">Guest</a> </div>
	<div id="guestInnerSubMenu">
    	<a href="javascript:addGuestScreen()">Add</a>
        <a href="javascript:updateGuestScreen()">Update</a>
        <a href="javascript:deleteGuestScreen()">Delete</a>
   </div>
   
<div class="subMenu"><a href="javascript:listAllGuest()">List All Guest</a></div>
<div class="subMenu"><a href="javascript:guestNeedsToCheckOut()">Guests Needs To Checkout</a></div>

</div>