package com.softeem.easyvideo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.dto.EvVideo;
import com.softeem.easyvideo.service.EvUserService;
import com.softeem.easyvideo.servlet.base.BaseServlet;
import com.softeem.easyvideo.utils.ResponseUtils;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.UploadListener;
import com.softeem.easyvideo.utils.UploadStatus;

@WebServlet("/user.html")
public class EvUserServlet extends BaseServlet {

	private static EvUserService userService = new EvUserService();

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		EvUser user1 = (EvUser) req.getAttribute("user");
		resp.setContentType("text/json;charset=utf-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		EvUser user = new EvUser();
		user.setUserEmail(email);
		user.setUserPassword(password);
		ServiceModel model = userService.login(user);
		if (model.isSuccess()) {
			req.getSession().setAttribute("user", model.getData());
		}
		ResponseUtils.response(resp, model);

	}

	public void uploadVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException, FileUploadException {
		boolean mark = false;
		// 上传状态
		UploadStatus status = new UploadStatus();
		// 监听器
		UploadListener listener = new UploadListener(status);
		// 把status放到session里
		req.getSession(true).setAttribute("status", status);

		EvVideo video = new EvVideo();
		String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		// 1工厂
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 2核心类
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		// 设置监听器
		servletFileUpload.setProgressListener(listener);

		// 解析request， List存放FileItem（表单元素的封装对象，一个<input>对应一个对象）
		List<FileItem> list = servletFileUpload.parseRequest(req);
		// 遍历集合，获得数据
		for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {
				// 5是否为表单字段（普通表单元素）
				// 5.1表单字段名称
				String fieldName = fileItem.getFieldName();
				System.out.println(fieldName);
				String fieldValue = fileItem.getString("utf-8");
				System.out.println(fieldValue);
				if (fieldName.equals("videoname")) {
					video.setVideoName(fieldValue);
				} else if (fieldName.equals("videoinfo")) {
					video.setVideoInfo(fieldValue);
				} else if (fieldName.equals("category")) {
					video.setCid(Integer.parseInt(fieldValue));
				}

			} else {
				// 6上传字段（上传表单元素）
				// 6.1表单字段名称fileItem.getFieldName()
				// 6.2上传文件名
				String fileName = fileItem.getName();
				if (fileName == null || fileName.isEmpty()) {
					continue;
				}
				fileName = fileName.replace("/", "\\");
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				fileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
				System.out.println(fileName);

				video.setVideoPath("upload/video/temp/" + dateDir + "/" + fileName);
				//video.setVideoPic("upload/pic/" + dateDir + "/" + fileName);
				String parentDirVideo = "d:/upload/video/temp/" + dateDir;
				String parentDirVideoFlv = "d:/upload/video/" + dateDir;
				String parentDirPic = "d:/upload/pic/" + dateDir;
				// 6.3上传内容,
				File file = new File(parentDirVideo, fileName);
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				File fileFlv = new File(parentDirVideoFlv, fileName.substring(0, fileName.lastIndexOf("."))+".flv");
				if (!fileFlv.getParentFile().exists()) {
					fileFlv.getParentFile().mkdirs();
				}
				/*if(!fileFlv.exists()){
					fileFlv.createNewFile();
				}*/
				//video.setVideoPath("upload/video/" + dateDir + "/" + fileName.substring(0, fileName.lastIndexOf("."))+".flv");
				File filePic = new File(parentDirPic, fileName.substring(0, fileName.lastIndexOf("."))+".jpg");
				if (!filePic.getParentFile().exists()) {
					filePic.getParentFile().mkdirs();
				}
				/*if(!filePic.exists()){
					filePic.createNewFile();
				}*/
				video.setVideoPic("upload/pic/" + dateDir + "/" + fileName.substring(0, fileName.lastIndexOf("."))+".jpg");
				
				InputStream is = fileItem.getInputStream();
				FileOutputStream os = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int len = -1;
				while ((len = is.read(buf)) != -1) {
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
				//mark = convertVideo(file.getPath(), fileFlv.getPath(), filePic.getPath());
				String ffmpegPath = getServletContext().getRealPath("/videos/")
						+ "\\ffmpeg.exe";
				mark = processImg(file.getPath(),filePic.getPath(),ffmpegPath);
			}
		}
		video.setVideoUploadtime(new Timestamp(System.currentTimeMillis()));
		video.setUid(((EvUser) req.getSession().getAttribute("user")).getUserId());
		if(mark){
			ServiceModel model = userService.uploadVideo(video);

		}
	}
	
