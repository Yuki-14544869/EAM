$(function(){
	$("#placeSearch").click(searchClick);
	$("#addPlace").click(addClick);
	$("#updateForm").click(updatetForm);
	$("#deletePlace").click(deleteClick);
	
	
	
	
	
});

function searchClick(){
	$("#placeForm").submit();
}


function addClick(){
	$("#addplaceForm").submit();
}

function resetForm(){
	$("input").val('');
}
function deleteClick(){
	$("#deleteplaceForm").submit();
}