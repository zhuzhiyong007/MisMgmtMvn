package net.zx.lims.core.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.db.RowSet;
import net.zx.lims.core.net.SessionInfo;

/**
 * @author Administrator
 *
 */
public class Tools {
	
	/**
	 * 获取数据库
	 * @param autocommit
	 * @return
	 */
	public static DataBase getDataBase(boolean autocommit){
		return new DataBase(autocommit);
	}
	
	/**
	 * 调用java里面的方法
	 */
	public static String getResult(){
		
		return null;
	}
	
	
	public static String getCustomXML(){ 
		//jdom.input.
		File file = new File("F:/javaweb/MisMgmtMvn/src/main/webapp/xlst/app/em/B1EMG00001.xml");
		String domstr=null;
    	try {
			domstr = Dom4jXML.readXML(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domstr;
	}
	
	public static Map<String,String> getMessages(){
		Map<String,String> map = new HashMap<String,String>();
		//从数据库中查询消息，封装到map中
//		String sql ="select mname,mvalue from Message where PGM_ID = ?";
//		RowSet rs = DataBase.getRs(sql, new Object[]{});
//		while (rs.next()){
//			map.put(rs.getColumn("mname"),rs.getColumn("mvalue"));
//		}
		map.put("mname","mvalue");
		map.put("mname2","mvalue2");
		map.put("mname3","mvalue3");
		return map;
	}
	
	public static SessionInfo getSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
		if(sessionInfo==null){
			synchronized(session){
				sessionInfo = new SessionInfo();
				session.setAttribute("sessionInfo", sessionInfo);
			}
		}
		return sessionInfo;
	}
	
	public static Document toDocument(String xml){
		SAXBuilder saxReader = new SAXBuilder();   		  
		Document document=null;
		try {
			document = saxReader.build(new ByteArrayInputStream(xml.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return document;
	}
}
