<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link type="text/css" rel="stylesheet" href="<%=basePath %>css/404.css" />
<!--[if IE 6]>
<script src="js/png.js"></script>
<script>DD_belatedPNG.fix('*')</script>
<![endif]-->


  </head>
  
  <body>

<div id="wrap">
	<div>
		<img src="image/404.png" alt="404" />
	</div>
	<div id="text">
		<strong>
			<span></span>
			
			<a href="javascript:history.back()">返回</a>
		</strong>
	</div>
</div>

<div class="animate below"></div>
<div class="animate above"></div>

</body>
</html>
