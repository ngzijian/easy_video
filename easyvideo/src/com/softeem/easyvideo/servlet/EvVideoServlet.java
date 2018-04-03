package com.softeem.easyvideo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softeem.easyvideo.dto.EvComm;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.dto.EvVideo;
import com.softeem.easyvideo.service.EvVideoService;
import com.softeem.easyvideo.servlet.base.BaseServlet;
import com.softeem.easyvideo.utils.PageBean;
import com.softeem.easyvideo.utils.ResponseUtils;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.view.CategoryView;
import com.softeem.easyvideo.utils.view.VideoView;

@WebServlet("/video.html")
public class EvVideoServlet extends BaseServlet {

	private static EvVideoService videoService = new EvVideoService();

	public void listVideosByCid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ServiceModel model = videoService.getVideosByCid();
		resp.setContentType("text/json;charset=utf-8");
		ResponseUtils.response(resp, model);

	}

	public void allVideosByCid(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int type = Integer.parseInt(req.getParameter("type"));
		int page = Integer.parseInt(req.getParameter("page"));
		PageBean<VideoView> pb = new PageBean<>();
		pb.setPage(page);
		ServiceModel model = videoService.allVideosByCid(type ,pb);
		resp.setContentType("text/json;charset=utf-8");
		ResponseUtils.response(resp, model);
	}

	public void fav(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/json;charset=utf-8");
		int videoId = Integer.parseInt(req.getParameter("videoId"));
		HttpSession session = req.getSession();
		EvUser user = (EvUser) session.getAttribute("user");
		if(user==null){
			ServiceModel model = new ServiceModel();
			model.setMsg("ÇëÏÈµÇÂ¼£¡");
			model.setCode(-2);
			ResponseUtils.response(resp, model);
		}else{
			int userId = user.getUserId();
			ServiceModel model = videoService.fav(videoId, userId);
			ResponseUtils.response(resp, model);
		}
		
	}

	

	public void uploadVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		req.getRequestDispatcher("WEB-INF/pages/uploadVideo.jsp").forward(req, resp);

	}

	public void watch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		int videoId = Integer.parseInt(req.getParameter("video"));
		EvVideo video = videoService.watch(videoId);
		
		req.setAttribute("video", video);
		req.getRequestDispatcher("WEB-INF/pages/watch.jsp").forward(req, resp);
		
		//resp.sendRedirect(video.getVideoPath());
	}
	
	public void rank(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ServiceModel model = videoService.rank();
		ResponseUtils.response(resp, model);
	}
	
}
