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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点管理</title>
<base href="<%=bas%>">

</head>
<body class="easyui-layout">

<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowCheckManageServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'pid',sortable:true">商品编号</th>
				<th data-options="field:'name',sortable:true">商品名称</th>
				<th data-options="field:'superPlatPeople',sortable:true">监盘人</th>
				<th data-options="field:'inventoryPeople',sortable:true">盘点人</th>
				<th data-options="field:'inventoryTime',sortable:true">盘点时间</th>
				<th data-options="field:'quantity',sortable:true">系统库存</th>
				<th data-options="field:'inventoryStock',sortable:true">盘点库存</th>
				<th data-options="field:'changeStock',sortable:true">库存差异</th>
				<th data-options="field:'note',sortable:true">备注</th>
			</tr>
		</thead>
	</table>



 	<div id="toolbar1" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addWin()">添加</a>
		</div>
		<div>
			商品编号: <input id="pid" class="easyui-textbox" style="width:80px">
			商品名称: <input id="name" class="easyui-textbox" style="width:80px">
			盘点人: <input id="inventoryPeople" class="easyui-textbox" style="width:80px">
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
			name : $('#name').textbox('getValue'),
			inventoryPeople : $('#inventoryPeople').val()
		});
	});
});
	

	    function addWin(){
	    	$('#Win').window({
	            width: 1000,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/sale/checkAdd.jsp",
			title : "添加盘点"
		});
	    }
	    
	    
	    
 	
	</script>
</body>
</html>