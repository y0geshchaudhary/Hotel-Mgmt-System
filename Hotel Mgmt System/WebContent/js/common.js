function guestSubMenu()
{
	//alert("called js file");
	//$('#HeaderSubMenu').append('GuestSubMenu.html');	
	
	$.get('GuestSubMenu.htm',{},function(data){
		$('#BottomWindow').empty().html();
		$('#HeaderSubMenu').empty().html(data);
	},"html");
	
}

function roomSubMenu()
{
	$.get('RoomSubMenu.htm',{},function(data){
		$('#BottomWindow').empty().html();;
		$('#HeaderSubMenu').empty().html(data);
	},"html");
}

function addGuestScreen()
{
	$.get('addGuest.htm',{data:'data'},function(data){
		$('#BottomWindow').empty().html(data);
	},"html");

}

function showInnerMenu(divId)
{
	$('#'+divId).slideToggle();	
	
}