<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎访问ERP管理信息系统</title>
<style type="text/css">
.img{
	margin:90px auto auto auto;
	text-align:center;
}
.text{
	margin:70px auto auto auto;
	font-family:微软雅黑;
	font-size:22px;
	font-weight:normal;
	text-align:center;
}
.sheet{
	margin:20px auto auto auto;
	font-family:微软雅黑;
	font-size:14px;
	font-weight:normal;
	text-align:center;
	line-height:10px;
}
.bottom{
	margin:50px auto auto auto;
	font-family:微软雅黑;
	font-size:13px;
	text-align:center;
	line-height:20px;
}
.bottomsign{
	margin:50px auto auto auto;
	font-family:微软雅黑;
	font-size:18px;
	text-align:center;
	line-height:25px;
}


a:link { 
font-size: 14px; 
color: #000000; 
text-decoration: none; 
} 
a:visited { 
font-size: 14px; 
color: #000000; 
text-decoration: none; 
} 
a:hover { 
font-size: 14px; 
color: #999999; 
text-decoration: underline; 
} 

</style>
<script type="text/javascript">  
	/*var timeout = null;//onresize触发次数过多，设置定时器  
    window.onresize = function () {  
    clearTimeout(timeout);  
    timeout = setTimeout(function () { window.location.reload(); }, 100);//页面大小变化，重新加载页面以刷新MAP  
    }*/
</script> 
</head>
<body>

<div class="img">
<img src="image/logo.png"/>
</div>
<div class="text">
ERP管理信息系统version1.0
</div>
<br>
<div class="sheet">
<form action="LoginServlet" method="post">
	<input type="text" name="username" placeholder="请输入您的登录帐号" style="width:285px;border-radius:5px;background:#E5E4E4;height:35px;border:0;color:#000;margin-bottom:10px;padding-left:15px"><br><br>
	<input type="password" name="password" placeholder="请输入您的登录口令" style="width:285px;border-radius:5px;background:#E5E4E4;height:35px;border:0;color:#000;margin-bottom:10px;padding-left:15px"><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="登&nbsp;&nbsp;&nbsp;录" style="width:120px;border-radius:5px;background:#5C411D;height:30px;border:0;color:#fff;margin-bottom:10px;padding-left:15px;">
</form>
</div>
<div class="bottom">
<p style="margin-top:20px">
<div style="color:#999999"><a href="http://www.y-mark.com">回到首页</a>&nbsp;&nbsp;
<a href="http://www.y-mark.com/help.aspx?id=19">隐私政策</a>&nbsp;&nbsp;
<a target="_blank" href="http://www.cnjobell.com">友情链接</a>&nbsp;&nbsp;
<a target="_blank" href="http://www.echuangwl.com">技术支持</a>
</div>
</p>	
<p >京ICP备11001590号 </p>
<p class="copyright">Copyright&copy 2016-2017 Your Mark. All Rights Reserved.</p>

</div>
<div class="bottomsign">
<img  src="image/foot.png">

</div>
</body>
</html>