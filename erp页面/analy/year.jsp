<%@page import="java.awt.Font"%>
<%@page import="org.jfree.chart.StandardChartTheme"%>
<%@page import="org.jfree.data.general.DefaultPieDataset"%>
<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.JFreeChart"%>
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
<title>日环比</title>



</head>
<body>

	<div>
		日期: <input class="Wdate" id="queryDate" type="text" size="35"
			onFocus="WdatePicker({dateFmt:'yyyy'})" readonly="readonly" />
		<button onclick="query()">搜索</button>
	</div>


	
	<!-- 步骤6：显示3D饼状图 -->
	<center>
		<img id="image" alt="日汇总" src="">
	</center>


	<script type="text/javascript">
		function query() {
			message = $("#queryDate").val();
			if (verifyIsNull(message)) {
				alert("填写日期");
				return;
			}
			$.ajax({
				type : 'POST',
				url : "AnalyYearServlet",
				data : "message=" + message,
				dataType: "json",
				success : function(data) {
					console.log(data);
					console.log(data.first);
					console.log(data.secord);
					$("#image").attr("src",data.first);
				}
			});
		}

		
	</script>
</body>

</html>

