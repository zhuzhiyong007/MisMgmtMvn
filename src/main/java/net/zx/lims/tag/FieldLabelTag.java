package net.zx.lims.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.zx.lims.dom.DataDom;
import net.zx.lims.dom.Table;

/**
 * @author Administrator
 *输出主表的字段标签
 */
public class FieldLabelTag extends TagSupport {

	String name;
	String value;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	String width;
	
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
		//输出Field字段的html元素
		DataDom dataDom = (DataDom) pageContext.getRequest().getAttribute("DataDom");
		//Table table = dataDom.getRootTable();
		//table.getFields().getColumn("");
		//暂时写死
		this.value="编号";
		StringBuffer outBuffer = new StringBuffer("<label id=\""+this.name+"\" name=\""+this.name+"\" type=\"text\" style=\"width:"+this.width+"\">"+this.value+"</label>");
		
		try {
			pageContext.getOut().write(outBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return TagSupport.EVAL_PAGE;
	}

}
