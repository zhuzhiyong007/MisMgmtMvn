package net.zx.lims.dom;

import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import net.zx.lims.core.net.SessionInfo;

public class DataDom {

	HashMap<String,Table> tables = new HashMap<String,Table>();
	HashMap<String,Tab> tabs = new HashMap<String,Tab>();
	Extend ext =null;
	
	public DataDom() {
		// TODO Auto-generated constructor stub
	}
	
	private void init(Document doc) {
		// TODO Auto-generated method stub

	}
	
	private void init(String domstr) {
		// TODO Auto-generated method stub
		//SAXReader reader = new SAXReader().build(domstr) ;
	}
	
	public void refresh(SessionInfo sessionInfo){}
	
	public String toString(){
		XMLWriter outputer =new XMLWriter();
		//outputer.write(this);
		return null;
	}
	
}
