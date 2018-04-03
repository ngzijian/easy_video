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
 * ������:����ʵ�ֶ�ָ������Ĺ��˴��������ڣ�������ˣ��Ƿ���¼�����д�
 * ��������:
 * 1.������ͨ��ʵ��Filter�ӿ�
 * 2.ʵ�ֽӿ��еķ�����doFilter��
 * 3.����
 * @author mrchai
 */
@WebFilter("/*")
public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("������������");
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//���������
		chain.doFilter(request, response);	
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



	

}
