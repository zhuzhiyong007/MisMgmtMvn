<%@page import="java.lang.reflect.Method"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<%
	//设置输出不缓存
	response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
	
	String params = request.getParameter("params");
	String className = request.getParameter("className");
	String method = request.getParameter("method");
	
	//参数转码
	Object obj = Class.forName(className).newInstance();
	Method md = obj.getClass().getMethod(method,java.lang.String.class,javax.servlet.http.HttpServletRequest.class);
	String rs =(String)md.invoke(obj,params,request);
	response.getWriter().write(rs);
	//out.write(rs);
%>
