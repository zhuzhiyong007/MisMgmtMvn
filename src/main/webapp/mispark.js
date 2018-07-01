



function Dom(){
	if(domObj==undefined){
		return;
	}
	this.domObj=domObj;
	return this;
}

function LimesDom(){
//	if(dom!=undefined){
//		Dom.call(this);
//	}
}


function toString(){
	function serializeDOM(xmldoc){//将DOM对象序列化成XML字符串
	    if (xmldoc.xml) {//IE
	        return xmldoc.xml;
	    }
	    else if (window.XMLSerializer) {//FF
	        var seria = new XMLSerializer();
	        return seria.serializeToString(xmldoc);
	    }
	    return null;
	}

	
}

LimesDom.prototype.dom= new Dom();
LimesDom.prototype.loadXMLString=loadXMLString;
LimesDom.prototype.loadXMLDoc=loadXMLDoc;
LimesDom.prototype.toString=toString;
var liemsDom = new LimesDom();
//console.log(liemsDom);
//var title = domObj.getElementsByTagName("price")[0];
//alert(title.childNodes[0].nodeValue); 


//try
//{
//	var liemsDom = new Object();
//	
//	
//	 var x=document.getElementById("demo").value;
//	  if(x=="")    throw "empty";
//	  if(isNaN(x)) throw "not a number";
//	  if(x>10)     throw "too high";
//	  if(x<5)      throw "too low";
//
//
//}catch(err)
//{
//	  txt="There was an error on this page.\n\n";
//	  txt+="Error description: " + err.message + "\n\n";
//	  txt+="Click OK to continue.\n\n";
//	  alert(txt);
//
//}
  

//LiemsDom
function getLiemsDomValue(table,feild){
	
}

function addPageInfo(table,type,message){
	
	
}



//foreign
function Foregin(obj){
	this.addParam=addParam;
	this.getReturnValue=getReturnValue;
}

//service
function Service(serviceName,params,owner,serviceForm,postType){
	this.serviceName = serviceName;
	this.params = params;
	this.owner = owner;
	this.serviceForm = serviceForm;
	var url = "/MisMgmtMvn/ServiceAgent?";
	var toFrame;
	//this.target="main";
	
	if(postType==null){
		postType="POST";
	}
	if(owner){
		console.log("ys");
		//隐式调用
		if(serviceForm==null){
			this.serviceForm = document.getElementById("LIEMSFORM");
		}else{
			this.serviceForm = document.getElementById("form")[i];
		}
		
		//toFrame=document.getElementById("port");
		toFrame="ServiceFrame";
		this.serviceForm.target=toFrame;
		console.log(toFrame);
	}else{
		console.log("xs");
		//显示调用
		if(serviceForm==null){
			this.serviceForm = document.getElementById("LIEMSFORM");
		}else{
			this.serviceForm = document.getElementById("form")[i];
		}
		
		
	}
	
	this.serviceForm.action=url;
	this.serviceForm.method=postType;
	
	//给隐式提交附加dom，serviceName和params等参数
	$("#serviceName").val(serviceName);
	$("#dataDom").attr("value",serviceName);
	this.serviceForm.owner.value=this.owner;
	//$("#params").innerHtml=paramsDiv;

	
}

function submit(){
	this.beforeSubmitCheck();
	this.serviceForm.submit();
}
function addParam(name,value){
	this.name=name;
	this.value=value;
}
function beforeSubmitCheck(){

}


Service.prototype.submit=submit;
Service.prototype.addParam=addParam;
Service.prototype.beforeSubmitCheck=beforeSubmitCheck;


function serviceValue(returnMethod){
	alert(returnMethod);
	eval("window."+returnMethod+"_setServiceValue");
}


//閹垮秳缍攄om閼哄倻鍋�
function createElement(){
	var para=document.createElement("p");
	var node=document.createTextNode("鏉╂瑦妲搁弬鐗堫唽閽�濮愶拷锟�");
	para.appendChild(node);

	var element=document.getElementById("div1");
	element.appendChild(para);
}

function removeElement(){
	var parent=document.getElementById("div1");
	var child=document.getElementById("p1");
	parent.removeChild(child);
}


//閹垮秳缍旈崨鎴掓姢
function param(name,method)
{
	var index=0;
	this.params=new Array();
	
	this.addParm=addParm;
	function addParm(name)
	{
		this.params[index++]=name;
	}
}

/**
 * 加载xml文档
 * @param fileName
 * @returns
 */
