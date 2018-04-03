package com.softeem.easyvideo.utils.view;

import com.softeem.easyvideo.dto.EvComm;
import com.softeem.easyvideo.dto.EvUser;

public class CommView extends EvComm {
	
	private EvUser user;
	private CommView cmv;

	public EvUser getUser() {
		return user;
	}

	public void setUser(EvUser user) {
		this.user = user;
	}

	public CommView getCmv() {
		return cmv;
	}

	public void setCmv(CommView cmv) {
		this.cmv = cmv;
	}

	
	

}
