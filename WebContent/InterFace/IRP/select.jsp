<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>IRP管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"s
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script>
<script type="text/javascript" src="/EAM/Static/JS/IRP/jQuery.js"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>IRP表单</legend>
	</fieldset>
	
	<form action="/EAM/RoleAction?method=UpdateRole" method="post" id="btn4">
		<input type="hidden" name="ChkName" id="inpu2" />
		<input type="hidden" name="name" id="inpu4">
	</form>
	<div align='right' style="padding-right:15px;">
	 		<form method="post" action="/EAM/UploadAction"  enctype="multipart/form-data" style="padding-right:0px;" >
				&nbsp; <span style="height:5px;font-family:微软雅黑;font-size:20px;color:blue">[--请选择Excel上传文件--]: </span>&nbsp;<input type="file" name="uploadFile" style="height:30px;font-family:微软雅黑;font-size:14px;color:red"  />
				<!-- <br/><br/> -->
				<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
				<input type="submit" value="点击上传" class="layui-btn layui-btn-small layui-btn-normal"/>
				<hr>
     		</form>
     		
            <div align='right' >
                <button id="find" class="layui-btn layui-btn-small layui-btn-normal" ><i class="layui-icon">&#xe615;</i>查询</button>
			   <!--  <button data-method="notice3"  class="layui-btn layui-btn-small layui-btn-normal" id="ii">修改</button> -->
										
				<button data-method="add" class="layui-btn layui-btn-small layui-btn-normal" 
					onclick="window.location='/EAM/InterFace/IRP/add.jsp';"><i class="layui-icon">&#xe654;</i>添加</button>&nbsp;
					
				<button  data-method="notice2" class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe640;</i>删除</button>
	        </div>
			<div align='right'> 
				<form id="roleform" method="post">
					<!-- 编号:&nbsp;<input type="text" name="id">&nbsp; 角色名称 :&nbsp;<input
						type="text" name="name">&nbsp; 冻结状态 :&nbsp; <select
						name="state">
						<option value="">无</option>
						<option value=0>否</option>
						<option value=1>是</option>
					</select> &nbsp; -->
					
					&nbsp;
				</form>
			</div>
   </div>
     <div align='right'>
	    
	</div>
	<div class="layui-form">
		<form id="rolefind" method="post">
			<table class="layui-table">
				<colgroup>
					<col width="50">
					<col width="200">
					<col width="200">
					<col width="200">
					<col width="200">
					<col width="200">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" name="" lay-skin="primary"
							lay-filter="allChoose"></th>
					  
				      <th>编号</th>
				      <th>功能名称</th>
				      <th>描述</th>
				      <th>是否冻结</th>
				      <th>操作</th> 
					</tr>
				</thead>
				<c:forEach items="${irp}" var="ID">
					<tr>
						<td><input type="checkbox" value='${ID.id}' name="box" lay-skin="primary"></td>
						<td>${ID.id}</td>
						<td>${ID.cname}</td>
						<td>${ID.detal}</td>
						<td>
				<c:if test="${ID.state=='0'}">
                   未冻结
            </c:if> 
            <c:if test="${ID.state=='1'}">
                   已冻结
            </c:if>
            </td>
						<td>
							
                            <c:if test="${ID.state=='0'}">
               <button class="layui-btn layui-btn-normal layui-btn-small state">冻结</button>
            </c:if> 
            <c:if test="${ID.state=='1'}">
                   <button class="layui-btn layui-btn-danger layui-btn-small state">解除</button>
            </c:if>&nbsp;
			<a class="layui-btn layui-btn layui-btn-small" id="searchTest"  
				href="/EAM/IrpAction?method=SearchIrp&id=${ID.id}"><i class="layui-icon">&#xe642;</i></a>
			<a class="layui-btn layui-btn layui-btn-small" id="searchTest"  
				href="/EAM/IrpAction?method=deleteonly&id=${ID.id}"><i class="layui-icon">&#xe640;</i></a>
						</td>

							
					</tr>
				</c:forEach>
			</table>
		</form>

	</div>
	<!-- <div align='right'>
	    <button data-method="notice3"  class="layui-btn" id="ii">修改</button>
								
		<button  data-method="notice2" class="layui-btn">删除</button>
		
		<button data-method="add" class="layui-btn" 
			onclick="window.location='/EAM/InterFace/IRP/add.jsp';">添加</button>&nbsp;
	</div> -->
	<script src="${pageContext.request.contextPath}/Static/layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use('form', function() {
		var $ = layui.jquery, form = layui.form();

			//全选
			form.on('checkbox(allChoose)', function(data) {
				var child = $(data.elem).parents('table').find(
						'tbody input[type="checkbox"]');
				child.each(function(index, item) {
					item.checked = data.elem.checked;
				});
				form.render('checkbox');
			});
			
		}); 
		layui.use('layer', function(){ //独立版的layer无需执行这一句
	     var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这
	     //触发事件
	     var active = {
	       setTop: function(){
	         var that = this; 
	         //多窗口模式，层叠置顶
	         layer.open({
	           type: 2 //此处以iframe举例
	           ,title: '当你选择该窗体时，即会在最顶端'
	           ,area: ['390px', '260px']
	           ,shade: 0
	           ,maxmin: true
	           ,offset: [ //为了演示，随机坐标
	             Math.random()*($(window).height()-300)
	             ,Math.random()*($(window).width()-390)
	           ] 
	           ,content: 'http://layer.layui.com/test/settop.html'
	           ,btn: ['继续弹出', '全部关闭'] //只是为了演示
	           ,yes: function(){
	             $(that).click(); 
	           }
	           ,btn2: function(){
	             layer.closeAll();
	           }
	           
	           ,zIndex: layer.zIndex //重点1
	           ,success: function(layero){
	             layer.setTop(layero); //重点2
	           }
	         });
	       }
	       
	       ,/* notice: function(){
	         //示范一个公告层
	         layer.open({
	           type: 1
	           ,title: false //不显示标题栏
	           ,closeBtn: false
	           ,area: '300px;'
	           ,shade: 0.8
	           ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	           ,btn: ['完成添加', '放弃添加']
	           ,moveType: 1 //拖拽模式，0或者1
	           ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><center><form id="roleaction" method="post">角色名称:<input type="text" name="name"></form></center></div>'
	           ,success: function(layero){
	        	 
	             var btn = layero.find('.layui-layer-btn');
	             btn.css('text-align', 'center');
	             console.log( btn.find('.layui-layer-btn0'))
	             btn.find('.layui-layer-btn0').on('click',show);
	           }
	         });
	       }, */
	       notice2: function(){
		         //示范一个公告层
		         layer.open({
		           type: 1
		           ,title: false //不显示标题栏
		           ,closeBtn: false
		           ,area: '300px;'
		           ,shade: 0.8
		           ,id: 'LAY_layuipro3' //设定一个id，防止重复弹出
		           ,btn: ['确定删除','取消']
		           ,moveType: 1 //拖拽模式，0或者1
		           ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><center>请谨慎删除</center></div>'
		           ,success: function(layero){
		        	 
		             var btn = layero.find('.layui-layer-btn');
		             btn.css('text-align', 'center');
		             console.log( btn.find('.layui-layer-btn0'))
		             btn.find('.layui-layer-btn0').on('click',show2);
		           }
		         });
		       },
		       notice3: function(id){
		    	   
		    	  var check = $("input[type='checkbox']").is(':checked');
		    	  if(check == false){
		    		  alert("未选中操作行")
		    	  }
		    	  else{
		    		  
			         //示范一个公告层
			         layer.open({
			           type: 1
			           ,title: false //不显示标题栏
			           ,closeBtn: false
			           ,area: '300px;'
			           ,shade: 0.8
			           ,id: 'LAY_layuipro2' //设定一个id，防止重复弹出
			           ,btn: ['完成修改', '放弃修改']
			           ,moveType: 1 //拖拽模式，0或者1
			           ,content: '<div id="div2" style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><center><form id="roleup" method="post"> 新角色名称:<input type="text" name="name"></form></center></div>'
			           ,success: function(layero){
			        	   
			             var btn = layero.find('.layui-layer-btn');
			             btn.css('text-align', 'center');
			             console.log( btn.find('.layui-layer-btn0'))
			            btn.find('.layui-layer-btn0').on('click',show3);
			           }
			         });
			       }},//多括号
	  
	       };
	     
	     $('.layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	     });
	     
	   }); 
		function show(){
			$("#roleaction").attr("action","/EAM/RoleAction?method=AddRole");
			$("#roleaction").submit();	
		}
		function show2(){
			$("#rolefind").attr("action","/EAM/IrpAction?method=deleteIrp");
			$("#rolefind").submit();	
		}
		function show3(){
			//alert('ssss');
			
			var div2 = document.getElementById('div2');
			var inpu2 = div2.getElementsByTagName('input');
			 var inpu4 = document.getElementById("inpu4");
			inpu4.value = inpu2[0].value;
			$("#btn4").attr("action","/EAM/RoleAction?method=UpdateRole");
			$("#btn4").submit();	
		}
		
		
		
		
	
		//function notice4(id){
   			//alert(id);
   			//return ${ID.id};
   			
   	  // }
		
	</script>


</body>

<script type="text/javascript">
	window.onload = function(){
			var ii = document.getElementById('ii');
			
			ii.onclick = function(){
			var tab = document.getElementById('tab');
			var inpu = tab.getElementsByTagName('input');
			var inpu2 = document.getElementById('inpu2');
			for(var i=0;i<inpu.length;i++){
				if(inpu[i].checked){
					inpu2.value = inpu[i].value
				}
			}
			
			}
		}
	</script>
</html>