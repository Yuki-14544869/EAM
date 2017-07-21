<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已办事项</title>
<link rel="stylesheet" href="Static/layui/css/layui.css" media="all">
<script src="Static/layui/layui.js"></script>

<script>
	layui.use([ 'element', 'layer' ], function() {
		var element = layui.element();
		var layer = layui.layer;
	});
</script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>
			已办事项（${plansnumSum}）<a href="PlanAction?method=listSubmitedPlan"><sub><i
					class="layui-icon">&#xe642;</i>查看待办事项</sub></a>
		</legend>
	</fieldset>

	<div class="layui-collapse" lay-accordion="">
		<div class="layui-colla-item">
			<h2 class="layui-colla-title">通过的计划（${plansnum1}）</h2>
			<div class="layui-colla-content ">
				<div class="layui-collapse" lay-filter="test">
		<c:forEach items="${Passed}" var="passed">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">${passed.title}</h2>

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
								<td>${passed.subtime}</td>
							</tr>
						</tbody>
					</table>



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
							<c:forTokens items="${passed.text}" delims="|" var="name">
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
								<td>${passed.detail}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
			</div>
		</div>
		<div class="layui-colla-item">
			<h2 class="layui-colla-title">否决的计划（${plansnum2 }）</h2>
			<div class="layui-colla-content ">
			<div class="layui-collapse" lay-filter="test">
		<c:forEach items="${Refused}" var="refused">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">${refused.title}</h2>

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
								<td>${refused.subtime}</td>
							</tr>
						</tbody>
					</table>



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
							<c:forTokens items="${refused.text}" delims="|" var="name2">
								<tr>
									<c:forTokens items="${name2}" delims="-" var="value2">
										<td>${value2}</td>
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
								<td>${refused.detail}</td>
							</tr>
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
								<th>反馈</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${refused.response}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
							</div>
		</div>
	</div>
	
</body>
</html>