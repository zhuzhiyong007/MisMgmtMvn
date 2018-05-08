<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Uimaker CMS 网站内容管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skins/tpphp.css" />
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script src="<%=basePath%>js/main.js"></script>
<script src="<%=basePath%>js/artDialog.js"></script>

</head>
<body >

	<IFRAME id="main" name="main" src="default.jsp" frameBorder=0 width="100%" scrolling="yes" height="536px"></IFRAME>
	<div class="member_info"><div class="member_ico"><img src="images/a.png" width="43" height="43"></div><a class="system_a" href="">系统设置</a><a href="" class="system_log">注销</a><a href="" class="system_logout">退出</a></div>
	<div class="left_title">常用功能操作</div>
	<ul class="side">
		<li><a href="#">网站栏目管理</a></li>
		<li><a href="#" class="selected">档案列表</a></li>
		<li><a href="#">等待审核的文档(23)</a></li>
		<li><a href="table.jsp" target="main">我发布的文档</a></li>
		<li><a href="#">评论管理</a></li>
		<li><a href="#">内容回收站</a></li>
	</ul> 
	<ul class="side catsub">
				<li class="feed"><a href="http://www.uimaker.com">网站订阅查看</a></li>
				<li class="side_about"><a href="#">版权声明</a></li>
	</ul>

</body>
</html>
