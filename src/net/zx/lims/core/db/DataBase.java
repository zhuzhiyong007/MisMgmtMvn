package net.zx.lims.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import net.zx.lims.core.util.Log;
import net.zx.lims.core.util.Validate;

public class DataBase {
	String type=null;
	boolean commit=false;
	Connection conn=null;
	//ResultSet rs= null;   //不能作为局部变量，否则无法返回前台
	
	public DataBase(){
		
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
	
	public static RowSet getRs(String sql,Object[] params){

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
		PreparedStatement pstm =null;
		ResultSet rs =null;
		try {
			if(conn==null){
				Log.error("conn为空！");
				return null;
			}
			pstm = conn.prepareStatement(sql);
			if(pstm==null){
				Log.error("pstm为空！");
			}
			rs =pstm.executeQuery();
			if(rs==null){
				Log.error("resultset数据为空！");
			}
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public RowSet getPrepareRs(String sql,Object[] params){
		PreparedStatement pstm =null;
		ResultSet rs =null;
		try {
			if(conn==null){
				Log.error("conn为空！");
				return null;
			}

			pstm = conn.prepareStatement(sql);
			if(pstm==null){
				Log.error("pstm为空！");
			}
			if(params.length!=0)
				PstmParms.setParams(pstm,params);
			
			rs = pstm.executeQuery();
			if(rs==null){
				Log.error("resultset数据为空！");
			}
			
			RowSet rowset = new RowSet(rs);
			return rowset;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean executePrepareSql(String sql,Object[] params){
		PreparedStatement pstm =null;
		boolean rs =false;
		try {
			
			//String[] ps = Validate.validate(params);
			
			pstm = conn.prepareStatement(sql);
			if(pstm==null){
				Log.error("pstm为空！");
			}
			PstmParms.setParams(pstm,params);
			rs = pstm.execute();
			
			return rs;
			
		} catch (SQLException e) {
			Log.error(e.getMessage());
			e.printStackTrace();
			return false;
		}finally{
			
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public boolean executePrepareSql(String sql){
		PreparedStatement pstm =null;
		boolean rs =false;
		try {
			
			pstm = conn.prepareStatement(sql);
			if(pstm==null){
				Log.error("pstm为空！");
			}
			rs = pstm.execute();
			
			return rs;
			
		} catch (SQLException e) {
			Log.error(e.getMessage());
			e.printStackTrace();
			return false;
		}finally{
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
