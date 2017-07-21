$(function(){
	$("#providerSearch").click(searchClick);
	$("#addProvider").click(addClick);
	$("#resetForm").click(resetForm);
	$("#updateProvider").click(updateForm);

});

function searchClick(){
	$("#providerForm").submit();
}

function addClick(){
	$("#addproviderForm").submit();
}

function resetForm(){
	$("input").val('');
}

function updateForm(){
	$("#updateForm").submit();
}

