<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>部门管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script type="text/javascript" src="/EAM/Static/JS/Dept/dept.js" charset="utf-8"></script>
<script type="text/javascript" src="/EAM/Static/layui/layui.js" charset="utf-8"></script>
</head>
<body>



	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>部门管理</legend>
		<br />
		<form id="DeptForm"  method="post">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">部门ID</label>
					<div class="layui-input-inline">
						<input name="id" class="layui-input" type="text"
							autocomplete="off" lay-verify="id" placeholder="请输入"  >
					</div>
				</div>

		
				<div class="layui-inline">
					<label class="layui-form-label" >部门名称</label>
					<div class="layui-input-inline">
						<input name="name" class="layui-input" type="text"
							autocomplete="off" lay-verify="name" placeholder="请输入" >
					</div>
				</div>
			
		
				<div class="layui-inline">
					<label class="layui-form-label" >父部门ID</label>
					<div class="layui-input-inline">
						<input name="pid" class="layui-input" type="text"
							autocomplete="off" lay-verify="pid" placeholder="请输入">
					</div>
				</div>
			
			
				<div class="layui-inline">
					<label class="layui-form-label" >部门电话</label>
					<div class="layui-input-inline">
						<input name="personid" class="layui-input" type="text"
							autocomplete="off" lay-verify="personid" placeholder="请输入">
					</div>
				</div>
				</div>		
		</form>

		<div style="padding-left: 50px;">
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp
			<button id="search" class="layui-btn">查询</button>
			<input class="layui-btn" type="submit" name="Submit"
				value="添加"
				onclick="window.location.href='http://localhost:8080/EAM/InterFace/Dept/addDept.jsp';">
			<button id="btn" class="layui-btn" >删除</button>
			<button class="layui-btn" id="det"  >修改</button>
			<input class="layui-btn" type="submit" name="Submit" value="返回"
			onclick="window.location.href='http://localhost:8080/EAM/InterFace/Dept/dept.jsp';">
		</div>
	</fieldset>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;"></fieldset>

	
	
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>部门信息</legend>
	</fieldset>

	<div class="layui-form">
		<table class="layui-table"  id="tbo">
			<colgroup>
				<col width="50">  
				<col width="100">
				<col width="150">
				<col width="150">
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="100">

			</colgroup>
			<thead>
				<tr>
					<th><input type="checkbox" lay-skin="primary"
						lay-filter="allChoose"></th>
					<th>部门id</th>
					<th>部门名称</th>
					<th>父部门ID</th>
					<th>部门电话</th>
				
					

				</tr>
			</thead>
			<tbody>
			<c:forEach items="${depts}" var="ID">
			<c:if test="${ID.del=='0' }">
				<tr>
					<td><input type="checkbox" value='${ID.id}' lay-skin="primary"></td>
					<td>${ID.id}</td>
					<td>${ID.name}</td>
					<td>${ID.pid}</td>
					<td>${ID.personid}</td>
					
				</tr>
				</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
layui.use('form', function(){
  var $ = layui.jquery, form = layui.form();
  
  //全选
  form.on('checkbox(allChoose)', function(data){
    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
    child.each(function(index, item){
      item.checked = data.elem.checked;
    });
    form.render('checkbox');
  });
  
});
</script>

	<form id="subform" action="/EAM/DeptAction?method=delete"method="post">
		<input type="hidden" name="id" id="hiddeninput" />
	</form>
	<div
		style="display: none; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.8); z-index: 1000"
		id="div1">

		<div
			style="position: absolute; left: 40%; top: 20%; background-color: #393D49; width: 20%; height: 50%;">
			<p
				style="position: absolute; top: 40%; left: 28%; color: white; font-size: 20px">确定要删除吗？</p>
			<button id="subinput" class="layui-btn layui-btn-warm" form="form"style="position: absolute; top: 70%; left: 15%;">确定</button>
			<button id="btn2" style="position: absolute; top: 70%; left: 60%;"
				class="layui-btn">返回</button>
		</div>

	</div>

	<script type="text/javascript">
		
		
		window.onload  = function(){
			var btn = document.getElementById('btn'); //删除按钮
			var subinput = document.getElementById('subinput'); //提交按钮
			var hiddeninput = document.getElementById('hiddeninput'); //hidden
			var div1 = document.getElementById('div1');
			var btn2 = document.getElementById('btn2');  //返回
			var subform = document.getElementById('subform');	//form
			var tbo = document.getElementById('tbo');	
			var det = document.getElementById('det');
			btn.onclick = function(){
				if($(".layui-form-checked").length==1){
				div1.style.display = "block";
			}
				else if($(".layui-form-checked").length==0)
				{
					alert("请选择删除信息！")

					
					}
					else if ($(".layui-form-checked").length>=2)
					{
						alert("请勿多选信息！")
					}
				}
			
			subinput.onclick = function(){
				var inpu22 = tbo.getElementsByTagName('input');
				
				for(var i=0;i<inpu22.length;i++){
					if(inpu22[i].checked){
						hiddeninput.value += inpu22[i].value;
					}
				}
				div1.style.display = "none";
				subform.submit();
				
			}
			det.onclick = function(){
				var inpu22 = tbo.getElementsByTagName('input');
				var hiddeninput = document.getElementById('hiddeninput');
				
                if($(".layui-form-checked").length==1){
					
				}
				else if($(".layui-form-checked").length==0)
				{
				alert("请选择删除信息！")
				return;
				}
				else if ($(".layui-form-checked").length>=2)
				{
					alert("请勿多选信息！")
					return;
				}
				for(var i=0;i<inpu22.length;i++){
					if(inpu22[i].checked){
						hiddeninput.value += inpu22[i].value;
					}
				}
				subform.action = "/EAM/DeptAction?method=Jump";
				subform.submit();
				
			}
			btn2.onclick = function(){
				div1.style.display = "none";
			}
		}
</script>


</body>
</html>