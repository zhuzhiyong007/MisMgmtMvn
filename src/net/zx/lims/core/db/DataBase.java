package net.zx.lims.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import org.apache.ibatis.session.SqlSession;

import net.zx.lims.core.util.Log;
import net.zx.lims.core.util.Validate;

public class DataBase {
	String type=null;
	boolean commit=false;
	Connection conn=null;
	ResultSet rs= null;   //不能作为局部变量，否则无法返回前台
	
	public DataBase(){
		
	}
	
	public DataBase(String autocommit){

		this.type=autocommit;
	}
	
	public DataBase(boolean autoCommit){
		this.commit=autoCommit;
		String extDataSource ="mysql";
		try{
			this.conn=getConnection(extDataSource);
			if(conn==null){
				Log.error("conn未初始化！");
			}
			this.conn.setAutoCommit(autoCommit);
		}catch(Exception e){
			Log.error(e.getMessage());
		}

	}
	
	public static RowSet getPrepareSqlRs(String sql,Object[] params){

		return null;
		
	}
	
	public Connection getConnection(String extDataSource){
		ConnectionDelegate delegate = new ConnectionDelegate();
		SqlSession session = delegate.getSqlSession(extDataSource);
		if(session==null){
			Log.error("session为空！");
		}
		return session.getConnection();
	}
	
	
	public ResultSet getPrepareRs(String sql){
		try {
			if(conn==null){
				Log.error("conn为空！");
				return null;
			}
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
			//String[] ps = Validate.validate(params);
			Log.error(sql);
			if(conn==null){
				Log.error("conn为空！");
				return null;
			}
			//PreparedStatement pstm = conn.prepareStatement(sql,ps);
			PreparedStatement pstm = conn.prepareStatement(sql);
			if(pstm==null){
				Log.error("pstm为空！");
			}
			rs = pstm.executeQuery();
			//rs =pstm.getResultSet();
			
			if(rs==null){
				Log.error("resultset数据为空！");
			}
			return rs;
			
		} catch (SQLException e) {
			
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
			Log.error(e.getMessage());
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
