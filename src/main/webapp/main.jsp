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
<script>
function openMsgWindow() {
	art.dialog({
		id:'msgDialog',
		title: '提示信息',
		lock:false,
		fixed:true,
		width:300,
		height:100,
		ok: function(){
			this.title('成功提示！').content('操作成功！').time(2);
			return false;
		 },
		 cancel: function(){
			
			return true;
		 },
		content: "<div style='line-height:25px'>您有新的站内信<Br><a href=\"http://www.uimaker.com\">点此阅读</a></div>"
	});
}

function toPgm(){
	$("#main").attr("src","<%=basePath%>FrontServlet?pgmNo=B1EMG00001");
}
</script>
</head>
<body >
<div class="top">
	<div class="member_info">
		<div class="member_ico">
 			<img src="images/a.png" width="43" height="43">
		</div>
		<a class="system_a" href="">系统设置</a>
		<a href="" class="system_log">注销</a>
		<a href="" class="system_logout">退出</a>
		<div class="top_about" style="display:none">	
			<a href="#" class="help1" id="btn2" onclick="openMsgWindow()">使用帮助</a>
			<a href="#" class="help2">关于</a>
		</div>
	</div>

	<div class="admin_logo">
		<img src="images/admin_logo.jpg">
	</div>
	<div class="top_nav">
			<ul>
				<li><a href="#" >后台首页</a></li>
				<li><a href="#" class="selected" >网站首页管理</a></li>
				<li><a href="#">菜单设置</a></li>
				<li><a href="#">文章管理</a></li>
				<li><a href="#">采集设置</a></li>
				<li><a href="#">广告管理</a></li>
				<li><a href="#">数据管理</a></li>
				<li><a href="#">用户管理</a></li>
				<li><a href="#">系统设置</a></li>
			</ul>
	</div>
</div>
<div class="side_switch" id="side_switch">
</div>
<div class="side_switchl" id="side_switchl">
</div>
<div class="left" style="height:625px">
	<div class="left_title">常用功能操作</div>
	<ul class="side">
		<li><label>网站栏目管理</label></li>
		<li><label class="selected">档案列表</label></li>
		<li><label onclick="toPgm()">jsp页面</label></li>
		<li><label>我发布的文档</label></li>
		<li><label>评论管理</label></li>
		<li><label>内容回收站</label></li>
	</ul> 
</div>
<div class="right">
	<IFRAME id="main" name="main" src="default.jsp" frameBorder=0 width="100%" scrolling="yes" style="height:625px"></IFRAME>
</div>
<div id="bottom" style="height:30px">
	<a href="#">版权声明:天宇集团</a>  |  地址：长江路
</div>
</body>
</html>
