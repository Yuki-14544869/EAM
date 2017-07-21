<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/EAM/Static/layui/css/layui.css"  media="all">
<title>更新人员信息</title>
</head>
<body>

  <div   align="center">
   <font size=8 color="black" face="黑体">
      <br/> <b>更新人员信息</b>
   </font>
   <fieldset class="layui-elem-field layui-field-title"></fieldset>
  </div>
 <form action="/EAM/PersonAction?method=updatePerson&id=${person.id}&version=${person.version}" method="post" >
<div  style="width:50%;height:auto;float:left;" align="right">
   <font size=6 color="black" face="黑体" style="line-height:160%">
     <br/>  工&nbsp;&nbsp;号:<input  type="text" name="username" style="width:220px; height:30px;border:#e2e2e2 1px solid;" value = "${person.username }">&nbsp;<br/>
                           姓&nbsp;&nbsp;名:<input type="text" name="realname" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.realname}">&nbsp;<br/>
       性&nbsp;&nbsp;别:<input type="text" name="sex" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.sex}">&nbsp;<br/>
       民&nbsp;&nbsp;族:<input type="text" name="nat" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.nat}">&nbsp;<br/>
       出生年月:<input type="text" name="borndate" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.borndate}">&nbsp;<br/>
       部&nbsp;&nbsp;门:<input type="text" name="deptid" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.deptid}">&nbsp;<br/>
       家庭地址:<input type="text" name="address" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.address}">&nbsp;<br/>
   </font>
    
</div>
<div style="width:50%;height:auto;float:right;" align="left">
    <font size=6 color="black" face="黑体" style="line-height:160%" >
      <br/> 
       身份证号:<input type="text" name="cardid" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.cardid}">&nbsp;<br/>
       籍&nbsp;&nbsp;贯:<input type="text" name="natpl" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.natpl}">&nbsp;<br/>
       电&nbsp;&nbsp;话:<input type="text" name="tel" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.tel}">&nbsp;<br/>
       邮&nbsp;&nbsp;箱:<input type="text" name="mail" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.mail}">&nbsp;<br/>
       职&nbsp;&nbsp;位:<input type="text" name="pos" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.pos}">&nbsp;<br/>
       入职时间:<input type="text" name="hiredate" style="width:220px; height:30px;border:#e2e2e2 1px solid;"value = "${person.hiredate}">&nbsp;<br/>
       是否离职
      <input type="checkbox" value="1" name="state" style="width:18px; height:18px;"  >
		 	

   </font>
       
</div>
         <div style="witdh:100%;height:150%;"align="center">
         &nbsp;<br/>
		    <input class="layui-btn layui-btn-small" type="submit" value="提交" onclick="fun()" style="width:70px; height:25px;">&nbsp;
			<input class="layui-btn layui-btn-small" type="reset" value="重置"  style="width:70px; height:25px;">&nbsp;
			
			</div>
		</form>

</body>
</html>