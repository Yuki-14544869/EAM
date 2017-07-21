/*
	author：张瑞红
	time：2014-7-9
*/
function setTop(){
	var header_height = $(".login_head").height();
	var content_height = $(".login_cont").height();
	var footer_height = $(".footer").height();
	var screen_height = $(window).height();
	var flag_top = screen_height - footer_height - content_height - header_height;
	if(flag_top > 0){
		$(".login_head").css({
			"padding-top" : (flag_top / 2)
		})
	}else{

	}
}

$(function(){
	//首页垂直居中屏幕
	setTop();
	$(window).resize(function(){  //浏览器窗口大小改变时
		setTop();
	})
	//登录输入框效果
	$(".login_ul").find("li").each(function(){
		var $this = $(this);
		//判断默认情况
		if($this.find("input").val()){
			$this.find(".user_tip").hide();
		}
		$this.find(".edit_input").click(function(){
			$(this).find(".user_tip").hide();
			$(this).find("input").focus();
			$(this).addClass("edit_input_light")
		});
		$this.find("input").blur(function(){
			$this.find(".edit_input").removeClass("edit_input_light");
			$this.find(".user_code").removeClass("edit_input_light");  //验证码
			if(!$(this).val()){  //为空
				$this.find(".user_tip").show();
			}else{
				$this.find(".user_tip").hide();
			}
		});
		//验证码
		$this.find(".user_code").focus(function(){
			$(this).addClass("edit_input_light");
		});
	});
});