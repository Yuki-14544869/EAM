<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, 
initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script type="text/javascript" src="/EAM/Static/JS/provider/provider.js" charset="UTF-8"></script>
<script type="text/javascript" src="/EAM/Static/layui/layui.js" charset="UTF-8"></script>
<script>


</script>
<title>人员管理查找功能</title>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 10px;">
		<legend>人员管理查找功能</legend>
		<br />


	<script type="text/javascript">
    function checkk()
    {
    	var obj=document.getElementById("Form");
    	obj.action="/EAM/PersonAction?method=selectPerson"
    	obj.submit();
    }
   
    
	</script>
	<form  method="post" id="Form">

		<div align="center" style="margin-top:auto;">
		<div class="layui-input-inline" >
				<div class="layui-inline">
					<label class="layui-form-label">工号</label>
					<div class="layui-input-inline">
						<input name="username" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input name="realname" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">部门</label>
					<div class="layui-input-inline">
						<input name="deptid" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline">
						<input name="sex" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">职位</label>
					<div class="layui-input-inline">
						<input name="pos" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
			</div>
		<div>
		&nbsp;<br/>
			<input type="button" name="check" value="查询" id="c_button" onclick="checkk()" class="layui-btn"/>&nbsp;&nbsp; 
			
		</div>
		</div>
	
</fieldset>
<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;"></fieldset>
		
		
		
<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>人员角色信息</legend>
	</fieldset>
		
		<div align="center">
			<table class="layui-table">
				<colgroup style="background:white">
					<col width="auto">
					<col width="auto">
					<col>
				</colgroup>
				<thead>
				
					<tr>
						<th><big>工号</big></th>
						<th><big>姓名</big></th>
						<th><big>性别</big></th>
						<th><big>民族</big></th>
						<th><big>出生日期</big></th>
						<th><big>入职日期</big></th>
						<th><big>部门id</big></th>
						<th><big>身份证号</big></th>
						<th><big>家庭住址</big></th>
						<th><big>籍贯</big></th>
						<th><big>电话</big></th>
						<th><big>邮箱</big></th>
						<th><big>职位</big></th>
						<th><big>在职状态</big></th>
						<th><big>处理</big></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${person}" var="person">
							<tr>
								
								<td><b>${person.username}</b></td>
								<td><b>${person.realname}</b></td>
								<td><b>${person.sex}</b></td>
								<td><b>${person.nat}</b></td>
								<td><b>${person.borndate}</b></td>
								<td><b>${person.hiredate}</b></td>
								<td><b>${person.deptid}</b></td>
								<td><b>${person.cardid}</b></td>
								<td><b>${person.address}</b></td>
								<td><b>${person.natpl}</b></td>
								<td><b>${person.tel}</b></td>
								<td><b>${person.mail}</b></td>
								<td><b>${person.pos}</b></td>
								<td><b>${person.state}</b></td>
								<td><a type="button" href="/EAM/PersonAction?method=jumpToUpdate&id=${person.id}" value="更新">更新</a>&nbsp;&nbsp;<a type="button" href="/EAM/PersonAction?method=deletePerson&id=${person.id}" value="删除">删除</a></td>
							
							</tr>
						</c:forEach>

					</tr>
				</tbody>
			</table>
		</div>
	</form>

</body>
</html>