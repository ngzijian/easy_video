package com.softeem.easyvideo.servlet.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���Ŀ����������е��Զ���servlet���Ӹ�servlet�̳У���BaseServletʵ������ת����ͳһ���ƣ���
 * @author mrchai
 *
 */
public class BaseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//��ȡ��Ҫ��ִ�еķ�������
			String method = req.getParameter("method");
			//���ݷ������ƻ�ȡ��������
			Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//ͨ���������ʵ�ַ����Ķ�̬����
			m.invoke(this, req,resp);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
