package net.zx.lims.business.em;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.db.RowSet;
import net.zx.lims.core.frame.OneToMany;
import net.zx.lims.core.net.ServiceRequest;
import net.zx.lims.core.net.SessionInfo;
import net.zx.lims.core.util.Log;
import net.zx.lims.core.util.Tools;
import net.zx.lims.dom.DataDom;

public class B1EMG00001 extends OneToMany{
	
	public void init(DataDom dataDom ,SessionInfo sessionInfo,ServiceRequest request){
		DataBase db =null;
		RowSet rs = null;
		try{
			db = Tools.getDataBase(true);
			
			//String sql = "select * from users";
			//String sql = "select * from EMP where empno= ?";
			String sql = "insert into users(name,password,userid) values(?,?,?)";
			//String sql = "select * from citys";
			
			//rs =db.getPrepareRs(sql, new Object[]{"test","12345","zzy"});
			db.executePrepareSql(sql, new Object[]{"test2","1234567","id123456"});

			/*while(rs.next()){
				//String name = rs.getString("city_name");
				//String name = rs.getString("name");
				String id = rs.getColumn("EMPNO");
				String name = rs.getColumn("ENAME");
				String date = rs.getColumn("HIREDATE");
				
				Log.log(id+name+date);
			}*/
			
		}catch(Exception e){
			Log.error(e.getMessage());
		}finally{
			/*if(rs!=null){
				rs.close();
			}
			if(db!=null){
				db.cleanUp();
			}*/
		}
	}
	
	
	
	
}
