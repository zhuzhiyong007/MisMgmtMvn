function LiemsLoadEvent(){
	alert(LiemsLoadEvent);
}

function Business(){
	
	p.addParm("","czml()");
}

function tab_onclick(){
	
	
	
}

function onBeforeSave(){
	
	
	
}


function  OGORGMST_opbaradd_onclick(){
	
}

function  OGORGMST_generateView_onclick(){
	
}

function  OGORGMST_rowEdit_onclick(){
	
}


function czml(){
	var service = new service("xianshi","");
	var service = new service("yinshi","","serviceBack");
	service.addParam();
	service.submit(true);
}

function serviceBack_setServiceValue(){
	addPageInfo("","0","成功");
	addPageInfo("","1","失败");
}

var domObj = ''; 
var domStr='<car><brand><price>50��</price><pattern>A6</pattern></brand><brand><price>65��</price><pattern>A8</pattern></brand><brand><price>17��</price></brand></car>'; 
	if(window.ActiveXObject){    
		domObj = new ActiveXObject("Microsoft.XMLDOM").load(domStr); 
	} else {      
		domObj=new DomParser().parseFromString(domStr,"text/xml");
	}
	
	var strNodes=domObj.documentElement.childNodes; 
	alert(strNodes.item(0).childNodes.item(0).childNodes.item(0).text); //����50�� 
	alert(strNodes.item(0).childNodes.item(1).childNodes.item(0).text); //����A6 

