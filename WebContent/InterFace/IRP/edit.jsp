<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmlPUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>IRP修改</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">  
  <script src="/EAM/Static/JS/IRP/jQuery.js"></script>

</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">

  <legend>IRP修改</legend>
 <form style="text-align: center; class="layui-form" id="addIrpForm" action="/EAM/IrpAction?method=updateIrp" method="post"  >
 <div class="layui-form-item"  >
 <div class="layui-inline">
      <label class="layui-form-label"></label>
      <div class="layui-input-inline">
        <input   type="hidden" name="id" value="${irp.id}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
      <div class="layui-input-inline">
        <input   type="hidden" name="version" value="${irp.version}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
   </div>
    
   
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">中文名:</label>
      <div class="layui-input-inline">
        <input type="text" name="cname" value="${irp.cname}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">英文名 :</label>
      <div class="layui-input-inline">
        <input type="text" name="name" value="${irp.name}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
    </div>
    </div>
  
   <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">路径:</label>
      <div class="layui-input-inline">
        <input type="text" name="path" value="${irp.path}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">上级菜单:</label>
      <div class="layui-input-inline">
        <input type="text" name="pid" value="${irp.pid}" lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input">
      </div>
    </div>
    </div>
     
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">标号:</label>
      <div class="layui-input-inline">
        <input type="text" name="code" value="${irp.code}"  lay-verify="title" placeholder="不能为空" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">描述:</label>
      <div class="layui-input-inline">
        <input type="text" name="detal" value="${irp.detal}" lay-verify="title"  placeholder="不能为空" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})" >
      </div>
    </div>
  </div>
     
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">是否冻结:</label>   <!-- placeholder="yyyy-mm-dd" -->
      <div class="layui-input-inline">
        <input type="text" name="state" value="${irp.state}" lay-verify="title" placeholder="冻结为1 未冻结为 0 " autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <%-- <div class="layui-inline">
      <label class="layui-form-label">供应商:</label>
      <div class="layui-input-inline">
        <input type="text" name="provid" value="${test.provid}" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div> --%>
  </div>
  
   <%--  <div class="layui-form-item">
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
     </div> --%>
  
     
     <%-- <div class="layui-form-item">
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
    </div> --%>
    </form>
			<hr>
			<hr>
			 <br><button id="UpdateIrp"  class="layui-btn layui-btn-warm layui-btn-radius">确认修改</button>
			&nbsp;<!-- <button  data-type="auto"  class="layui-btn layui-btn-warm layui-btn-radius" > -->
				<!-- <a href="http://localhost:8080/EAM/InterFace/IRP/select.jsp" class="layui-btn layui-btn-warm layui-btn-radius">返回</a></button> -->
				<button id="returnbutton" class="layui-btn layui-btn-warm layui-btn-radius" >返回</button>
			<br>
   
			
		
	
	
     
<script src="/EAM/Static/layui/css/layui.css" charset="utf-8"></script>

</fieldset>
</body>
</html>