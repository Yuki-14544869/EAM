<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- jstl 标签 -->
<!-- struts2 标签
taglib prefix="s" uri="/struts-tags"
 -->
<html lang="en"><head>
		<meta charset="UTF-8">
		<title>登录页面</title>
		 <meta http-equiv="Pragma" content="no-cache">
		 <meta http-equiv="Cache-Control" content="no-cache">
		 <meta http-equiv="Expires" content="0">
		
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--ipad 兼容-->
<meta name="viewport" content"width="device-width;" initial-scale="0.5,maximum-scale=0.5,minimum-scale=0.5,user-scalable=yes&quot;">
<meta name="MobileOptimized" content="960">
<!-- <script src="http://cn.yimg.com/script/2012/0130/html5_v3.js"></script> -->
<!-- <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script> -->

<!--[if lte IE 8]>
    <script src="/sixtteacher/js/html5.js"></script>
<![endif]--> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
	
<title>固定资产管理系统</title>
<!-- 引入公共的js、css 如：jquery相关-->
<link href="${pageContext.request.contextPath}/Static/JS/login_files/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/Static/JS/login_files/jquery.js" language="javascript" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/Static/JS/login_files/public.js" language="javascript" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/Static/JS/login_files/base.js" language="javascript" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/Static/JS/login_files/thickbox_plus.js" language="javascript" type="text/javascript"></script>
<!-- 引入项目自定义css -->
<link href="${pageContext.request.contextPath}/Static/JS/login_files/sixtteacher.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/Static/JS/login_files/header.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/Static/JS/login_files/sixtteacher.js"></script>
<script type="text/javascript">
//<![CDATA[
var basePath = "/sixtteacher/";
var cachePath = "/sixtteacher/";
$.ajaxSetup({cache:false});
var async_token_static = '<s:property value="#session.asyncTokenId"/>';
window.onload = function() {
	if ($("input[name='async_token_static']").length > 0) {
		$("input[name='async_token_static']").attr("value", async_token_static);
	} 
	/*返回旧版和鼠标滚动特效*/
	var help_flag= $("#help_wrap");	//帮助按钮
    var av_height = $(window).height();
    var av_width = $(window).width();
    var go_top= $("#go_top");
    var Gotop_w = go_top.width()+2;
    var Gotop_h = go_top.height()+2;
    var doc_width = 1010;
    var Gotop_x = (av_width>doc_width?0.5*av_width+0.5*doc_width:av_width-Gotop_w)+ 20;
    var Gotop_y = av_height-Gotop_h;
    var ie6Hack = "<style>.go_top{position:absolute; top:expression(documentElement.scrollTop+documentElement.clientHeight - this.offsetHeight-40);</style>}";
    if ($.browser.msie && ($.browser.version == "6.0")){
        $("body").append(ie6Hack);
    }
    help_flag.css({
    	left:Gotop_x
    });
    function setGotop(){
        av_height = $(window).height();
        av_width = $(window).width();
        Gotop_y = av_height-Gotop_h-40;
        Gotop_x = (av_width>doc_width?0.5*av_width+0.5*doc_width:av_width-Gotop_w) + 20;
        if($(window).scrollTop()>0){
            go_top.fadeIn(200);
        }else{
            go_top.fadeOut(200);
        }
        if ($.browser.msie && ($.browser.version == "6.0")){
            go_top.animate({"left":Gotop_x},0);
            return false;
        }
        go_top.animate({"left":Gotop_x,"top":Gotop_y},0);
    }
     //返回旧版
    var backi= $("#backi");
    var ie6Hack1 = "<style>.backi{position:absolute; top:expression(documentElement.scrollTop+documentElement.clientHeight - this.offsetHeight-40);</style>}";
    if ($.browser.msie && ($.browser.version == "6.0")){
        $("body").append(ie6Hack1);
    }
    function setbacki(){
        av_height = $(window).height();
        av_width = $(window).width();
        Gotop_y = av_height-Gotop_h-87;
        Gotop_x = (av_width>doc_width?0.5*av_width+0.5*doc_width:av_width-Gotop_w);
        if ($.browser.msie && ($.browser.version == "6.0")){
            backi.animate({"left":Gotop_x},0);
            return false;
        }
        backi.animate({"left":Gotop_x,"top":Gotop_y},0);
    }
    setbacki();
    setGotop();
    $(window).resize(function(){
        setbacki();
        setGotop();
    });
    $(window).scroll(function(){
        setbacki();
        setGotop();
    });
     go_top.click(function(){
        $("html , body").animate({scrollTop:"0"},100);
    });

	//点击中学库关注按钮弹出层
	//$(".right_module").find(".ico_focus").click(function(){
		//$("#set_focus_box").show();
    //	});
	//中学库弹出层输入框效果
	$(".search_main").find(".search_input").focus(function(){
		if($(this).val() == "请输入中学名称/关键字"){
			$(this).val("");
		}else{
			$(this).css({
				"color": "#333" 
			});
		}
		$(this).css({
				"color": "#333" 
		});
	}).blur(function(){
		if($(this).val() == ""){
			$(this).val("请输入中学名称/关键字");
			$(this).css({
				"color": "#a5a5a5" 
			});
		}else{
			$(this).css({
				"color": "#333" 
			});
		}
	});
	
};

