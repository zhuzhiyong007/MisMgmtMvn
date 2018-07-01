package net.zx.lims.core.net;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
// @WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * String name = request.getParameter("name") ; String password =
		 * request.getParameter("password") ; PrintWriter out =
		 * response.getWriter() ; out.println("<html>") ;
		 * out.println("<head><title>MLDNJAVA</title></head>") ;
		 * out.println("<body>") ; out.println("<h1>" + name + "</h1>") ;
		 * out.println("</body>") ; out.println("</html>") ; out.close() ;
		 */

		String name = request.getParameter("userName");
		String passwd = request.getParameter("password");
		String eid = request.getParameter("eid");
		if ("sys".equals(name)) {
			// 服务器端跳转
			request.getSession().setAttribute("name", "sys");
			request.setAttribute("info", "MLDNJAVA");
			
			//
			request.getSession().setAttribute("USERSESSONKEY", "zzy");
			
			String id = (String) request.getSession().getAttribute("USERSESSONKEY");
			
			//RequestDispatcher rd = request.getRequestDispatcher("/main.jsp"); // 准备好了跳转操作
			//RequestDispatcher rd = request.getRequestDispatcher("/xlst/index.jsp"); // 准备好了跳转操作
			//rd.forward(request, response); // 完成跳转
			response.sendRedirect("/MisMgmtMvn/xlst/datepicker.jsp");
		}
		else {
		
			// 客户端跳转  和 Login过滤器冲突了
			/*request.getSession().setAttribute("name", "李兴华");
			request.setAttribute("info", "MLDNJAVA");
			response.sendRedirect("/MisMgmtMvn/xlst/index2.jsp");*/
			
			//RequestDispatcher rd = request.getRequestDispatcher("/main.jsp"); // 准备好了跳转操作
			//RequestDispatcher rd = request.getRequestDispatcher("/xlst/index.jsp"); // 准备好了跳转操作
			//rd.forward(request, response); // 完成跳转
			response.sendRedirect("/MisMgmtMvn/xlst/datepicker.jsp");
		}
	}
}
