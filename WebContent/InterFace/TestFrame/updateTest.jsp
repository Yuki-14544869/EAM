<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmlPUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>质检单修改</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">  
  <script type="text/javascript" src="/EAM/Static/JS/Test/Test.js"></script>

</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">

  <legend>质检单修改</legend>
 <form style="text-align: center; class="layui-form" id="addtestForm" action="/EAM/TestAction?method=UpdateTest" method="post"  >
 <div class="layui-form-item"  >
 <div class="layui-inline">
      <label class="layui-form-label"></label>
      <div class="layui-input-inline">
        <input   type="hidden" name="id" value="${test.id}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
   </div>
    
   
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">样品编号:</label>
      <div class="layui-input-inline">
        <input type="text" name="testcode" value="${test.testcode}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">样品名称 :</label>
      <div class="layui-input-inline">
        <input type="text" name="name" value="${test.name}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    </div>
  
   <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">样品单位:</label>
      <div class="layui-input-inline">
        <input type="text" name="unit" value="${test.unit}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">样品数量:</label>
      <div class="layui-input-inline">
        <input type="text" name="count" value="${test.count}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    </div>
     
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">生产日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="proddate" value="${test.proddate}"  lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">接收日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="recvdate" value="${test.recvdate}" lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})" >
      </div>
    </div>
  </div>
     
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">检验日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="testdate" value="${test.testdate}" lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">供应商:</label>
      <div class="layui-input-inline">
        <input type="text" name="provid" value="${test.provid}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">负责人:</label>
      <div class="layui-input-inline">
        <input type="text" name="person" value="${test.person}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
   
    <div class="layui-inline">
      <label class="layui-form-label">检验项目:</label>
      <div class="layui-input-inline">
        <input type="text" name="project" value="${test.project}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
     </div>
  
     
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">检验结论:</label>
      <div class="layui-input-inline">
        <input type="text" name="conclusion" value="${test.conclusion}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    
    
 

   
 
    <div class="layui-inline">
      <label class="layui-form-label" >备注:</label>
      <div class="layui-input-inline" >
        <input type="text" name="detail" value="${test.detail}" lay-verify="title"  autocomplete="off" class="layui-input">
      </div>
    </div>
    </div>
    </form>
			
			 <br><button id="UpdateTest"  class="layui-btn layui-btn-warm layui-btn-radius">确认修改</button>
			&nbsp<button  data-type="auto"  class="layui-btn layui-btn-warm layui-btn-radius" ><a href="http://localhost:8080/EAM/InterFace/TestFrame/Testindex.jsp">
			返回</a></button>
			</br>
   
			
		
	
	
     
<script src="/EAM/Static/layui/css/layui.css" charset="utf-8"></script>


</body>
</html>