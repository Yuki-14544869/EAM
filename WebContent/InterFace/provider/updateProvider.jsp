<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <title>修改供应商信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
  <script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
  <script type="text/javascript" src="/EAM/Static/JS/provider/provider.js" charset="utf-8"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top:20px;">
  <legend>修改供应商信息</legend><br/><br/>
  
 <form id="updateForm" style="text-align: center; class="layui-form" action="/EAM/providerAction?method=updateProvider" method="post">
  <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline" >
      <label class="layui-form-label">id</label>
      <div class="layui-input-inline">
        <input name="id" class="layui-input" type="text" value="${provider.id}" autocomplete="off" lay-verify="id">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label" >供应商名</label>
      <div class="layui-input-inline">
        <input name="name" class="layui-input" type="text" value="${provider.name}"autocomplete="off" lay-verify="name">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">法人代表</label>
      <div class="layui-input-inline">
        <input name="perid" class="layui-input" type="text" value="${provider.perid}"autocomplete="off" lay-verify="perid">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">联系电话</label>
      <div class="layui-input-inline">
        <input name="tel" class="layui-input" type="text"value="${provider.tel}" autocomplete="off" lay-verify="tel">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">邮箱</label>
      <div class="layui-input-inline">
        <input name="mail" class="layui-input" type="text" value="${provider.mail}"autocomplete="off" lay-verify="mail">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">网址</label>
      <div class="layui-input-inline">
        <input name="url" class="layui-input" type="text" value="${provider.url}"autocomplete="off" lay-verify="url">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">地址</label>
      <div class="layui-input-inline">
        <input name="address" class="layui-input" type="text" value="${provider.address}"autocomplete="off" lay-verify="address">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">银行账户</label>
      <div class="layui-input-inline">
        <input name="bankaccount" class="layui-input" type="text"value="${provider.bankaccount}" autocomplete="off" lay-verify="bankaccount">
      </div>
    </div>
  </div>
   <div class="layui-form-item"style="padding-left:10px;">
    <div class="layui-inline">
      <label class="layui-form-label">状态</label>
      <div class="layui-input-inline">
        <input name="state" class="layui-input" type="text"value="${provider.state}" autocomplete="off" lay-verify="state">
      </div>
    </div>
  </div>
  </form>
  <div style="padding-left:750px;"><button id="updateProvider" class="layui-btn layui-btn-normal layui-btn-radius">>提交</button>
  &nbsp<button  data-type="auto"  class="layui-btn layui-btn-warm layui-btn-radius" ><a href="http://localhost:8080/EAM/InterFace/provider/searchProvider.jsp">
			返回</a></button>

    </div>
  </fieldset>
</body>
</html>