<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html style="height:100%">

	<head>
		<title>固定资产管理中心</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" charset="utf-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/css/base.css" charset="utf-8" />
	<script src="/EAM/InterFace/IndexFrame/index.js"></script>
	</head>

	<body class="hold-transition skin-blue sidebar-mini"style="width: 100%;height:100%">
		<div class="wrapper" style="height: 100%;width: 100%;">
			<header class="main-header" >
				
				<!--左上角LOGO-->
				<a href="javascript:" id="aa" class="logo" style="background-color: rgba(41, 46, 47, 0.92); ">
					<font style="text-shadow: 3px 3px 10px black"> 
					<span class="logo-mini"><b>资产</b></span>
					<span class="logo-lg"><b><img src="${pageContext.request.contextPath}/InterFace/IndexFrame/Img/G2.jpg" width="19px"/> 固定资产中心</b></span>
					</font>
				</a>
				
				<!--右上角导航条-->
				<nav class="navbar navbar-static-top">
					<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
						<span class="fa fa-navicon"></span>
					</a>
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<li class="dropdown messages-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									 <span >在线人数：${number}</span>
								</a>
							</li>

							<!-- 通知提醒消息 -->
							<!--左侧第二个菜单-->
							<li class="dropdown notifications-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<span class="fa fa-bell"></span>
									<!--<i class="fa fa-bell-o"></i>-->
									<span class="label label-primary">${fn:length(backlog) }</span>
								</a>
								<ul class="dropdown-menu">
									<li class="header">亲，你的部门有${fn:length(backlog) }条待批采购计划</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
										<c:forEach items="${backlog}" var="var" begin="0" end="4">
											<li>
												<a href="#">
													${var.title }
												</a>
											</li>
										</c:forEach>
										</ul>
									</li>
									<li class="footer">
										<a href="javascript:" id="aaaa">MORE</a>
									</li>
								</ul>
							</li>

							<!-- 任务提醒消息 -->
							<li class="dropdown tasks-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<span class="fa fa-bell-slash-o"></span>
									<span class="label label-warning">${fn:length(defeat) }</span>
								</a>
								<ul class="dropdown-menu">
									<li class="header">亲，你的部门有${fn:length(defeat) }条发回的采购计划</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
											<c:forEach items="${defeat}" var="vara" begin="0" end="4">
												<li>
													<!-- Task item -->
													<a href="#">
														<h3>
									                       ${vara.title }
									                    </h3>
														
													</a>
												</li>
											</c:forEach>
										</ul>
									</li>
									<li class="footer">
										<a href="javascript:" id="aaaaa">MORE</a>
									</li>
								</ul>
							</li>
							
							
							<li class="dropdown tasks-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<span class="fa fa-send-o"></span>
									<span class="label label-warning">${fn:length(success) }</span>
								</a>
								<ul class="dropdown-menu">
									<li class="header">亲，你的部门有${fn:length(success) }条已通过采购计划</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
											<c:forEach items="${success}" var="varaa" begin="0" end="4">
												<li>
													<!-- Task item -->
													<a href="#">
														<h3>
									                       ${varaa.title }
									                    </h3>
														
													</a>
												</li>
											</c:forEach>
										</ul>
									</li>
									<li class="footer">
										<a href="javascript:" id="aaaaaa">MORE</a>
									</li>
								</ul>
							</li>
							
							

							<!-- 用户账户信息 -->
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<img src="/EAM/InterFace/login/group1/${user['id'] }.jpg" class="user-image" alt="User Image"/>
									
									<span class="hidden-xs">${user['realname'] }</span>

								</a>
								<ul class="dropdown-menu">
									<!-- User image -->
									<li class="user-header">
										<img src="/EAM/InterFace/login/group1/${user['id'] }.jpg" class="img-circle" alt="User Image" />

										<p>
											${user['pos'] }
											<small>入职时间：${user['hiredate'] }</small>
										</p>
									</li>
									<!-- Menu Body -->
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="javascript:alert('正在建设中')" class="btn btn-default btn-flat">用户信息</a>
										</div>
										<div class="pull-right">
											<a href="/EAM/login?method=loginOut" class="btn btn-default btn-flat">注销登陆</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</nav>
			</header>

			<aside class="main-sidebar" style="border-top: 1px solid white;height:89%">
				<section class="sidebar" style="height:100%">
					 <div class="user-panel">
				        <div class="pull-left image" style="color:white;margin-left:10px;">
				         <img src="/EAM/InterFace/login/group1/${user['id'] }.jpg" class="img-circle" alt="User Image" />
				        </div>
				        <div class="pull-left info">
				          <p style="padding-left: 2px">${user['realname'] }</p>
				          <a href="#"><i class="fa fa-circle text-success"></i>IP：${ip}<span th:text="${userIp}"></span></a>
				        </div>
				      </div>
					<!-- <form action=${pageContext.request.contextPath}/irp method="get" class="sidebar-form">
	        <div class="input-group">
	          <input type="text" name="id" class="form-control" placeholder="Search..."/>
	          <span class="input-group-btn">
	                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
	                </button>
	              </span>
	        </div>
	      </form> -->
	      <div class="classdiv" style="height:90%;overflow:auto" >
	      <!--左侧导航栏-->
					<ul class="sidebar-menu" data-widget="tree" ">
					
						
				
						
						
						<c:forEach items="${irp}" var="va">
							<li class="treeview">
								<a href="#">
									<i class="fa fa-hand-o-right"></i>
									<c:forEach items="${va.value}" var="map1" begin = "0" end = "0">
									
										<span>${map1.key}</span>
									</c:forEach>
									<span class="pull-right-container">
										<i class="fa fa-angle-left pull-right"></i>
									</span>
								</a>
								
								<ul class="treeview-menu">
									<c:forEach items="${va.value}"  var="map2" begin = "1">
										<li onclick="jumpin">
										
											<a href="javascript:void(0)" tarPage=${map2.value} onclick="jumpPage(this)"><i class="fa fa-circle-o"></i> ${map2.key}</a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
						
						<%-- <c:forEach items="${irp }" var="var">
						
						<c:forEach items="${var.value }" var="var2" begin="1" end="1">
						
						
						</c:forEach>
						
						<c:forEach items="${var.value } " var="var2" begin="2">
						
						
						</c:forEach>
						
						</c:forEach>
						 --%>
						
						
						
					</ul>
				</div>
				</section>
			</aside>
			
			<!--Iframe界面-->
			<div class="content-wrapper"style="height: 30px;" >
				<!--<section class="content-header">
				</section>-->
				<section class="content" style="height: 100%;">
					<iframe  src="/EAM/InterFace/IndexFrame/clock/index2.html" id="Iframe" style=" height: 100%; width: 100%; margin-top:0px; border: 0;background-color: #D0D0D0;" name="frame"></iframe>
				</section>
			</div>
	
	
			<footer class="main-footer" style="text-align: center;">
				<!-- 默认居左显示页脚内容 -->
				<font style="font-size: 10px;">CopyEAM &copy; 2017 <a href="#" style="color: white;">固定资产(EAM)</a></font> 
			</footer>
		</div>
		
		
		<script src="${pageContext.request.contextPath}/Static/JS/base.js"></script>
		<script type="text/javascript">
			var aa = document.getElementById('aa');
			var aaaa = document.getElementById('aaaa');
			var aaaaa = document.getElementById('aaaaa');
			var aaaaaa = document.getElementById('aaaaaa');
			var iframe = document.getElementById('Iframe');
			window.onload = function(){
				aa.onclick = function(){
					iframe.src = "/EAM/InterFace/IndexFrame/clock/index2.html";
				}
				aaaa.onclick = function(){
					iframe.src = "PlanAction?method=listSubmitedPlan";
				}
				aaaaa.onclick = function(){
					iframe.src = "PlanAction?method=listRefusedPlan";
				}
				aaaaaa.onclick = function(){
					iframe.src = "PlanAction?method=listPassedPlan";
				}
			}
		</script>
		<!--<script src="index.js"></script>-->
	</body>

</html>