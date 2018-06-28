function LiemsLoadEvent(){
	alert("LiemsLoadEvent");
}

function BusinessOnclick(){
	
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

function testXMLDom(){
	//text
	var domObj = ''; 
	var domStr='<car><price>50万</price></car>'; 
	if(window.ActiveXObject){    
		domObj = new ActiveXObject("Microsoft.XMLDOM").load(domStr); 
	} else {      
		domObj=new DOMParser().parseFromString(domStr,"text/xml");
	}
	
	var title = domObj.getElementsByTagName("price")[0];
	alert(title.childNodes[0].nodeValue); 
	
}

//var xmlDoc=liemsDom.loadXMLDoc("B1EMG00001.xml");
//var txt=xmlDoc.getElementsByTagName("field")[0].childNodes[0].nodeValue;
//alert(txt);

function TESTMST_PRO_generateView_onclick(obj){
	var foreign = new Foreign(obj);
	foreign.addParam("id","123");
	foreign.addParam("name","hello");
	foreign.patchForeignInfo("");
}
