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
	public static String MYBATISCONTENT="/WEB-INF/mybatis-config.xml";
	public static HashMap<String,SqlSessionFactory> sessionFactoryMap=new HashMap<String,SqlSessionFactory>();
	
	public ConnectionDelegate(){
		
	}
	 
	
	public SqlSession getSqlSession(String extDataSource){
		synchronized(DataBase.class){
			if(sessionFactoryMap.get(extDataSource)==null){
				sessionFactoryMap.put(extDataSource,getSessionFactory());
			}
		}
		return sessionFactoryMap.get(extDataSource).openSession();
	}
	

	
	public SqlSessionFactory getSessionFactory(){
		Reader reader = null;
		SqlSessionFactory factory =null;
		try {
			reader = Resources.getResourceAsReader(MYBATISCONTENT);
			factory = new SqlSessionFactoryBuilder().build(reader);
			//SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment);
			//SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment,properties);
			
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		if(factory==null){
			Log.error("factory为空！");
		}
		/*else{
			Log.fatalError(factory.toString());
			return factory;
		}*/
		return factory;
		
	}
	 
}