//function loadXMLDoc(fileName) {
//	var xmlDoc ="";
//	try // Internet Explorer
//	{
//		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
//	} catch (e) {
//		try // Firefox, Mozilla, Opera, etc.
//		{
//			xmlDoc = document.implementation.createDocument("", "", null);
//		} catch (e) {
//			alert(e.message)
//		}
//	}
//	try {
//		xmlDoc.async = false;
//		xmlDoc.load(fileName);
//		return (xmlDoc);
//	} catch (e) {
//		alert(e.message)
//	}
//	return (null);
//}

//function loadXMLDoc(dname)
//{
//    if (window.XMLHttpRequest)
//    {
//        xhttp=new XMLHttpRequest();
//    }
//    else
//    {
//        xhttp=new ActiveXObject("Microsoft.XMLHTTP");
//    }
//    xhttp.open("GET",dname,false);
//    xhttp.send();
//    return xhttp.responseXML;
//}


function loadXMLDoc(xmlFile) {
	var xmlDoc = null;
	// 判断浏览器的类型
	// 支持IE浏览器
	if (!window.DOMParser && window.ActiveXObject) {
		var xmlDomVersions = [ 'MSXML.2.DOMDocument.6.0',
				'MSXML.2.DOMDocument.3.0', 'Microsoft.XMLDOM' ];
		for (var i = 0; i < xmlDomVersions.length; i++) {
			try {
				xmlDoc = new ActiveXObject(xmlDomVersions[i]);
				break;
			} catch (e) {
			}
		}
	}
	// 支持Mozilla浏览器
	else if (document.implementation && document.implementation.createDocument) {
		try {
			/*
			 * document.implementation.createDocument('','',null); 方法的三个参数说明
			 * 第一个参数是包含文档所使用的命名空间URI的字符串； 第二个参数是包含文档根元素名称的字符串；
			 * 第三个参数是要创建的文档类型（也称为doctype）
			 */

			xmlDoc = document.implementation.createDocument('', '', null);
		} catch (e) {
			
		}
	} else {
		return null;
	}
	if (xmlDoc != null) {
		xmlDoc.async = false;
		alert(xmlDoc);
		console.log(xmlDoc);
		xmlDoc.Load(xmlFile);
		//xmlDoc.loadXML(xmlFile,"text/xml");
	}
	return xmlDoc;
}


/**
 * 加载xml字符串
 * @param text
 */
//function  loadXMLString(text){
//	var xmlDoc ="";
//	try // Internet Explorer
//	{
//		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
//		xmlDoc.async = "false";
//		xmlDoc.loadXML(text);
//	} catch (e) {
//		try // Firefox, Mozilla, Opera, etc.
//		{
//			parser = new DOMParser();
//			xmlDoc = parser.parseFromString(text, "text/xml");
//		} catch (e) {
//			alert(e.message)
//		}
//	}
//	
//}


//function loadXMLString(txt) 
//{
//    if (window.DOMParser)
//    {
//        parser=new DOMParser();
//        xmlDoc=parser.parseFromString(txt,"text/xml");
//    }
//    else 
//    {
//        // Internet Explorer
//        xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//        xmlDoc.async=false;
//        xmlDoc.loadXML(txt); 
//    }
//    return xmlDoc;
//}


function loadXMLString(xmlString) {
	var xmlDoc = null;
	// 判断浏览器的类型
	// 支持IE浏览器
	if (!window.DOMParser && window.ActiveXObject) { // window.DOMParser
														// 判断是否是非ie浏览器
		var xmlDomVersions = [ 'MSXML.2.DOMDocument.6.0',
				'MSXML.2.DOMDocument.3.0', 'Microsoft.XMLDOM' ];
		for (var i = 0; i < xmlDomVersions.length; i++) {
			try {
				xmlDoc = new ActiveXObject(xmlDomVersions[i]);
				xmlDoc.async = false;
				xmlDoc.loadXML(xmlString); // loadXML方法载入xml字符串
				break;
			} catch (e) {
			}
		}
	}
	// 支持Mozilla浏览器
	else if (window.DOMParser && document.implementation
			&& document.implementation.createDocument) {
		try {
			/*
			 * DOMParser 对象解析 XML 文本并返回一个 XML Document 对象。 要使用
			 * DOMParser，使用不带参数的构造函数来实例化它，然后调用其 parseFromString() 方法
			 * parseFromString(text, contentType) 参数text:要解析的 XML 标记
			 * 参数contentType文本的内容类型 可能是 "text/xml" 、"application/xml" 或
			 * "application/xhtml+xml" 中的一个。注意，不支持 "text/html"。
			 */
			domParser = new DOMParser();
			xmlDoc = domParser.parseFromString(xmlString, 'text/xml');
		} catch (e) {
		}
	} else {
		return null;
	}
	return xmlDoc;
}



