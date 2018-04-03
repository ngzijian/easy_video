package com.softeem.easyvideo.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.softeem.easyvideo.dto.EvComm;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.service.EvCommService;
import com.softeem.easyvideo.servlet.base.BaseServlet;
import com.softeem.easyvideo.utils.PageBean;
import com.softeem.easyvideo.utils.ResponseUtils;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.view.CommView;


@WebServlet("/comm.html")
public class EvCommServlet extends BaseServlet {
	private static final String EvUser = null;
	private static EvCommService commService = new EvCommService();

	public void comm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int videoId = Integer.parseInt(req.getParameter("videoId"));
		int pid = Integer.parseInt(req.getParameter("pid"));
		String videoinfo = req.getParameter("videoinfo");
		EvComm comm = new EvComm();
		comm.setVid(videoId);
		comm.setCommContent(videoinfo);
		EvUser user = (EvUser) req.getSession().getAttribute("user");
		if (user == null) {
			ServiceModel model = new ServiceModel();
			model.setMsg("ÇëÏÈµÇÂ¼£¡");
			model.setCode(-2);
			ResponseUtils.response(resp, model);
		} else {
			comm.setUid(user.getUserId());
			if (pid != 0) {
				comm.setPid(pid);
			}

			ServiceModel model = commService.comm(comm);
			ResponseUtils.response(resp, model);
		}
	}

	public void getCommsByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int videoId = Integer.parseInt(req.getParameter("videoId"));
		PageBean<CommView> pb = new PageBean<>();
		pb.setPage(page);
		ServiceModel model = commService.getComms(pb, videoId);
		ResponseUtils.response(resp, model);

	}
}
