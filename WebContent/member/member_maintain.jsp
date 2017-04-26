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
<title>会员维护</title>

</head>
<body class="easyui-layout">

	<table id="productGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:false
			,singleSelect:true
			,method:'get'
			,url:'PreShowMember_maintainServlet'
			,toolbar:'#toolbar1'
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'id'
			,sortOrder:'desc'
			,remoteSort:false
			">
			
		<thead>
			<tr>
				<th data-options="field:'id',sortable:true">会员号</th>
				
				<th data-options="field:'name'">顾客姓名</th>
				<th data-options="field:'tel',sortable:true">联系方式</th>
				<th data-options="field:'firService'">第一次维护服务（七个工作日）</th>
				<th data-options="field:'secService'">第二次维护服务（三个月时间）</th>
				<th data-options="field:'thrService'">第三次维护服务（六个月时间）</th>
				<th data-options="field:'fouService'">第四次维护服务（一年时间）</th>
				<th data-options="field:'serviceLeader'">负责人</th>
				<th data-options="field:'note'">备注</th>
			</tr>
		</thead>
	</table>

	<div id="productmenu" class="easyui-menu">
		<div name="detail" iconCls="icon-tip">详情</div>
	</div>


 	<div id="toolbar1" style="padding:5px;height:auto">
		
		<div>
			会员编号: <input id="scid" class="easyui-textbox" style="width:80px">
			会员姓名: <input id="sname" class="easyui-textbox" style="width:80px">
			会员电话：<input id="stel" class="easyui-textbox" style="width:80px">
			<a id="findProductBtn" href="#" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		</div>
		
	</div>
	<div id="Win"></div>


	<script type="text/javascript">



 $(function(){
	$("#findProductBtn").click(function() {
		// 更新表格中的数据（携带参数），还是访问原servlet
		$('#productGrid').datagrid('load', {
			scid : $('#scid').val(),
			sname : $('#sname').textbox('getValue'),
			stel:$('#stel').textbox('getValue'),
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
				            href: "<%=bas%>/member/memberAddService.jsp?id="+rowData.id,
						title : "会员维护"
					});
	            	}
	            } 
	        });
	        e.preventDefault();
	    };

	    
	    
	    
	 
	</script>
</body>

</html>