//var xmlDoc=liemsDom.loadXMLDoc("B1EMG00001.xml");
//alert(xmlDoc);
//var txt=xmlDoc.getElementsByTagName("field")[0].childNodes[0].nodeValue;
//alert(txt);


/*------------dialog-----------*/
//判断是否为数组 
function isArray(v) 
{ 
	return v && typeof v.length == 'number' && typeof v.splice == 'function'; 
} 
//创建元素 
function createEle(tagName) 
{ 
	return document.createElement(tagName); 
} 
//在body中添加子元素 
function appChild(eleName) 
{ 
	return document.body.appendChild(eleName); 
} 
//从body中移除子元素 
function remChild(eleName) 
{ 
	return document.body.removeChild(eleName); 
} 
//弹出窗口，标题（html形式）、html、宽度、高度、是否为模式对话框(true,false)、按钮（关闭按钮为默认，格式为['按钮1',fun1,'按钮2',fun2]数组形式，前面为按钮值，后面为按钮onclick事件） 
function showWindow(title,html,width,height,modal,buttons) 
{ 
	//避免窗体过小 
	if (width < 300) 
	{ 
		width = 300; 
	} 
	if (height < 200) 
	{ 
		height = 200; 
	} 
	//声明mask的宽度和高度（也即整个屏幕的宽度和高度） 
	var w,h; 
	//可见区域宽度和高度 
	var cw = document.body.clientWidth; 
	var ch = document.body.clientHeight; 
	//正文的宽度和高度 
	var sw = document.body.scrollWidth; 
	var sh = document.body.scrollHeight; 
	//可见区域顶部距离body顶部和左边距离 
	var st = document.body.scrollTop; 
	var sl = document.body.scrollLeft; 
	w = cw > sw ? cw:sw; 
	h = ch > sh ? ch:sh; 
	//避免窗体过大 
	if (width > w) 
	{ 
		width = w; 
	} 
	if (height > h) 
	{ 
		height = h; 
	} 
	//如果modal为true，即模式对话框的话，就要创建一透明的掩膜 
	if (modal) 
	{ 
		var mask = createEle('div'); 
		mask.style.cssText = "position:absolute;left:0;top:0px;background:#fff;filter:Alpha(Opacity=30);opacity:0.5;z-index:100;width:" + w + "px;height:" + h + "px;"; 
		appChild(mask); 
	} 
	//这是主窗体 
		var win = createEle('div'); 
		win.style.cssText = "position:absolute;left:" + (sl + cw/2 - width/2) + "px;top:" + (st + ch/2 - height/2) + "px;background:#f0f0f0;z-index:101;width:" + width + "px;height:" + height + "px;border:solid 2px #afccfe;"; 
	//标题栏 
		var tBar = createEle('div'); 
		//afccfe,dce8ff,2b2f79 
		tBar.style.cssText = "margin:0;width:" + width + "px;height:25px;background:url(top-bottom.png);cursor:move;"; 
	//标题栏中的文字部分 
		var titleCon = createEle('div'); 
		titleCon.style.cssText = "float:left;margin:3px;"; 
		titleCon.innerHTML = title;//firefox不支持innerText，所以这里用innerHTML 
		tBar.appendChild(titleCon); 
	//标题栏中的“关闭按钮” 
		var closeCon = createEle('div'); 
		closeCon.style.cssText = "float:right;width:40px;margin:3px;color:blue;cursor:pointer;";//cursor:hand在firefox中不可用 
		closeCon.innerHTML = "关闭"; 
		tBar.appendChild(closeCon); 
		win.appendChild(tBar); 
	//窗体的内容部分，CSS中的overflow使得当内容大小超过此范围时，会出现滚动条 
		var htmlCon = createEle('div'); 
		htmlCon.style.cssText = "text-align:center;width:" + width + "px;height:" + (height - 50) + "px;overflow:auto;"; 
		htmlCon.innerHTML = html; 
		win.appendChild(htmlCon); 
	//窗体底部的按钮部分 
		var btnCon = createEle('div'); 
		btnCon.style.cssText = "width:" + width + "px;height:25px;text-height:20px;background:url(top-bottom.png);text-align:center;padding-top:3px;"; 
	//如果参数buttons为数组的话，就会创建自定义按钮 
	if (isArray(buttons)) 
	{ 
		var length = buttons.length; 
		if (length > 0) 
		{ 
			if (length % 2 == 0) 
				{ 
				for (var i = 0; i < length; i = i + 2) 
				{ 
					//按钮数组 
					var btn = createEle('button'); 
					btn.innerHTML = buttons[i];//firefox不支持value属性，所以这里用innerHTML 
					// btn.value = buttons[i]; 
					btn.onclick = buttons[i + 1]; 
					btnCon.appendChild(btn); 
					//用户填充按钮之间的空白 
					var nbsp = createEle('label'); 
					nbsp.innerHTML = "  "; 
					btnCon.appendChild(nbsp); 
				} 
			} 
		} 
	} 
	//这是默认的关闭按钮 
	var btn = createEle('button'); 
	// btn.setAttribute("value","关闭"); 
	btn.innerHTML = "取消"; 
	// btn.value = '关闭'; 
	btnCon.appendChild(btn); 
	win.appendChild(btnCon); 
	appChild(win); 
	/******************************************************以下为拖动窗体事件************************************************/ 
	//鼠标停留的X坐标 
	var mouseX = 0; 
	//鼠标停留的Y坐标 
	var mouseY = 0; 
	//窗体到body顶部的距离 
	var toTop = 0; 
	//窗体到body左边的距离 
	var toLeft = 0; 
	//判断窗体是否可以移动 
	var moveable = false; 
	
	//标题栏的按下鼠标事件 
	tBar.onmousedown = function() 
	{ 
		var eve = getEvent(); 
		moveable = true; 
		mouseX = eve.clientX; 
		mouseY = eve.clientY; 
		toTop = parseInt(win.style.top); 
		toLeft = parseInt(win.style.left); 
		//移动鼠标事件
	　　 tBar.onmousemove = function(){ 
		　　if(moveable){ 
		　　　　var eve = getEvent(); 
		　　　　var x = toLeft + eve.clientX - mouseX; 
		　　　　var y = toTop + eve.clientY - mouseY; 
			　　if (x > 0 && (x + width < w) && y > 0 && (y + height < h)){ 
				　　win.style.left = x + "px"; 
	　　			  win.style.top = y + "px"; 
			　　} 
		　　} 
	　　} 
	　　//放下鼠标事件，注意这里是document而不是tBar 
	　　document.onmouseup = function(){ 
	　　	moveable = false; 
	　　} 
	} 
	
	//获取浏览器事件的方法，兼容ie和firefox 
	function getEvent() 
	{ 
		return window.event || arguments.callee.caller.arguments[0]; 
	} 
	//顶部的标题栏和底部的按钮栏中的“关闭按钮”的关闭事件 
	btn.onclick = closeCon.onclick = function(){ 
		remChild(win); 
		if (mask) 
		{ 
			remChild(mask); 
		} 
	} 
}

