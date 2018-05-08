package net.zx.lims.core.util;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.OutputStreamWriter;  
import java.util.Iterator;  
import java.util.List;  

import org.dom4j.Attribute;  
import org.dom4j.Document;  
import org.dom4j.DocumentHelper;
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.SAXReader;  
import org.dom4j.io.XMLWriter;  
import org.junit.Test;  

public class Dom4jXML {  

    @Test  
    public static String readXML(File file) throws Exception {  
    	Document document=null;
        // 创建saxReader对象  
        SAXReader reader = new SAXReader();  
        // 通过read方法读取一个文件 转换成Document对象 
        if(file!=null){
	        document = reader.read(file);  
	        //获取根节点元素对象  
	        Element root = document.getRootElement();  
	        
	        //StringBuffer domStr=new StringBuffer();
	        //listNodes(root,domStr);
	        
	        //遍历所有的元素节点  
	        // listNodes(node); 
	        //elementMethod(node);
	      
        }
        
        return readXMLDocument(document);
    } 

    
    /**
     * @param doc
     * @return
     * @throws Exception
     * xml字符串转化成Document
     */
    @Test
    public static Document readXMLString(String doc) throws Exception {  
         Document document = DocumentHelper.parseText(doc);
 
         return document;
    }
    
    /**
     * @param doc
     * @return
     * @throws Exception
     * Document转化成字符串
     */
    @Test
    public static String readXMLDocument(Document document) throws Exception {  
    	
         return document.asXML();
    }
    
    @Test
    public void createXMLString() throws Exception {  
         Document document = DocumentHelper.createDocument();
         Element root = document.addElement( "cars" );
         Element supercarElement= root.addElement("supercars")
            .addAttribute("company", "Ferrai");

         supercarElement.addElement("carname")
            .addAttribute("type", "Ferrari 101")
            .addText("Ferrari 101");

         supercarElement.addElement("carname")
            .addAttribute("type", "sports")
            .addText("Ferrari 202");
         // 写入到一个新的文件中 
         writer(document);
    }

    /** 
     * 把document对象写入新的文件 
     *  
     * @param document 
     * @throws Exception 
     */  
    public void writer(Document document) throws Exception {  
        // 紧凑的格式  
        // OutputFormat format = OutputFormat.createCompactFormat();  
        // 排版缩进的格式  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        // 设置编码  
        format.setEncoding("UTF-8");  
        // 创建XMLWriter对象,指定了写出文件及编码格式  
        // XMLWriter writer = new XMLWriter(new FileWriter(new  
        // File("src//a.xml")),format);  
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(  
                new FileOutputStream(new File("src//car.xml")), "UTF-8"), format);  
        // 写入  
        writer.write(document);  
        // 立即写入  
        writer.flush();  
        // 关闭操作  
        writer.close();  
    }  

    /** 
     * 遍历当前节点元素下面的所有(元素的)子节点 
     *  
     * @param node 
     */  
    public static void listNodes(Element node,StringBuffer domStr) {  
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  

        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  

        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();  
        // 遍历  
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e,domStr);  
        }  
    }  

    /** 
     * 介绍Element中的element方法和elements方法的使用 
     *  
     * @param node 
     */  
    public void elementMethod(Element node) {  
        // 获取node节点中，子节点的元素名称为supercars的元素节点。  
        Element e = node.element("supercars");  
        // 获取supercars元素节点中，子节点为carname的元素节点(可以看到只能获取第一个carname元素节点)  
        Element carname = e.element("carname");  

        System.out.println(e.getName() + "----" + carname.getText());  

        // 获取supercars这个元素节点 中，所有子节点名称为carname元素的节点 。  

        List<Element> carnames = e.elements("carname");  
        for (Element cname : carnames) {  
            System.out.println(cname.getText());  
        }  

        // 获取supercars这个元素节点 所有元素的子节点。  
        List<Element> elements = e.elements();  

        for (Element el : elements) {  
            System.out.println(el.getText());  
        }  

    }  
    
    public static void main(String[] args){
    	File file = new File("F:/javaweb/MisMgmtMvn/src/main/webapp/xlst/app/em/B1EMG00001.xml");
    	try {
			readXML(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}  