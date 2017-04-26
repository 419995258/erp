<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
<link href="../css/common.css" type="text/css" rel="stylesheet">
<style type="text/css">
body, input {
	font-family: "微软雅黑";
	font-size: 14px;
}

table, tr, th, td {
	border-collapse: collapse;
	border-spacing: 0;
	text-align: center;
	vertical-align: middle;
	line-height: 25px;
}

.box {
	width: 100%;
	margin: 5px auto auto auto;
	padding: 5px;
	height: 100%;
	float: left;
	display: none;
	margin: 5px auto auto auto; /* 默认对话框隐藏 */
}

.box.show {
	display: block;
}

.box .x {
	display: block;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("#add").click(function() {
			$("#inputbox").toggle();
		});
	});
</script>
</head>
<body>
<div class="contain">
<input type="button" id="add" value="新增/隐藏"><br>
<table border="1" cellspacing="0" cellpadding="0" width="1000">
		<tr>
			<th>序列号</th>
			<th>用户名</th>
			<th>用户权限</th>
		</tr>
</table>
</div>
<div id="inputbox" class="box">
		<form action="#">
		<table>
			<tr>
				<td width="80" align="right"><div align="right">序列号：</div></td>
				<td width="300" align="left"><div align="left">
						<input name="" type="text" size="35">
					</div></td>
				<td width="80" align="right"><div align="right">用户名：</div></td>
				<td width="300" align="left"><div align="left">
						<input name="" type="text" size="35">
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">用户权限：</div></td>
				<td width="300"><div align="left">
						<input name="" type="text" size="35">
					</div></td>
			</tr>
		</table>
		</form>
		</div>
</body>
</html>