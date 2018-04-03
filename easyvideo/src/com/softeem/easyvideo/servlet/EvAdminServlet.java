package com.softeem.easyvideo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.softeem.easyvideo.dto.EvAdmin;
import com.softeem.easyvideo.service.EvAdminService;
import com.softeem.easyvideo.servlet.base.BaseServlet;
import com.softeem.easyvideo.utils.ResponseUtils;
import com.softeem.easyvideo.utils.ServiceModel;

/**
 * Servlet:Server+Applet �����ڷ���˵�javaС���򣬶Կͻ��˵��������������Լ���Ӧ
 * Servlet��������:
 * 1.������ͨjava��̳�HttpServlet
 * 2.��дdoGet/doPost����
 * 3.����Servlet��2.X��3.X��
 * @author mrchai
 *
 */
@WebServlet("/admin")
public class EvAdminServlet extends BaseServlet{
	
	/**
	 * ��¼
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		EvAdmin admin = new EvAdmin();
		admin.setAdName(username);
		admin.setAdPass(password);
		EvAdminService service = new EvAdminService();
		ServiceModel model = service.login(admin);
		ResponseUtils.response(resp, model);
	}

	/**
	 * ע��
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void register(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//��ȡ�˺�����
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		EvAdmin admin = new EvAdmin();
		admin.setAdName(name);
		admin.setAdPass(pass);
		EvAdminService service = new EvAdminService();
		ServiceModel model = service.add(admin);
		//��java����ת��Ϊjson���ݸ�ʽ
		ResponseUtils.response(resp, model);
	}
	
	/**
	 * �޸�����
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void modifyPwd(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String id = req.getParameter("id");
		String pwd = req.getParameter("password");
		EvAdminService service = new EvAdminService();
		EvAdmin admin = new EvAdmin();
		admin.setAdId(Integer.parseInt(id));
		admin.setAdPass(pwd);
		ServiceModel model = service.modifyPassword(admin);
		ResponseUtils.response(resp, model);
	}
	
	/**
	 * �޸��˺�״̬
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void modifyStatus(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String id = req.getParameter("id");
		String status = req.getParameter("status");
		EvAdminService service = new EvAdminService();
		EvAdmin admin = new EvAdmin();
		admin.setAdId(Integer.parseInt(id));
		admin.setAdState(Integer.parseInt(status));;
		ServiceModel model = service.modifyStatus(admin);
		ResponseUtils.response(resp, model);
	}
	
	

}
