<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型管理</title>
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script type="text/javascript" src="/EAM/Static/JS/provider/provider.js" charset="UTF-8"></script>
<script type="text/javascript" src="/EAM/Static/layui/layui.js" charset="UTF-8"></script>
</head>
<body>
    <div class="layui-inline">
      <label class="layui-form-label">类型名称</label>
      <div class="layui-input-inline">
        <input id="name" lay-verify="phone" autocomplete="off" class="layui-input" type="tel">
      </div>
       <button  id="serachButton"class="layui-btn ">查询</button>
        <button  id="addButton"class="layui-btn ">添加</button>
   </div>
    <table class="layui-table">
    <thead>
      <tr>
        <th style="width: 10px;">ID</th>
        <th style="width: 50px;">类型名称</th>
        <th style="width: 200px;">描述</th>
         <th style="width: 10px;">操作</th>
      </tr> 
    </thead>
    <tbody>
     <c:forEach items="${types}" var="type">
      <tr>
        <th style="width: 10px;">${type.id}</th>
        <th style="width: 50px;">${type.name}</th>
        <th style="width: 200px;">${type.detail}</th> 
        <th style="width: 10px;"> <button  class="layui-btn " onclick="updateFunction(${type.id})">更新</button><button  class="layui-btn " onclick="deleteFunction(${type.id})">删除</button></th>
      </tr> 
     </c:forEach>
    </tbody>
    </table>
    <form id="searchForm" action="/EAM/typeAction?method=findType" method="post">
       <input type="hidden" id="subName" name="name">
       <input type="hidden" id="subid" name="id">
    </form>
    <script type="text/javascript">
       $("#serachButton").on('click',btnClick);
       $("#addButton").on('click',jumpToAdd);
       function jumpToAdd(){
    	   $("#searchForm").attr("action","/EAM/typeAction?method=jumpToAddType");
    	   $("#searchForm").submit();
       }
       function btnClick(){
    	   $("#subName").val($("#name").val());
    	   $("#searchForm").attr("action","/EAM/typeAction?method=findType");
    	   $("#searchForm").submit();
       }
       
       function deleteFunction(id,name,detail,version){
    	   $("#subid").val(id);
    	   $("#searchForm").attr("action","/EAM/typeAction?method=deleteType");
    	   $("#searchForm").submit();
       }
       function updateFunction(id){
    	   $("#subid").val(id);
    	   $("#searchForm").attr("action","/EAM/typeAction?method=jumpToUpdateType");
    	   $("#searchForm").submit();
       }
    </script>
</body>
</html>