function addCheckbox(name,value,id,click) 
{ 
	var str = "<input type='checkbox' name='" + name + "' value='" + value + "' id='" + id + "' onclick='" + (click == null ? '':click) + "'/> <label for='" + id + "'>" + value + "</label>"; 
	return str; 
} 
	
function show() 
{ 
	var str = "<div><div style='border:dotted 1px blue'><table cellspacing='2'>"; 
	str += "<tr><td colspan='7' style='text-align:center'>请选择所在地区：" + addCheckbox('all','全（不）选','cities_all','selectAll(this,\"cities_cb\")') + "</td></tr>"; 
	str += "<tr><td>" + addCheckbox('cities_cb','永州市','cities_cb11') + "</td><td>" + addCheckbox('cities_cb','怀化市','cities_cb12') + "</td></tr>"; 
	str += "</table></div><br/><div style='border:dotted 1px blue'><table cellspacing='2'>"; 
	str += "<tr><td colspan='10' style='text-align:center'>请选择矿种：" + addCheckbox('all','全（不）选','class_all','selectAll(this,\"class_cb\")') + "</td></tr>"; 
	str += "<tr><td>" + addCheckbox('class_cb','硼','class_cb21') + "</td><td>" + addCheckbox('class_cb','磷','class_cb22') + "</td></tr>"; 
	str += "</table></div></div>"; 
	//showWindow('我的提示框',str,850,250,true,['确定',fun1,'矿种',fun2]); 
	showWindow('我的提示框',str,850,250,true,['确定',fun1,'矿种',fun2]); 
} 


function fun1() 
{ 
	alert("func1");
} 
function fun2() 
{ 	
	alert("fun2"); 
} 












