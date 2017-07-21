<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
<script type="text/javascript">//查询的动作
  function addClick() {
		var obj = document.getElementById("myForm");
		obj.action = "/EAM/IrpAction?method=addIrp";
		obj.submit();
  } 

</script>
<title>添加</title>
</head>
<body>
	<fieldset>
		<legend>添加信息</legend>
		<form id="myForm" method="post" action="/EAM/IrpAction" style="text-align: center;">
			<!-- 编号  :&nbsp;<input type="text" name="id"   >&nbsp;      <br />   -->   
			路径  :&nbsp;<input type="text" name="path" >&nbsp;      <br />     
			英文名 :&nbsp;<input type="text" name="name"  >&nbsp;     <br />    
			中文名 :&nbsp;<input type="text" name="cname"  >&nbsp;     <br />
			父节点：&nbsp;<input type="text" name="pid"  >&nbsp;     <br />
			标号：&nbsp;<input type="text" name="code"  >&nbsp;     <br />
			描述：&nbsp;<input type="text" name="detal"  >&nbsp;     <br />
			是否启用：&nbsp;<input type="text" name="del"  >&nbsp;     <br />
			<br />
			<button class="layui-btn" onclick="addClick()">确定</button>
			<input class="layui-btn" type="reset" value="重置">
		</form>
	</fieldset>
</body>
</html>