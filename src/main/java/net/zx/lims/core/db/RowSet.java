package net.zx.lims.core.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import net.zx.lims.core.util.Log;

public class RowSet {
	
	CachedRowSet rowset =null;
	
	HashMap<String,String> columnTypes =new HashMap<String,String>();
	HashMap<String,Integer> columnTypes2 =new HashMap<String,Integer>();
	
	public RowSet(){
		
	}
	
	public RowSet(ResultSet rs){
		
		RowSetFactory factory=null;
		
		try{
			int columns = rs.getMetaData().getColumnCount();
			for(int i=0;i<columns;i++){
				String columnName = rs.getMetaData().getColumnName(i+1);
				int id =rs.getMetaData().getColumnType(i+1);
				String type = rs.getMetaData().getColumnTypeName(i+1);
				columnTypes.put(columnName, type);
				columnTypes2.put(columnName, id);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			factory = RowSetProvider.newFactory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rowset = factory.createCachedRowSet();
			rowset.populate(rs);

			if(rowset==null){
				Log.error("RowSet初始化失败！");
			}
			
			//Log.log(String.valueOf(rowset.next()));
			/*while(rowset.next()){
				String id = rowset.getString("EMPNO");
				String name = rowset.getString("ENAME");
				String date = rowset.getString("HIREDATE");
				Log.log(id+name+date);
			}*/

		} catch (SQLException e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		
	}
	
	public String getColumn(String name){

		String column =null;
		//String type =columnTypes.get(name);
		
		try {
//			if("VACHAR2".equals(type)){
//				column = rowset.getString(name);
//			}
//			if("DATE".equals(type)){
//				column = rowset.getDate(name);
//			}
			column = rowset.getString(name);
			return column;
		} catch (SQLException e) {
			e.printStackTrace();
			Log.error(e.getMessage());
			return null;
		}
	}
	
	public String getColumn(int id){
		
		try {
			String column = rowset.getString(id);
			return column;
		} catch (SQLException e) {
			e.printStackTrace();
			Log.error(e.getMessage());
			return null;
		}
	}
	
	public boolean next(){
		try {
			//Log.log(String.valueOf(rowset.next()));
			return rowset.next();
		} catch (SQLException e) {
			e.printStackTrace();
			Log.error(e.getMessage());
			return false;
		}
	}
	
	public void close(){
		try {
			rowset.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}

	public String getSafeString(String name) {
		if(this.getColumn(name)!=null){
			return this.getColumn(name);
		}
		return "";
	}
}
