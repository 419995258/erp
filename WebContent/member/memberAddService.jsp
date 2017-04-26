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
<title>添加维护信息</title>

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
				<td width="80" align="right"><div align="right">第一次维护服务（七个工作日）：</div></td>
				<td width="250"><div align="left">
						<input name="firService" id="firService" type="text" size="30"
							class="easyui-textbox" >
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">第二次维护服务（三个月时间）：</div></td>
				<td width="250"><div align="left">
						<input name="secService" id="secService" type="text" size="30"
							class="easyui-textbox" >
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">第三次维护服务（六个月时间）：</div></td>
				<td width="250"><div align="left">
						<input name="thrService" id="thrService" type="text" size="30"
							class="easyui-textbox" >
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">第四次维护服务（一年时间）：</div></td>
				<td width="250"><div align="left">
						<input name="fouService" id="fouService" type="text" size="30"
							class="easyui-textbox" >
					</div></td>
			</tr>
			<tr>
				<td width="80" align="right"><div align="right">负责人：</div></td>
				<td width="250"><div align="left">
						<input name="serviceLeader" id="serviceLeader" type="text" size="30"
							class="easyui-textbox" >
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
				class="easyui-linkbutton updateMemberBtn">确定</a>
		</div>

	</form>



	<script type="text/javascript">
	$(function() {

		$(".updateMemberBtn").click(function() {
			submitProductFrom();
		});
	});

	function submitProductFrom() {
		$('#productDetailfrom').form('submit', {
			url : 'UpdateCustomerServiceServlet?id=${param.id}',
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
		            	
		            	$("#firService").textbox("setValue", data.firService);
		            	$("#secService").textbox("setValue", data.secService);
		            	$("#thrService").textbox("setValue", data.thrService);
		            	$("#fouService").textbox("setValue", data.fouService);
		            	$("#serviceLeader").textbox("setValue", data.serviceLeader);
		            	$("#note").textbox("setValue", data.note);
		            
					}
				});  
			});
	</script>
</body>


</html>

