package net.zx.lims.core.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zx.lims.core.language.Content;
import net.zx.lims.dom.DataDom;

//@WebServlet("/ServiceAgent")
public class ServiceAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServiceAgent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String owner = request.getParameter("owner");
		String serviceName = request.getParameter("serviceName");
		DataDom dom = new DataDom(request.getParameter("dom"));
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute("sessionInfo");
		ServiceRequest serviceRequest = new ServiceRequest(request);
		PrintWriter out =response.getWriter();
		StringBuffer str = new StringBuffer();
		Object obj =null;
		if(owner==null){
			
			//反射调用
			try {
				obj = Class.forName("net.zx.lims.business.em.B1EMG00001").newInstance();
				Method m =obj.getClass().getMethod(serviceName,net.zx.lims.dom.DataDom.class, net.zx.lims.core.net.SessionInfo.class,net.zx.lims.core.net.ServiceRequest.class);
				m.invoke(obj, dom,sessionInfo,serviceRequest);
				//需要将函数的返回值返回
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/MisMgmtMvn/B1EMG00001.jsp").forward(request, response);
			
		}else{
			//反射调用

			HashMap<String,String> map =null;
			try {
				obj = Class.forName("net.zx.lims.business.em.B1EMG00001").newInstance();
				Method m =obj.getClass().getMethod(serviceName,net.zx.lims.dom.DataDom.class, net.zx.lims.core.net.SessionInfo.class,net.zx.lims.core.net.ServiceRequest.class);
				String rst = (String)m.invoke(obj, dom,sessionInfo,serviceRequest);
				map = serviceRequest.getServiceReturnParams();
				serviceRequest.addParameter(Content.requestMassage,rst);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			str.append("<script> serviceValue("+
					owner
					+ ","+map.entrySet()+") </script>");
		}
		
		out.print(str.toString());
		out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
