function MyTools(){
	
}

//MyTools.getResult=getResult;

function getXMLHttp(){
	var xmlrequest;
	if (window.ActiveXObject) {
		try {
			xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			xmlrequest = "";
		}

	} else {
		xmlrequest = new XMLHTTP();
	}
}

function getResult(params,className,method,jsback,postType) {
	var xmlrequest = getXMLHttp();
	var url = "/xlst/getAjaxText.jsp?params="+params+"&className="+className+"&method="+method;
	
	if(!postType){
		postType="GET";
	}
	
	if(postType=="POST"){
		url = "/xlst/getAjaxText.jsp?className="+className+"&method="+method;
	}
	
	
	var status = xmlrequest.open();
	
	if(status=="200"){
		return xmlrequest.resultText;
	}
	
	return null;
}


function trace(pgmto, pkto, pgmfrom, pkfrom, params) {

}


//ajax寮傛鑾峰彇servlet鏁版嵁
function createXMLHttpRequest() {

	var xmlrequest;

	if (window.XMLHttpRequest) {

		xmlrequest = new XMLHttpRequest();

	} else if (window.ActiveXObject) {

		try {

			xmlrequest = new ActiveXObject("Msxm12.XMLHTTP");

		} catch (e) {

			try {

				xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");

			} catch (e) {

				xmlrequest = "";

			}

		}

	}

	return xmlrequest;

}

// 鑾峰彇鏁版嵁鐨勫嚱鏁�

function change() {

	var xmlrequest = createXMLHttpRequest();

	xmlrequest.open("POST", "AjaxServlet", true);

	xmlrequest.onreadystatechange = function() {

		if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {

			var data = JSON.parse(xmlrequest.responseText);

			var content = "<table border=1>";

			for (var i = 0; i < data.length; i++) {

				content += "<tr>";

				for (o in data[i]) {

					content += "<td>" + data[i][o] + "</td>";

				}

				content += "</tr>";

			}

			content += "</table>";

			document.getElementById("test").innerHTML = content;

		}

	};

	xmlrequest.send();

}
