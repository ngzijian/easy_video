package com.softeem.easyvideo.utils;

import org.apache.commons.fileupload.ProgressListener;

public class UploadListener implements ProgressListener {
	
	private UploadStatus status;

	
	
	public UploadListener(UploadStatus status) {
		this.status = status;
	}



	@Override
	public void update(long bytesRead, long contentLength, int items) {
		status.setBytesRead(bytesRead);
		status.setContentLength(contentLength);
		status.setItems(items);
		
	}

}
