package com.softeem.easyvideo.service;

import java.sql.SQLException;

import com.softeem.easyvideo.dao.EvAdminDAO;
import com.softeem.easyvideo.dto.EvAdmin;
import com.softeem.easyvideo.utils.ServiceModel;

/**
 * Model(数据模型，业务逻辑模型)
 * Controller
 * View
 * 业务逻辑层(业务逻辑模型)
 * @author mrchai
 *
 */
public class EvAdminService {

	private static EvAdminDAO dao = new EvAdminDAO();
	/**
	 * 新增管理员
	 * @param admin
	 * @return
	 */
	public ServiceModel add(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			//判断管理员是否存在
			if(dao.findByUsername(admin.getAdName()) == null){				
				//若不存在则添加
				if(dao.insert(admin)){
					model.setCode(1);//添加完成
					model.setSuccess(true);
					model.setMsg("添加成功");
				}else{
					model.setCode(0);//添加失败
					model.setMsg("添加失败");
				}
			}else{
				//该名称管理员已经被添加
				model.setCode(-1);//账号已经存在
				model.setMsg("账号已存在");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	//登录业务逻辑
	public ServiceModel login(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			EvAdmin tempAdmin = dao.findByUsername(admin.getAdName());
			if(tempAdmin != null){
				if(tempAdmin.getAdPass().equals(admin.getAdPass())){
					//密码正确
					if(tempAdmin.getAdState() == 1){
						//登录成功
						model.setCode(1);
						model.setMsg("登录成功");
						model.setSuccess(true);
						model.setData(tempAdmin);
					}else{
						//账号禁用
						model.setCode(-2);
						model.setMsg("账号禁用");
					}
				}else{
					//密码错误
					model.setCode(0);
					model.setMsg("密码错误");
				}
			}else{
				//账号不存在
				model.setCode(-1);
				model.setMsg("账号不存在");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ServiceModel modifyPassword(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			EvAdmin evAdmin = dao.findById(admin.getAdId());
			//判断旧密码是否与新密码一致
			if(!evAdmin.getAdPass().equals(admin.getAdPass())){
				boolean f = dao.updatePasword(admin);
				if(f){
					model.setCode(1);
					model.setMsg("修改成功");
					model.setSuccess(true);
				}else{
					model.setCode(0);
					model.setMsg("修改失败");
				}
			}else{
				model.setCode(-1);
				model.setMsg("密码未修改");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public ServiceModel modifyStatus(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			boolean f = dao.updateStatus(admin);
			if(f){
				model.setCode(1);
				model.setMsg("修改成功");
				model.setSuccess(true);
			}else{
				model.setCode(-1);
				model.setMsg("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
}
