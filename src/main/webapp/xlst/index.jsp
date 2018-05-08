<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SparkMis管理系统</title>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
</head>
<body>
	
	<div name="top">
		
	</div>
	<div name="middle">
		<div id="left" width=>
			<IFRAME style="OVERFLOW: visible" id="menu" name="menu" src="<%=basePath%>xlst/tree.html" frameBorder=0 width="100%" scrolling="yes" height="100%"></IFRAME>
		</div>
		<div id="main">
			<IFRAME style="OVERFLOW: visible" id="main" name="main" src="table.jsp" frameBorder=0 width="100%" scrolling="yes" height="100%"></IFRAME>
		</div>
	</div>
	</div>
	<div name="botom">
		<IFRAME style="OVERFLOW: visible" id="main" name="main" src="<%=basePath%>main.jsp" frameBorder=0 width="100%" scrolling="yes" height="100%"></IFRAME>
	</div>
</body>
</html>