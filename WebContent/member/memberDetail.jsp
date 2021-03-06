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
<title>商品详情</title>

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

<link rel="stylesheet" type="text/css"
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
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body class="easyui-layout">
	<form id="productDetailfrom" class="easyui-form" method="post"
		data-options="novalidate:false">

		<table>
			<tr>
				
				<td width="80" align="right"><div align="right">顾客名称：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="name" id="name" type="text" size="30"
							class="easyui-textbox" data-options="required:true"></input>
					</div></td>
				<td width="80" align="right"><div align="right">联系方式：</div></td>
				<td width="250"><div align="left">
						<input name="tel" id="tel" type="text" size="30"
							class="easyui-textbox" data-options="required:true"></input>
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">生日日期：</div></td>
				<td width="250"><div align="left">
						<input name="birthday" id="birthday" type="text" size="30"
							class="easyui-datebox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">家庭住址：</div></td>
				<td width="250"><div align="left">
						<input name="address" id="address" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">E-MAIL：</div></td>
				<td width="250"><div align="left">
						<input name="email" id="email" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">购买金额：</div></td>
				<td width="250"><div align="left">
						<input name="saleAmount" id="saleAmount" type="text" size="30"
							class="easyui-textbox" data-options="required:true">
					</div></td>
				<td width="80" align="right"><div align="right">回访记录：</div></td>
				<td width="250"><div align="left">
						<input name="record" id="record" type="text" size="30"
							class="easyui-textbox">
					</div></td>

			</tr>

			<tr>
				<td width="80" align="right"><div align="right">备注：</div></td>
				<td colspan="5"><div align="left">
						<input name="note" id="note" type="text" size="80"
							class="easyui-textbox" data-options="multiline:true"
							style="width: 100%; height: 100px">
					</div></td>

			</tr>



		</table>

		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)"
				class="easyui-linkbutton updateMemberBtn">更新</a>
		</div>
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
	</form>



	<script type="text/javascript">
	$(function() {

		$(".updateMemberBtn").click(function() {
			submitProductFrom();
		});
	});

	function submitProductFrom() {
		$('#productDetailfrom').form('submit', {
			url : 'UpdateCustomerServlet?id=${param.id}',
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
	
	
		$(function() {
			$.ajax({
		            type : "post",
		            url : 'GetMemberServlet',
		            data : {//设置数据
		            	id : ${param.id}},
		            dataType : "json",//设置需要返回的数据类型
		            success : function(data) {
		            	$("#cid").textbox("setValue", data.id);
		            	$("#name").textbox("setValue", data.name);
		            	$("#tel").textbox("setValue", data.tel);
		            	$("#birthday").datebox("setValue", data.birthday);
		            	$("#address").textbox("setValue", data.address);
		            	$("#email").textbox("setValue", data.email);
		            	$("#saleAmount").textbox("setValue", data.saleAmount);
		            	$("#record").textbox("setValue", data.record);
		            	$("#note").textbox("setValue", data.note);
		            	/* $("#subStone").textbox("setValue", data.subStone);
		            	$("#mainStone").textbox("setValue", data.mainStone);
		            	$("#goldCost").numberbox("setValue", data.goldCost);
		            	$("#handCost").numberbox("setValue", data.handCost);
		            	$("#quantity").numberbox("setValue", data.quantity);
		            	$("#cost").numberbox("setValue", data.cost);
		            	$("#note").textbox("setValue", data.note);
		            	$("#photoLink").filebox("setValue", data.photoLink); */
		            	/* $("#photoLink").attr('src',data.photoLink); */ 
 		            	/* $("#photoLink").attr('alt',data.photoLink); */  
		            	
		            	
					}
				});  
			});
	</script>
</body>


</html>

