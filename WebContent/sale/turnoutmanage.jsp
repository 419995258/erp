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
<title>出勤管理</title>

</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowAttendServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'name',sortable:true">姓名</th>
				<th data-options="field:'nowdate',sortable:true">当前月份</th>
				<th data-options="field:'attendday',sortable:true">出勤天数</th>
				<th data-options="field:'passday',sortable:true">事假天数</th>
				<th data-options="field:'restday',sortable:true">休息天数</th>
				<th data-options="field:'sickday',sortable:true">病假天数</th>
				<th data-options="field:'leaveday',sortable:true">旷工天数</th>
				<th data-options="field:'allday',sortable:true">月总天数</th>
				<th data-options="field:'lateday',sortable:true">迟到</th>
				<th data-options="field:'inday',sortable:true">早退</th>
				<th data-options="field:'overday',sortable:true">加班</th>
				<th data-options="field:'leader',sortable:true">考勤员</th>
				<th data-options="field:'surer',sortable:true">负责人确认</th>
				<th data-options="field:'note',sortable:true">备注</th>
				<th data-options="field:'user_id',sortable:true">店铺id</th>
				<th data-options="field:'user_name',sortable:true">店铺名称</th>
			</tr>
		</thead>
	</table>


	<div id="toolbar1" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="addWin()">添加</a>
		</div>
		<div>
			姓名: <input id="name" class="easyui-textbox" style="width:80px">
			
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">


	$(function(){
		$("#findProductBtn").click(function() {
			// 更新表格中的数据（携带参数），还是访问原servlet
			$('#productGrid').datagrid('load', {
				name : $('#name').val(),
			});
		});
	});
		
		    function addWin(){
		    	$('#Win').window({
		            width: 1200,
		            height: 400,
		            modal: true,
		            href: "<%=bas%>/sale/attendAdd.jsp",
				title : "添加考勤"
			});
		    }
		    
	</script>
</body>

</html>

