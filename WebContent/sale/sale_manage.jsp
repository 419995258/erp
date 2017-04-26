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
<!-- <script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
<link href="../css/common.css" type="text/css" rel="stylesheet">
<style type="text/css">
body, input {
	font-family: "微软雅黑";
	font-size: 14px;
}

table, tr, th, td {
	border-collapse: collapse;
	border-spacing: 0;
	text-align: center;
	vertical-align: middle;
	line-height: 25px;
}

.box {
	width: 100%;
	margin: 5px auto auto auto;
	padding: 5px;
	height: 100%;
	float: left;
	display: none;
	margin: 5px auto auto auto; /* 默认对话框隐藏 */
}

.box.show {
	display: block;
}

.box .x {
	display: block;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("#add").click(function() {
			$("#inputbox").toggle();
		});
	});
</script> -->
</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowCustomizationServlet'
			,toolbar:'#toolbar1'
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<!-- <th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'stadiumNumber',align:'right',sortable:true">编号</th>
				<th data-options="field:'price',sortable:true">单价</th>
				<th data-options="field:'avaliable',sortable:true"
					formatter="formatAvaliable">是否可用</th>
				<th data-options="field:'descriptions'">描述</th> -->
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'pid',sortable:true">商品编号</th>
				<th data-options="field:'cid',sortable:true">会员号</th>
				<th data-options="field:'customer1'" formatter="cCname">姓名</th>
				<th data-options="field:'customer2'" formatter="cCtel">电话</th>
				<th data-options="field:'sid',sortable:true">销售编号</th>
				<th data-options="field:'diyNum',sortable:true">定制单号</th>
				<th data-options="field:'diyDate',sortable:true">定制日期</th>
				<th data-options="field:'deliverDate',sortable:true">交货日期</th>
				<th data-options="field:'quantity',sortable:true">数量</th>
				<th data-options="field:'retaPrice',sortable:true">零售价</th>
				<th data-options="field:'deposit',sortable:true">定金</th>
				<th data-options="field:'billing',sortable:true">结算</th>
				<th data-options="field:'cashier',sortable:true">收银员</th>
				<th data-options="field:'diyConsultant',sortable:true">定制顾问</th>
				<th data-options="field:'customerArchiveName',sortable:true" formatter="download">附件(顾客建档)</th>
				<th data-options="field:'note',sortable:true">备注</th>
				<!-- 	<th data-options="field:'photoLink',sortable:true">图片地址</th> -->
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
		<!-- <div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addWin()">添加</a>
		</div> -->
		<!-- <div>
			商品编号: <input id="spid" class="easyui-textbox" style="width:80px">
			负责人: <input id="sleader" class="easyui-textbox" style="width:80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div> -->
	</div>

	<div id="Win"></div>


	<script type="text/javascript">

	/* 	$(function(){
	$.ajax({
        type : "post",
        url : 'PreShowProduct_manageServlet',
        dataType : "json",//设置需要返回的数据类型
        success : function(data) {
			alert("213");
		}
	}); 
}); */

$(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			spid : $('#spid').val(),
			sleader : $('#sleader').textbox('getValue'),
		});
	});
});
	
	function download(value){
		return "<a href='DownloadDiySaleServlet?name="+value+"'>"+value+"</a>";
	}
	
	   <%--  function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#productmenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	if(item.name=='detail'){
	            		$('#Win').window({
				            width: 1000,
				            height: 400,
				            modal: true,
				            href: "<%=bas%>/product/productDetail.jsp?id="+rowData.id,
						title : "商品详情"
					});
	            	}
	            } 
	        });
	        e.preventDefault();
	    };
 --%>
	    function addWin(){
	    	$('#Win').window({
	            width: 1000,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/product/productAdd.jsp",
			title : "添加商品"
		});
	    }
	    
	    
	    function cCname(value, rowData, rowIndex) {
			return rowData["customer"].name;
		}

		function cCtel(value, rowData, rowIndex) {
			return rowData["customer"].tel;
		}
 		<%-- var toolbar = [ {
			text : '添加',
			iconCls : 'icon-add',
			
			handler : function() {
			      $('#Win').window({
			            width: 1000,
			            height: 400,
			            modal: true,
			            href: "<%=bas%>/product/productAdd.jsp",
					title : "添加商品"
				});

			}
		} ]; --%>
	</script>
</body>

</html>