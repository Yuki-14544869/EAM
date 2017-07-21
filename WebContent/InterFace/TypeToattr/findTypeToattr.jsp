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
<script type="text/javascript" src="/EAM/Static/JS/provider/provider.js" charset="utf-8"></script>
<script type="text/javascript" src="/EAM/Static/layui/layui.js" charset="utf-8"></script>


<title>RoleToIrp</title>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 10px;">
		<legend>角色权限管理</legend>
		<br />
	<script type="text/javascript">
    function checkk()
    {
    	var obj=document.getElementById("Form");
    	obj.action="/EAM/roleToIrpAction?method=findRoleToIrp"
    	obj.submit();
    }
    function addd()
    {
    	var obj=document.getElementById("Form");
    	obj.action="/EAM/roleToIrpAction?method=jumpAddRoleToIrp";
    	obj.submit();
    }
    function deletee()
    {
    	var obj=document.getElementById("Form");
    	obj.action="/EAM/roleToIrpAction?method=jumpdeleteRoleToIrp";
    	obj.submit();
    }
	
	</script>
	<form action="" method="post" id="Form">
<!-- 		<div align="center" class="layui-form-item"> -->
<!-- 			<label class="layui-form-label">角色名：</label><input type="text" name="name" id="textname" class="layui-input-inline"/> -->
<!-- 		</div> -->
		
		<div align="center" style="margin-top:40px;">
		<div class="layui-form-item" align="center" style="margin-left:-80px">
				<div class="layui-inline">
					<label class="layui-form-label">角色名</label>
					<div class="layui-input-inline">
						<input name="name" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
			</div>
		</div>



		<div align="center">
			<input type="button" name="check" value="查询" id="c_button" onclick="checkk()"/>&nbsp;&nbsp;
			<input type="button" name="add" value="添加" id="t_button" onclick="addd()"/>&nbsp;&nbsp;
			<input type="button" name="delete" value="删除" id="s_button" onclick="deletee()"/>
		</div>
		</div>
</fieldset>
		<br>
<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;">
</fieldset>
<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>角色权限对照信息</legend>
</fieldset>
		<div align="center">
		
			<table class="layui-table">
				<colgroup style="background:#48D1CC">
					<col width="100">
					<col width="450">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th>角色</th>
						<th>权限</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${roletoirp}" var="rti">
							<tr>
								<td><input type="radio" value=${rti.key }
									name="selected">${rti.key }</td>
								<td>${rti.value}</td>
							</tr>
						</c:forEach>

					</tr>
				</tbody>
			</table>
	
	
		
		</div>
		
	</form>





</body>
</html>