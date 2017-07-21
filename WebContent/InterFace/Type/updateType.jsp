<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型更新</title>
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>类型更新</legend>
</fieldset>
 
<form class="layui-form" action="/EAM/typeAction" method="post">
 <div class="layui-form-item">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
      <input value="updateType" name="method" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="hidden">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">id</label>
    <div class="layui-input-block">
      <input value="${type.id}" name="id" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input value="${type.name}" name="name" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">说明</label>
    <div class="layui-input-block">
      <input value="${type.detail}" name="detail" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
      <input value="${type.version}" name="version" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="hidden">
    </div>
  </div>
  <button  class="layui-btn " >确定</button>
  </form>
</body>
</html>