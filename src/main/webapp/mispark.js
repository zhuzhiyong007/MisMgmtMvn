//菜单收缩按钮
$(function(){
	var flag=true;
	$("#slider").click(function(){
		if(flag){
			$("#left").hide();
			$("#mainframe").find(".maindiv").css('margin-left',10);
			$("#slider").removeClass("side_switch");
			$("#slider").addClass("side_switchl");
			flag=false;
		}else{
			$("#left").show();
			$("#mainframe").find(".maindiv").css('margin-left',190);
			$("#slider").removeClass("side_switchl");
			$("#slider").addClass("side_switch");
			flag=true;
		}
	})
		
	$(".folder").click(function () {
	    $('.item').stop();
	    $(this).siblings(".item").removeAttr("id");
	    if($(this).attr("id")=="open"){
	        $(this).removeAttr("id").siblings(".item").slideUp();
	    }else{
	        $(this).attr("id","open").next().slideDown().siblings(".item").slideUp();
	    }
	});
})



function Dom(domObj){
	if(domObj==undefined){
		return;
	}
	this.domObj=domObj;
	return this;
}

function LimesDom(dom){
	if(dom!=undefined){
		Dom.call(dom,this);
	}
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

LimesDom.prototype.dom= new Dom(domObj);
LimesDom.prototype.loadXMLString=loadXMLString;
LimesDom.prototype.loadXMLDoc=loadXMLDoc;
LimesDom.prototype.toString=toString;
var liemsDom = new LimesDom(domObj);
console.log(liemsDom);
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
  

//LiemsDom閻ㄥ嫭鏌熷▔锟�
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















