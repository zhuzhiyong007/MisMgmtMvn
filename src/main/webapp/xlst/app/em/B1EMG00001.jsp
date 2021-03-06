<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="Ieas" uri="SparkMisTag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/MisMgmtMvn/css/admin_style.css" />
<script src="/MisMgmtMvn/js/jquery-1.4.4.min.js"></script>
<script src="/MisMgmtMvn/js/iframe.js"></script>
<Ieas:ComponentTag title="getProgramTitle"/>
</head>
<body onload="LiemsLoadEvent()"><!-- onLoad="LiemsLoadEvent()" -->
	<Ieas:TabsTag/>
	<Ieas:DataDomInitTag/>
	<h1>B1EMG00001JSP</h1>
	<div>
		<form action="FrontServlet" method="post" onSubmit="">
			<input id="dom" type="hidden"></input>
			<input id="prams" type="hidden"></input>
			<div><label>程序号:</label><input id="pgmNo" type="text" name="pgmNo"/></div>
			<div><label>主键:</label><input id="pkValue" type="text" name="pkValue"/></div>

			<div style="margin:right">
				<input type="submit"/>
				<input type="reset"/>
			</div>
			
			<Ieas:Grid9DefineTag>
			</Ieas:Grid9DefineTag>
		</form>
	</div>
	
	<Ieas:DataDomClientTag/>
		
	<script src="/MisMgmtMvn/mispark.js"></script>
	<script src="/MisMgmtMvn/Tools.js"></script>
	<script src = "/MisMgmtMvn/xlst/app/em/B1EMG00001.js"></script>
<!-- 	<iframe id="ServiceFrame" src="hiddenServlet?"></iframe> -->
</body>
</html>