package com.softeem.easyvideo.utils;

/**
 * ҵ���߼�ģ�ͽ������
 * @author mrchai
 *
 */
public class ServiceModel {

	private int code;	//״̬��
	private String msg; //��Ϣ
	private boolean success;
	private Object data;//��Ҫ���ݵ�ǰ�˵�����
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ServiceModel [code=" + code + ", msg=" + msg + ", success=" + success + ", data=" + data + "]";
	}
	
	

}
