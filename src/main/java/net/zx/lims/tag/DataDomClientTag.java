package net.zx.lims.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
 
/**
 * @author Administrator
 *将后端传过来的Dom的string字符串转换为前端的Dom
 */
public class DataDomClientTag extends TagSupport{
    /* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
//		String domStr = (String) pageContext.getSession().getAttribute("LiemsDom");
		//解析xml字符串///////////////////////////////////////////////////////////////////////// 
		String domStr="<car>"+ 
		"<brand><price>50万</price><pattern>A6</pattern></brand>"+ 
		"<brand><price>65万</price><pattern>A8</pattern></brand>"+ 
		"<brand><price>17万</price></brand>"+ 
		"</car>"; 
		String domObj ="";
//		StringBuffer domObj = new StringBuffer("<script> var domObj = ''; var domStr=\'"+domStr+ "\';");
//		domObj.append(" if(window.ActiveXObject){    ");
//		domObj.append("		domObj = new ActiveXObject(\"Microsoft.XMLDOM\").load(domStr);  ");
//		domObj.append(" } else {              ");
//		domObj.append("		domObj=new DomParser().parseFromString(domStr,\'text/xml\');  ");
//		domObj.append(" }      ");
//		domObj.append("  </script>  ");
		

		  
//		//跨浏览器，ie和火狐解析xml使用的解析器是不一样的。 
//		var xmlStrDoc=null; 
//		if (window.DOMParser){// Mozilla Explorer 
//		 parser=new DOMParser(); 
//		 xmlStrDoc=parser.parseFromString(str,"text/xml"); 
//		}else{// Internet Explorer 
//		 xmlStrDoc=new ActiveXObject("Microsoft.XMLDOM"); 
//		 xmlStrDoc.async="false"; 
//		 xmlStrDoc.loadXML(str); 
//		} 

		try {
			pageContext.getOut().write(domObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//将后台的Message输出到前台
		getBusinessMessages();
		
		return TagSupport.EVAL_PAGE;
	}

	private void getBusinessMessages(){
		StringBuffer mess = new StringBuffer();
		mess.append("{");
		Map<String, String> messages = (Map<String, String>) pageContext.getSession().getAttribute("businessMassages");
		if(messages!=null){
			for (Map.Entry<String, String> entry : messages.entrySet()) { 
				  mess.append("'"+entry.getKey()+"':'"+entry.getValue()+"',");
			}
		}
		mess.substring(0, mess.length()-1);
		mess.append("}");
		
		String out = new String("<script> var Message="+mess.toString()+"  </script>  ");
		try {
			pageContext.getOut().write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
