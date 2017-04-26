<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<style type="text/css">
.style1 {font-size: 24px;}
.style2{font-size:14px;
		vertical-align: bottom;}
.style3{
	float:right;
	vertical-align: top;
}
body{
	font-family: 微软雅黑;
	font-size:13px;
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 5px;
	color:#000000;
}
a{
	text-decoration:none;
	color:#000000;
}
a:hover{
	text-decoration:underline;
	color:#0000ff;
}

</style>
<script type="text/javascript">
	function Time(){
			var date=new Date();
			var year=date.getYear();
			year = year + 1900;
			var month=date.getMonth();
			month = month + 1;
			var day=date.getDate();
			
			var hour=date.getHours();
			hour=parseInt(hour)>9?hour:"0"+hour;
			var minute=date.getMinutes();
			minute=parseInt(minute)>9?minute:"0"+minute;
			var second=date.getSeconds();
			second=parseInt(second)>9?second:"0"+second;
			
			var weekday=date.getDay();
			switch(weekday){
				case 0: weekday = "日"; break; 
				case 1: weekday = "一"; break;
				case 2: weekday = "二"; break;
				case 3: weekday = "三"; break;
				case 4: weekday = "四"; break;
				case 5: weekday = "五"; break;
				case 6: weekday = "六"; break;
			}
			var layer=document.getElementById('CurrentTime');
			layer.innerHTML = "当前时间：" + year +"年"+ month +"月"+ day + "日" +"&nbsp;"+hour+":"+minute+":"+second+" &nbsp;星期"+weekday;
			setTimeout("Time()","1000");		
		}
	
</script>
</head>

<body onload="javascript:Time()">
<div>
    <div class="style1">企业资源规划管理信息系统（ERP系统）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="style2">欢迎您,&nbsp;${sessionScope.username}&nbsp;|&nbsp;<a href="logout.jsp">注销</a></span></div>
    <div class="style3" id="CurrentTime">现在时间：xxxx年xx月xx日 xx：xx：xx 星期x</div>
</div>
</body>
</html>