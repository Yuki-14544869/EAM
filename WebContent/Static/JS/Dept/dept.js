$(function(){
	$("#search").click(searchClick);
	$("#addDept").click(addClick);
	$("#resetForm").click(resetForm);
	$("#updateDept").click(updateClick);
});

function searchClick(){
	$("#DeptForm").attr("action","/EAM/DeptAction?method=Find");
	$("#DeptForm").submit();
}


function addClick(){
	$("#addDeptForm").attr("action","/EAM/DeptAction?method=addDept");
	$("#addDeptForm").submit();
}

function resetForm(){
	$("input").val('');
}
function updateClick(){
	$("#updateDeptForm").attr("action","/EAM/DeptAction?method=update");
	$("#updateDeptForm").submit();
}