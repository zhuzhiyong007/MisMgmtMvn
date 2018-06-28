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
	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
//		String domStr = (String) pageContext.getSession().getAttribute("LiemsDom");
		//解析xml字符串
		String domStr="<car>"+ 
		"<brand><price>50万</price><pattern>A6</pattern></brand>"+ 
		"<brand><price>65万</price><pattern>A8</pattern></brand>"+ 
		"<brand><price>17万</price></brand>"+ 
		"</car>"; 
		StringBuffer domObj = new StringBuffer("<script> var domObj = ''; var domStr=\'"+domStr+ "\';");
		domObj.append(" if(window.ActiveXObject){    ");
		domObj.append("		domObj = new ActiveXObject(\"Microsoft.XMLDOM\").load(domStr);  ");
		domObj.append(" } else {              ");
		domObj.append("		domObj=new DOMParser().parseFromString(domStr,\'text/xml\');  ");
		domObj.append(" }   console.log(domObj);   ");
		domObj.append("  </script>  ");

		try {
			pageContext.getOut().write(domObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//将后台的Message输出到前台
		//getBusinessMessages();
		
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
