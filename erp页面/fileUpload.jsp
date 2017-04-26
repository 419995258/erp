<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  method="post" enctype="multipart/form-data" action="up">
	上传人：<input type="text" name="upLoadMan"><br/>
	上传命名：<input type="text" name= "fname"><br/>
	上传文件：<input type="file" id="myfile" name="myfile"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>