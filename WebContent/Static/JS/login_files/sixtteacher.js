
/**
 * lyy 通用分页组件
 * pageNo 当前页
 * pageTotal 总页数
 * pageNum 每页中最大显示页数
 * pagenav 放分页组件的div容器ID
 * jsfunc 分页执行函数
 */
function createPageNav(pageNo,pageTotal,pageNum,pagenav,jsfunc){
	var pages="";
	var  curpage=parseInt(pageNo);
	var  prepage=curpage-1;
	var  nextpage=curpage+1;
	if(pageTotal>0){
		if(curpage>1){
			pages=pages+"<a class='pagnum' href='javascript:"+jsfunc+"(1);'>首页</a> "
			pages=pages+"<a class='pagnum' href='javascript:"+jsfunc+"("+prepage+");'>上一页</a> "
		}else{
			pages=pages+"<span class='pagall' >首页<span style='display:none;'></span></span> ";
			pages=pages+"<span class='pagall'>上一页<span style='display:none;'></span></span> ";
		}
		var endpage=pageTotal;
		var startpage=1;
		/*模仿google分页效果*/
		if(pageTotal>pageNum&&curpage>pageNum/2){
			 endpage=curpage+pageNum/2;
			if(endpage>pageTotal){
				endpage=pageTotal;
			}
		}else if(pageTotal>pageNum&&curpage<=pageNum/2){
			endpage=pageNum;
		}
		
		if(endpage-9>0){startpage=endpage-9;}
		for(var i=startpage;i<=endpage;i++){
			if(i==curpage){
				pages=pages+"<span class='pagpresent'>"+i+"<span style='display:none;'></span></span> ";
			}else{
				pages=pages+"<a class='pagnum' href='javascript:"+jsfunc+"("+i+");'>"+i+"</a> "
			}
		}
		if(nextpage<=pageTotal){
			pages=pages+"<a class='pagnum' href='javascript:"+jsfunc+"("+nextpage+");'>下一页</a> "
			pages=pages+"<a class='pagnum' href='javascript:"+jsfunc+"("+pageTotal+");'>尾页</a>"
		}else{
			pages=pages+"<span class='pagall'>下一页<span style='display:none;'></span></span> ";
			pages=pages+"<span class='pagall'>尾页<span style='display:none;'></span></span>";
		}
	}
	$("#"+pagenav).html(pages);
}
/**
*图像等比缩放
**/
function AutoResizeImage(maxWidth,maxHeight,objImg){
	var img = new Image();
	img.src = objImg.src;
	var hRatio;
	var wRatio;
	var Ratio = 1;
	var w = img.width;
	var h = img.height;
	wRatio = maxWidth / w;
	hRatio = maxHeight / h;
	if (maxWidth ==0 && maxHeight==0){
	Ratio = 1;
	}else if (maxWidth==0){//
	if (hRatio<1) Ratio = hRatio;
	}else if (maxHeight==0){
	if (wRatio<1) Ratio = wRatio;
	}else if (wRatio<1 || hRatio<1){
	Ratio = (wRatio<=hRatio?wRatio:hRatio);
	}
	if (Ratio<1){
	w = w * Ratio;
	h = h * Ratio;
	}
	objImg.height = h;
	objImg.width = w;
	/* if(maxWidth>w){
	var left=(maxWidth-w)/2
	$(objImg).css("margin-left",left+"px");
	}
	if(maxHeight>h){
	var top=(maxHeight-h)/2
	$(objImg).css("margin-top",top+"px");
	} */
	
}