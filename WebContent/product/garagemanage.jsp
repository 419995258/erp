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
		<input type="button" id="add" value="新增出库记录/隐藏"><br>
		<table border="1" cellspacing="0" cellpadding="0" width="1000">
			<tr>
				<th>条形码</th>
				<th>款号</th>
				<th>商品</th>
				<th>签收部门</th>
				<th>签收人</th>
				<th>签收时间</th>
				<th>规格</th>
				<th>金重(k)</th>
				<th>配石(ct)</th>
				<th>主石(ct)</th>
				<th>金费</th>
				<th>工费</th>
				<th>数量</th>
				<th>价格</th>
				<th>备注</th>
			</tr>
		</table>
	</div>

	<div id="inputbox" class="box">
		<form action="#">
			<table>
				<tr>
					<td width="80" align="right"><div align="right">条形码：</div></td>
					<td width="250" align="left"><div align="left">
							<input name="Ebarcode" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">款号：</div></td>
					<td width="250" align="left"><div align="left">
							<input name="Emodel" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">商品：</div></td>
					<td width="250"><div align="left">
							<input name="Egoods" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">签收部门：</div></td>
					<td width="250"><div align="left">
							<input name="EreceDepart" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">签收人：</div></td>
					<td width="250"><div align="left">
							<input name="Ereceiver" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">签收时间：</div></td>
					<td width="250"><div align="left">
							<input name="EreceTime" type="text" size="30">
						</div></td>
				</tr>

				<tr>
					<td width="80" align="right"><div align="right">规格：</div></td>
					<td width="250"><div align="left">
							<input name="Esize" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">金重(k)：</div></td>
					<td width="250"><div align="left">
							<input name="EgoldWeight" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">配石(ct)：</div></td>
					<td width="250"><div align="left">
							<input name="EsubStone" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">主石(ct)：</div></td>
					<td width="250"><div align="left">
							<input name="EmainStone" type="text" size="30">
						</div></td>
						<td width="80" align="right"><div align="right">金费：</div></td>
					<td width="250"><div align="left">
							<input name="EgoldCost" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">工费：</div></td>
					<td width="250"><div align="left">
							<input name="EhandCost" type="text" size="30">
						</div></td>
				</tr>
				
				<tr>
					<td width="80" align="right"><div align="right">数量：</div></td>
					<td width="250"><div align="left">
							<input name="Enum" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">价格：</div></td>
					<td width="250"><div align="left">
							<input name="Eprice" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">备注：</div></td>
					<td colspan="5"><div align="left">
							<input name="Gnotes" type="text" size="90">&nbsp;&nbsp;&nbsp;<input
								name="add" type="submit" value="添加">
						</div></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>