//閸忋劌鐪崣姗�鍣�
var txt="";

function Dom(domObj){
	if(domObj==undefined){
		return;
	}
	this.domObj=domObj;
	return this;
}

function limesDom(dom){
	if(dom!=undefined){
		Dom.call(dom,this);
	}
}

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


//婢舵牠鏁猾锟�
function foregin(obj){
	this.addParam=addParam;
	this.getReturnValue=getReturnValue;
}

//閸掓稑缂搒ervice鐎电钖�
function service(method,params,owner,serviceForm,postType){
	this.method = method;
	this.params = params;
	this.owner = owner;
	this.submit=submit;
	this.url = "net.zx.lims.core.net.ServiceAgent?";
	if(owner){
		//闂呮劕绱￠幓鎰唉
		
		
		
	}else{
		//閺勫墽銇氶幓鎰唉
		if(serviceForm==null){
			serviceForm = "liemsForm";
		}else{
			serviceForm = document.getElementById("form")[i];
		}
		
	}
	
	
	function submit(){
		serviceForm.submit();
	}
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

