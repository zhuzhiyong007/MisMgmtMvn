<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	
	<div name="top"></div>
	<div name="main">
		<div name="left">
			<div id="tree1">
				<div class="ui-dynatree-container">
				<span id="ui-dynatree-id-root" class="ui-dynatree-folder ui-dynatree-expanded ui-dynatree-has-children ui-dynatree-lastsib ui-dynatree-exp-el ui-dynatree-ico-ef"><span class="ui-dynatree-icon"></span>
				<a href="#" class="ui-dynatree-title">All Regions</a></span>
				<div>
					<span id="ui-dynatree-id-_1" class="ui-dynatree-document ui-dynatree-lastsib ui-dynatree-statusnode-wait ui-dynatree-exp-cl ui-dynatree-ico-c">
						<span class="ui-dynatree-empty"></span>
						<span class="ui-dynatree-connector"></span>
						<span class="ui-dynatree-icon"></span>
						<a href="#" class="ui-dynatree-title">Loading…</a>
					</span>
				</div>
				</div>
			</div>
			<ul id="ctxMenu1" class="ctxMenu hidden">
				<li action="insert" class="add item clear">
				<span style="display: block">
					<span class="icon icon-plus"></span>
					<span>Add Region</span>
				</span>
				</li>
				<li action="update" class="edit item clear">
					<span style="display: block">
						<span class="icon icon-pencil"></span>
						<span>Edit Region</span>
					</span>
				</li>
				<li action="delete" class="delete item clear">
					<span style="display: block">
						<span class="icon icon-minus"></span>
						<span>Delete Region</span>
					</span>
				</li>
			</ul>
		</div>
		<div name="middle">
		<form action="FrontServlet" method="post" onSubmit="">
			<div><label>程序号:</label><input id="pgmNo" type="text" name="pgmNo"/></div>
			<div><label>主键:</label><input id="pkValue" type="text" name="pkValue"/></div>

			<div style="margin:right">
				<input type="submit"/>
				<input type="reset"/>
			</div>
		</form>
		</div>
		<div name="right">
			<IFRAME style="OVERFLOW: visible" id="content" name="content" src="default.jsp" frameBorder=0 width="100%" scrolling="yes" height="100%"></IFRAME>
		</div>
	</div>
	<div name="botom"></div>
</body>
</html>