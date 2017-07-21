$(function(){
	$("#find").click(FindRole);
	$("#add").click(AddRole);
	$("#UpdateIrp").click(UpdateIrp);	
	$(".state").click(Freeze);
	$("#returnbutton").click(Rturn);
	$("#rbutton").click(Rturn);
});
function FindRole(){
	$("#roleform").attr("action","/EAM/IrpAction?method=findAll");
	$("#roleform").submit();
	
}

function AddRole(){
	$("#roleaction").attr("action","/EAM/RoleAction?method=AddRole");
	$("#roleaction").submit();
}

function UpdateIrp(){
	$("#addIrpForm").submit();
}

function Rturn() {
	$("#returnbutton").attr("actoin","/EAM/IrpAction?method=returnIrp");
}

function Freeze(){
	 var check = $("input[type='checkbox']").is(':checked');
	  if(check == false){
		  alert("未选中操作行")
	  }
	  else{

	$("#rolefind").attr("action","/EAM/IrpAction?method=irpFreeze");
	$("#rolefind").submit();}
}

