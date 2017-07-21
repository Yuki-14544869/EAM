$(function() {
	$("#itemdelete").click(deleteClick);
	$("#itemadd").click(addClick);
	$("#itemToupdate").click(toUpdateClick);
	$("#itemToadd").click(jumpToAdd);
});
function deleteClick() {
	var checks = document.getElementsByName("selected");
	n = 0;
	for (i = 0; i < checks.length; i++) {
		if (checks[i].checked) {
			n++;
		}
	}
	if (n == 0) {
		alert("未选择删除内容！");
	} else {
		$('#itemOperateForm').attr("action",
				"/EAM/ItemAction?itemOperate=deleteItem").submit();
	}
}
function addClick() {
	$('#itemOperateForm').attr("action", "/EAM/ItemAction?itemOperate=addItem")
			.submit();
}

function jumpToAdd() {
	$('#itemOperateForm').attr("action", "/EAM/suibian")
			.submit();
}

function toUpdateClick() {
	var checks = document.getElementsByName("selected");
	n = 0;
	for (i = 0; i < checks.length; i++) {
		if (checks[i].checked) {
			n++;
		}
	}
	if (n == 0) {
		alert("未选择更改内容！");
	} else if (n == 1) {
		$('#itemOperateForm').attr("action",
				"/EAM/ItemAction?itemOperate=updateItem").submit();
	} else {
		alert("不可一次更改多个！");
	}
}
function updateClick() {
	$('#itemupdateForm').attr("action", "/EAM/ItemAction?itemOperate=update")
			.submit();
}
