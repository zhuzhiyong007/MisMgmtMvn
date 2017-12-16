package net.zx.lims.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
 
public class DataDomClientTag extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
       PageContext ctx = (PageContext)getJspContext();
       JspWriter out = ctx.getOut();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’");
       out.println(sdf.format(new Date()));
    }
}
