<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>库存管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="//res.layui.com/layui/build/css/layui.css"  media="all">
<title>库存</title>
</head>
<body>
<fieldset class="layui-elem-field site-demo-button">
  <legend>库存信息操作</legend>
  <div>    
    <button class="layui-btn">添加</button>
    <button class="layui-btn">修改</button>
    <button class="layui-btn">删除</button>
    <button class="layui-btn">查看</button>
  </div>
</fieldset>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>库存信息表  </legend>
 
<table class="layui-table" >
  <colgroup>
    <col width="150">
    <col width="150">
    <col width="150">
     <col width="150">
    <col width="150">
    <col width="150">
     <col width="150">
    <col width="150">
    <col width="150">
     <col width="150">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>商品编号</th>
      <th>商品名称</th>
      <th>商品价格</th>
      <th>场地编号</th>
      <th>质检编号</th>
      <th>部门编号</th>
      <th>采购者</th>
      <th>供应商</th>
      <th>资产类型</th>
      <th>入库日期</th>
    </tr> 
  </thead>
<c:forEach items="${item}" var="item>
			<tr>
				<td><input type="radio" value=${item.id} name="selected"></td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.placeid}</td>
				<td>${item.testid}</td>
				<td>${item.deptid}</td>
				<td>${item.buyername}</td>
				<td>${item.provid}</td>
				<td>${item.typeid}</td>
				<td>${item.enterdate}</td>
			</tr>
		</c:forEach>  
  </table>
</fieldset> 
</body>
</html>