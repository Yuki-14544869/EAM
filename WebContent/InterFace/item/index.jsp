<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<title>固定资产管理中心</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" charset="utf-8" />
		<link rel="stylesheet" href="../../Static/css/base.css" />
	</head>

	<body class="hold-transition skin-blue sidebar-mini"style="width: 100%;">
		<div class="wrapper" style="height: 100%;width: 100%;">
			<header class="main-header" >
				
				<!--左上角LOGO-->
				<a href="index.html" class="logo" style="background-color: rgba(41, 46, 47, 0.92); ">
					<font style="text-shadow: 3px 3px 10px black"> 
					<span class="logo-mini"><b>资产</b></span>
					<span class="logo-lg"><b><img src="Img/G2.jpg" width="19px"/> 固定资产 中 心</b></span>
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
									 <span class="fa fa-send-o"></span>
								</a>
								<ul class="dropdown-menu">
									<li class="header">您收到4个站内消息</li>
									<li>
										<!-- 内部消息数据 -->
										<ul class="menu">
											<li>
												<!-- start message -->
												<a href="#">
													<div class="pull-left">
														
													</div>
													<h4>
								                    	Developers
								                    	<small><i class="fa fa-clock-o"></i> Today</small>
								                    </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<!-- end message -->
											<li>
												<a href="#">
													<div class="pull-left">
														
													</div>
													<h4>
								                    	Developers
								                        <small><i class="fa fa-clock-o"></i> Today</small>
								                    </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														
													</div>
													<h4>
								                        Developers
								                        <small><i class="fa fa-clock-o"></i> Today</small>
								                     </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														
													</div>
													<h4>
								                        Sales Department
								                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
								                    </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
											<li>
												<a href="#">
													<div class="pull-left">
														
													</div>
													<h4>
								                        Reviewers
								                        <small><i class="fa fa-clock-o"></i> 2 days</small>
								                    </h4>
													<p>Why not buy a new awesome theme?</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="footer">
										<a href="#">查看全部消息</a>
									</li>
								</ul>
							</li>

							<!-- 通知提醒消息 -->
							<!--左侧第二个菜单-->
							<li class="dropdown notifications-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<span class="fa fa-binoculars"></span>
									<!--<i class="fa fa-bell-o"></i>-->
									<!--<span class="label label-warning">10</span>-->
								</a>
								<ul class="dropdown-menu">
									<li class="header">You have 10 notifications</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
											<li>
												<a href="#">
													<i class="fa fa-users text-aqua"></i> 5 new members joined today
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the page and may cause design problems
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-users text-red"></i> 5 new members joined
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-shopping-cart text-green"></i> 25 sales made
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-user text-red"></i> You changed your username
												</a>
											</li>
										</ul>
									</li>
									<li class="footer">
										<a href="#">View all</a>
									</li>
								</ul>
							</li>

							<!-- 任务提醒消息 -->
							<li class="dropdown tasks-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<span class="fa fa-gear"></span>
									
								</a>
								<ul class="dropdown-menu">
									<li class="header">You have 9 tasks</li>
									<li>
										<!-- inner menu: contains the actual data -->
										<ul class="menu">
											<li>
												<!-- Task item -->
												<a href="#">
													<h3>
								                        Design some buttons
								                        <small class="pull-right">20%</small>
								                    </h3>
													<div class="progress xs">
														<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">20% Complete</span>
														</div>
													</div>
												</a>
											</li>
											<!-- end task item -->
											<li>
												<!-- Task item -->
												<a href="#">
													<h3>
										            	Create a nice theme
										            	<small class="pull-right">40%</small>
										            </h3>
													<div class="progress xs">
														<div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">40% Complete</span>
														</div>
													</div>
												</a>
											</li>
											<!-- end task item -->
											<li>
												<!-- Task item -->
												<a href="#">
													<h3>
								                        Some task I need to do
								                        <small class="pull-right">60%</small>
								                    </h3>
													<div class="progress xs">
														<div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">60% Complete</span>
														</div>
													</div>
												</a>
											</li>
											<!-- end task item -->
											<li>
												<!-- Task item -->
												<a href="#">
													<h3>
								                        Make beautiful transitions
								                        <small class="pull-right">80%</small>
								                    </h3>
													<div class="progress xs">
														<div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">80% Complete</span>
														</div>
													</div>
												</a>
											</li>
											<!-- end task item -->
										</ul>
									</li>
									<li class="footer">
										<a href="#">View all tasks</a>
									</li>
								</ul>
							</li>

							<!-- 用户账户信息 -->
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<!--<img src="img/user2-160x160.jpg" class="user-image" alt="User Image"/>-->
									<span class="fa fa-user">:</span>
									<span class="hidden-xs">User</span>

								</a>
								<ul class="dropdown-menu">
									<!-- User image -->
									<li class="user-header">
										<img src="img/user2-160x160.jpg" class="img-circle" alt="User Image" />

										<p>
											系统管理员 角色管理员
											<small>注册时间：2017年7月4日</small>
										</p>
									</li>
									<!-- Menu Body -->
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="#" class="btn btn-default btn-flat">Profile</a>
										</div>
										<div class="pull-right">
											<a href="#" class="btn btn-default btn-flat">Sign out</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</nav>
			</header>

			<aside class="main-sidebar" style="border-top: 1px solid white;">
				<section class="sidebar">
					<div class="user-panel">
						<div class="pull-left " style="color: white;">
							<p style="padding-left: 2px">&nbsp; <span class="fa fa-user">:</span> &nbsp;&nbsp;User</p>
						</div>
						
					</div>
					<form action="#" method="get" class="sidebar-form">
	        <div class="input-group">
	          <input type="text" name="q" class="form-control" placeholder="Search..."/>
	          <span class="input-group-btn">
	                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
	                </button>
	              </span>
	        </div>
	      </form>
	      
	      <!--左侧导航栏-->
					<ul class="sidebar-menu" data-widget="tree">
					
						
						
						
						
						<c:forEach items="${irp } " var="va">
							<li class="treeview">
								<a href="#">
									<i class="fa fa-hand-o-right"></i>
									<c:forEach items="${va }" var="list1" begin="1" end="1">
										<span>${va.key}</span>
									</c:forEach>
									<span class="pull-right-container">
										<i class="fa fa-angle-left pull-right"></i>
									</span>
								</a>
								
								<ul class="treeview-menu">
									<c:forEach items="${va }"  var="list2"  begin="2">
										<li>
											<a href=""><i class="fa fa-circle-o"></i> ${list2}</a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
						
						
						
						
					</ul>
				</section>
			</aside>
			
			<!--Iframe界面-->
			<div class="content-wrapper"style="height: 30px;" >
				<!--<section class="content-header">
				</section>-->
				<section class="content" style="height: 100%;">
					<iframe src="" id="Iframe" style=" height: 100%; width: 100%; margin-top:0px; border: 0;background-color: white;" name="frame"></iframe>
				</section>
			</div>
	
	
			<footer class="main-footer" style="text-align: center;">
				<!-- 默认居左显示页脚内容 -->
				<font style="font-size: 1px;">CopyEAM &copy; 2017 <a href="#" style="color: white;">固定资产(EAM)</a></font> 
			</footer>
		</div>
		
		
		<script src="../../Static/JS/base.js"></script>
		<!--<script src="index.js"></script>-->
	</body>

</html>