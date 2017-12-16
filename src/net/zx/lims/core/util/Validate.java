package net.zx.lims.core.util;

public class Validate {
	
	public static String[] validate(Object[] params){
		
		boolean rs =sqlValidate(params);
		boolean rs2 =htmlValidate(params);
		 
		return (String[])params;
		
	}
	
	public static boolean sqlValidate(Object[] params){

		return (Boolean) null;
		
	}
	
	public static boolean htmlValidate(Object[] params){

		return (Boolean) null;
		
	}
}
