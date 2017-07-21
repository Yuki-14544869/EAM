// JavaScript Document

//顶部导航js显示隐藏
function nav(id,sun){
	var show=document.getElementById(id);
	var showsun=document.getElementById(sun);
		showsun.style.display="block";
}
function navout(id,sun){
	var show=document.getElementById(id);
	var showsun=document.getElementById(sun);
		showsun.style.display="none";
}



//全局弹出层
function show(cover,id){
        var showBoxCenter = function () {
			var objCover	= $("#"+cover+"");
			objCover.css({'display':'block'});
			objCover.width($(document).width()+'px');
			objCover.height($(document).height()+'px');
			
			var objId=document.getElementById(id);
			objId.style.display = 'block';
			var L=(document.documentElement.clientWidth-objId.clientWidth)/2+document.documentElement.scrollLeft;
			//var T=(document.documentElement.clientHeight-objId.clientHeight)/2+document.documentElement.scrollTop;
			
			objId.style.top="100px";
			objId.style.left=L+"px";
			$("#flashDiv").css('display','none');
 		};
		showBoxCenter();
		window.onresize = function() {
			/* 判断 */
			if($("#"+cover+":visible").length>0){
				showBoxCenter();
			}		
		};
}
function hide(cover,id){
	var objCover=document.getElementById(cover);
	var objId=document.getElementById(id);
	objCover.style.display="none";
	objId.style.display="none";
     $("#flashDiv").css('display','');
}

//课程规划定定位弹出层
function feedback(id){
		var objId=document.getElementById(id);
		objId.style.display="block";
}
function feedbackhide(id){
	var objId=document.getElementById(id);
	objId.style.display="none";
}


//返回顶部
window.onload=function(){
	var help_flag= $("#help_wrap")	//帮助按钮
    var av_height = $(window).height();
    var av_width = $(window).width();
    var go_top= $("#go_top");
    var Gotop_w = go_top.width()+2;
    var Gotop_h = go_top.height()+2;
    var doc_width = 1010;
    var Gotop_x = (av_width>doc_width?0.5*av_width+0.5*doc_width:av_width-Gotop_w);
    var Gotop_y = av_height-Gotop_h;
    var ie6Hack = "<style>.go_top{position:absolute; top:expression(documentElement.scrollTop+documentElement.clientHeight - this.offsetHeight-40);</style>}";
    if ($.browser.msie && ($.browser.version == "6.0")){
        $("body").append(ie6Hack);
    }
    help_flag.css({
    	left:Gotop_x
    });
    debugger;
    function setGotop(){
        av_height = $(window).height();
        av_width = $(window).width();
        Gotop_y = av_height-Gotop_h-40;
        Gotop_x = (av_width>doc_width?0.5*av_width+0.5*doc_width:av_width-Gotop_w);
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
    })
    $(window).scroll(function(){
        setbacki();
        setGotop();
    })
     go_top.click(function(){
        $("html , body").animate({scrollTop:"0"},100);
    })
     
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
//首页显示隐藏
$(function(){
	$('.top_open').hover(function(){
		$(this).children("a").addClass('top_on').removeClass('csbg');
		$(this).children("ul").stop(true,true).show()
	},function(){
		$(this).children("a").removeClass('top_on').addClass('csbg');
		$(this).children("ul").hide()
	});
})

 