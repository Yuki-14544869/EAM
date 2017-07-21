<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>供应商信息管理</title>
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
</head>
<body>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>供应商信息管理</legend>
		<br />
		<form id="providerForm"
			action="/EAM/providerAction?method=findByCondition" method="post">
			<div class="layui-form-item"style="padding-left: 400px; margin-top: 25px;">
				<div class="layui-inline">
					<label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input name="id" class="layui-input" type="text"
							autocomplete="off" lay-verify="id">
					</div>
				</div>
			</div>
			<div class="layui-form-item"style="padding-left: 400px; margin-top: 30px;">
				<div class="layui-inline">
					<label class="layui-form-label">供应商名</label>
					<div class="layui-input-inline">
						<input name="name" class="layui-input" type="text"
							autocomplete="off" lay-verify="name">
					</div>
				</div>
			</div>
		</form>

		<div style="padding-left: 450px; margin-top: 50px;">
			<button id="providerSearch" class="layui-btn">查询</button>
			 
			<input class="layui-btn layui-btn-warm" type="submit" name="Submit"
				value="添加"
				onclick="window.location.href='http://localhost:8080/EAM/InterFace/provider/addProvider.jsp';">
			<button class="layui-btn" id="btn"><i class="layui-icon"></i> </button>
			<button class="layui-btn layui-btn-warm"  id="jj"><i class="layui-icon"></i></button>
		</div>
	</fieldset>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 50px;">
		</fieldset>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>供应商信息</legend>
	</fieldset>

	<div class="layui-form">
		<table class="layui-table" id="tbo">
			<colgroup>
				<col width="30">
				<col width="70">
				<col width="200">
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
					<th><input type="checkbox" 
						></th>
					<th>id</th>
					<th>供应商名</th>
					<th>法人代表</th>
					<th>联系电话</th>
					<th>邮箱</th>
					<th>网址</th>
					<th>地址</th>
					<th>银行账户</th>
					
				</tr>
			</thead>
			<tbody >
				<c:forEach items="${provider}" var="ID">
					<c:if test="${ID.del=='0' }">
						<tr>
							<td><input type="checkbox" value=${ID.id }
								lay-skin="primary"></td>
							<td>${ID.id }</td>
							<td>${ID.name}</td>
							<td>${ID.perid}</td>
							<td>${ID.tel}</td>
							<td>${ID.mail}</td>
							<td>${ID.url}</td>
							<td>${ID.address}</td>
							<td>${ID.bankaccount}</td>
							
							
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
	<form id="subform" action="/EAM/providerAction?method=deleteProvider"method="post">
		<input type="hidden" name="id" id="hiddeninput" />
	</form>
	<div
		style="display: none; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.8); z-index: 1000"
		id="div1">

		<div
			style="position: absolute; left: 20%; top: 20%; background-color: #393D49; width: 40%; height: 50%;">
			<p
				style="position: absolute; top: 40%; left: 40%; color: white; font-size: 15px">确定要删除吗？</p>
			<button id="subinput" class="layui-btn layui-btn-warm" form="form"style="position: absolute; top: 70%; left: 20%;">确定</button>
			<button id="btn2" style="position: absolute; top: 70%; left: 70%;"
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
			var jj = document.getElementById('jj');
			btn.onclick = function(){
				if($(".layui-form-checked").length==1){
					div1.style.display = "block";
				}
				else if($(".layui-form-checked").length==0)
				{
				alert("你要删啥啊！！！")

				
				}
				else if ($(".layui-form-checked").length>=2)
				{
					alert("你选多啦！")
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
				
		
			btn2.onclick = function(){
				div1.style.display = "none";
			}
			jj.onclick = function(){
				
				var inpu22 = tbo.getElementsByTagName('input');
				var hiddeninput = document.getElementById('hiddeninput');
				if($(".layui-form-checked").length==1){
					
				}
				else if($(".layui-form-checked").length==0)
				{
				alert("你要改啥啊！！！")
				return;
				}
				else if ($(".layui-form-checked").length>=2)
				{
					alert("你选多啦！")
					return;
				}
				for(var i=0;i<inpu22.length;i++){
					if(inpu22[i].checked){
						hiddeninput.value += inpu22[i].value;
					}
						subform.action = "/EAM/providerAction?method=SelectProvider";
						subform.submit();
					
				}
	
			}
			
		}
</script>
</body>
</html>
