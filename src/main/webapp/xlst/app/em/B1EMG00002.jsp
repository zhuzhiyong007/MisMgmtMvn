<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="Ieas" uri="SparkMisTag"%>
<html>
<head>
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/MisMgmtMvn/css/admin_style.css" />

<!-- jqGrid组件基础样式包-必要 -->
<link rel="stylesheet" href="/MisMgmtMvn/jqgrid/jqgrid/css/ui.jqgrid.css" />
<!-- jqGrid主题包-非必要 --> 
<!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
<link rel="stylesheet" href="/MisMgmtMvn/jqgrid/jqgrid/css/css/redmond/jquery-ui-1.8.16.custom.css" />
<!-- jquery插件包-必要 -->
<!-- 这个是所有jquery插件的基础，首先第一个引入 -->
<script type="text/javascript" src="/MisMgmtMvn/jqgrid/js/jquery-1.7.1.js"></script>
<!-- jqGrid插件包-必要 -->
<script type="text/javascript" src="/MisMgmtMvn/jqgrid/jqgrid/js/jquery.jqGrid.src.js"></script>
<!-- jqGrid插件的多语言包-非必要 -->
<!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
<script type="text/javascript" src="/MisMgmtMvn/jqgrid/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="/MisMgmtMvn/jqgrid/js/index.js"></script>	
<title>jqgrid</title>
</head>
<body onload="LiemsLoadEvent()">
	<div id="content">
		<div id="maindiv">
			<label id="id" style="width:50px">ID:</label><input type="text" width="200px"/>
			<label>RPO:</label><input type="text"/>
			<label>ORG:</label><input type="text"/>
		</div>
	
		<div class="border-bg">
			<div id="header" class="ui-widget-header" style="height:30px">
				<div id="title" style="float:left">我的表格</div>
				<div id="toolbar">操作按钮</div>
			</div>
			<table id="list2"></table>
		    <div id="pager2"></div>
		   
		</div>
	</div>
	<Ieas:DataDomClientTag/>
	<script src="/MisMgmtMvn/mispark.js"></script>
	<script src="/MisMgmtMvn/Tools.js"></script>
	<script src = "/MisMgmtMvn/xlst/app/em/B1EMG00002.js"></script>
	<!-- 	<iframe id="ServiceFrame" src="hiddenServlet?"></iframe> -->
</body>
</html>