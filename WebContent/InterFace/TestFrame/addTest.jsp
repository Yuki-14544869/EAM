<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmlPUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>质检单添加</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Static/layui/css/layui.css"  media="all"> 
  <script type="text/javascript" src="/EAM/Static/JS/JQuery/jquery.min.js"></script> 
  <script type="text/javascript" src="/EAM/Static/JS/Test/Test.js"></script>

</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">

  <legend>质检单添加</legend>

 <form style="text-align:left" class="layui-form" id="addtestForm" action="/EAM/TestAction?method=AddTest" method="post"  >
 <br><blockquote >温馨提示：质检单需谨慎添加，下方加*为必填项。</blockquote></br>
   
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">样品编号:</label>
      <div class="layui-input-inline">
        <input type="text" name="testcode" placeholder="如 ABCD-1234" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">样品名称 :</label>
      <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
    </div>
  
   <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">样品单位:</label>
      <div class="layui-input-inline">
        <input type="text" name="unit" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">样品数量:</label>
      <div class="layui-input-inline">
        <input type="text" name="count" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
    </div>
     
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">生产日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="proddate" lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input required" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">接收日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="recvdate" lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input required" onclick="layui.laydate({elem: this})" >
      </div>
    </div>
  </div>
     
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">检验日期:</label>
      <div class="layui-input-inline">
        <input type="text" name="testdate" lay-verify="title" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input required" onclick="layui.laydate({elem: this})">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">供应商:</label>
      <div class="layui-input-inline">
        <input type="text" name="provid" placeholder="如 1234" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
  </div>
  
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">负责人:</label>
      <div class="layui-input-inline">
        <input type="text" name="person" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
   
    <div class="layui-inline">
      <label class="layui-form-label">检验项目:</label>
      <div class="layui-input-inline">
        <input type="text" name="project" lay-verify="title" autocomplete="off" class="layui-input required">
      </div>
    </div>
    </div>
  
     
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label" >检验结论:</label>
      <div class="layui-input-inline" >
        <input type="text" name="conclusion" lay-verify="title" placeholder="合格/不合格" autocomplete="off" class="layui-input required">
      </div>
    </div>
    </div>
    
    
  <div class="layui-form-item layui-form-text required">
    <label class="layui-form-label">备注:</label>
    <div class="layui-input-block" >
      <textarea  name="detail" placeholder="请输入内容"  class="layui-textarea"></textarea>
    </div>
    </form>
			
			 <br><center><button id="addTest"   data-method="notice" class="layui-btn-warm layui-btn-radius layui-btn">提交</button>
			 &nbsp<input type="reset"  value="重置" id="resetForm" class="layui-btn layui-btn-warm layui-btn-radius">
			&nbsp<button  data-type="auto"  class="layui-btn-warm layui-btn-radius layui-btn" ><a href="http://localhost:8080/EAM/InterFace/TestFrame/Testindex.jsp">
			返回</a></button></center></br>
			
			
			

<script type="text/javascript">
 //为表单的必填文本框添加提示信息（选择form中的所有后代input元素）
 $("form :input.required").each(function () {
 //创建元素
 var $required = $("<strong class='high'>*</strong>");
 //将它追加到文档中
 $(this).parent().append($required);
 });
</script>


			
<%-- <script src="${pageContext.request.contextPath}/Static/layui/layui.js" charset="utf-8"></script>
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
	       
	       ,notice: function(){
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
	           ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><center>lkjjj</center></div>'
	           ,success: function(layero){
	        	 
	             var btn = layero.find('.layui-layer-btn');
	             btn.css('text-align', 'center');
	             console.log( btn.find('.layui-layer-btn0'))
	             btn.find('.layui-layer-btn0').on('click',show);
	           }
	         });
         
	         $('.layui-btn').on('click', function(){
	        	    var othis = $(this), method = othis.data('method');
	        	    active[method] ? active[method].call(this, othis) : '';
	        	  });
	        	  
	        	
	function show(){
		$("#addtestForm").attr("action","/EAM/TestAction?method=AddTest");
		$("#addtestForm").submit();
	}
		
	
		    
 </script>   --%>
     



</body>
</html>