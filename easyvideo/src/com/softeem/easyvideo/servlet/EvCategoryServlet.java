package com.softeem.easyvideo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.softeem.easyvideo.dto.EvCategory;
import com.softeem.easyvideo.service.EvCategoryService;
import com.softeem.easyvideo.servlet.base.BaseServlet;
import com.softeem.easyvideo.utils.ResponseUtils;
import com.softeem.easyvideo.utils.ServiceModel;
@WebServlet("/category.html")
public class EvCategoryServlet extends BaseServlet{
	private static EvCategoryService categoryService = new EvCategoryService();
	
	public void findAll(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/json;charset=utf-8");
		ServiceModel model = categoryService.findAll();
		ResponseUtils.response(resp, model);
	}
	public void square(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		int type = Integer.parseInt(req.getParameter("type"));
		EvCategory cate = categoryService.square(type);
		if(cate!=null){
			req.getSession().setAttribute("cate", cate);
			
		}
		req.getRequestDispatcher("WEB-INF/pages/square.jsp").forward(req, resp);
	}
	
}
