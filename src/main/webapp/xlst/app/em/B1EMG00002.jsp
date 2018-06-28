<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/MisMgmtMvn/css/admin_style.css" />

<!-- jqGrid组件基础样式包-必要 -->
<link rel="stylesheet" href="/MisMgmtMvn/framework/jquery.jqGrid-3.8.2/css/ui.jqgrid.css" />
<!-- jqGrid主题包-非必要 --> 
<!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
<link rel="stylesheet" href="/MisMgmtMvn/framework/jquery.jqGrid-3.8.2/css/ui-lightness/jquery-ui-1.8.16.custom.css" />
<!-- jquery插件包-必要 -->
<!-- 这个是所有jquery插件的基础，首先第一个引入 -->
<script type="text/javascript" src="/MisMgmtMvn/js/jquery-1.7.1.js"></script>
<!-- jqGrid插件包-必要 -->
<script type="text/javascript" src="/MisMgmtMvn/framework/jquery.jqGrid-3.8.2/js/jquery.jqGrid.src.js"></script>
<!-- jqGrid插件的多语言包-非必要 -->
<!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
<script type="text/javascript" src="/MisMgmtMvn/framework/jquery.jqGrid-3.8.2/js/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="/MisMgmtMvn/js/index.js"></script>
<title>jqgrid</title>
</head>
<body onload="LiemsLoadEvent()">
	<div id="content">
		<div id="maindiv">
			<label id="id" style="width:50px">ID:</label><input type="text" width="200px"/>
			<label>RPO:</label><input type="text"/>
			<label>ORG:</label><input type="text"/>
		</div>
	

	</div>
	
	<script src="/MisMgmtMvn/mispark.js"></script>
	<script src="/MisMgmtMvn/Tools.js"></script>
	<script src = "/MisMgmtMvn/xlst/app/em/B1EMG00002.js"></script>
	<!-- 	<iframe id="ServiceFrame" src="hiddenServlet?"></iframe> -->
</body>
</html>