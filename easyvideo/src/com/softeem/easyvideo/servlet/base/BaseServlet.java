package com.softeem.easyvideo.servlet.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 核心控制器（所有的自定义servlet都从该servlet继承，由BaseServlet实现请求转发，统一控制），
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
			//获取需要被执行的方法名称
			String method = req.getParameter("method");
			//根据方法名称获取方法对象
			Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//通过反射机制实现方法的动态调用
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
