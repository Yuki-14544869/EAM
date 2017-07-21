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

<title>PersonToRole</title>
</head>
<body>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 10px;">
		<legend>人员角色管理</legend>
		<br />


		<script type="text/javascript">
			function checkk() {
				var obj = document.getElementById("Form");
				obj.action = "/EAM/PersonToRoleAction?method=findPersonToRole"
				obj.submit();
			}
			function addd() {
				var obj = document.getElementById("Form");
				obj.action = "/EAM/PersonToRoleAction?method=jumpAddPersonToRole";
				obj.submit();
			}
			function deletee() {
				var obj = document.getElementById("Form");
				obj.action = "/EAM/PersonToRoleAction?method=jumpDeletePersonToRole";
				obj.submit();
			}
		</script>
		<form method="post" id="Form">
			<!-- 		<div align="center" class="layui-form-item"> -->
			<!-- 			<label class="layui-form-label">姓名：</label><input type="text" name="name" id="textname" class="layui-input-inline"/> -->
			<!-- 		</div> -->

			<div align="center" style="margin-top: 40px;">
				<div class="layui-form-item" align="center"
					style="margin-left: -1100px">
					<div class="layui-inline" style="margin-top:-60px;">
						<label class="layui-form-label"><big>姓名:</big></label>
						<div class="layui-input-inline">
							<input name="name" class="layui-input" type="text"
								autocomplete="off" lay-verify="id">
						</div>
					</div>
				</div>
				<div style="margin-top:-50px;">
					<input type="button" name="check" value="查询" id="c_button"
						onclick="checkk()" class="layui-btn" />&nbsp;&nbsp; <input
						type="button" name="add" value="添加" id="t_button" onclick="addd()"
						class="layui-btn layui-btn-warm" />&nbsp;&nbsp; <input
						type="button" name="delete" value="删除" id="s_button"
						onclick="deletee()" class="layui-btn layui-btn-danger" />
				</div>
			</div>
	</fieldset>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: -10px;"></fieldset>



	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>人员角色信息</legend>
	</fieldset>

	<div align="center">
		<table class="layui-table">
			<colgroup style="background:#97CBFF">
				<col width="100">
				<col width="450">
				<col>
			</colgroup>
			<thead>

				<tr>
					<th><big>人员</big></th>
					<th><big>角色</big></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${persontorole}" var="pertoro">
						<tr>
							<td><input type="radio" value=${pertoro.key }
								name="selected"><b>${pertoro.key }</b></td>
								<c:if test="${pertoro.value[0]==null}">
								<td>  </td>
								</c:if>
								<c:if test="${pertoro.value[0]!=null}">
								<td><b>${pertoro.value}</b></td>
								</c:if>
							
						</tr>
					</c:forEach>

				</tr>
			</tbody>
		</table>
	</div>
	</form>

</body>
</html>