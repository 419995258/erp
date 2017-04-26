<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String bas = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ bas + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=bas%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定制添加</title>

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




	<form id="productfrom" class="easyui-form" name="productfrom"
		encType="multipart/form-data" method="post"
		data-options="novalidate:false">

		<table>
			<tr>
				<td width="150" align="right"><div align="right">商品编号：</div></td>
				<td width="300" align="left"><div align="left">
						<input name="pid" type="text" size="30" class="easyui-numberbox"
							data-options="required:true">
					</div></td>
				<td width="150" align="right"><div align="right">会员号：</div></td>
				<td width="300" align="left"><div align="left">
						<input name="cid" type="text" size="30" class="easyui-numberbox"
							data-options="required:true">
					</div></td>
			</tr>
			<tr>

				<td width="150" align="right"><div align="right">定制单号：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="diyNum" type="text" size="30" class="easyui-numberbox"
							data-options="required:true"></input>
					</div></td>
				<td width="150" align="right"><div align="right">定制日期：</div></td>
				<td width="250"><div align="left">
						<input name="diyDate" type="text" size="30" class="easyui-datebox"
							data-options="required:true"></input>
					</div></td>
			</tr>
			<tr>
				<td width="150" align="right"><div align="right">交货日期：</div></td>
				<td width="250"><div align="left">
						<input name="deliverDate" type="text" size="30"
							class="easyui-datebox" data-options="required:true">
					</div></td>
				<td width="150" align="right"><div align="right">数量：</div></td>
				<td width="250"><div align="left">
						<input name=quantity type="text" size="30" class="easyui-numberbox"
							data-options="required:true">
					</div></td>
				<td width="150" align="right"><div align="right">零售价：</div></td>
				<td width="250"><div align="left">
						<input name="retaPrice" type="text" size="30"
							class="easyui-numberbox" data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="150" align="right"><div align="right">定金：</div></td>
				<td width="250"><div align="left">
						<input name="deposit" type="text" size="30" class="easyui-numberbox"
							data-options="required:true">
					</div></td>
				<td width="150" align="right"><div align="right">结算：</div></td>
				<td width="250"><div align="left">
						<input name="billing" type="text" size="30" class="easyui-numberbox"
							data-options="required:true">
					</div></td>
				<td width="150" align="right"><div align="right">收银员：</div></td>
				<td width="250"><div align="left">
						<input name="cashier" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="150" align="right"><div align="right">定制顾问：</div></td>
				<td width="250"><div align="left">
						<input name="diyConsultant" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>

				<td width="150" align="right"><div align="right">备注：</div></td>
				<td width="250"><div align="left">
						<input name="note" type="text" size="30" class="easyui-textbox"
							data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="150" align="right"><div align="right">附件：</div></td>
				<td width="250"><div align="left">
						<input class="easyui-filebox" name="customerArchive"
							data-options="prompt:'请选择附件'" style="width: 100%">
					</div></td>
			</tr>

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
				var s=document.productfrom.customerArchive.value; 
				if(s==""){
					alert("请选择文件！");
					return;
				}
				submitProductFrom();
			});

		});

		function submitProductFrom() {
			$('#productfrom').form('submit', {
				url : 'AddDiySaleServlet',
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

