var TB_WIDTH;
var TB_HEIGHT;
$(document).ready(TB_launch); 

// 首页锁账号效果
// 
function TB_launch() {
$("a.thickbox").click(function(){
  var clickbody =document.getElementById('body1');
  var clickhtml =document.getElementById('html1');
  var t = this.title;
  TB_show(t,this.href);
  this.blur();
  clickbody.style.overflow="hidden";
  clickbody.style.width="100%";
  clickbody.style.height="100%";
  clickhtml.style.overflow="hidden";
  clickhtml.style.width="100%";
  clickhtml.style.height="100%";
  /*clickbody.style.zoom= 1;*/
  return false;
});
}

function TB_show(caption, url) { //function called when the user clicks on a thickbox link
	try {
		$("body")
		.append("<div id='TB_overlay'></div><div id='TB_window'></div>");
		$("#TB_overlay").css("opacity","1");
		$("#TB_overlay").css("filter","alpha(opacity=100)");
		$("#TB_overlay").css("-moz-opacity","1");
		$(window).resize(TB_position);
		$("body").append("<div id='TB_load'><div id='TB_loadContent'></div></div>");
		$("#TB_overlay").show();
		var urlString = /.jpg|.jpeg|.png|.gif|.html|.htm/g;
		var urlType = url.match(urlString);
		
		if(urlType == '.jpg' || urlType == '.jpeg' || urlType == '.png' || urlType == '.gif'){//code to show images

			var imgPreloader = new Image();
			imgPreloader.onload = function(){

			// Resizing large images added by Christian Montoya
			var de = document.documentElement;
			var x = (self.innerWidth || (de&&de.clientWidth) || document.body.clientWidth) - 50;
			var y = (self.innerHeight || (de&&de.clientHeight) || document.body.clientHeight) - 80;
			if(imgPreloader.width > x) { 
				imgPreloader.height = imgPreloader.height * (x/imgPreloader.width); 
				imgPreloader.width = x; 
				if(imgPreloader.height > y) { 
					imgPreloader.width = imgPreloader.width * (y/imgPreloader.height); 
					imgPreloader.height = y; 
				}
			} 
			else if(imgPreloader.height > y) { 
				imgPreloader.width = imgPreloader.width * (y/imgPreloader.height); 
				imgPreloader.height = y; 
				if(imgPreloader.width > x) { 
					imgPreloader.height = imgPreloader.height * (x/imgPreloader.width); 
					imgPreloader.width = x;
				}
			}
			// End Resizing

			TB_WIDTH = imgPreloader.width + 30;
			TB_HEIGHT = imgPreloader.height + 60;
			$("#TB_window").append("<img id='TB_Image' src='"+url+"' width='"+imgPreloader.width+"' height='"+imgPreloader.height+"' alt='"+caption+"'/>"+ "<div id='TB_caption'>"+caption+"</div><div id='TB_closeWindow'><a href='#' id='TB_closeWindowButton'>关闭</a></div>"); 
			$("#TB_closeWindowButton").click(TB_remove);
			$("#TB_Image").click(TB_remove); // close when image clicked added by Christian Montoya
			TB_position();
			$("#TB_load").remove();
			$("#TB_window").slideDown("normal");
			}
	  
			imgPreloader.src = url;
		}
		
		if(urlType == '.htm' || urlType == '.html'){//code to show html pages
			
			var queryString = url.replace(/^[^\?]+\??/,'');
			var params = parseQuery( queryString );
			
			TB_WIDTH = (params['width']*1);
			TB_HEIGHT = (params['height']*1);
			ajaxContentW = TB_WIDTH;
			ajaxContentH = TB_HEIGHT;
			$("#TB_window").append("<input name='' class='referButjs' type='button' href='#' id='TB_closeWindowButton' value='解锁' /><div id='TB_ajaxContent' style='width:"+ajaxContentW+"px;height:"+ajaxContentH+"px;'></div>");
			$("#TB_closeWindowButton").click(TB_remove);
			$("#TB_ajaxContent").load(url, function(){
			TB_position();
			$("#TB_load").remove();
			$("#TB_window").slideDown("normal");
			});
		}
		
	} catch(e) {
		alert( e );
	}
}

