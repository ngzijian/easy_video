package com.softeem.easyvideo.utils;

/**
 * 业务逻辑模型结果对象
 * @author mrchai
 *
 */
public class ServiceModel {

	private int code;	//状态码
	private String msg; //消息
	private boolean success;
	private Object data;//需要传递到前端的数据
	
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
