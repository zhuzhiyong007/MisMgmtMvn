//全局变量
var txt="";


try
{
	var liemsDom = new Object();
	
	
	 var x=document.getElementById("demo").value;
	  if(x=="")    throw "empty";
	  if(isNaN(x)) throw "not a number";
	  if(x>10)     throw "too high";
	  if(x<5)      throw "too low";


}catch(err)
{
	  txt="There was an error on this page.\n\n";
	  txt+="Error description: " + err.message + "\n\n";
	  txt+="Click OK to continue.\n\n";
	  alert(txt);

}
  

//LiemsDom的方法
function getLiemsDomValue(table,feild){
	
}

function addPageInfo(table,type,message){
	
	
}


//外键类
function foregin(obj){
	this.addParam=addParam;
	this.getReturnValue=getReturnValue;
}

//创建service对象
function service(method,params,owner,serviceForm,postType){
	this.method = method;
	this.params = params;
	this.owner = owner;
	this.submit=submit;
	this.url = "net.zx.lims.core.net.ServiceAgent?";
	if(owner){
		//隐式提交
		
		
		
	}else{
		//显示提交
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






//操作dom节点
function createElement(){
	var para=document.createElement("p");
	var node=document.createTextNode("这是新段落。");
	para.appendChild(node);

	var element=document.getElementById("div1");
	element.appendChild(para);
}

function removeElement(){
	var parent=document.getElementById("div1");
	var child=document.getElementById("p1");
	parent.removeChild(child);
}


//操作命令
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

