<%@page import="net.zx.lims.business.em.B1EMG00001"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="ieas" uri="SparkMisTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SparkMis</title>

<script type="text/javascript">
	
// 	function validate(f){
// 		if(!(/^\w{5,15}$/.test(f.userid.value))){
// 			alert("用户ID必须是5~15位！") ;
// 			f.userid.focus() ;
// 			return false ;
// 		}
// 		if(!(/^\w{5,15}$/.test(f.userpass.value))){
// 			alert("密码必须是5~15位！") ;
// 			f.userpass.focus() ;
// 			return false ;
// 		}
// 	}

function validate(f){
	return true;
}

	function getCookie(c_name)
	{
		if (document.cookie.length>0)
		{ 
			c_start=document.cookie.indexOf(c_name + "=")
			if (c_start!=-1)
			{ 
				c_start=c_start + c_name.length+1 
				c_end=document.cookie.indexOf(";",c_start)
				if (c_end==-1) c_end=document.cookie.length
				return unescape(document.cookie.substring(c_start,c_end))
			} 
		}
		return ""
	}
	
	function setCookie(c_name,value,expiredays)
	{
		var exdate=new Date()
		exdate.setDate(exdate.getDate()+expiredays)
		document.cookie=c_name+ "=" +escape(value)+
		((expiredays==null) ? "" : "; expires="+exdate.toGMTString())
	}
	
	function checkCookie()
	{
		username=getCookie('username')
		if (username!=null && username!="")
		  {alert('Welcome again '+username+'!')}
		else 
		  {
		  username=prompt('Please enter your name:',"")
		  if (username!=null && username!="")
		    {
		    setCookie('username',username,365)
		    }
		  }
	}
</script>

</head>
<body >

	<%-- <%
		B1EMG00001 b1 = new B1EMG00001();
		b1.init();
	%> --%>
	<div>
		<form action="UserLogin" method="post" onSubmit="return validate(this)">
			<div><label>账号:</label><input id="name" type="text" name="name"/></div>
			<div><label>密码:</label><input id="password" type="text" name="password"/></div>
			<div><label>密码:</label><input id="password2" type="text" name="password2"/></div>
			<div style="margin:right">
				<input type="submit"/>
				<input type="reset"/>
			</div>
		</form>
	</div>

	
	
	<script src="mispark.js"></script>
	
</body>
</html>