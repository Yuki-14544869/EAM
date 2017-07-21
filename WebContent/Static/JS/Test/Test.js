/**
 * 
 */
$(function(){
	$("#search").click(searchClick);
	$("#addTest").click(addClick);
	$("#resetForm").click(resetForm);
	$("#updateTest").click(updateForm);
	$("#searchTest").click(searchForm);
});

function searchClick(){
	$("#testform").attr("action","/EAM/TestAction?method=SelectTest");
	$("#testform").submit();
}


function addClick(){
	$("#addtestForm").submit();
}

function resetForm(){
	$("input").val('');
}

function updateForm(){
	
	$("#updatetestForm").submit();
	
}

function searchForm(){
	$("#searchform").attr("action","/EAM/TestAction?method=SearchTest&id=${ID.id}&name=${ID.name}&count=${ID.count}&testdate=${ID.testdate}&provid=${ID.provid}&person=${ID.person}&testcode=${ID.testcode}&unit=${ID.unit}&proddate=${ID.proddate}&recvdate=${ID.recvdate}&provid=${ID.provid}&project=${ID.project}&conclusion=${ID.conclusion}&detail=${ID.detail}");
	$("#searchform").submit();
	
}