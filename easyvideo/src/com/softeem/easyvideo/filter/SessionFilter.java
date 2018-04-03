/*package com.softeem.easyvideo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.easyvideo.dto.EvUser;

@WebFilter(urlPatterns = { "/comm.html", "/video.html" })
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("½øÈëSessionFilter¹ýÂËÆ÷");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// System.out.println(request.getParameter("method"));
		if ("fav".equals(request.getParameter("method")) || "/easyvideo/comm.html".equals(request.getRequestURI())) {
			EvUser user = (EvUser) request.getSession().getAttribute("user");
			if (user == null) {
				response.sendRedirect("/index.jsp");
			}
		} else {

			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
*/