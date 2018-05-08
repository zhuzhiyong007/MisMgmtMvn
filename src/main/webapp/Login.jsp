<%@page import="net.zx.lims.business.em.B1EMG00001"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="Ieas" uri="SparkMisTag"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<html>
<head>
<title>SparkMis管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css"/>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>

<script>
	
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

// function validate(f){
// 	return true;
// }

// 	function getCookie(c_name)
// 	{
// 		if (document.cookie.length>0)
// 		{ 
// 			c_start=document.cookie.indexOf(c_name + "=")
// 			if (c_start!=-1)
// 			{ 
// 				c_start=c_start + c_name.length+1 
// 				c_end=document.cookie.indexOf(";",c_start)
// 				if (c_end==-1) c_end=document.cookie.length
// 				return unescape(document.cookie.substring(c_start,c_end))
// 			} 
// 		}
// 		return ""
// 	}
	
// 	function setCookie(c_name,value,expiredays)
// 	{
// 		var exdate=new Date()
// 		exdate.setDate(exdate.getDate()+expiredays)
// 		document.cookie=c_name+ "=" +escape(value)+
// 		((expiredays==null) ? "" : "; expires="+exdate.toGMTString())
// 	}
	
// 	function checkCookie()
// 	{
// 		username=getCookie('username')
// 		if (username!=null && username!="")
// 		  {alert('Welcome again '+username+'!')}
// 		else 
// 		  {
// 		  username=prompt('Please enter your name:',"")
// 		  if (username!=null && username!="")
// 		    {
// 		    setCookie('username',username,365)
// 		    }
// 		  }
// 	}

	$(function(){
		var _select=$('.select');
		_select.click(function(){
			$(this).find('ul').show();
		})

		$('.select li').click(function(){
			var eid=$(this).attr('eid');
			//var eid_input='<input type="hidden" value="'+eid+'" name="eid" id="eid" \/>';
			var _eidhtml=$(this).html();
			$('.eid_value').html(_eidhtml); //设置显示的p
			if($('#eid').attr('value')){
				$('#eid').attr('value',eid);	//设置input
			}
			
		})
		$('.select ul').hover(function(){
			
		},function(){
			$(this).hide();
		})
	})
	
</script>

</head>
<body >

	<%-- <%
		B1EMG00001 b1 = new B1EMG00001();
		b1.init();
	%> --%>
	<!-- 
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
	 -->
	 
	<div class="login">
		<div class="login_form">
		<form action="UserLogin" method="post">
				<div class="login_info">
					<div class="login_info_title">选择登录版本：</div>
					<div class="select">
						<p class="eid_value">中文版</p>
						<ul>
							<li eid="english">English</li>
							<li eid="chinese">中文版</li>
						</ul>
						<input type="hidden" value="chinese" name="eid" id="eid" />
					</div>
				</div>
				<div class="form_info">
					<div class="field">
						<label>用户名：</label>
						<input name="userName" type="text" class="text" size="20" value="sys">
					</div>
					<div class="field">
						<label>密　码：</label>
						<input id="password" name="password" type="password" class="text" size="20">
					</div>
					<div class="field">
						<label>验证码：</label>
						<input type="text" class="text" size="10">
	                    <cite class="yzm">3986</cite>
					</div>
					<div class="field">
						<label></label>
						<button class="button" style="margin-left:50px;_margin-left:48px" onclick="submit"></button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>