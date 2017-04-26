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
<title>日销售分析</title>



</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowSummaryDaymanageServlet'
			,toolbar:'#toolbar1'
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'sid'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<th data-options="field:'sid',sortable:true">销售号</th>
				<th data-options="field:'strSaleMoney',sortable:true">销售额</th>
				<th data-options="field:'strImGet',sortable:true">毛利润</th>
				<th data-options="field:'cashier',sortable:true">收银人员</th>
				<th data-options="field:'sid',sortable:true">销售编号</th>
				<th data-options="field:'note',sortable:true">备注</th>
				<th data-options="field:'diyDate',sortable:true">成交日期</th>
				<th data-options="field:'userName',sortable:true">店铺名</th>
				
			</tr>
		</thead>
	</table>


 	<div id="toolbar1" style="padding:5px;height:auto">
		
		<div>
			成交日期: <input id="diyDate" class="easyui-datebox" style="width:120px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			/* diyDate : $('#diyDate').val() */
			diyDate : $('#diyDate').datebox('getValue')
		});
	});
});
	
	   
	</script>
</body>

</html>

