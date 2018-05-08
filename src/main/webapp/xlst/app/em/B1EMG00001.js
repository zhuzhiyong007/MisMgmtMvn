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
	addPageInfo("","0","鎴愬姛");
	addPageInfo("","1","澶辫触");
}

var domObj = ''; 
var domStr='<car><brand><price>50万</price><pattern>A6</pattern></brand><brand><price>65万</price><pattern>A8</pattern></brand><brand><price>17万</price></brand></car>'; 
	if(window.ActiveXObject){    
		domObj = new ActiveXObject("Microsoft.XMLDOM").load(domStr); 
	} else {      
		domObj=new DomParser().parseFromString(domStr,"text/xml");
	}
	
	var strNodes=domObj.documentElement.childNodes; 
	alert(strNodes.item(0).childNodes.item(0).childNodes.item(0).text); //弹出50万 
	alert(strNodes.item(0).childNodes.item(1).childNodes.item(0).text); //弹出A6 

