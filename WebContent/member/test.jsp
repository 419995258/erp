<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<body>
	<input class="Wdate" name="birthday" type="text" size="35" onFocus="WdatePicker({lang:'zh-cn'})" readonly="readonly"/>
	<input name="birthday" type="text" size="30" class="easyui-textbox" 
							data-options="required:true" onFocus="WdatePicker({lang:'zh-cn'})" readonly="readonly">
</body>
</html>