package net.zx.lims.core.util;

import net.zx.lims.core.db.DataBase;

/**
 * @author Administrator
 *
 */
public class Tools {
	
	/**
	 * 获取数据库连接
	 * @param autocommit
	 * @return
	 */
	public static DataBase getDataBase(boolean autocommit){
		return new DataBase(autocommit);
	}
	
	/**
	 * 调用后台java类
	 */
	public static String getResult(){
		
		return null;
	}
}
