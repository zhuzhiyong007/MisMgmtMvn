<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Uimaker CMS 网站内容管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
	var _select=$('.select');
		_select.click(function(){
			$(this).find('ul').show();
		})

		$('.select li').click(function(){
			var eid=$(this).attr('eid');
			var eid_input='<input type="hidden" value="'+eid+'" name="eid" id="eid" \/>';
			var _eidhtml=$(this).html();
			$('.eid_value').html(_eidhtml);
			if($('#eid').attr('value')){
				$('#eid').attr('value',eid);	
			}
			
		})
		$('.select ul').hover(function(){
			
		},function(){
			$(this).hide();
		})
	})
</script>
</head>
<body>
	<div class="login">
		<div class="login_form">
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
					<input type="text" class="text" size="20">
				</div>
				<div class="field">
					<label>密　码：</label>
					<input type="password" class="text" size="20">
				</div>
				<div class="field">
					<label>验证码：</label>
					<input type="text" class="text" size="10">
                    <cite class="yzm">3986</cite>
				</div>
				<div class="field">
					<label></label>
					<button class="button" style="margin-left:50px;_margin-left:48px" onclick="javascript:window.location='main.html'"></button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>