/**TIPS: 
0.提交数据时，在需要提交的FORM里加入名为'async_token_static'的hidden，或在请求中添加async_token_static参数
1.同步提交、页面载入或刷新时无需调用
2.异步提交需要在回调函数中手动调用
3.关闭子页面后 需要在父页面手动调用(如果父页面用到TOKEN)
*/


var sync_token_from_session = function (asyncTokenId) {
	async_token_static = asyncTokenId;
	$("input[name='async_token_static']").attr("value", asyncTokenId);
};


//]]>
</script>

		<link href="${pageContext.request.contextPath}/Static/JS/login_files/notice.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/Static/JS/login_files/login.js"></script>
		
		<!--[if lte IE 8]>
		<script src="js/html5.js"></script>
		<![endif]-->
		<script type="text/javascript">
		var imageUrlArr=[];
		var num=0;

	/* *
	 * 登陆验证脚本
	 * @author siqingwei
	 * 时间 2013-05-07
	 */
	$(function() {
		document.onkeydown = function(e) {
			var ev = document.all ? window.event : e;
			if (ev.keyCode == '13') {
				login();
			}
		};
		
	});
     
    function login(){
	
	   var userName=$.trim($("#userName").val());
		var passWord=$.trim($("#userPass").val());

		   if(userName=="" || userName=="帐号"){
			 $("#loginError").html("账号");
			 return false;
		   }
	      if(passWord=="" || passWord=="输入智康密码"){
			  $("#loginError").html("请输入密码");
			 return false;
		   }

           if(!checkSubmitMobil(userName,0)){
		     $("#loginError").html("账号格式不正确");
			 return false;
		   }


	      $("#userName").attr("disabled","disabled");
		  $("#userPass").attr("disabled","disabled");
		  $("#loginError").html("正在登录...");
		  var url="/sixtteacher/login!newLogin.action?userName="+userName+"&passWord="+passWord;
		  $.get(url,function(result){
		     if(result.success==true){
			setCookie('uinfo',[userName,passWord].join(','),{expires:new Date($('.remember_pass input').is(':checked')?+new Date()+1000*3600*24*7:+new Date()-1000)});

			   window.location="/sixtteacher/home/home!newIndex.action?modelTab=1";
			 }else{
			    $("#loginError").html(result.message);
				$("#userName").attr("disabled",false);
		        $("#userPass").attr("disabled",false);
			 }

		  });
	
	}
    

	//系统登陆与app下载切换
	function setTab(name,cursel,n){ 
		 for(i=1;i<=n;i++){ 
		  var menu=document.getElementById(name+i); 
		  var con=document.getElementById("con_"+name+"_"+i); 
		  menu.className=i==cursel?"hover":""; 
		  con.style.display=i==cursel?"block":"none";
		 } 
		};
		
	//二维码切换
	$(function(){
		var getApp=$('.app');
		var index=0;
		function hover(num){
			$(getApp).removeClass('hover');
			$(getApp[index]).addClass('hover');
		}hover(index);
		$('.turnRight').click(function(){
			if(++index>=getApp.length){
				index=0;
			}
			hover(index);
		});
		$('.turnLeft').click(function(){
			if(--index<0){
				index=getApp.length-1;	
			}
			hover(index);
		});
	});
		
		
	$(function(){
		//控制登录页背景图片
		var imgUrl="ggupload/201706191608298.jpg";
		var basePath="http://keben.izhikang.com/sixtht/";
		//if(imgUrl!=""&&imgUrl!=null){
		//	$(".login_cont").css("background-image","url("+basePath+imgUrl+")");
		//}
		num=+getCookie('imageIndex')||num;
		$.ajax({
			   type: "POST",
			   url: "/sixtteacher/login!getSystemNnouncementList.action",
			   success: function(data){
				 for ( var i = 0; i < data.data.length; i++) {
					imageUrlArr.push(data.data[i].imgUrl);
				}
				 
					if(imageUrlArr.length>0){
						var imgPath=imageUrlArr[num];
						if(imgPath!=""&&imgPath!=null){
							$(".login_cont").css("background-image","url("+basePath+imgPath+")");
						}
					}	
			   }
			});
		
		$(".rightTurn").click(function(){
			if(num==(imageUrlArr.length-1)){
				num=0;
			}else{
				num=num+1;
			}
			if(imageUrlArr.length>num){
				var imgPath=imageUrlArr[num];
				if(imgPath!=""&&imgPath!=null){
					$(".login_cont").css("background-image","url("+basePath+imgPath+")");
					setCookie('imageIndex',[num].join(','));
				}
			}	
		});
		$(".leftTurn").click(function(){
			if(num==0){
				num=imageUrlArr.length-1;
			}else{
				num=num-1;
			}
			if(imageUrlArr.length>num){
				var imgPath=imageUrlArr[num];
				if(imgPath!=""&&imgPath!=null){
					$(".login_cont").css("background-image","url("+basePath+imgPath+")");
					setCookie('imageIndex',[num].join(','));
				}
			}	
		});

            

	});
		
		

	// 记住用户名密码
	$(function(){
		
		var user=getCookie('uinfo')||',';
		user=user.split(',');
		if(checkSubmitMobil(user[0],0)){
		   $("#userName").val(user[0]);
		   user[1]&&$("#userPass").val(($('.remember_pass input').attr('checked',true),user[1]));
		   $(".user_tip").hide();
		}
		
		
	});
	
	
	function setCookie(r,q,w){
		w=w||{};
		q=q||'';
		if(!r)return;
		document.cookie = [escape(r), "=", 0 ? q : escape(q), w.expires ? "; expires=" + w.expires.toUTCString() : "", w.path ? "; path=" + w.path : "", w.domain ? "; domain=" + w.domain : "", w.secure ? "; secure" : ""].join("");
	}
	function getCookie(r){		
		var u = document.cookie.split("; ");
		var x = r ? null : {};
		for (var p = 0, n = u.length; p < n; p++) {
			var o = u[p].split("=");
			var k = unescape(o.shift());
			var m = unescape(o.join("="));
			if (r && r === k) {
				x = m;
				break;
			}
			if (!r) {
				x[k] = m;
			}
		}
		return x;
	
	}
    $(function(){
       //显示绑定页面
	   $(".relative_btn").click(function(){
	      $(".pop_layer").show();
	      $("#mask").show();
	   });
	   //隐藏绑定页面
	   $(".ico_close").click(function(){

		  hideBangDingPage();
	     
	   })
       //光标事件
	   $(".zk_user_name").focus(function(){
		   var userName=$.trim($(this).val());
		   if(userName=="输入智康用户名"){
			    $(this).val("");
		   }
	   });
       $(".input_pass").focus(function(){
	       var passWord=$.trim($(this).val());
			if(passWord=="输入智康密码"){
			    $(this).val("");
		   }
	   });
	   $(".bangding_phone").focus(function(){
	       var phone=$.trim($(this).val());
		   if(phone=="输入账号"){
		       $(this).val("");
		   }
	   });
	   $(".input_code").focus(function(){
	       var code=$.trim($(this).val());
		   if(code=="输入验证码"){
		       $(this).val("");
		   }
	   });
        $(".zk_user_name").blur(function(){
		   var userName=$.trim($(this).val());
		   if(userName==""){
			    $(this).val("输入智康用户名");
		   }
	   });
       $(".input_pass").blur(function(){
	       var passWord=$.trim($(this).val());
			if(passWord==""){
			    $(this).val("输入智康密码");
		   }
	   });
	   $(".bangding_phone").blur(function(){
	       var phone=$.trim($(this).val());
		   if(phone==""){
		       $(this).val("输入手机号");
		   }
	   });
	   $(".input_code").blur(function(){
	       var code=$.trim($(this).val());
		   if(code==""){
		       $(this).val("输入验证码");
		   }
	   });
		$(".input_code_valid").focus(function(){
			var code=$.trim($(this).val());
			if(code=="输入校验码"){
				$(this).val("");
			}
		});
		$(".input_code_valid").blur(function(){
			var code=$.trim($(this).val());
			if(code==""){
				$(this).val("输入校验码");
			}
		});


		//发送验证码
	   $(".btn_code").click(function(){
		    hideErrorMsg();

	       var userName=$.trim($(".zk_user_name").val());
		   var passWord=$.trim($(".input_pass").val());
           var city=$.trim($("#city_list").val());
	       var phone=$.trim($(".bangding_phone").val());
		   var code=$.trim($("#valid_code").val());


		   if(code == "" || code == "输入校验码"){
			   $("#code_error").html("输入校验码才能发送短信");
			   $("#code_error").show();
			   return false;
		   }

		   if(userName=="" || userName=="输入智康用户名"){
		     $("#user_name_error").html("请输入智康用户名");
			 $("#user_name_error").show();
			 return false;
		   }


		   if(passWord=="" || passWord=="输入智康密码"){
		     $("#pass_word_error").html("请输入智康密码");
			 $("#pass_word_error").show();
			 return false;
		   }
		   
		   var patt1=/^[a-zA-Z0-9]{6,10}$/;   
           var r=passWord.match(patt1);
           if(r==null){
        	   $("#pass_word_error").html("密码必须由6~10位字母或数字组成");
  			   $("#pass_word_error").show();
        	   return false;
           }
		   
	       if(city==0){
		      $("#city_list_error").html("请选择城市");
			  $("#city_list_error").show();
			  return false;
		   } 
		   if(phone=="" || phone=="输入账号"){
		     $("#phone_error").html("请输入账号");
			 $("#phone_error").show();
			 return false;
		   }
			
			if(!checkSubmitMobil(phone,1)){
			  return false;
			};

              $(".zk_user_name").attr("disabled","disabled");
			  $(".input_pass").attr("disabled","disabled");
			  $("#city_list").attr("disabled","disabled");
			  $(".bangding_phone").attr("disabled","disabled");

             $.get("/sixtteacher/login!sendCode.action?phone="+phone+"&checkCode="+code,function(result){
			    if(result.success==true){
					 $(".btn_code").hide();
	    	         $(".btn_code2").show();
				     countTime(119);
				}else{
				   $("#phone_error").html(result.message);
				   $("#phone_error").show();
				   $(".bangding_phone").attr("disabled",false);
				}
			 });
			 
			

	   });


	   $(".notice_btn").click(function(){
	       
		   hideErrorMsg();
	       var userName=$.trim($(".zk_user_name").val());
		   var passWord=$.trim($(".input_pass").val());
           var city=$.trim($("#city_list").val());
	       var phone=$.trim($(".bangding_phone").val());
		   var code=$.trim($("#validatioin_code").val());
		   if(userName=="" || userName=="输入智康用户名"){
		     $("#user_name_error").html("请输入智康用户名");
			 $("#user_name_error").show();
			 return false;
		   }


		   if(passWord=="" || passWord=="输入智康密码"){
		     $("#pass_word_error").html("请输入智康密码");
			 $("#pass_word_error").show();
			 return false;
		   }
		   
		   var patt1=/^[a-zA-Z0-9]{6,16}$/;   
           var r=passWord.match(patt1);
           if(r==null){
        	   $("#pass_word_error").html("密码必须由6~16位字母或数字组成");
  			   $("#pass_word_error").show();
        	   return false;
           }
		   
		   
	       if(city==0){
		      $("#city_list_error").html("请选择城市");
			  $("#city_list_error").show();
			  return false;
		   } 
		   if(phone=="" || phone=="输入手机号"){
		     $("#phone_error").html("请输入手机号");
			 $("#phone_error").show();
			 return false;
		   }

		   if(code=="" || code=="输入验证码"){
		     $("#code_error").html("请输验证码");
			 $("#code_error").show();
			 return false;
		   }
			
			if(!checkSubmitMobil(phone,1)){
			  return false;
			};

              $(".zk_user_name").attr("disabled","disabled");
			  $(".input_pass").attr("disabled","disabled");
			  $("#city_list").attr("disabled","disabled");
			  $(".bangding_phone").attr("disabled","disabled");
			  $(".input_code").attr("disabled","disabled");
            var url="/sixtteacher/login!bindingNumber.action?userName="+encodeURI(userName)+"&passWord="+passWord+"&phone="+phone+"&code="+code+"&cityCode="+city;
            $.get(url,function(result){
			    if(result.success==true){
				     hideBangDingPage();
					 alert("绑定成功！");
                     $("#userName").val(phone);
					 $("#userPass").val(passWord);
					 login();
				}else{
				    $("#code_error").html(result.message);
		            $("#code_error").show();
               $(".zk_user_name").attr("disabled",false);
			  $(".input_pass").attr("disabled",false);
			  $("#city_list").attr("disabled",false);
			  $(".bangding_phone").attr("disabled",false);
			  $(".input_code").attr("disabled",false);

				}
			
			});

	   
	   });
	   
	});


	function hideBangDingPage(){
	      hideErrorMsg();

              $(".zk_user_name").attr("disabled",false);
			  $(".input_pass").attr("disabled",false);
			  $("#city_list").attr("disabled",false);
			  $(".bangding_phone").attr("disabled",false);
			  $(".input_code").attr("disabled",false);
		      $(".pop_layer").hide();
	          $("#mask").hide();

              $(".zk_user_name").val("输入智康用户名");
			  $(".input_pass").val("输入智康密码");
			  $("#city_list").find("option :eq(0)").attr("selected","selected");
			  $(".bangding_phone").val("输入手机号");
			  $(".input_code").val("输入验证码");
	
	}

    function hideErrorMsg(){
	         $("#user_name_error").html("");
			 $("#user_name_error").hide();
			 $("#pass_word_error").html("");
			 $("#pass_word_error").hide();
			 $("#city_list_error").html("");
			 $("#city_list_error").hide();
			 $("#phone_error").html("");
			 $("#phone_error").hide();
			 $("#code_error").html("");
		     $("#code_error").hide();

			
	}


	 //jquery验证手机号码 
	function checkSubmitMobil(phone,sign) { 
		if ($.trim(phone) == "") { 
			if(sign==1){
				 $("#phone_error").html("请输入账号");
			     $("#phone_error").show(); 
			}		   
		   return false; 
		} 

		/*
		if (!phone.match(/^(((4[0-9]{1})|(6[0-9]{1})|(8[0-9]{1})|(10[0-9]{1}))+\d{8})$/)) { 
		  
		   if(sign==1){
					$("#phone_error").html("账号格式不正确");
		          $("#phone_error").show();
			}
		return false; 
		}
		*/
		return true; 
	}

    //计时
	function countTime(countNum){
		   runTime(countNum);
	  }

	  function runTime(countNum){
	    if(countNum>=0){
		   window.setTimeout(function(){
		      $(".btn_code2").find("span").html(countNum);
              countTime(countNum-1); 
		   },1000);
		}else{
            $(".btn_code").show();
	    	$(".btn_code2").hide();
			
		}
		
	  }
	  
		function refreshCheckCode(){
			$("#random").attr("src","/sixtteacher//jsp/checkcode/random.jsp?random="+Math.random());
		}
