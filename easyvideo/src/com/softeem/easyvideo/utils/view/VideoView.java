package com.softeem.easyvideo.utils.view;

import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.dto.EvVideo;

public class VideoView extends EvVideo {
	
	private EvUser user;

	public EvUser getUser() {
		return user;
	}

	public void setUser(EvUser user) {
		this.user = user;
	}
	
}
