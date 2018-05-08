package net.zx.lims.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.zx.lims.core.db.DataBase;
import net.zx.lims.core.util.Tools;

/**
 * @author Administrator
 *生成后台Dom
 */
public class DataDomInitTag extends TagSupport{

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		
		return super.doStartTag();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		//设置Message到request
		String domstr = Tools.getCustomXML();
		pageContext.getSession().setAttribute("LiemsDom", domstr);
		
		//设置Message到request
		Map<String, String> messages = Tools.getMessages();
		pageContext.getSession().setAttribute("businessMassages", messages);
		return TagSupport.EVAL_PAGE;
	}
	
	

}
