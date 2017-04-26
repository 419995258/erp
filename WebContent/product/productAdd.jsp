<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String bas = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ bas + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=bas%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>

<link href="<%=bas%>/css/menu.css" type="text/css" rel="stylesheet">
<link href="<%=bas%>/css/common.css" type="text/css" rel="stylesheet">


<%-- <link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/demo/demo.css">
<script type="text/javascript" src="<%=bas%>/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script> --%>

</head>
<body class="easyui-layout">




	<form id="productfrom" class="easyui-form"
		encType="multipart/form-data" method="post"
		data-options="novalidate:false">

		<table>
			<tr>
				<td width="80" align="right"><div align="right">商品编号：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="pid" type="text" size="30" class="easyui-textbox"
							data-options="required:true"></input>
					</div></td>
				<td width="80" align="right"><div align="right">商品名称：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="name" type="text" size="30" class="easyui-textbox"
							data-options="required:true"></input>
					</div></td>
				<td width="80" align="right"><div align="right">供应商：</div></td>
				<td width="250"><div align="left">
						<input name="supplier" type="text" size="30"
							class="easyui-textbox" data-options="required:true"></input>
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">负责人：</div></td>
				<td width="250"><div align="left">
						<input name="leader" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">联系方式：</div></td>
				<td width="250"><div align="left">
						<input name="tel" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">证书号：</div></td>
				<td width="250"><div align="left">
						<input name="certificateNum" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">金料成分：</div></td>
				<td width="250"><div align="left">
						<input name="component" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">规格：</div></td>
				<td width="250"><div align="left">
						<input name="size" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">金重(k)：</div></td>
				<td width="250"><div align="left">
						<input name="weight" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">配石(ct)：</div></td>
				<td width="250"><div align="left">
						<input name="subStone" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">主石(ct)：</div></td>
				<td width="250"><div align="left">
						<input name="mainStone" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">金费：</div></td>
				<td width="250"><div align="left">
						<input name="goldCost" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
			</tr>

			<tr>
				<td width="80" align="right"><div align="right">工费：</div></td>
				<td width="250"><div align="left">
						<input name="handCost" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">数量：</div></td>
				<td width="250"><div align="left">
						<input name="quantity" type="text" size="30"
							class="easyui-numberbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">成本：</div></td>
				<td width="250"><div align="left">
						<input name="cost" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
			</tr>
			
			<tr>
				<td width="80" align="right"><div align="right">备注：</div></td>
				<td colspan="5"><div align="left">
						<input name="note" type="text" size="80" class="easyui-textbox"
							data-options="multiline:true" style="width: 100%; height: 100px">
					</div></td>

			</tr>
			
			<tr>
				<td width="80" align="right"><div align="right">商品图片：</div></td>
				<td width="250"><div align="left">
						<!-- <input name="photoLink" type="file" size="10" value="选择图片"> -->
						<input class="easyui-filebox" name="photoLink"
							data-options="prompt:'选择一张商品图片'" style="width: 100%">
						<!-- <input name="add" type="submit" value="添加"> -->
					</div></td>
			</tr>
			

			<!-- <tr>
					<td width="80" align="right"><div align="right">备注：</div></td>
					<td colspan="3"><div align="left">
							<input name="note" type="text" size="70">&nbsp;<input
								name="add" type="submit" value="添加">
						</div></td>
					<td width="80" align="right"><div align="right">商品图片：</div></td>
					<td width="250"><div align="left">
							<input name="photoLink" type="file" size="30" value="选择图片">
						</div></td>
				</tr> -->

		</table>

		<!-- <table cellpadding="5">
			<tr>
				<td>场地编号:</td>
				<td><input class="easyui-textbox" type="text"
					name="stadiumNumber" data-options="required:true"></input></td>
			</tr>
			<tr>
				<td>单价/时:</td>
				<td><input name="photoLink" type="file" size="10" value="选择图片"></td>
			</tr>


			<tr>
				<td>可用性:</td>
				<td><input type="radio" checked="checked" name="avaliable"
					value="0" />可用 <br /> <input type="radio" name="avaliable"
					value="1" />不可用</td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><input class="easyui-filebox" name="file1" />
				<input id="fb" class="easyui-filebox" style="width:400px" data-options="prompt:'Choose a file...'"></td>
			</tr>



		</table> -->
		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton addProductBtn">确认添加</a>
		</div>
	</form>



	<script type="text/javascript">
		$(function() {

			$(".addProductBtn").click(function() {
				submitProductFrom();
			});

		});

		function submitProductFrom() {
			$('#productfrom').form('submit', {
				url : 'AddProductServlet',
				onSubmit : function() {
					return $(this).form('validate');
				},
				dataType : "json",
				success : function(data) {
					// 此处是表单提交的回调函数
					var json = eval("(" + data + ")");
					if (json.result == "0") {
						alert(json.msg);
					} else if (json.result == "1") {
						alert(json.msg);
						parent.$('#productGrid').datagrid('reload');
						parent.$('#Win').window('close');
					}
					
				}
			});
		}
	</script>
</body>


</html>

