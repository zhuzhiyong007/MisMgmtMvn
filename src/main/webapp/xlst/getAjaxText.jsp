<%@page import="java.lang.reflect.Method"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String params = request.getParameter("params");
	String className = request.getParameter("className");
	String method = request.getParameter("className");
	Object obj = Class.forName(className).newInstance();
	Method md = obj.getClass().getMethod(method);
	//String rs =(String)md.invoke(obj, new Object[]{java.lang.String.class,http.serlet.httpServletRequest.class});
	//response.output(rs);
%>

</body>
</html>