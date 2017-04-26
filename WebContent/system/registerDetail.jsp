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
				
				<td width="80" align="right"><div align="right">姓名：</div></td>
				<td width="250" align="left"><div align="left">
						<input name="name" id="name" type="text" size="30"
							class="easyui-textbox" data-options="required:true"></input>
					</div></td>
				
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">密码：</div></td>
				<td width="250"><div align="left">
						<input name="pwd" id="pwd" type="password" size="30"
							class="easyui-validatebox" data-options="required:true"></input>
					</div></td>

			</tr>
			<tr>
				<td width="80" align="right"><div align="right">确定密码：</div></td>
				<td width="250"><div align="left">
						<input name="rpwd" id="rpwd" type="password" size="30"
							class="easyui-validatebox" data-options="required:true"
							validType="equals['#pwd']"></input>
					</div></td>

			</tr>
			
			<tr>
				<td width="80" align="right"><div align="right">使用状态：</div></td>
				<td width="250"><div align="left">
						<input type="radio" name="status" id="status0"  value="0">禁用
						<input type="radio" name="status"  id="status1" value="1">启用
					</div></td>

			</tr>
			

			
			



		</table>

		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)"
				class="easyui-linkbutton updateMemberBtn">更新</a>
		</div>
		
	</form>



	<script type="text/javascript">
	$(function() {

		$(".updateMemberBtn").click(function() {
			submitProductFrom();
		});
	});
	
	$.extend($.fn.validatebox.defaults.rules, {
		equals : {
			validator : function(value, param) {
				return value == $(param[0]).val();
			},
			message : '两次输入的密码不相同.'
		}
	});

	function submitProductFrom() {
		$('#productDetailfrom').form('submit', {
			url : 'UpdateUserServlet?id=${param.id}',
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
		            url : 'GetUserServlet',
		            data : {//设置数据
		            	id : ${param.id}},
		            dataType : "json",//设置需要返回的数据类型
		            success : function(data) {
		            	//$("#id").textbox("setValue", data.id);
		            	$("#name").textbox("setValue", data.name);
		            	//$("#status").textbox("setValue", data.status);
		            	console.log(data.status);
		            	if(data.status == 1){
		            		$("#status1").attr("checked","checked");

		            		//$("#status1").checked=true;
		            	}else{
		            		$("#status0").attr("checked","checked");
		            	}
					}
				});  
			});
	</script>
</body>


</html>

