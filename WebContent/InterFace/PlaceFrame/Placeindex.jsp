<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
  <script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
  <script type="text/javascript" src="/EAM/Static/JS/Place/Place.js"></script>
  
  <script type="text/javascript">
  function deleteClick(){
	  var obj =document.getElementById("placeForm");
	  obj.action="/EAM/PlaceAction?method=deletePlace";
	  obj.submit();
  }
  
  function updateClick(){
	  var obj =document.getElementById("placeForm");
	  obj.action="/EAM/PlaceAction?method=updatePlace";
	  obj.submit();
  }

</script>
</head>
<body style="background-color:#d0d0d0;">
	<form action="/EAM/PlaceAction?method=deletePlace" method="post" id="btn4">
		<input type="hidden" name="id" id="inpu2" />
		
	</form>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
	<legend>场地信息管理</legend><br/>
	   <form id="placeForm" action="/EAM/PlaceAction?method=findPersonByConditionPlace"  method="post"  style="font-size:20px;">
	  
			编号:&nbsp;<input type="text" name="id">&nbsp; 名称 :&nbsp;<input
				type="text" name="name">&nbsp;类型:&nbsp;<input type="text" name="type">&nbsp; 状态 :&nbsp; <select name="state">
				<option value=0>全部</option>
				<option value=1>已用</option>
				<option value=2>未用</option>
			</select> 
	 </form>
		
	<div style="padding-left:755px; padding-top:20px;">		
    <button id="placeSearch" class="layui-btn" >查询</button>
   <input class="layui-btn layui-btn-warm" type="submit" name="Submit" value="添加" onclick="window.location.href='/EAM/InterFace/PlaceFrame/addPlace.jsp';">
    <button class="layui-btn"  id="ii">删除</button>
    <button class="layui-btn layui-btn-warm"  id="jj">修改</button>
  
  </div>
			
	</fieldset>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>场地信息</legend>
</fieldset>  
 
<table class="layui-table" lay-skin="nob" lay-even="">
  <colgroup>
    <col width="70">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="150">
    <col width="100">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>选择</th>
      <th>编号</th>
      <th>场地名称</th>
      <th>场地类型</th>
      <th>场地状态</th>
      <th>场地面积（㎡）</th>
      <th>负责人</th>
      <th>联系方式</th>
      <th>备注</th>
     
    </tr> 
  </thead>
  
  <tbody id="tab">
  
  <c:forEach items="${Places}" var="pla">
  <c:if test="${pla.del=='0' }">
			<tr>
				<td><input type="radio" value=${pla.id} name="id"></td>
				<td>${pla.id}</td>
				<td>${pla.name}</td>
                <td>${pla.type}</td>
                <td>	<c:if test="${pla.state=='1'}">
                   已用
            </c:if> 
            <c:if test="${pla.state=='2'}">
                   未用
            </c:if>
		</td>
            <td>${pla.area}</td>
            <td>${pla.person}</td>
				<td>${pla.tel}</td>
                <td>${pla.detail}</td>
			</tr>
</c:if>
		</c:forEach>
   
  </tbody>
</table> 
<script type="text/javascript">
	window.onload = function(){
			var ii = document.getElementById('ii');
			var jj = document.getElementById('jj');
			var btn4 = document.getElementById('btn4');
			ii.onclick = function(){
			var tnb = document.getElementById('tab');
			var inpu = tab.getElementsByTagName('input');
			var inpu2 = document.getElementById('inpu2');
			var j = 0;
			for(var i=0;i<inpu.length;i++){
				if(inpu[i].checked){
					j++;
				}
			}
			
			if(j==0){
				alert("你错了！");
			}else{
				for(var i=0;i<inpu.length;i++){
					if(inpu[i].checked){
						inpu2.value = inpu[i].value;
					}
				}
				btn4.submit();
				
			}
			}
			jj.onclick = function(){
				var tnb = document.getElementById('tab');
				var inpu = tab.getElementsByTagName('input');
				var inpu2 = document.getElementById('inpu2');
				var j = 0;
				for(var i=0;i<inpu.length;i++){
					if(inpu[i].checked){
						j++;
					}
				}
				
				if(j==0){
					alert("你错了！");
				}else{
					
					for(var i=0;i<inpu.length;i++){
						if(inpu[i].checked){
							inpu2.value = inpu[i].value
						}
					}
					btn4.action = "/EAM/PlaceAction?method=SearchPlace";
					btn4.submit();
				}
				}
		}
	</script>
</body>
</html>