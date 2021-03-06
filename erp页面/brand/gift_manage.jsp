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
<title>礼品管理</title>


</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowProduct_manageServlet'
			,toolbar:'#toolbar1'
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'id'
			,sortOrder:'asc'
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
				<th data-options="field:'GMdepart',sortable:true">申请部门：</th>
				<th data-options="field:'GMtime',sortable:true">申请时间：</th>
				<th data-options="field:'GMhead',sortable:true">申请人：</th>
				<th data-options="field:'GMcustomer',sortable:true">顾客信息：</th>
				<th data-options="field:'GMcustomerTel',sortable:true">顾客电话</th>
				<th data-options="field:'GMname',sortable:true">礼品名称</th>
				<th data-options="field:'GMnum',sortable:true">礼品数量：</th>
				<th data-options="field:'GMprice',sortable:true">礼品价格：</th>
				<th data-options="field:'GMinstruction',sortable:true">用途说明：</th>
				<th data-options="field:'GMapproval',sortable:true">审批人：</th>
				<th data-options="field:'Gnotes',sortable:true">备注</th>
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
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addWin()">添加</a>
		</div>
		<div>
			商品编号: <input id="spid" class="easyui-textbox" style="width:80px">
			负责人: <input id="sleader" class="easyui-textbox" style="width:80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
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
	
	    function showRowContextMenu(e, rowIndex, rowData) { //右键操作
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

	    function addWin(){
	    	$('#Win').window({
	            width: 1000,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/product/productAdd.jsp",
			title : "添加商品"
		});
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