</script>
	</head>
	<body>
		<!--header-->
		<header class="login_head" style="padding-top: 18.5px;">
		<div class="wrap clearfix">
			
			<h1 style="font-size:30px">固定资产登陆系统</h1>
			
		</div>
		</header>
		<!--中间区域-->
		<section class="login_cont" style="background-image: url(&quot;http://keben.izhikang.com/sixtht/ggupload/2015062314253925.png&quot;);">
		<div class="wrap cont">
			<div class="upload_pic">
				
				
					<img src="/EAM/Static/JS/login_files/text.png" alt="">
				
			</div>
			<!--登陆-->
			<aside class="login_wrap">
			<!--透明外层-->
			<div class="filter_layer"></div>
			<div class="login_main">
				<h2>
					<span id="three1" onclick="setTab('three',1,2)" class="hover">系统登录</span><span id="three2" onclick="setTab('three',2,2)" class="">刷脸登陆</span>
				</h2>
				<div id="con_three_1" style="display: block;">
					
				
					<ul class="login_ul">
						<!--用户名&&密码-->
						<li class="clearfix">
							<!-- <label for="user_name">
								用户名：
							</label> -->
							<form id="user_pass" action="/EAM/login?method=NormalLogin" method="post">
							        
							</form>
							<div class="edit_input">
								<i class="ico_user"></i>
								<span class="user_tip" style="display: block;">账号</span>
								<input id="username" name="username" form="user_pass" type="text">
						</div></li>
						<li class="clearfix">
							<!-- <label for="pwd">
								密码：
							</label> -->
							<div class="edit_input">
								<i class="ico_pass"></i>
								<span class="user_tip" style="display: none;">密码</span>
								<input name="pwd" id="userPass" form="user_pass" type="password" >
							</div>
						</li>
					</ul>
					<!--登录按钮-->
					<div class="clearfix">
						<input value="Login" type="submit"  form="user_pass" class="login_btn" id="loginBtn" onclick="login()"/>
					</div>
					<div class="text_error">
						<span id="loginError"></span>
					</div>
					<div class="remember_pass clearfix">
						<div style="float:left">
							
							${ msg }
							
						</div>
						
					</div>
				</div>

				<!--二维码区域-->
				<div id="con_three_2" style="display: none;">
				<span class="turnLeft"></span>
					<div class="app hover" id="turn1">
						<div style="width: 300px;height: 190px;margin-top:5px;margin-left:5px;">
								
								<video id="video" width="300" height="190" autoplay></video>
								<div>
									<form action="/EAM/login?method=FaceLogin" method="post"style="font-size:20px;" id="frm">
									<input type="hidden" id="img" value="" name="hid" />
										id:<input type="text" name="ID" style="height: 25px;margin-top:10px ;"/>
										<input type="submit" class="login_btn" id="picture" value="验证"onclick="a()" />
									</form>
									
								</div>
								<canvas align="center" style="display:block;" id="canvas"width="296" height="190"></canvas>
								
						</div>
						
					</div>
					
						
							
					<script>
		
						var p = navigator.mediaDevices.getUserMedia({
							audio : false,
							  audio: true,
							  video: {
								  width: 300, height: 190
							  }
							});
				
						p.then(function(mediaStream) {
						  var video = document.getElementById('video');
						  video.src = window.URL.createObjectURL(mediaStream);
						  video.onloadedmetadata = function(e) {
						    console.log("111111111111");
						  };
						});
						
						function a() {
							var context = document.getElementById("canvas").getContext("2d");
							context.drawImage(video, 0, 0, 350, 280);
							console.log("asd");
							var imgData = document.getElementById("canvas").toDataURL("image/jpeg");
							imgData = imgData.substr(23);
							var frm = document.getElementById("frm");
							var img = document.getElementById("img");
							img.value = imgData;
							console.log(img.value);
			
						}
					
					</script>
						
							
					
				</div>
				
			</div>
			<div class="turnBottom">
				<span class="leftTurn"></span>
				<span class="ico_skin"></span>
				<span class="rightTurn"></span>
			</div>
			</aside>
		</div>
		
		   
	<div id="mask" style="display: none;"></div>
		
	
		
		</section>
		<!--footer-->
		
		
	
		
		
	
</body></html>