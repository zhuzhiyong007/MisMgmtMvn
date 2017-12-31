package net.zx.lims.core.net;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FrontFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	// 从xml中取值
	String uncheckUrls = null;
	String userSessionKey = null;
	String rediretPage = null;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// 1.得到访问路径
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String servletPath = request.getServletPath();
		List<String> urls = Arrays.asList(uncheckUrls.split(","));
		// 2.如果是属于不需要过滤的地址就直接 放行 方法结束
		if (urls.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}

		Object user = request.getSession().getAttribute(userSessionKey);
		if (user == null) {
			//客户端为什么不行
			//String login = request.getContextPath() + rediretPage;
			//response.sendRedirect(login);
			request.getRequestDispatcher(rediretPage).forward(request, response);
			return;
		}

		// 4、否则放行
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		rediretPage = fConfig.getServletContext().getInitParameter(
				"rediretPage");
		uncheckUrls = fConfig.getServletContext().getInitParameter(
				"uncheckUrls");
		userSessionKey = fConfig.getServletContext().getInitParameter(
				"userSessionKey");
	}

}
