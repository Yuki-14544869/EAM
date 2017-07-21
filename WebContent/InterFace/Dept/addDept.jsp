<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <title>添加部门信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
  <script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
  <script type="text/javascript" src="/EAM/Static/JS/Dept/dept.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top:20px;">
  <legend>添加部门信息</legend><br/><br/>
  
 <form id="addDeptForm"  method="post">
 

   <div class="layui-form-item"style="padding-left:600px;">
    <div class="layui-inline">
      <label class="layui-form-label" >部门名称</label>
      <div class="layui-input-inline">
        <input name="name" class="layui-input" type="text" autocomplete="off" lay-verify="name">
      </div>
    </div>
  </div>
  
   <div class="layui-form-item"style="padding-left:600px;">
    <div class="layui-inline">
      <label class="layui-form-label">父部门ID</label>
      <div class="layui-input-inline">
        <input name="pid" class="layui-input" type="text" autocomplete="off" lay-verify="pid">
      </div>
    </div>
  </div>
  
   <div class="layui-form-item"style="padding-left:600px;">
    <div class="layui-inline">
      <label class="layui-form-label">部门电话</label>
      <div class="layui-input-inline">
        <input name="personid" class="layui-input" type="text" autocomplete="off" lay-verify="personid">
      </div>
    </div>
  </div>
  

  
  </form>
  
  <div style="padding-left:720px;"><button id="addDept" class="layui-btn">提交</button>
   &nbsp&nbsp&nbsp&nbsp 
   <input class="layui-btn" type="submit" name="Submit" value="返回"
			onclick="window.location.href='http://localhost:8080/EAM/InterFace/Dept/dept.jsp';">
    </div>
  
</fieldset>
</body>
</html>