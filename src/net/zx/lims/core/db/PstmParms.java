package net.zx.lims.core.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.zx.lims.core.util.Log;

public class PstmParms {
	
	public static void setParams(PreparedStatement pstm,Object[] params){
		
		//校验
		boolean rs =sqlValidate(params);
		boolean rs2 =htmlValidate(params);
		
		for(int i=0;i<params.length;i++){
			try {
				pstm.setObject(i+1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//简单转换
		//return (String[])params;
		
	}
	
	public static boolean sqlValidate(Object[] params){

		return false;
		
	}
	
	public static boolean htmlValidate(Object[] params){

		return false;
		
	}
}
