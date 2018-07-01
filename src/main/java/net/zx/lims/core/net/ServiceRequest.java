package net.zx.lims.core.net;

import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import net.zx.lims.core.language.Message;

import org.springframework.http.HttpRequest;

public class ServiceRequest {
	HashMap params = new HashMap<String, Vector<ServiceParam>>();
	HashMap serviceReturnParams = new HashMap<String, String>();
	Message messages;
	
	public HashMap getServiceReturnParams() {
		return serviceReturnParams;
	}

	public void setServiceReturnParams(HashMap serviceReturnParams) {
		this.serviceReturnParams = serviceReturnParams;
	}


	HttpRequest request;
	
	
	/**
	 * @return the request
	 */
	public HttpRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public ServiceRequest(HttpServletRequest request) {
		super();
		this.request = (HttpRequest) request;
	}
	
	public ServiceRequest(HttpRequest request) {
		super();
		this.request = request;
	}


	public void setReturnValue(String key,String value){
		this.serviceReturnParams.put(key, value);
	};
	
	public String getReturnValue(String key){
		return (String) this.serviceReturnParams.get(key);
	};
	
	
	public void getParam(String key){
		this.params.get(key).toString();
	};
	public void getParam(ServiceParam param){
		this.params.get(param.getValue());
	};
	
	public void setParam(String key,String value){
		this.params.put(key, new ServiceParam(key,value));
	};
	public void setParam(ServiceParam param){
		this.params.put(param.getValue(),param);
	};
	
	public void addMessage(){
		//addAlert
		
		//addInfo
	}

	public void addParameter(String key, String value) {
		this.params.put(key, new ServiceParam(key,value));
	};

}
