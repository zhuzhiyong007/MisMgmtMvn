package net.zx.lims.core.db;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;

import net.zx.lims.core.util.Log;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionDelegate {
	public static String MYBATISCONTENT="/net/zx/core/db/mybatis-config.xml";
	public static HashMap<String,SqlSessionFactory> sessionFactoryMap=new HashMap<String,SqlSessionFactory>();
	
	public ConnectionDelegate(){
		
	}
	 
	
	public Connection getConnection(String extDataSource){
		Log.log("11111111111111");
		synchronized(DataBase.class){
			if(sessionFactoryMap.get(extDataSource)==null){
				sessionFactoryMap.put(extDataSource,getSessionFactory());
			}
		}
		System.out.println("9999999999");
		return (Connection) sessionFactoryMap.get(extDataSource).openSession();
	}
	

	
	public SqlSessionFactory getSessionFactory(){
		//System.out.println("88888888888888"+request.getSession().getServletContext().getRealPath("/"));
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(MYBATISCONTENT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment);
		//SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment,properties);
		
		return factory;
	}
	 
}
