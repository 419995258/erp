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
<title>物料管理</title>

</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowMattertManageServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'pid'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<th data-options="field:'pid',sortable:true">商品编号</th>
				<th data-options="field:'name',sortable:true">名称</th>
				<th data-options="field:'size',sortable:true">规格</th>
				<th data-options="field:'receiveDept',sortable:true">部门</th>
				<th data-options="field:'receiver',sortable:true">签收人</th>
				<th data-options="field:'receiveTime',sortable:true">签收时间</th>
				<th data-options="field:'quantity',sortable:true">数量</th>
				<th data-options="field:'retaPrice',sortable:true">零售价</th>
				<th data-options="field:'allMoney',sortable:true">合计</th>
				<th data-options="field:'note',sortable:true">备注</th>
			</tr>
		</thead>
	</table>

	<div id="productmenu" class="easyui-menu">
		<div name="detail" iconCls="icon-tip">详情</div>
	</div>

 	<div id="toolbar1" style="padding:5px;height:auto">
		<div>
			商品编号: <input id="pid" class="easyui-textbox" style="width:80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

	
$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			pid : $('#pid').val(),
		});
	});
});	    
	    
	</script>
</body>

</html>

