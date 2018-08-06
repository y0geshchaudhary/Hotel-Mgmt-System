<%@ include file="../common.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$('a').css({'color': '#000'});
	$('#adminTaskSubMenu').css({'height':'auto','background-color': '#B071B3'});
	//$('#adminTaskSubMenu .subMenu').css({'text-decoration':'line-through'});
	$('#adminTaskSubMenu a').css({'display':'block','text-decoration':'none','text-align':'left','font-weight':'bold'});	
	$('#inventoryInnerSubMenu a').css({'font-weight':'normal','margin-bottom':'3px','margin-left':'10px'});
	$('#employeeInnerSubMenu a').css({'font-weight':'normal','margin-bottom':'3px','margin-left':'10px'});
	$('#rolesInnerSubMenu a').css({'font-weight':'normal','margin-bottom':'3px','margin-left':'10px'});
	$('.subMenu a').css({'margin-bottom':'10px'});
	$('#inventoryInnerSubMenu').hide();
	$('#employeeInnerSubMenu').hide();
	$('#rolesInnerSubMenu').hide();
	$('.subMenu').css({'margin-left':'10px'});
	/* $('#guest a').css({'margin-bottom':'0px'}) */
});


</script>

<div id='adminTaskSubMenu' width="100%" border="0">

<div id='inventory' onClick="showInnerMenu('inventoryInnerSubMenu')" class="subMenu"><a href="#">Inventory</a> </div>
	<div id="inventoryInnerSubMenu">
    	<!-- <a href="javascript:addScreenForAdmin('Room')">Add Room</a> -->
    	<a href="javascript:testTable();">Add Room</a>
        <a href="javascript:updateDeleteScreenForAdmin('Room')">Update/Delete Room</a>
        <!-- <a href="javascript:deleteScreenForAdmin('Room')">Delete Room</a> -->
   </div>
   
<div id='employee' onClick="showInnerMenu('employeeInnerSubMenu')" class="subMenu"><a href="#">Employee</a> </div>
	<div id="employeeInnerSubMenu">
    	<a href="javascript:addScreenForAdmin('Employee')">Add Employee</a>
        <a href="javascript:updateDeleteScreenForAdmin('Employee')">Update/Delete Employee</a>
        <!-- <a href="javascript:deleteScreenForAdmin('Employee')">Delete Employee</a> -->
   </div>
   
<div id='roles' onClick="showInnerMenu('rolesInnerSubMenu')" class="subMenu"><a href="#">Roles</a> </div>
	<div id="rolesInnerSubMenu">
    	<a href="javascript:addScreenForAdmin('Roles')">Add Role</a>
        <a href="javascript:updateDeleteScreenForAdmin('Roles')">Update/Delete Role</a>
        <!-- <a href="javascript:deleteScreenForAdmin('Roles')">Delete Role</a> -->
   </div>
   
<!-- <div class="subMenu"><a href="javascript:listAllGuest()">List All Guest</a></div>
<div class="subMenu"><a href="javascript:guestNeedsToCheckOut()" class="a">Guests Needs To Checkout</a></div>-->
 
</div>