//helper functions below

function TB_remove() {
	// #TB_load removal added by Christian Montoya; solves bug when overlay is closed before image loads
	$("#TB_window").fadeOut("fast",function(){$('#TB_window,#TB_overlay,#TB_load').remove();}); 
	  var clickbody =document.getElementById('body1');
	  var clickhtml =document.getElementById('html1');
	  clickbody.style.overflow="auto";
	  clickbody.style.width="auto";
	  clickbody.style.height="auto";
	  clickhtml.style.overflow="auto";
	  clickhtml.style.width="auto";
	  clickhtml.style.height="auto";
	
	return false;
}

function TB_position() {
	var de = document.documentElement;
	var w = self.innerWidth || (de&&de.clientWidth) || document.body.clientWidth;
	var h = self.innerHeight || (de&&de.clientHeight) || document.body.clientHeight;
  
  	if (window.innerHeight && window.scrollMaxY) {	
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		yScroll = document.body.offsetHeight;
  	}
	
	$("#TB_window").css({width:TB_WIDTH+"px",height:TB_HEIGHT+"px",
	left: ((w - TB_WIDTH)/2)+"px", top: ((h - TB_HEIGHT)/2)+"px" });
	$("#TB_overlay").css("height",yScroll +"px");
}

function parseQuery ( query ) {
   var Params = new Object ();
   if ( ! query ) return Params; // return empty object
   var Pairs = query.split(/[;&]/);
   for ( var i = 0; i < Pairs.length; i++ ) {
      var KeyVal = Pairs[i].split('=');
      if ( ! KeyVal || KeyVal.length != 2 ) continue;
      var key = unescape( KeyVal[0] );
      var val = unescape( KeyVal[1] );
      val = val.replace(/\+/g, ' ');
      Params[key] = val;
   }
   return Params;
}

/**
 * 锁屏
 * @author 赵彦军 <zyjun622@163.com>
 * @date 2012-11-07
 */
function lock_screen() {
	$.post(basePath+"lockscreen!lock.action");
	$("#TB_window").css('display','block');
    $("#flashDiv").css('display','none');
    
}

/**
 * 解锁
 * @author 赵彦军 <zyjun622@163.com>
 * @date 2012-11-07
 */
function check_screenlock() {
	var lock_password = $("#lock_password").val();
	if(lock_password=='') {
		$("#lock_tips").html('<font style="color:red;padding-left:18px;">密码不能为空！</font>');
		return false;
	}
	$.post(basePath+"lockscreen!unLock.action", { lock_password: lock_password},function(data){
		if(data.success==false) {
			$("#TB_window").css('display','block');
			$("#lock_password").val('');
			$("#lock_tips").html('<font style="color:red;padding-left:18px;">密码输入错误！</font>');
		}else {
                     $("#TB_window").css('display','');
                     $("#flashDiv").css('display','none');
                      window.location.reload();
                  }
	});
}

 

/**
 * 输入密码切换
 * @author 赵彦军 <zyjun622@163.com>
 * @date 2012-11-07
 */
function loginswitching(){
    var switch_password = $("#switch_password").val(); 
	if(switch_password=='') {
		$("#switch_tips").html('<font color="red">密码不能为空。</font>');
		return false;
	}
	$.post(basePath+"workmodel!change.action",{password: switch_password},function(data){
		if(data.success==false) { 
			$("#switch_password").val('');
			$("#switch_tips").html('密码输入错误');
		}else if(data.success == true){ 
          window.location.href=basePath+'home/home!index.action?modelTab=1';
        }
	});
}



//滑动门
function setTab(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
 }
}