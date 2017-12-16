package net.zx.lims.business.em;

import java.sql.ResultSet;

import javax.sql.RowSet;

import oracle.jdbc.driver.DBConversion;
import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.util.Tools;

public class B1EMG00001 {
	
	public void init(){
		DataBase db =null;
		ResultSet rs = null;
		try{
			db = Tools.getDataBase(true);
			String sql = "select * from Users";
			rs =db.getPrepareRs(sql, new Object[]{});
			while(rs.next()){
				String name = rs.getString("user_name");
				System.out.println(name+"3333333333");
			}
		}catch(Exception e){
			//Log.log();
		}finally{
			if(db!=null){
				db.cleanUp();
			}
		}
	}
	
	
	
	
}
