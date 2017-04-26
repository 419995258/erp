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
<title>出库管理</title>

</head>
<body class="easyui-layout">

	<table id="garageGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowGarage_manageServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'barCode'">条形码</th>

				<th data-options="field:'product1'" formatter="pPid">款号</th>

				<th data-options="field:'product2'" formatter="pName">商品</th>

				<th data-options="field:'receiveDept'">签收部门</th>
				<th data-options="field:'receiver'">签收人</th>
				<th data-options="field:'receiveTime'">签收时间</th>
				<!-- 商品信息 -->
				<th data-options="field:'product3'" formatter="pSize">规格</th>
				<th data-options="field:'product4'" formatter="productWeight">金重(k)</th>
				<th data-options="field:'product5'" formatter="productSubStone">配石(ct)</th>
				<th data-options="field:'product6'" formatter="productMainStone">主石(ct)</th>
				<th data-options="field:'product7'" formatter="productGoldCost">金费</th>
				<th data-options="field:'product8'" formatter="productHandCost">工费</th>

				<th data-options="field:'quantity'">数量</th>
				<th data-options="field:'retaPrice'">价格</th>
				<th data-options="field:'note'">备注</th>
			</tr>
		</thead>
	</table>


	<div id="toolbar1" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="addWin()">添加</a>
		</div>
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

	
	
	    function addWin(){
	    	$('#Win').window({
	            width: 1000,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/product/garageAdd.jsp",
				title : "添加出库信息"
			});
		}

		function pPid(value, rowData, rowIndex) {
			return rowData["product"].pid;
		}

		function pName(value, rowData, rowIndex) {
			return rowData["product"].name;
		}

		function pSize(value, rowData, rowIndex) {
			return rowData["product"].size;
		}

		function productWeight(value,rowData,rowIndex) {
			return rowData["product"].weight;
		};
		
		function productSubStone(value,rowData,rowIndex) {
			return rowData["product"].subStone;
		};
		
		function productMainStone(value,rowData,rowIndex) {
			return rowData["product"].mainStone;
		};
		
		function productGoldCost(value,rowData,rowIndex) {
			return rowData["product"].goldCost;
		};
		
		function productHandCost(value,rowData,rowIndex) {
			return rowData["product"].handCost;
		}; 
	</script>
</body>

</html>

