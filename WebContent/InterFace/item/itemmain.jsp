<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>库存管理</title>
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

	<form id="itemForm" action="ItemAction?itemOperate=listByPlaceId"
		method="post">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">场地编号：</label>
				<div class="layui-input-inline">
					<input type="text" name="placeId" id="placeId" lay-verify="phone"
						autocomplete="off" class="layui-input">
				</div>
				<button type="submit" id="itemSearch"
					class="layui-btn ">查看</button>
			</div>
		</div>
	</form>

	<form id="itemOperateForm" class="layui-form" method="post">
		<div class="layui-form">
			<table class="layui-table">
				<colgroup>
					<col width="2">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col width="20">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" name="" lay-skin="primary"
							lay-filter="allChoose"></th>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>场地名称</th>
						<th>质检名称</th>
						<th>部门名称</th>
						<th>采购者</th>
						<th>供应商</th>
						<th>资产类型</th>
						<th>入库日期</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${items}" var="item">
						<tr>
							<td><input type="checkbox" value=${item.id } name="selected" lay-skin="primary">
							</td>
							<td style="width:100px">${item.id}</td>
							<td style="width:100px">${item.name}</td>
							<td style="width:100px">${item.price}</td>
							<td style="width:100px">${item.placeName}</td>
							<td style="width:100px">${item.testName}</td>
							<td style="width:100px">${item.deptName}</td>
							<td style="width:100px">${item.buyerName}</td>
							<td style="width:100px">${item.provName}</td>
							<td style="width:100px">${item.typeName}</td>
							<td style="width:100px">${item.enterDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div style="text-align: right;">
			<button id="itemToadd" class="layui-btn"
				margin-left="200px">添加</button>
			<button id="itemToupdate" class="layui-btn"
				margin-left="200px">修改</button>
			<button id="itemdelete" class="layui-btn"
				margin-left="200px">删除</button>
		</div>
	</form>
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