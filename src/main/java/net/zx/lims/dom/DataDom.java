package net.zx.lims.dom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import net.zx.lims.core.language.Charset;
import net.zx.lims.core.net.SessionInfo;
import net.zx.lims.core.util.Log;

public class DataDom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HashMap<String,Table> tables = new HashMap<String,Table>();
	HashMap<String,Tab> tabs = new HashMap<String,Tab>();
	Extend extend =null;
	PersonInfo personInfo;
	ProgramInfo programInfo;
	
	
	public DataDom() {
		
	}
	
	public DataDom(Document doc) {
		init(doc);
	}
	
	public DataDom(String domStr) {
		//this.
	}
	
	private void init(Document doc) {
		XMLOutputter outputer = new XMLOutputter(); //new Format("",true,"GBK")
		//解析Document，生成DataDom实例
		init(outputer.outputString(doc.getRootElement()));

	}
	
	private void init(String domstr) {
		if("".equals(Charset.nullToEmpty(domstr))){
			Log.log("初始化DataDom的字符串 为空");
		}
		//Document doc = new SAXBuilder().build(domstr) ;
		
	}
	
	public void refresh(SessionInfo sessionInfo){}
	
	
	public String toString(Element e){
		XMLOutputter outputer =new XMLOutputter(Format.getPrettyFormat());
		//outputer.write(this);
		String rs = outputer.outputString(e);// 显示到屏幕
		return rs;
	}
	
	
	public void CreateXML() {
		/*<?xml version="1.0" encoding="GBK"?>
		<users>
		  <user id="0001">
		    <name>张三</name>
		    <sex>男</sex>
		    <age>20</age>
		  </user>
		  <user id="0002">
		    <name>李四</name>
		    <sex>女</sex>
		    <age>25</age>
		  </user>
		</users>*/
        //创建DOM对象
        Document doc = new Document();
        //创建根节点
        Element rootNode = new Element("users");
        
        //创建二级节点(id=0001)
        Element userNode1 = new Element("user");
        //为二级节点设置属性
        userNode1.setAttribute("id", "0001");
        
        //创建三级节点(name)
        Element nameNode1 = new Element("name");
        //为三级节点设置文本
        nameNode1.addContent("张三");
        //创建三级节点(name)
        Element sexNode1 = new Element("sex");
        //为三级节点设置文本
        sexNode1.addContent("男");
        //创建三级节点(age)
        Element ageNode1 = new Element("age");
        //为三级节点设置文本
        ageNode1.addContent("20");
        
        
        //创建二级节点(id=0001)
        Element userNode2 = new Element("user");
        //为二级节点设置属性
        userNode2.setAttribute("id", "0002");
        
        //创建三级节点(name)
        Element nameNode2 = new Element("name");
        //为三级节点设置文本
        nameNode2.addContent("李四");
        //创建三级节点(name)
        Element sexNode2 = new Element("sex");
        //为三级节点设置文本
        sexNode2.addContent("女");
        //创建三级节点(age)
        Element ageNode2 = new Element("age");
        //为三级节点设置文本
        ageNode2.addContent("25");
        
        //添加单个节点
        //userNode.addContent(nameNode);
        //把三级节点添加到二级节点上
        userNode1.addContent(new ArrayList<Element>(Arrays.asList(nameNode1,sexNode1,ageNode1)));
        //把三级节点添加到二级节点上
        userNode2.addContent(new ArrayList<Element>(Arrays.asList(nameNode2,sexNode2,ageNode2)));
        
        
        //把二级节点添加到跟节点上
        rootNode.addContent(userNode1);
        rootNode.addContent(userNode2);
        
        //把跟节点添加到DOM对象上
        doc.addContent(rootNode);
        //创建XML输出对象(XMLOutputter)
        XMLOutputter xop = new XMLOutputter();
        //为输出的XML定义格式
        Format format = Format.getPrettyFormat();
        //编码方式
        format.setEncoding("GBK");
        //把格式设置到输出对象中
        xop.setFormat(format);
        File file = new File("D:\\dd");
        if(!file.exists()){
            file.mkdirs();
        }
        //创建输出流
        FileWriter fw;
		try {
			fw = new FileWriter(file+"\\connection.xml");
			  //把xml输出
	        xop.output(doc, fw);
	        System.out.println(xop.outputString(doc));
	        //关闭输出流
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }
	
	 public void SelectXML()throws Exception {
        //创建XML解析器
        SAXBuilder builder = new SAXBuilder(false);
        //创建DOM对象
        Document doc = builder.build("D:\\dd\\connection.xml");
        //获得跟节点
        Element rootNode = doc.getRootElement();
        //获得根节点下的所有子节点
        List<Element> elements = rootNode.getChildren("user");
        Element zsElement = null;
        //遍历所有子节点判断要查找的节点是否存在
        for(Element e : elements){
            if(e.getAttributeValue("id").equals("0003")){
                zsElement = e;
                break;
            }
        }
        if(zsElement!=null){
            //获得属性
            String id = zsElement.getAttributeValue("id");
            //获得子节点的值
            String name = zsElement.getChildText("name");
            System.out.println(id);
            System.out.println(name);
        }
    }
	
	 
	 public void InsertXML()throws Exception {
        //创建XML解析器
        SAXBuilder builder = new SAXBuilder(false);
        //创建DOM对象
        Document doc = builder.build("D:\\dd\\connection.xml");
        //获得跟节点
        Element rootNode = doc.getRootElement();
        //获得根节点下的所有子节点
        List<Element> elements = rootNode.getChildren("user");
        Element zsElement = null;
        //遍历所有子节点判断要查找的节点是否存在
        for(Element e : elements){
            if(e.getAttributeValue("id").equals("0003")){
                zsElement = e;
                break;
            }
        }
        if(zsElement!=null){
            
            Element pwdNode = new Element("pwd");
            pwdNode.addContent("000000");
            //追加(插入到末尾)
            zsElement.addContent(pwdNode);
            //插入到指定位置
            zsElement.addContent(0, pwdNode);
            //创建XML输出对象(XMLOutputter)
            XMLOutputter xop = new XMLOutputter();
            //为输出的XML定义格式
            Format format = Format.getPrettyFormat();
            //编码方式
            format.setEncoding("GBK");
            //把格式设置到输出对象中
            xop.setFormat(format);
            File file = new File("D:\\dd");
            if(!file.exists()){
                file.mkdirs();
            }
            //创建输出流
            FileWriter fw = new FileWriter(file+"\\connection.xml");
            //把xml输出
            xop.output(doc,fw);
            //关闭输出流
            fw.close();
        }
    }
	 
	 /**
	  * 修改张三的信息
	  */
	 public void UpdateXML()throws Exception {
         //创建XML解析器
         SAXBuilder builder = new SAXBuilder(false);
         //创建DOM对象
         Document doc = builder.build("D:\\dd\\connection.xml");
         //获得跟节点
         Element rootNode = doc.getRootElement();
         //获得根节点下的所有子节点
         List<Element> elements = rootNode.getChildren("user");
         Element zsElement = null;
         //遍历所有子节点判断要查找的节点是否存在
         for(Element e : elements){
             if(e.getAttributeValue("id").equals("0001")){
                 zsElement = e;
                 break;
             }
         }
         if(zsElement!=null){
             //修改内容
             //先移除
             zsElement.getChild("name").removeContent();
             //在添加
             zsElement.getChild("name").addContent("王五");
             //修改属性
             zsElement.removeAttribute("id");
             zsElement.setAttribute("id","0003");
             //创建XML输出对象(XMLOutputter)
             XMLOutputter xop = new XMLOutputter();
             //为输出的XML定义格式
             Format format = Format.getPrettyFormat();
             //编码方式
             format.setEncoding("GBK");
             //把格式设置到输出对象中
             xop.setFormat(format);
             File file = new File("D:\\dd");
             if(!file.exists()){
                 file.mkdirs();
             }
             //创建输出流
             FileWriter fw = new FileWriter(file+"\\connection.xml");
             //把xml输出
             xop.output(doc,fw);
             //关闭输出流
             fw.close();
         }
         /*
          <?xml version="1.0" encoding="GBK"?>
         <users>
           <user id="0003">
             <name>王五</name>
             <sex>男</sex>
             <age>20</age>
           </user>
           <user id="0002">
             <name>李四</name>
             <sex>女</sex>
             <age>25</age>
           </user>
         </users>
          */
     }
	 
	 public void DeleteXML()throws Exception {
        //创建XML解析器
        SAXBuilder builder = new SAXBuilder(false);
        //创建DOM对象
        Document doc = builder.build("D:\\dd\\connection.xml");
        //获得跟节点
        Element rootNode = doc.getRootElement();
        //获得根节点下的所有子节点
        List<Element> elements = rootNode.getChildren("user");
        Element zsElement = null;
        //遍历所有子节点判断要查找的节点是否存在
        for(Element e : elements){
            if(e.getAttributeValue("id").equals("0001")){
                zsElement = e;
                break;
            }
        }
        if(zsElement!=null){
            //删除某个节点下节点名是name的第一个子节点
            zsElement.removeChild("name");
            //删除某个节点下节点名是name的所有子节点
            //zsElement.removeChildren("name");
            //删除属性名称是id的属性
            //zsElement.removeAttribute("id");
            //删除该节点下的所有内容
            //zsElement.removeContent();
            
            //创建XML输出对象(XMLOutputter)
            XMLOutputter xop = new XMLOutputter();
            //为输出的XML定义格式
            Format format = Format.getPrettyFormat();
            //编码方式
            format.setEncoding("GBK");
            //把格式设置到输出对象中
            xop.setFormat(format);
            File file = new File("D:\\dd");
            if(!file.exists()){
                file.mkdirs();
            }
            //创建输出流
            FileWriter fw = new FileWriter(file+"\\connection.xml");
            //把xml输出
            xop.output(doc,fw);
            //关闭输出流
            fw.close();
        }
    }
	 
	 public Table getRootTable(){
		 return this.tables.get("rootTable");
	 }
	 
	 public Table getTable(String tableName){
		 return  this.tables.get(tableName);
	 }
}
