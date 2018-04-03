package com.softeem.easyvideo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.easyvideo.dao.EvCategoryDAO;
import com.softeem.easyvideo.dao.EvVideoDAO;
import com.softeem.easyvideo.dto.EvCategory;
import com.softeem.easyvideo.dto.EvVideo;
import com.softeem.easyvideo.utils.PageBean;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.view.CategoryView;
import com.softeem.easyvideo.utils.view.VideoView;

public class EvVideoService {
	private static EvVideoDAO videoDao = new EvVideoDAO();
	private static EvCategoryDAO cateDao = new EvCategoryDAO();

	public ServiceModel getVideosByCid() {
		ServiceModel model = new ServiceModel();
		List<CategoryView> cvs = new ArrayList<>();
		CategoryView cv = null;
		try {
			List<EvCategory> cates = cateDao.findAll();
			for (EvCategory cate : cates) {
				List<VideoView> list = videoDao.findByCid(cate.getCateId());
				if (list != null & list.size() > 0) {
					cv = new CategoryView();
					cv.setCateId(cate.getCateId());
					cv.setCateName(cate.getCateName());
					cv.setVideos(list);
					cvs.add(cv);
				}
			}
			model.setData(cvs);
			model.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	public ServiceModel allVideosByCid(int cateId, PageBean<VideoView> pb) {
		ServiceModel model = new ServiceModel();
		List<VideoView> vvs = null;
		try {
			vvs = videoDao.allVideosByCid(cateId,(pb.getPage()-1)*pb.getPageSize(),pb.getPageSize());
			pb.setList(vvs);
			model.setCode(1);
			model.setData(pb);
			model.setSuccess(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
			model.setCode(0);
			model.setMsg("查询失败");
		}
		return model;
	}

	public ServiceModel fav(int videoId, int userId) {

		ServiceModel model = new ServiceModel();
		EvVideo video = null;
		try {
			video = videoDao.findById(videoId);
			String favUid = video.getFavUid();
			if(favUid != null){
				/*String[] aus = favUid.split(",");
				for (String au : aus) {
					if((userId+"").equals(au)){
						model.setCode(-1);
						model.setMsg("您已经点过赞了！");
						return model;
					}
				}*/
				if(favUid.contains(userId+"")){
					model.setCode(-1);
					model.setMsg("您已经点过赞了！");
					return model;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (videoDao.fav(videoId, userId)) {

			try {
				video = videoDao.findById(videoId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			model.setCode(1);
			model.setSuccess(true);
			model.setMsg("点赞成功");
			model.setData(video);

		} else {
			model.setCode(0);
			model.setMsg("点赞失败");
		}
		return model;
	}
	public EvVideo watch(int id){
		EvVideo video = null;
		try {
			boolean incrView = videoDao.incrViewcount(id);
			video = videoDao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return video;
	}
	
	public ServiceModel rank(){
		ServiceModel model = new ServiceModel();
		try {
			List<VideoView> list = videoDao.rank();
			//System.out.println(list);
			model.setSuccess(true);
			model.setCode(1);
			model.setData(list);
		} catch (SQLException e) {
			e.printStackTrace();
			model.setCode(0);
			model.setMsg("查询失败");
		}
		return model;
		
	}

}
