<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Uimaker CMS 网站内容管理系统</title>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<style>
	div{flaot:left;display:inline}
	.div-inline{ display:inline} 
</style>
</head>
<body>
	<div style="left:50%">
		<div class="div-inline">
			<a href="#">版权声明:天宇集团</a>  |  地址：长江路
		</div>
	</div>

</body>
</html>
