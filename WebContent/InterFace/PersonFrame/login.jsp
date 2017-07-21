<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录用户信息</title>
</head>
<body>
  <form method="POST" name="divlogin" action="LoginSelvet">   
    <div align="center">          
    <div >
        <font size=6 color="#2a5caa" face="宋体" ><b><i>欢迎使用固定资产系统</i></b></font> <br/><br/>
                             账号：      <input type="text" name="username"><br/><br/>
                              密码：   <input type="password" name="password"><br/> <br/>   
    <input type="submit" name="login" value="登陆" onclick="return emptyLogin()">  
    <input type="reset" name="reset" value="重置"> 
      </div> 
       </div>   
         <script type="text/javascript">  
          function emptyLogin(){     
           var eusername=document.divlogin.username.value;    
           var epassword=document.divlogin.password.value;    
           if(eusername==""){         
        	    alert("请输入账号");        
        	    return false;      
        	    }    
           if(epassword=="") {      
        	   alert("请输入密码");        
        	   return false;     
        	   } 
           }  </script> 
     </form>
</body>
</html>