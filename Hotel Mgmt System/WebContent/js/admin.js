function adminTaskSubMenu()
{
	$.get('AdminTaskSubMenu.htm',{},function(data){
		$('#BottomWindow').empty().html();
		$('#HeaderSubMenu').empty().html(data);
	},"html");
}

/*
addScreenForAdmin('Employee')">Add Employee</a>
<a href="javascript:updateScreenForAdmin('Employee')">Update Employee</a>
<a href="javascript:deleteScreenForAdmin
*/

function addScreenForAdmin(forEntity)
{
	var url;
	if(forEntity == 'Roles') url ='addRole.htm';
	if(forEntity == 'Employee') url ='addEmployee.htm';
	if(forEntity == 'Room') url ='addRoom.htm';
	
	$.get(url,{}, function(data){
		
		$('#BottomWindow').empty().html(data);
	},"htmk");
	
}


function updateDeleteScreenForAdmin(forEntity)
{
	var url;
	if(forEntity == 'Roles') url ='roleSearchScreen.htm';
	if(forEntity == 'Employee') url ='employeeSearchScreen.htm';
	if(forEntity == 'Room') url ='updateRoom.htm';
	
	$.get(url,{},function(data){
		$('#BottomWindow').empty().html(data);
	},"html");
}



function addEntity(formId)
{
	$.blockUI();
	
	var dataToSubmit = $("#"+formId).formSerialize();
	var url = $("#"+formId).attr('action');
	
	$.post(url,dataToSubmit,function(data){
		$('#BottomWindow').empty().html(data);
		$.unblockUI();
	},"html");
}


function SearchRolesOrEmployee(formId)
{
	//alert("inside SearchRoles(formId)")
	var url = $('#'+ formId).attr('action');
	var data = $('#'+formId).formSerialize();
	
	
	$.get(url,data,function(data){
		//alert(data);
		$('#Search_Result').empty().html(data);
	},"html");
}

function UpdateRole(roleId){
	
	var url = 'updateRoleScreen/'+roleId+'.htm';
	$.get(url,{},function(data){
		
		$('#BottomWindow').empty().html(data);
	},"html");
}


function UpdateDeleteRole(action,formId){
	
	var url = $('#'+formId).attr('action');
	var data = $('#'+formId).formSerialize();
	data+="&action="+action;
	//data+="&action="+action;
	//alert(data);
	
	$.post(url,data,function(data){
		$('#BottomWindow').empty().html(data);
	},"html");
	
}

function testTable(){
	
	$.post("test.htm",{data:"data"},function(data){
		$('#BottomWindow').empty().html(data);
	},"html");
}

