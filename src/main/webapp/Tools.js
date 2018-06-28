
function MyTools(){
	this.name="zhuzhiyong";
}

MyTools.prototype.getResult=getResult;
MyTools.prototype.getAsyResult=getAsyResult;
MyTools.prototype.trace=trace;
MyTools.prototype.isEmpty=isEmpty;

//获取xmlhttp
function getXMLHttp(){
	var xmlHttp;
	if (window.ActiveXObject) {
		var aVersions = [ "MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0","MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp", "Microsoft.XMLHttp" ];
  		for (var i = 0; i < aVersions.length; i++) {
  			try {
  				xmlHttp = new ActiveXObject(aVersions[i]);
  				return xmlHttp;
  			} catch (oError) {
  			}
  		}

	}else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}else {
		xmlHttp = new XMLHTTP();
	}
	return xmlHttp;
}

function getResult(params,className,method,jsback,postType) {
	var xmlrequest = getXMLHttp();
	var url = "/xlst/getAjaxText.jsp?params="+params+"&className="+className+"&method="+method;
	if(!postType){
		postType="GET";
	}
	if(postType=="POST"){
		url = "/xlst/getAjaxText.jsp?params="+params+"&className="+className+"&method="+method;
	}
	var status = xmlrequest.open(postType,url);
	if(status=="200"){
		return xmlrequest.resultText;
	}
	return "";
}

function getAsyResult(params,className,method,jsback,postType){
	var xmlrequest = getXMLHttp();
//	xmlrequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//	xmlrequest.send("fname=Henry&lname=Ford");
	var url = "/MisMgmtMvn/xlst/getAjaxText.jsp?params="+params+"&className="+className+"&method="+method;
	if(!postType){
		postType="GET";
	}
	if(postType=="POST"){
		url = "/MisMgmtMvn/xlst/getAjaxText.jsp?params="+params+"&className="+className+"&method="+method;
	}
	var status = xmlrequest.open(postType,url,true);
	xmlrequest.send();
	alert(11);
	alert(xmlrequest.responseText);
	//设置回调方法
	xmlrequest.onreadystatechange = function() {   
		if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {
			var data = JSON.parse(xmlrequest.responseText);
			if(jsback!=undefined && jsback!=null&& jsback!=""){
				eval("jsback("+data+")");  //执行回调方法
			}else{
				createMenu(data);
			}
		} else {
		    alert("ajax error!");
		}
	};
	
}


function trace(pgmto, pkto, pgmfrom, pkfrom, params) {

}


function isEmpty(param) {
	if(param!=undefined && param!=null&& param!=""){
		return true;
	}else{
		return false;
	}
}

var Tools = new MyTools();

//var canshu =11;
//Tools.getResult(canshu,"net.zx.lims.business.em.B1EMG00001","getAjax","","POST");

