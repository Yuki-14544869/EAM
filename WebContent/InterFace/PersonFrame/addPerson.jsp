<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
<title>新建人员信息</title>
</head>
<body>

  <div   align="center">
   <font size=8 color="black" face="黑体">
      <br/> <b>新建人员信息</b>
   </font>
       <fieldset class="layui-elem-field layui-field-title"></fieldset>
  </div>

<form   id="subForm" action="/EAM/PersonAction?method=addPerson" method="post" >
<div style="width:50%;height:auto;float:left;" align="right">
   <font size=6 color="black" face="黑体" style="line-height:160%">
     <br/>  <b>工&nbsp;&nbsp;号</b>:<input type="text" name="username" style="width:220px; height:30px;" >&nbsp;<br/>
       <b>姓&nbsp;&nbsp;名</b>:<input type="text" name="realname" style="width:220px; height:30px;"value = "${Idtest.realname }">&nbsp;<br/>
       <b>性&nbsp;&nbsp;别</b>:<input type="text" name="sex" style="width:220px; height:30px;"value = "${Idtest.sex }">&nbsp;<br/>
       <b>民&nbsp;&nbsp;族</b>:<input type="text" name="nat" style="width:220px; height:30px;"value = "${Idtest.nat }">&nbsp;<br/>
       <b>出生年月</b>:<input type="text" name="borndate" style="width:220px; height:30px;"value = "${Idtest.borndate }">&nbsp;<br/>
       <b>部&nbsp;&nbsp;门</b>:<input type="text" name="deptid" style="width:220px; height:30px;">&nbsp;<br/>
       <b>家庭地址</b>:<input type="text" name="address" style="width:220px; height:30px;"value = "${Idtest.address }">&nbsp;<br/>
   </font>
    
</div>
<div style="width:50%;height:auto;float:right;" align="left">
    <font size=6 color="black" face="黑体" style="line-height:160%">
      <br/> 
       <b>身份证号</b>:<input type="text" name="cardid" style="width:220px; height:30px;"value = "${Idtest.cardid }">&nbsp;<br/>
       <b>籍&nbsp;&nbsp;贯</b>:<input type="text" name="natpl" style="width:220px; height:30px;">&nbsp;<br/>
       <b>电&nbsp;&nbsp;话</b>:<input type="text" name="tel" style="width:220px; height:30px;">&nbsp;<br/>
       <b>邮&nbsp;&nbsp;箱</b>:<input type="text" name="mail" style="width:220px; height:30px;">&nbsp;<br/>
       <b>职&nbsp;&nbsp;位</b>:<input type="text" name="pos" style="width:220px; height:30px;">&nbsp;<br/>
       <b>入职时间</b>:<input type="text" name="hiredate" style="width:220px; height:30px;">&nbsp;<br/>
      
    
   </font>
 
</div>
         <div style="width:50%;height:20%;float:left;" align="center">
         
     
		    <input type="submit" value="提交" style="width:70px; height:25px;background:#009688;color:white">&nbsp;
		    
			<input type="reset" value="重置"  style="width:70px; height:25px;background:#009688;color:white">&nbsp;
			</div>
</form >
  <form   action="/EAM/PersonAction?method=addform" method="post" enctype="multipart/form-data">
    <b>身份证识别</b><input type="file" name="file" style="width:220px; height:30px;font-size:15px">
          <div style="width:50%;height:auto;float:right;" align="left">
           <button style="witdh:80px;height:25px; background:#009688;color:white"" id="btn2" >检测</button>
        </div>	
        </form>
	<script type="text/javascript">
		var form = document.getElementById('subForm');
	
		function testCard(){
				form.action = "/EAM/PersonAction?method=addform";
				form.submit();
			}
	</script>	
</body>

</html>