	  public  boolean processImg(String veido_path,String pic, String ffmpeg_path) {
		    File file = new File(veido_path);
		    if (!file.exists()) {
		      System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");
		      return false;
		    }
		    List<String> commands = new java.util.ArrayList<String>();
		    commands.add(ffmpeg_path);
		    commands.add("-i");
		    commands.add(veido_path);
		    commands.add("-y");
		    commands.add("-f");
		    commands.add("image2");
		    commands.add("-ss");
		    commands.add("8");// 这个参数是设置截取视频多少秒时的画面
		    // commands.add("-t");
		    // commands.add("0.001");
		    commands.add("-s");
		    commands.add("700x700");
		    commands.add(pic);
		    try {
		      ProcessBuilder builder = new ProcessBuilder();
		      builder.command(commands);
		      builder.start();
		      System.out.println("截取成功");
		      return true;
		    } catch (Exception e) {
		      e.printStackTrace();
		      return false;
		    }
		  }
	
	/**
	 * @功能：①转换上传的视频为FLV格式；②从上传的视频中截图。
	 * @参数：①upFilePath： 用于指定要转换格式的文件路径；以及用来指定要截图的视频。<br>
	 * @参数：②flvFilePath：用于指定转换为FLV格式后的文件的保存路径。<br>
	 * @参数：③cutPicPath： 用于指定截取的图片的保存路径
	 * @返回：boolean型值
	 */
	private boolean convertVideo(String upFilePath, String flvFilePath,
			String cutPicPath) {
		String ffmpegPath = getServletContext().getRealPath("/videos/")
				+ "\\ffmpeg.exe"; // 获取在web.xml中配置的转换工具（ffmpeg.exe）的存放路径
		// 创建一个List集合来保存转换视频文件为flv格式的命令
		/*List<String> convert = new ArrayList<String>();
		convert.add(ffmpegPath); // 添加转换工具路径
		convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
		convert.add(upFilePath); // 添加要转换格式的视频文件的路径
		convert.add("-qscale");
		convert.add("6");
		convert.add("-ab");
		convert.add("64");
		convert.add("-acodec");
		convert.add("mp3");
		convert.add("-ac");
		convert.add("2");
		convert.add("-ar");
		convert.add("22050");
		convert.add("-r");
		convert.add("24");
		convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
		convert.add(flvFilePath);
*/
		// 创建一个List集合来保存从视频中截取图片的命令
		List<String> cutpic = new ArrayList<String>();
		cutpic.add(ffmpegPath);
		cutpic.add("-i");
		cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
		cutpic.add("-y");
		cutpic.add("-f");
		cutpic.add("image2");
		cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
		cutpic.add("9"); // 添加起始时间为第9秒
		cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
		cutpic.add("0.001"); // 添加持续时间为1毫秒
		cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
		cutpic.add("350*240"); // 添加截取的图片大小为350*240
		cutpic.add(cutPicPath); // 添加截取的图片的保存路径

		boolean mark = true;
		ProcessBuilder builder = new ProcessBuilder();
		try {
			/*builder.command(convert);
			builder.start();*/
			builder.command(cutpic);
			builder.start();
		} catch (Exception e) {
			mark = false;
			System.out.println(e);
			e.printStackTrace();
		}
		return mark;
	}

	public void listenUpVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("************");
		resp.setHeader("Cache-Control", "no-store");
		resp.setHeader("Pragrma", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("text/json;charset=utf-8");

		UploadStatus status = (UploadStatus) req.getSession(true).getAttribute("status");
		PrintWriter writer = resp.getWriter();
		if (status == null) {
			return;
		}
		long startTime = status.getStartTime();
		long currentTime = System.currentTimeMillis();

		// 以传输的时间 单位：s
		long time = (currentTime - startTime) / 1000 + 1;
		// 传输速率 单位：byte/s
		double velocity = ((double) status.getBytesRead()) / (double) time;
		// 估计总时间 单位：s
		double totalTime = status.getContentLength() / velocity;
		// 估计剩余时间 单位：s
		double timeLeft = totalTime - time;
		// 已完成的百分比
		int percent = (int) (100 * (double) status.getBytesRead() / (double) status.getContentLength());
		// 已完成数 单位：M
		double length = ((double) status.getBytesRead()) / 1024 / 1024;
		// 总长度 单位：M
		double totalLength = ((double) status.getContentLength()) / 1024 / 1024;
		// 格式：百分比||已完成数(M)||文件总长度(M)||传输速率(K)||已用时间(s)||估计总时间(s)||估计剩余时间(s)||正在上传第几个文件
		String value = percent + "||" + length + "||" + totalLength + "||" + velocity + "||" + time + "||" + totalTime
				+ "||" + timeLeft + "||" + status.getItems();
		String json = JSON.toJSONString(value);
		writer.println(json);
		writer.flush();

	}

	public void upload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		req.getRequestDispatcher("/WEB-INF/pages/upload.html").forward(req, resp);
	}

}
