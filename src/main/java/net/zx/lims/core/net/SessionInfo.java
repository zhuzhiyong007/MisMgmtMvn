package net.zx.lims.core.net;

import java.io.Serializable;

public class SessionInfo implements Serializable {
	private String usrId; 

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

	public void setDefaultOrg(String defaultOrg) {
		this.defaultOrg = defaultOrg;
	}

	private String currentLanguage; 
	private String defaultOrg;
	
	private static final long serialVersionUID = 1L;
	
	public String getCurrentUser(){
		
		return this.usrId;
	}
	
	public String getDefaultOrg(){
		
		return this.defaultOrg;
	}
	
	public String getCurrentLanguage(){
		
		return this.currentLanguage;
	}
	
	
}
