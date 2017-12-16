package net.zx.lims.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import net.zx.lims.core.util.Validate;

public class DataBase {
	String type=null;
	boolean commit=false;
	Connection conn=null;
	
	public DataBase(){
		
	}
	
	public DataBase(String autocommit){

		this.type=autocommit;
	}
	
	public DataBase(boolean autocommit){
		this.commit=autocommit;
		String extDataSource ="mysql";
		
		this.conn=getConnection(extDataSource);
		System.out.println("555555555"+conn);
	}
	
	public static RowSet getPrepareSqlRs(String sql,Object[] params){
		//Œ¥ÕÍ≥…
		return null;
		
	}
	
	public Connection getConnection(String extDataSource){
		ConnectionDelegate delegate = new ConnectionDelegate();
		return delegate.getConnection(extDataSource);
	}
	
	
	public ResultSet getPrepareRs(String sql){
		try {
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs =pstm.getResultSet();
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getPrepareRs(String sql,Object[] params){
		try {
			String[] ps = Validate.validate(params);
			
			PreparedStatement pstm = conn.prepareStatement(sql,ps);
			
			ResultSet rs =pstm.getResultSet();
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean executePrepareSql(String sql,Object[] params){
		try {
			
			String[] ps = Validate.validate(params);
			
			PreparedStatement pstm = conn.prepareStatement(sql,ps);
			
			boolean rs = pstm.execute();
			
			return rs;
			
		} catch (SQLException e) {
			//Log.log("sql”Ôæ‰÷¥–– ß∞‹£°");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void rollback(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void commit(){
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cleanUp(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
