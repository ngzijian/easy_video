package com.softeem.easyvideo.utils.view;

import java.util.List;

import com.softeem.easyvideo.dto.EvCategory;

public class CategoryView extends EvCategory {
	
	private List<VideoView> videos;

	public List<VideoView> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoView> videos) {
		this.videos = videos;
	}
	
}
