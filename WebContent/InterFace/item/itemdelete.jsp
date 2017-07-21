<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除库存</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script src="/EAM/Static/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/EAM/Static/JS/item/item.js"></script>
</head>

<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>库存信息表</legend>
	</fieldset>
<form id="itemdeleteForm" class="layui-form" action="ItemAction?method=deleteItem">
	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary"
						lay-filter="allChoose"></th>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>场地编号</th>
					<th>质检编号</th>
					<th>部门编号</th>
					<th>采购者</th>
					<th>供应商</th>
					<th>资产类型</th>
					<th>入库日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${item}" var="item">
					<tr>
						<td><input type="radio" value=${item.id } name="selected"></td>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.placeid}</td>
						<td>${item.testid}</td>
						<td>${item.deptid}</td>
						<td>${item.buyername}</td>
						<td>${item.provid}</td>
						<td>${item.typeid}</td>
						<td>${item.enterdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>
	<div style="text-align: right;">
		<button id="itemdelete" class="layui-btn layui-btn-primary" margin-left="200px">删除</button>
		<button class="layui-btn layui-btn-primary" margin-left="300px">取消</button>
	</div>
	<script>
		layui.use('form', function() {
			var $ = layui.jquery, form = layui.form();

			//全选
			form.on('checkbox(allChoose)', function(data) {
				var child = $(data.elem).parents('table').find(
						'tbody input[type="checkbox"]');
				child.each(function(index, item) {
					item.checked = data.elem.checked;
				});
				form.render('checkbox');
			});

		});
	</script>
</body>
</html>