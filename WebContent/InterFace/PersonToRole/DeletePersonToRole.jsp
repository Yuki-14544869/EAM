<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script type="text/javascript" src="/EAM/Static/JS/provider/provider.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/EAM/Static/layui/layui.js"
	charset="utf-8"></script>
	
<link rel="stylesheet"
	href="//res.layui.com/layui/build/css/layui.css?t=1498856285724"
	media="all">
<link rel="stylesheet"
	href="//res.layui.com/css/global.css?t=1498856285724" media="all">
<style type="text/css"> samp {
	font-family: monospace, monospace;
	font-size: 1em
}</style>	

<title>人员的角色删除</title>
</head>

<script>
function back()
{
	 window.location.href="/EAM/PersonToRoleAction?method=addPersonToRole";
}

</script>

<body topmargin="50px" leftmargin="200px">

 
	<fieldset style="border-color: #666; width: 600px; height: 300px;margin-left:380px;margin-top:50px">
		<legend><font size="+2">删除人员角色</font></legend>
		<div class="layui-layout layui-layout-admin">
			<form style="text-align: center"
				action="/EAM/PersonToRoleAction?method=deletePersonToRole"
				method="post">
				<div class="layui-form-item" align="center"
					style="margin-left: -80px">
					<div class="layui-inline">
						<label class="layui-form-label"><big>姓名</big></label>
						<div class="layui-input-inline">
							<input name="name" class="layui-input" type="text"
								autocomplete="off" lay-verify="id" value=${selected}>
						</div>
					</div>
				</div>
				<div class="layui-form-item" align="center">
					<div class="layui-inline" style="margin-left: -140px">
						<label class="layui-form-label"><big>角色:</big></label>
					</div>
				</div>
				<div style="margin-left: 60px; margin-top: -50px">
					<select name="select" style="width: 80px;height:30px">
						<c:forEach items="${deletepersontorole}" var="pertoro">
							<option value=${pertoro}>${pertoro}</option>
						</c:forEach>
					</select>
				</div>
				<div style="margin-top: 30px">
					<input type="submit" value="确定" class="layui-btn" />&nbsp; <input
						type="button" value="关闭" class="layui-btn layui-btn-warm" onclick="back()"/>
				</div>
			</form>
		</div>
	</fieldset>
</body>
</html>