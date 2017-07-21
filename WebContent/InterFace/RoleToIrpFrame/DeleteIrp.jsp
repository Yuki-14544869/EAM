<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<link rel="stylesheet"
	href="//res.layui.com/layui/build/css/layui.css?t=1498856285724"
	media="all">
<link rel="stylesheet"
	href="//res.layui.com/css/global.css?t=1498856285724" media="all">
<style type="text/css"> samp {
	font-family: monospace, monospace;
	font-size: 1em
}</style>	

<title>角色权限删除</title>
</head>
<body topmargin="50px">
<script>
function back()
{
	 window.location.href="/EAM/roleToIrpAction?method=findRoleToIrp";
}

</script>

	<fieldset style="border-color: #666" class="layui-elem-field layui-field-title"  >
		<legend>删除角色权限</legend>
		
       <div class="layui-layout layui-layout-admin"  style="margin-top : 60px">
		<form style="text-align: center" action="/EAM/roleToIrpAction?method=deleteRoleToIrp" method="post">
		
<!-- 			<p> -->
<%-- 				角色： <input type="text" name="name" value=${selected } /></p> --%>
<!-- 			<p> -->
<!-- 				权限： <select name="select"> -->

<div class="layui-form-item" align="center"
					style="margin-left: -80px">
					<div class="layui-inline">
						<label class="layui-form-label"><big>角色</big></label>
						<div class="layui-input-inline">
		                <input name="name" class="layui-input" type="text"
								autocomplete="off" lay-verify="id" value=${selected }>
						</div>
					</div>
				</div>
<div class="layui-form-item" align="center">
					<div class="layui-inline" style="margin-left: -140px">
						<label class="layui-form-label"><big>权限:</big></label>
					</div>
				</div>

		<div  style="margin-left: 60px;margin-top: -50px">
						 <select name="select"  style="width:80px" >			
					<c:forEach items="${deleteroletoirp}" var="rol">
							<option value=${rol.id} >${rol.cname}</option>
						</c:forEach>
					
				</select>
	</div>
		
		<div style="margin-top: 30px">
			<input type="submit" value="确定"class="layui-btn layui-btn-normal"/>&nbsp; <input type="button" onclick=back()
				value="返回" class="layui-btn layui-btn-normal"/>
				</div>
		</form>
		</div>
	</fieldset>

</body>
</html>