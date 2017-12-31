<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>B1EMG00001JSP</h1>
	<div>
		<form action="FrontServlet" method="post" onSubmit="">
			<div><label>程序号:</label><input id="pgmNo" type="text" name="pgmNo"/></div>
			<div><label>主键:</label><input id="pkValue" type="text" name="pkValue"/></div>

			<div style="margin:right">
				<input type="submit"/>
				<input type="reset"/>
			</div>
		</form>
	</div>
</body>
</html>