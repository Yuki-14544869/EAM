<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <title>采购计划管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../../Static/layui/css/layui.css"  media="all">
	<script type="text/javascript">
	function add(){
		document.getElementById("body1").innerHTML+='<tr><td><input type="text" name="procuct"  ></td><td><input type="text" name="number1"  ></td><td><input type="text" name="price"  ><td><button class="layui-btn layui-btn-primary" onclick="deleteRow(this)">删除</button></td></td></tr>';

	
	}
	function add1(){
		 var x=document.getElementById('table1').insertRow(0)
		  var y=x.insertCell(0)
		  var z=x.insertCell(1)
		  var m=x.insertCell(2)
		  var n=x.insertCell(3)
		  y.innerHTML='<input type="text" name="product">'
		  z.innerHTML='<input type="text" name="number1"  >'
		  m.innerHTML='<input type="text" name="price"  >'
		  n.innerHTML='<button class="layui-btn layui-btn-danger" onclick="deleteRow(this)">删除</button>'
	}
	function deleteRow(r)
	  {
	  var i=r.parentNode.parentNode.rowIndex
	  document.getElementById('table1').deleteRow(i);
	  }
	function reset()
	{
		document.getElementById("form1").reset()
	}
	function sub(){
		
	var obj= document.getElementById("form1");
	obj.action="/EAM/PlanAction?method=addPlan"
    obj.method="post"
	obj.submit();		
	}
	</script>
</head>
<body>

<div>
<p style="font-size:40px;text-align:center;">固定资产采购计划管理</p>
<br/>
<br/>
<br/>
<br/>
<div style="text-align:right;margin-right:50px;">
<a href="../../PlanAction?method=listUnsubmitedPlan">已创建的计划&nbsp;&nbsp;</a>
<a href="../../PlanAction?method=checkingPlan">审核中的计划&nbsp;&nbsp;</a>
<a href="../../PlanAction?method=listPassedPlan">已通过计划&nbsp;&nbsp;</a>
<a href="../../PlanAction?method=listRefusedPlan">未通过的计划&nbsp;&nbsp;</a>
</div>
<br/>
<div>
<form id="form1" action="/EAM/PlanAction?method=addPlan"  method="post">
 <label class="layui-form-label">计划标题</label>
    <div class="layui-input-block" style="padding-right:50px;">
      <input type="text" name="title" id="title" lay-verify="title" autocomplete="off" placeholder="请输入计划标题" class="layui-input">
    </div>
    
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>采购清单</legend>
</fieldset>
 
<div class="layui-form" style="margin-left:50px;margin-right:50px;">
  <table class="layui-table" id="table0">
    <colgroup>
      <col width="102">
      <col width="102">
      <col width="102">
      <col width="48">
      
      <col>
    </colgroup>
    <thead>
      <tr>
        
        <th>物品</th>
        <th>数量</th>
        <th>单价</th>
       <th>操作</th>
        
      </tr> 
    </thead>
 </table>
    <table class="layui-table" id="table1">
    <colgroup>
      <col width="100">
      <col width="100">
      <col width="100">
      <col width="100">
      
      <col>
    </colgroup>
    <tbody id="body1">
      <tr>
        
        <td><input type="text" name="product"></td>
        <td><input type="text" name="number1"  ></td>
        <td><input type="text" name="price"  ></td>
        <td><button class="layui-btn layui-btn-danger" onclick="deleteRow(this)">删除</button></td>
      </tr>
      
     
    
    </tbody>
     
  </table>
  
</div>

<br/>
    
    <div class="layui-form-item layui-form-text"style="padding-left:50px;padding-right:50px;" >
    <label>备注:</label>
    <div class="layui-input-block" style="margin-left:0px;">
      <textarea placeholder="请输入内容" class="layui-textarea" name="detail" id="detail"></textarea>
    </div>
  </div>
  </div>
  
</form>
</div>
<button class="layui-btn" style="margin-left:50px"; onclick="add1()">增加采购物品</button>
<button class="layui-btn" style="margin-left:50px"; onclick="reset()">清空</button>
<button class="layui-btn" style="margin-left:50px"; onclick="sub()">创建</button>


<div></div>
</div>
</body>
</html>