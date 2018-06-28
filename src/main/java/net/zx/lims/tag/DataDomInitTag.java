package net.zx.lims.tag;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.jdom.Document;

import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.net.ServiceRequest;
import net.zx.lims.core.net.SessionBroker;
import net.zx.lims.core.net.SessionInfo;
import net.zx.lims.core.util.Tools;
import net.zx.lims.dom.DataDom;

/**
 * @author Administrator
 *生成后台Dom
 */
public class DataDomInitTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		
		return super.doStartTag();
	}
	@Override
	public int doEndTag() throws JspException {
		//反射调用init方法获取DataDom
		String domStr = Tools.getCustomXML();
		Document doc = Tools.toDocument(domStr);
		DataDom dataDom = new DataDom(doc);
		//生成DataDom
		SessionBroker broke = new SessionBroker();
		try {
			broke.invokeReflectMethod(dataDom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageContext.getRequest().setAttribute("dataDom", doc);
		
		//设置Message到request
		Map<String, String> messages = Tools.getMessages();
		pageContext.getSession().setAttribute("businessMassages", messages);
		return TagSupport.EVAL_PAGE;
	}
	
	public void getI18NMessage(String program,SessionInfo sessionInfo){
		String sql = "select msg_id,msg_dec from PGMSGMST WHERE program_id = ? and lang_id = ?";
		Rowset rs = DataBase.getRs(sql, program,sessionInfo.getCurrentLanguage());
		StringBuffer sb = new StringBuffer("<script> var businessMessage={");
		//构造消息数组方法
		while(rs.next){
			sb.append(rs.getSafeString("msg_id"));
			sb.append(":"+rs.getSafeString("msg_dsc")+",");
		}
		sb.append("}</script>");
	}

}
