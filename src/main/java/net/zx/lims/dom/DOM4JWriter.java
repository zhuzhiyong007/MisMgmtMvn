package net.zx.lims.dom;
import java.io.* ;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element ;
import org.dom4j.io.* ;

public class DOM4JWriter {
	public static void main(String args[]) throws Exception {
		Document doc = DocumentHelper.createDocument() ;
		Element addresslist = doc.addElement("addresslist") ;	
		Element linkman = addresslist.addElement("linkman") ;
		Element name = linkman.addElement("name") ;
		Element email = linkman.addElement("email") ;
		name.setText("���˻�") ;
		email.setText("email") ;
		OutputFormat format = OutputFormat.createPrettyPrint() ;
		format.setEncoding("GBK") ;

		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("d:" + File.separator + "output.xml")),format) ;
		writer.write(doc) ;	
		writer.close() ;
	}
}