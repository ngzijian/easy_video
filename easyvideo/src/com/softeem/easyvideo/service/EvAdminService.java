package com.softeem.easyvideo.service;

import java.sql.SQLException;

import com.softeem.easyvideo.dao.EvAdminDAO;
import com.softeem.easyvideo.dto.EvAdmin;
import com.softeem.easyvideo.utils.ServiceModel;

/**
 * Model(����ģ�ͣ�ҵ���߼�ģ��)
 * Controller
 * View
 * ҵ���߼���(ҵ���߼�ģ��)
 * @author mrchai
 *
 */
public class EvAdminService {

	private static EvAdminDAO dao = new EvAdminDAO();
	/**
	 * ��������Ա
	 * @param admin
	 * @return
	 */
	public ServiceModel add(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			//�жϹ���Ա�Ƿ����
			if(dao.findByUsername(admin.getAdName()) == null){				
				//�������������
				if(dao.insert(admin)){
					model.setCode(1);//������
					model.setSuccess(true);
					model.setMsg("��ӳɹ�");
				}else{
					model.setCode(0);//���ʧ��
					model.setMsg("���ʧ��");
				}
			}else{
				//�����ƹ���Ա�Ѿ������
				model.setCode(-1);//�˺��Ѿ�����
				model.setMsg("�˺��Ѵ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	//��¼ҵ���߼�
	public ServiceModel login(EvAdmin admin){
		ServiceModel model = new ServiceModel();
		try {
			EvAdmin tempAdmin = dao.findByUsername(admin.getAdName());
			if(tempAdmin != null){
				if(tempAdmin.getAdPass().equals(admin.getAdPass())){
					//������ȷ
					if(tempAdmin.getAdState() == 1){
						//��¼�ɹ�
						model.setCode(1);
						model.setMsg("��¼�ɹ�");
						model.setSuccess(true);
						model.setData(tempAdmin);
					}else{
						//�˺Ž���
						model.setCode(-2);
						model.setMsg("�˺Ž���");
					}
				}else{
					//�������
					model.setCode(0);
					model.setMsg("�������");
				}
			}else{
				//�˺Ų�����
				model.setCode(-1);
				model.setMsg("�˺Ų�����");
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
			//�жϾ������Ƿ���������һ��
			if(!evAdmin.getAdPass().equals(admin.getAdPass())){
				boolean f = dao.updatePasword(admin);
				if(f){
					model.setCode(1);
					model.setMsg("�޸ĳɹ�");
					model.setSuccess(true);
				}else{
					model.setCode(0);
					model.setMsg("�޸�ʧ��");
				}
			}else{
				model.setCode(-1);
				model.setMsg("����δ�޸�");
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
				model.setMsg("�޸ĳɹ�");
				model.setSuccess(true);
			}else{
				model.setCode(-1);
				model.setMsg("�޸�ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
}
