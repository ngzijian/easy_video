package com.softeem.easyvideo.dto;/******************************************************************************* * javaBeans * ev_web_info --> EvWebInfo  * <table explanation> * @author 2018-01-31 16:17:08 *  */	public class EvWebInfo implements java.io.Serializable {	//field	/**  **/	private int id;	/**  **/	private String name;	/**  **/	private String keywords;	/**  **/	private String description;	/**  **/	private String icp;	/**  **/	private String comname;	/**  **/	private String tel;	/**  **/	private String email;	//method	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public String getKeywords() {		return keywords;	}	public void setKeywords(String keywords) {		this.keywords = keywords;	}	public String getDescription() {		return description;	}	public void setDescription(String description) {		this.description = description;	}	public String getIcp() {		return icp;	}	public void setIcp(String icp) {		this.icp = icp;	}	public String getComname() {		return comname;	}	public void setComname(String comname) {		this.comname = comname;	}	public String getTel() {		return tel;	}	public void setTel(String tel) {		this.tel = tel;	}	public String getEmail() {		return email;	}	public void setEmail(String email) {		this.email = email;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'name':'"+this.getName()+"',");		sb.append("'keywords':'"+this.getKeywords()+"',");		sb.append("'description':'"+this.getDescription()+"',");		sb.append("'icp':'"+this.getIcp()+"',");		sb.append("'comname':'"+this.getComname()+"',");		sb.append("'tel':'"+this.getTel()+"',");		sb.append("'email':'"+this.getEmail()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"id","name","keywords","description","icp","comname","tel","email"};	}}