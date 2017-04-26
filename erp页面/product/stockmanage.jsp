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
		<input type="button" id="add" value="新增库存记录/隐藏"><br>
		<table border="1" cellspacing="0" cellpadding="0" width="1000">
			<tr>
				<th>商品编号</th>
				<th>供应商</th>
				<th>负责人</th>
				<th>联系方式</th>
				<th>证书号</th>
				<th>金料成分</th>
				<th>规格</th>
				<th>金重(k)</th>
				<th>配石(ct)</th>
				<th>主石(ct)</th>
				<th>金费</th>
				<th>工费</th>
				<th>数量</th>
				<th>成本</th>
				<th>备注</th>
			</tr>
		</table>
	</div>

	<div id="inputbox" class="box">
		<form action="#">
			<table>
				<tr>
					<td width="80" align="right"><div align="right">商品编号：</div></td>
					<td width="250" align="left"><div align="left">
							<input name="pid" type="text" size="30">
						</div></td>
					<!-- <td width="80" align="right"><div align="right">供应商：</div></td>
					<td width="250" align="left"><div align="left">
							<input name="Ssupplier" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">负责人：</div></td>
					<td width="250"><div align="left">
							<input name="Shead" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">联系方式：</div></td>
					<td width="250"><div align="left">
							<input name="Stel" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">证书号：</div></td>
					<td width="250"><div align="left">
							<input name="ScertificateNum" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">金料成分：</div></td>
					<td width="250"><div align="left">
							<input name="Scomponent" type="text" size="30">
						</div></td>
				</tr>
				
				<tr>
					<td width="80" align="right"><div align="right">规格：</div></td>
					<td width="250"><div align="left">
							<input name="Ssize" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">金重(k)：</div></td>
					<td width="250"><div align="left">
							<input name="SgoldWeight" type="text" size="30">
						</div></td>
						<td width="80" align="right"><div align="right">配石(ct)：</div></td>
					<td width="250"><div align="left">
							<input name="SsubStone" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">主石(ct)：</div></td>
					<td width="250"><div align="left">
							<input name="SmainStone" type="text" size="30">
						</div></td>
						<td width="80" align="right"><div align="right">金费：</div></td>
					<td width="250"><div align="left">
							<input name="SgoldCost" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">工费：</div></td>
					<td width="250"><div align="left">
							<input name="ShandCost" type="text" size="30">
						</div></td>
				</tr>
				
				<tr> -->
					<td width="80" align="right"><div align="right">数量：</div></td>
					<td width="250"><div align="left">
							<input name="quantity" type="text" size="30">
						</div></td>
					<td width="80" align="right"><div align="right">成本：</div></td>
					<td width="250"><div align="left">
							<input name="cost" type="text" size="30">
						</div></td>
				</tr>
				<tr>
					<td width="80" align="right"><div align="right">备注：</div></td>
					<td colspan="5"><div align="left">
							<input name="note" type="text" size="85">&nbsp;&nbsp;&nbsp;<input
								name="add" type="submit" value="添加">
						</div></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>