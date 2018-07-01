<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SparkMis管理系统</title>
<link rel="stylesheet" type="text/css" href="/MisMgmtMvn/css/home.css" />
<script src="/MisMgmtMvn/js/jquery-1.4.4.min.js"></script>
<script src="/MisMgmtMvn/js/artDialog.js"></script>
<script src="/MisMgmtMvn/framework/json3.js"></script>
<script src="/MisMgmtMvn/framework/Tools.js"></script>
<script type="text/javascript" src="/MisMgmtMvn/js/index.js"></script>
</head>
<body>
	
	<div id="topframe" class="topframe">
		<div class="sys_info">
			<a class="system_a" href="">系统设置</a>
			<a href="" class="system_log">注销</a>
			<a href="" class="system_logout">退出</a>
			<div class="top_about" style="display:none">	
				<a href="#" class="help1" id="btn2" onclick="openMsgWindow()">使用帮助</a>
				<a href="#" class="help2">关于</a>
			</div>
		</div>
		<div class="admin_logo">
			<img src="../images/admin_logo.jpg">
		</div>
		<div class="top_nav">
				<ul>
					<li><a href="#" >后台首页</a></li>
					<li><a href="#" class="selected">网站首页管理</a></li>
					<li><a href="../artdialog.html">菜单设置</a></li>
					<li><a href="#">文章管理</a></li>
					<li><a href="#">采集设置</a></li>
					<li><a href="#">广告管理</a></li>
					<li><a href="#">数据管理</a></li>
					<li><a href="#">用户管理</a></li>

				</ul>
		</div>
	</div>
	<div id="mainframe" class="mainframe">
		<div id="left" class="left">
			<div class="left_title">菜单列表</div>
			<div>
				<div id="menu1" class="folder">网站栏目管理</div>
				<div class="item">子菜单项</div>
				<div class="item">子菜单项</div>
				<div class="item">子菜单项</div>
				<div class="folder"  onclick="toProgram('artdialog')">测试dialog</div>
				<div class="folder" onclick="toProgram('app/em/B1EMG00001')">测试datadomClient</div>
				<div class="folder" onclick="toProgram('app/em/B1EMG00002')">测试jqgrid</div>
				<div class="folder" onclick="toProgram('ztreeindex')">测试ztree</div>
				<div class="folder" onclick="toProgram('wdatepicker')">测试datepicker</div>
				<div class="folder">jsp页面</div>
				<div class="folder">我发布的文档</div>
				<div class="folder">评论管理</div>
				<div class="folder">内容回收站</div>
				<div class="folder">jsp页面</div>
				<div class="folder">我发布的文档</div>
				<div class="folder">评论管理</div>
				<div class="folder">内容回收站</div>
				<div class="folder">内容回收站</div>
				<div class="folder">内容回收站</div>
			</div> 
		</div>
		<div id="slider" class="side_switch"></div>
		<div id="maindiv" class="maindiv">
			<IFRAME style="OVERFLOW: visible;display:none" id="port" name="port" src="" frameBorder="0" width="100%" scrolling="yes" height="100%" marginheight="0"></IFRAME>
			<IFRAME style="OVERFLOW: visible;display:block" id="main" name="main" src="/MisMgmtMvn/xlst/main.jsp"  frameBorder="0"  width="100%" scrolling="yes" height="100%" marginheight="0"></IFRAME>
			<IFRAME style="OVERFLOW: visible;display:none" id="bottom" name="bottom" src="" frameBorder="0" width="100%" scrolling="yes" height="100%"></IFRAME>
		</div>
	</div>

	<div id="bottomframe" class="bottomframe">
		<a href="#" style="">版权声明:天宇集团</a>  |  地址：长江路
	</div>
</body>
<script type="text/javascript">
//获取一级和二级菜单
// 	function  createMenu(menuData){
// 		//alert(menuData[0].count);
// 		console.log(menuData);
// 	}
	
// 	Tools.getAsyResult("","net.zx.lims.business.em.B1EMG00001","getCurrentUserMenu","","");
	function toProgram(program){
		//document.getElementById("port").atrr("src","/MisMgmtMvn/xlst/");
		//alert(program);
		document.getElementById("main").src="/MisMgmtMvn/xlst/"+program+".jsp";
	}
</script>
</html>