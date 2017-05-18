<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String bas = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ bas + "/";
	
	String username = (String) session.getAttribute("username");
%>

<%
	if (username == null) {
		out.println("<script>alert('对不起,你还没有登录,请先登录');location.href='login.jsp'</script>");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Mark ERP管理系统</title>

<link href="<%=bas%>/css/menu.css" type="text/css" rel="stylesheet">
<link href="<%=bas%>/css/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/global.js"></script>
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/mustache.min.js"></script>
</head>


<%-- <script type="text/javascript" src="<%=bas%>/js/jquery-1.4.2.js"></script> --%>
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/demo/demo.css">
<script type="text/javascript" src="<%=bas%>/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">

	<!-- 头部 -->
	<div data-options="region:'north',border:false" style="padding: 18px">
		<%@ include file="header.jsp"%>
	</div>

	<!-- 功能菜单 -->
	<div data-options="region:'west',split:false" style="width: 157px;">
		<div class="easyui-accordion" data-options="fit:true,border:true">
			<div title="商品管理">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/product/productManager.jsp')"
						class="easyui-linkbutton"
						data-options="toggle:true,group:'g1',selected:true">商品管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/product/garageManager.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">出库管理</a></li>
					<li><a href="#" onclick="showpanel('<%=bas%>/product/order_query.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">订单管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/product/matterManage.jsp')"
						class="easyui-linkbutton"
						data-options="toggle:true,group:'g1'">物料管理</a></li>
				</ul>
			</div>
			<div title="销售管理">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/sale/turnoutmanage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">出勤管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/sale/customization.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">定制管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/sale/passenger.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">客流管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/sale/sale_check.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">盘点管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/sale/sale_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">销售管理</a></li>
				</ul>
			</div>
			<div title="会员管理">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/member/member_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">会员管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/member/member_maintain.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">客户维护</a></li>
					<%-- <li><a href="#"
						onclick="showpanel('<%=bas%>/member/member_exchange.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">积分兑换</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/member/member_message.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">群发短信</a></li> --%>
				</ul>
			</div>
			<%-- <div title="品牌管理">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/event_planning.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">活动策划</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/gift_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">礼品管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/media_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">媒介管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/brand_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">品牌管理</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/trackingprotection.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">维护跟踪</a></li>
						<li><a href="#"
						onclick="showpanel('<%=bas%>/brand/image_manage.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">形象管理</a></li>
				</ul>
			</div> --%>
			<div title="统计查询">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/statistics/summary_day.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">日汇总</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/statistics/summary_month.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">月汇总</a></li>
					
					<li><a href="#"
						onclick="showpanel('<%=bas%>/statistics/summary_year.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">年汇总</a></li>
					
				</ul>
			</div>
			<div title="业绩分析">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/analy/day.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">日环比分析</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/analy/month.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">月环比分析</a></li>
					<li><a href="#"
						onclick="showpanel('<%=bas%>/analy/year.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">年环比分析</a></li>
					
				</ul>
			</div>
			<div title="系统设置">
				<ul class="navContent">
					<li><a href="#"
						onclick="showpanel('<%=bas%>/system/register.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">用户管理</a></li>
					<%-- <li><a href="#"
						onclick="showpanel('<%=bas%>/statistics/summary_year.jsp')"
						class="easyui-linkbutton" data-options="toggle:true,group:'g1'">数据备份</a></li> --%>
					
				</ul>
			</div>
		
		</div>
	</div>


	<!-- 页脚 -->
	<div data-options="region:'south',border:false"
		style="height: 50px; padding: 10px;">
		<table id=footer cellSpacing=0 cellPadding=0 width="100%" align=center
			border=0>
			<tbody>
				<tr>
					<td align=middle>
						<div align=center>Copyright&copy；2016-2017 Your Mark. All Rights Reserved.</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div data-options="region:'center'">
		<div id="mainpanel" class="easyui-panel" fit="true" border="false"
			data-options="href:'<%=bas%>/product/productManager.jsp'"></div>
	</div>
</body>

<script type="text/javascript">
	function showpanel(url) {
		/* 更新主panel中的页面 */
		$('#mainpanel').panel('open').panel('refresh', url);
	};
</script>
</html>

