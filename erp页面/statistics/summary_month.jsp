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
<title>商品管理</title>

<%-- <script type="text/javascript" src="<%=bas%>/js/jquery-1.4.2.js"></script> --%>

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

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowSummaryMonthmanageServlet'
			,toolbar:'#toolbar1'
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'leader'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				
				
				<!-- <th data-options="field:'diyDate',sortable:true">日期</th> -->
				<th data-options="field:'strSaleMoney',sortable:true">销售额</th>
				<th data-options="field:'strImGet',sortable:true">毛利润</th>
				<th data-options="field:'strGetpercent',sortable:true">利润率</th>
				<th data-options="field:'userId',sortable:true">店铺id</th>
				<th data-options="field:'userName',sortable:true">店铺名</th>
			</tr>
		</thead>
	</table>

	<div id="productmenu" class="easyui-menu">
		<div name="detail" iconCls="icon-tip">详情</div>
	</div>

<!-- 	<div id="toolbar1" class="easyui-layout">
		<input class="easyui-datebox" style="width: 80px">
	</div> -->


 	<div id="toolbar1" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			(请任意选择想要查询的月份的日期)
		</div>
		<div>
			成交日期: <input id="diyDate" class="easyui-datebox" style="width:120px" >
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

	

$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			diyDate : $('#diyDate').datebox('getValue'),
		});
	});
});
	
	</script>
</body>

</html>

