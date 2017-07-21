<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改库存</title>
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
	<div align='center'>
		<br>
		<fieldset style="width:400px;"
			class="layui-elem-field layui-field-title" style="margin-top: 20px">
			<legend>修改库存</legend>
			<br>
			<form id="itemupdateForm" class="layui-form" method="post" action="ItemAction?itemOperate=update&itemId=${item.id }&version=${item.version}">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">商品名称</label>
						<div class="layui-input-inline">
							<input type="text" name="name" id="name" lay-verify="phone"
								class="layui-input" value=${item.name}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">商品价格</label>
						<div class="layui-input-inline">
							<input type="text" name="price" id="price" lay-verify="phone"
								 class="layui-input" value=${item.price}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">场地名称</label>
						<div class="layui-input-inline">
							<input type="text" name="placeName" id="placeName"
								lay-verify="phone" class="layui-input" value=${item.placeName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">质检名称</label>
						<div class="layui-input-inline">
							<input type="text" name="testName" id="testName"
								lay-verify="phone" class="layui-input" value=${item.testName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">部门名称</label>
						<div class="layui-input-inline">
							<input type="text" name="deptName" id="deptName"
								lay-verify="phone" class="layui-input" value=${item.deptName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">采购者</label>
						<div class="layui-input-inline">
							<input type="text" name="buyerName" id="buyerName"
								lay-verify="phone" class="layui-input" value=${item.buyerName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">供应商名称</label>
						<div class="layui-input-inline">
							<input type="text" name="provName" id="provName"
								lay-verify="phone" class="layui-input" value=${item.provName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">资产类型</label>
						<div class="layui-input-inline">
							<input type="text" name="typeName" id="typeName"
								lay-verify="phone" class="layui-input" value=${item.typeName}>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">入库日期</label>
						<div class="layui-input-inline">
							<input type="datetime" name="enterDate" id="enterDate"
								lay-verify="phone" class="layui-input" value=${item.enterDate}>
						</div>
					</div>
				</div>
				<div style="text-align:right;">
					<button id="itemupdate" class="layui-btn layui-btn-primary"
						margin-left="200px">确认更改</button>
					<button type="reset" id="resetForm"
						class="layui-btn layui-btn-primary" margin-left="300px">重置</button>
				</div>
			</form>
		</fieldset>
	</div>
</body>
</html>