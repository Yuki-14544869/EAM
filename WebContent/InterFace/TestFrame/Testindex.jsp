<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE htmlPUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>质检单信息管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">  
  <script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
  <script type="text/javascript" src="/EAM/Static/JS/Test/Test.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>质检单信息管理</legend>

   <form id="testform" method="post">
   <br>
    <div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">样品编号</label>
					<div class="layui-input-inline">
						<input width="400" type="text" name="testcode" lay-verify="testcode" autocomplete="off" class="layui-input">
					</div>
				</div>   
		
		
				<div class="layui-inline">
					<label class="layui-form-label">样品名称</label>
					<div class="layui-input-inline">
						<input type="text" name="name" lay-verify="name" autocomplete="off" class="layui-input">
					</div>
				</div> 
				  	
				
				<div class="layui-inline">
					<label class="layui-form-label">质检人员</label>
					<div class="layui-input-inline">
					<input type="text" name="person" lay-verify="person" autocomplete="off" class="layui-input">
					</div>
				</div>   
				
			
				<div class="layui-inline">
					<label class="layui-form-label">质检日期</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id= "search" class="layui-btn layui-btn-warm layui-btn-radius">查询</button>
					<a class="layui-btn layui-btn-warm layui-btn-radius" onclick="window.location.href='http://localhost:8080/EAM/InterFace/TestFrame/addTest.jsp';">添加</a>
					<div class="layui-input-inline">
					 <input type="text" name="testdate" lay-verify="testcode" autocomplete="off" class="layui-input">				 
					</div>
				</div>   
			</div>	
			</br>	
</form>
</fieldset>

   </div>
  <form id="searchform" method="post">	
  <fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>质检单信息</legend>
	</fieldset>
	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="100">
				<col width="50">
			</colgroup>
			<thead>
				<tr>
					<th>样品编号</th>
					<th>样品名称</th>
					<th>样品数量</th>
					<th>检验日期</th>
					<th>负责人</th>
					<th>查看详情及修改</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${test}" var="ID">
				<tr>
				<td>${ID.testcode}</td>
				<td>${ID.name}</td>
				<td>${ID.count}</td>		
				<td>${ID.testdate}</td>
				<td>${ID.person}</td>		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="layui-btn layui-btn-warm" id="searchTest"  href="/EAM/TestAction?method=SearchTest&id=${ID.id}"><i class="layui-icon">&#xe642;</i></a></td>
				
				</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
	</form>
</body>
</html>  
   
  
  
