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
<title>客流管理</title>

</head>
<body class="easyui-layout">
	
	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowTrafficManageServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'innum',sortable:true">进店人数</th>
				<th data-options="field:'intime',sortable:true">进店时间</th>
				<th data-options="field:'outtime',sortable:true">离店时间</th>
				<th data-options="field:'type',sortable:true">需求类型</th>
				<th data-options="field:'age',sortable:true">顾客年龄</th>
				<th data-options="field:'pid',sortable:true">商品款号</th>
				<th data-options="field:'reason',sortable:true">成交与不成交原因</th>
				<th data-options="field:'diyConsultant',sortable:true">定制顾问</th>
				<th data-options="field:'note',sortable:true">备注</th>
				<th data-options="field:'userName',sortable:true">店铺名</th>
				
			</tr>
		</thead>
	</table>



 	<div id="toolbar1" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addWin()">添加</a>
		</div>
		<div>
			店铺名: <input id="userName" class="easyui-textbox" style="width:80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div> 
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

	

$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			userName : $('#userName').val(),
		});
	});
}); 
	

	    function addWin(){
	    	$('#Win').window({
	            width: 1000,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/sale/trafficAdd.jsp",
			title : "添加客流"
		});
	    }
	    
	    
	    
	</script>
</body>
</html>