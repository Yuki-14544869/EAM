<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已创建的计划</title>
<link rel="stylesheet" href="Static/layui/css/layui.css" media="all">
<script src="Static/layui/layui.js"></script>

<script>
	layui.use([ 'element', 'layer' ], function() {
		var element = layui.element();
		var layer = layui.layer;
	});
	function sub(id,version)
	{
		var listid = "list"+id;
		var mailtext = document.getElementById(listid).innerHTML;
	
		var temp = document.createElement("form");
		  temp.action = "PlanAction?method=subPlan";
		  temp.method = "post";
		  temp.style.display = "none";
		  var PARAMS = {method:'subPlan',id:id,version:version,mail:mailtext}
		  for (var x in PARAMS) {
		    var opt = document.createElement("textarea");
		    opt.name = x;
		    opt.value = PARAMS[x];
		    
		    temp.appendChild(opt);
		  }
		  document.body.appendChild(temp);
	 temp.submit();
		
	}
	function del1(id)
	{
		
	
		var temp = document.createElement("form");
		  temp.action = "PlanAction";
		  temp.method = "post";
		  temp.style.display = "none";
		  var PARAMS = {method:'delPlan',id:id}
		  for (var x in PARAMS) {
		    var opt = document.createElement("textarea");
		    opt.name = x;
		    opt.value = PARAMS[x];
		    
		    temp.appendChild(opt);
		  }
		  document.body.appendChild(temp);
	 temp.submit();
		
	}
</script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>未提交的计划（${plansnum}）
		<a href="PlanAction?method=checkingPlan"><i class="layui-icon">&#xe602;</i></a>
		<a href="PlanAction?method=listPassedPlan"><i class="layui-icon">&#xe605;</i></a>
<a href="PlanAction?method=listRefusedPlan"><i class="layui-icon">&#x1006;</i></a>
		</legend>
	</fieldset>
	<div class="layui-collapse" lay-filter="test">
		<c:forEach items="${plans}" var="plan">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">${plan.title}</h2>

				<div class="layui-colla-content">


					<table class="layui-table" lay-skin="line">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>提交时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${plan.subtime}</td>
							</tr>
						</tbody>
					</table>


					<div id="list${plan.id }">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>采购明细</legend>
					</fieldset>
					<table class="layui-table" lay-even="" lay-skin="row">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>物品</th>
								<th>数量</th>
								<th>单价</th>
							</tr>
						</thead>
						<tbody>
							<c:forTokens items="${plan.text}" delims="|" var="name">
								<tr>
									<c:forTokens items="${name}" delims="-" var="value">
										<td>${value}</td>
									</c:forTokens>
								</tr>
							</c:forTokens>
						</tbody>

					</table>
					<table class="layui-table" lay-skin="line">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${plan.detail}</td>
							</tr>
						</tbody>
					</table>
					</div>
                    <div class="site-demo-button" style="margin-bottom: 0;">
						<button class="layui-btn" onclick="sub(${plan.id},${plan.version })">提交</button>
						<button class="layui-btn layui-btn-danger" onclick="del1(${plan.id})">删除</button>
					</div>




				</div>
			</div>
		</c:forEach>
	</div>
	


</body>
</html>