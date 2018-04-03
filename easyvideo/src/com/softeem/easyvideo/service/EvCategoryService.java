package com.softeem.easyvideo.service;

import java.sql.SQLException;
import java.util.List;
import com.softeem.easyvideo.dao.EvCategoryDAO;
import com.softeem.easyvideo.dto.EvCategory;
import com.softeem.easyvideo.utils.ServiceModel;

public class EvCategoryService {
	private static EvCategoryDAO categoryDao = new EvCategoryDAO();

	public ServiceModel findAll(){
		ServiceModel model = new ServiceModel();
		try {
			List<EvCategory> list = categoryDao.findAll();
			model.setSuccess(true);
			model.setCode(1);
			model.setData(list);
		} catch (SQLException e) {
			model.setCode(0);
			model.setMsg("≤È—Ø ß∞‹");
			e.printStackTrace();
		}
		return model;
	}
	public EvCategory square(int type){
		try {
			return categoryDao.findById(type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
