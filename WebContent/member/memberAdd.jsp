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
<title>会员添加</title>
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
		 method="post"
		data-options="novalidate:false">

		<table>
			<tr>
				<td width="80" align="right"><div align="right">会员号：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="cid" type="text" size="30" class="easyui-numberbox"
							data-options="required:true"></input>
					</div></td>
				<td width="80" align="right"><div align="right">顾客名称：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="name" type="text" size="30" class="easyui-textbox"
							data-options="required:true"></input>
					</div></td>
				<td width="80" align="right"><div align="right">联系方式：</div></td>
				<td width="250"><div align="left">
						<input name="tel" type="text" size="30"
							class="easyui-numberbox" data-options="required:true"></input>
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">生日日期：</div></td>
				<td width="250"><div align="left">
						<input name="birthday" type="text" size="30" class="easyui-datebox" 
							data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">家庭住址：</div></td>
				<td width="250"><div align="left">
						<input name="address" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">E-MAIL：</div></td>
				<td width="250"><div align="left">
						<input name="email" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">购买金额：</div></td>
				<td width="250"><div align="left">
						<input name="saleAmount" type="text" size="30"
							class="easyui-numberbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">回访记录：</div></td>
				<td width="250"><div align="left">
						<input name="record" type="text" size="30" class="easyui-textbox"
							>
					</div></td>
			
			</tr>
			
			<tr>
				<td width="80" align="right"><div align="right">备注：</div></td>
				<td colspan="5"><div align="left">
						<input name="note" type="text" size="80" class="easyui-textbox"
							data-options="multiline:true" style="width: 100%; height: 100px">
					</div></td>

			</tr>
		
			

		</table>

		
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
				url : 'AddCustomerServlet',
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

