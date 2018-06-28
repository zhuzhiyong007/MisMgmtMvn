
var xmlHttp;
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		var aVersions = [ "MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0",
				"MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp", "Microsoft.XMLHttp" ];
		for (var i = 0; i < aVersions.length; i++) {
			try {
				xmlHttp = new ActiveXObject(aVersions[i]);
				return;
			} catch (oError) {
			}
		}
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
		return;
	}
	throw new Error("XMLHttp object could not becreated.");
}