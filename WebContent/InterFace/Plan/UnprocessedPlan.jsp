<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>
<link rel="stylesheet" href="Static/layui/css/layui.css" media="all">
<script src="Static/layui/layui.js"></script>

<script>
	layui.use([ 'element', 'layer' ], function() {
		var element = layui.element();
		var layer = layui.layer;
	});
	function pass(id,version)
	{
		var listid = "list"+id;
		var mailtext = document.getElementById(listid).innerHTML;
	
		var temp = document.createElement("form");
		  temp.action = "PlanAction?method=passPlan";
		  temp.method = "post";
		  temp.style.display = "none";
		  var PARAMS = {method:'passPlan',id:id,version:version,mail:mailtext}
		  for (var x in PARAMS) {
		    var opt = document.createElement("textarea");
		    opt.name = x;
		    opt.value = PARAMS[x];
		    
		    temp.appendChild(opt);
		  }
		  document.body.appendChild(temp);
	 temp.submit();
		
	}
</script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>待办事项（${plansnum}）<a href="PlanAction?method=listProcessedPlan"><sub><i class="layui-icon">&#x1005;</i>查看已办事项</sub></a></legend>
	</fieldset>

	<div class="layui-collapse" lay-filter="test">
		<c:forEach items="${plans}" var="plan">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">${plan.title}</h2>

				<div class="layui-colla-content">


					<table class="layui-table" lay-skin="line">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>提交时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${plan.subtime}</td>
							</tr>
						</tbody>
					</table>


					<div id="list${plan.id }">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>采购明细</legend>
					</fieldset>
					<table class="layui-table" lay-even="" lay-skin="row">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>物品</th>
								<th>数量</th>
								<th>单价</th>
							</tr>
						</thead>
						<tbody>
							<c:forTokens items="${plan.text}" delims="|" var="name">
								<tr>
									<c:forTokens items="${name}" delims="-" var="value">
										<td>${value}</td>
									</c:forTokens>
								</tr>
							</c:forTokens>
						</tbody>

					</table>
					<table class="layui-table" lay-skin="line">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${plan.detail}</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="site-demo-button" style="margin-bottom: 0;">
						<button class="layui-btn" onclick="pass(${plan.id},${plan.version })"><i class="layui-icon">&#xe605;</i>通过</button>
						<button data-method="notice" class="layui-btn layui-btn-danger" name = "${plan.version }" id="${plan.id }"><i class="layui-icon">&#x1006;</i>否决</button>
					</div>




				</div>
			</div>
		</c:forEach>
	</div>
	<script>
		var clickId = -1;
		var clickHTML = null;
		var version = null;
		layui.use('layer', function() { //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

			//触发事件
			var active = {
				setTop : function() {
					var that = this;
					//多窗口模式，层叠置顶
					layer.open({
						type : 2 //此处以iframe举例
						,
						title : '当你选择该窗体时，即会在最顶端',
						area : [ '390px', '260px' ],
						shade : 0,
						maxmin : true,
						offset : [ //为了演示，随机坐标
						Math.random() * ($(window).height() - 300),
								Math.random() * ($(window).width() - 390) ],
						content : 'http://layer.layui.com/test/settop.html',
						btn : [ '继续弹出', '全部关闭' ] //只是为了演示
						,
						yes : function() {
							$(that).click();
						},
						btn2 : function() {
							layer.closeAll();
						}

						,
						zIndex : layer.zIndex //重点1
						,
						success : function(layero) {
							layer.setTop(layero); //重点2
						}
					});
				}

				,
				notice : function() {
					//示范一个公告层
					layer.open({
						type : 1,
						title : false //不显示标题栏
						,
						closeBtn : false,
						area : '300px;',
						shade : 0.8,
						id : 'LAY_layuipro' //设定一个id，防止重复弹出
						,
						btn : [ '取消操作' ],
						moveType : 0 //拖拽模式，0或者1
						// ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
						,
						content : clickHTML
						,success : function(layero) {
							var btn = layero.find('.layui-layer-btn');
							btn.css('text-align', 'center');
						
						}
					});
				},
				offset : function(othis) {
					var type = othis.data('type'), text = othis.text();

					layer.open({
						type : 1,
						offset : type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
						,
						id : 'LAY_demo' + type //防止重复弹出
						,
						content : '<div style="padding: 20px 100px;">' + text
								+ '</div>',
						btn : '关闭全部',
						btnAlign : 'c' //按钮居中
						,
						shade : 0 //不显示遮罩
						,
						yes : function() {
							layer.closeAll();
						}
					});
				}
			};

			$('.site-demo-button .layui-btn').on('click', function() {
				clickId = event.target.id;
				version = event.target.name;
				
				clickHTML = "<form action = PlanAction?method=refusePlan&id="+clickId+"&version="+version+" method = post style = margin:0px auto;  class= layui-form  > <div class= layui-form-item layui-form-text ><label class= layui-form-label ><h2>否决反馈</h2></label><div class= layui-input-block ><textarea name = response rows= 6  placeholder= 请输入反馈内容  class= layui-textarea ></textarea>  <input type=submit  style= margin-left:50px ; value= 提交 ></div></div></form>";
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});

		});
	</script>


</body>
</html>