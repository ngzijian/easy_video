package com.softeem.easyvideo.filter;

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

/**
 * 过滤器:可以实现对指定请求的过滤处理，常用于：编码过滤，非法登录，敏感词
 * 创建流程:
 * 1.创建普通类实现Filter接口
 * 2.实现接口中的方法（doFilter）
 * 3.配置
 * @author mrchai
 */
@WebFilter("/*")
public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("进入编码过滤器");
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//对请求放行
		chain.doFilter(request, response);	
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



	

}
