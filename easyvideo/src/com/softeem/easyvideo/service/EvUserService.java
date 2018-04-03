package com.softeem.easyvideo.service;

import java.sql.SQLException;
import java.util.List;

import com.softeem.easyvideo.dao.EvCategoryDAO;
import com.softeem.easyvideo.dao.EvUserDAO;
import com.softeem.easyvideo.dao.EvVideoDAO;
import com.softeem.easyvideo.dto.EvCategory;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.dto.EvVideo;
import com.softeem.easyvideo.utils.ServiceModel;

public class EvUserService {
	private static EvUserDAO userDao = new EvUserDAO();
	private static EvVideoDAO videoDao = new EvVideoDAO();
	private static EvCategoryDAO categoryDao = new EvCategoryDAO(); 
	
	public ServiceModel login(EvUser user) {
		ServiceModel model = new ServiceModel();
		try {
			EvUser tempUser = userDao.findByEmail(user.getUserEmail());
			if (tempUser != null) {
				if (tempUser.getUserPassword().equals(user.getUserPassword())) {
					if (tempUser.getUserStatus() == 1) {
						model.setCode(1);
						model.setMsg("µ«¬º≥…π¶");
						model.setSuccess(true);
						model.setData(tempUser);
					} else {
						model.setCode(-2);
						model.setMsg("’À∫≈Ω˚”√");
					}
				} else {
					model.setCode(0);
					model.setMsg("√‹¬Î¥ÌŒÛ");
				}
			} else {
				model.setCode(-1);
				model.setMsg("’ ∫≈≤ª¥Ê‘⁄");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	public ServiceModel uploadVideo(EvVideo video) {
		ServiceModel model = new ServiceModel();
		try {
			boolean i = videoDao.insert(video);
			if(i){
				model.setCode(1);
				model.setSuccess(true);
				model.setMsg("ÃÌº”≥…π¶");
			}else{
				model.setCode(0);
				model.setMsg("ÃÌº” ß∞‹");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	public ServiceModel listVideo(){
		ServiceModel model = new ServiceModel();
		try {
			List<EvCategory> cates = categoryDao.findAll();
			for (EvCategory cate : cates) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return model;
	}
}
