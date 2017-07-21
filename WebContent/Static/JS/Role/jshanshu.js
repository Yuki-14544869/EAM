$(function() {
	$("#find").click(FindRole);
	$("#add").click(AddRole);
	$("#Update").click(UpdateRole);

});
function FindRole() {
	$("#roleform").attr("action", "/EAM/RoleAction?method=FindRole");
	$("#roleform").submit();

}

function AddRole() {
	$("#roleaction").attr("action", "/EAM/RoleAction?method=AddRole");
	$("#roleaction").submit();
}

function UpdateRole() {
	$("#rolefind").attr("action", "/EAM/RoleAction?method=UpdateRole");
	$("#rolefind").submit();
}

function Freeze() {

	var check = $("input[type='checkbox']").is(':checked');
	if (check == false) {
		alert("未选中操作行，请在前面选择操作行 ...");
		return false;
	} 
	else { var nums = $(".layui-form-checked").length;
	       if(nums == 1 )
	         {if($("#rolefind").attr("isdelete")==undefined){
	 			$("#rolefind").attr("action", "/EAM/RoleAction?method=Freeze");
	 		}
	 		return true;}
	       else{
		alert("亲！只能修改一行哦.......");}
		
	}}
	

