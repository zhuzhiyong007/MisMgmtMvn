package net.zx.lims.core.util;

import net.zx.lims.core.db.DataBase;

/**
 * @author Administrator
 *
 */
public class Tools {
	
	/**
	 * ��ȡ��ݿ�����
	 * @param autocommit
	 * @return
	 */
	public static DataBase getDataBase(boolean autocommit){
		return new DataBase(autocommit);
	}
	
	/**
	 * ���ú�̨java��
	 */
	public static String getResult(){
		
		return null;
	}
	
	
	public void getCustomXML(){
		
	}
}
