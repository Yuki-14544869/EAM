<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型更新</title>
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>类型添加</legend>
</fieldset>

	<form class="layui-form" action="/EAM/typeAction" method="post">
	   <div class="layui-form-item">
			<div class="layui-input-block">
				<input name="method" lay-verify="title" autocomplete="off"
					 class="layui-input" type="hidden" value="addType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input name="name" lay-verify="title" autocomplete="off"
					placeholder="请输入标题" class="layui-input" type="text">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">说明</label>
			<div class="layui-input-block">
				<input name="detail" lay-verify="title" autocomplete="off"
					placeholder="请输入标题" class="layui-input" type="text">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input name="version" lay-verify="title" autocomplete="off"
					placeholder="请输入标题" class="layui-input" type="hidden">
			</div>
		</div>
		<button class="layui-btn ">确定</button>
	</form>
</body>
</html>