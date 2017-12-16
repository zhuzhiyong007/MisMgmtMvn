package net.zx.lims.business.em;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.util.Log;
import net.zx.lims.core.util.Tools;

public class B1EMG00001 {
	
	public void init(){
		DataBase db =null;
		ResultSet rs = null;
		try{
			db = Tools.getDataBase(true);
			String sql = "select * from citys";
			rs =db.getPrepareRs(sql, new Object[]{});
			while(rs.next()){
				String name = rs.getString("city_name");
				Log.log(name);
			}
		}catch(Exception e){
			Log.error(e.getMessage());
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(db!=null){
				db.cleanUp();
			}
		}
	}
	
	
	
	
}
