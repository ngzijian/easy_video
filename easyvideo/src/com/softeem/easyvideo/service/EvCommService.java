package com.softeem.easyvideo.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.softeem.easyvideo.dao.EvCommDAO;
import com.softeem.easyvideo.dao.EvVideoDAO;
import com.softeem.easyvideo.dto.EvComm;
import com.softeem.easyvideo.utils.PageBean;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.view.CommView;

public class EvCommService {
	
	private static EvCommDAO commDao = new EvCommDAO();
	private static EvVideoDAO videoDao = new EvVideoDAO();
	
	public ServiceModel comm(EvComm comm){
		ServiceModel model = new ServiceModel();
		try {
			comm.setCommPtime(new Timestamp(System.currentTimeMillis()));;
			int id = commDao.insertRid(comm);
			videoDao.incrComms(comm.getVid());
			CommView cmv = commDao.findById(id);
			
			if(cmv.getPid()!=0){
				CommView cmv1 = commDao.findById(cmv.getPid());
				cmv.setCmv(cmv1);
			}
			if(cmv==null){
				model.setSuccess(false);
				model.setCode(0);
				model.setMsg("≤Â»Î ß∞‹");
			}else{
				model.setSuccess(true);
				model.setCode(1);
				model.setData(cmv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			model.setSuccess(false);
			model.setCode(-1);
			model.setMsg("≤Â»Î ß∞‹");
		}
		
		return model;
	}
	public ServiceModel getComms(PageBean<CommView> pb,int videoId){
		ServiceModel model = new ServiceModel();
		try {
			List<CommView> list = commDao.getComms(videoId,(pb.getPage()-1)*pb.getPageSize(), pb.getPageSize());
			pb.setList(list);
			model.setCode(1);
			model.setData(pb);
			model.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			model.setCode(0);
			model.setMsg("≤È—Ø∆¿¬€¡–±Ì ß∞‹");
		}
		return model;
	}
}
