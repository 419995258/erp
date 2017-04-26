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
<title>订单管理</title>



</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowOrder_manageServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'pid'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>

				<th data-options="field:'pid',sortable:true">商品编号</th>
				<th data-options="field:'diyNum',sortable:true">定制单号</th>
				<th data-options="field:'name'">客户姓名</th>
				<th data-options="field:'tel'">联系方式</th>
				<th data-options="field:'diyDate',sortable:true">定制日期</th>
				<th data-options="field:'deliverDate',sortable:true">交货日期</th>
				<th data-options="field:'weight',sortable:true">金量</th>
				<th data-options="field:'subStone',sortable:true">配石</th>
				<th data-options="field:'mainStone',sortable:true">主石</th>
				<th data-options="field:'goldCost',sortable:true">金费</th>
				<th data-options="field:'handCost',sortable:true">工费</th>
				<th data-options="field:'quantity',sortable:true">数量</th>
				<th data-options="field:'cost',sortable:true">成本价</th>
				<th data-options="field:'billing',sortable:true">成交价</th>
			</tr>
		</thead>
	</table>


	<div id="toolbar1" style="padding: 5px; height: auto">
		<div>
			商品编号: <input id="pid" class="easyui-textbox" style="width: 80px">
			定制单号: <input id="diyNum" class="easyui-textbox" style="width: 80px">
			联系方式：<input id="tel" class="easyui-textbox" style="width: 80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton"
				iconCls="icon-search">搜索</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			pid : $('#pid').val(),
			diyNum : $('#diyNum').textbox('getValue'),
			tel : $('#tel').val(),
		});
	});
});
	
	   
	    
	    
	
	</script>
</body>

</html>

