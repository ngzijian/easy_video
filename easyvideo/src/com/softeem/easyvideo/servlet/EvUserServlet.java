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
		// �ϴ�״̬
		UploadStatus status = new UploadStatus();
		// ������
		UploadListener listener = new UploadListener(status);
		// ��status�ŵ�session��
		req.getSession(true).setAttribute("status", status);

		EvVideo video = new EvVideo();
		String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		// 1����
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 2������
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		// ���ü�����
		servletFileUpload.setProgressListener(listener);

		// ����request�� List���FileItem����Ԫ�صķ�װ����һ��<input>��Ӧһ������
		List<FileItem> list = servletFileUpload.parseRequest(req);
		// �������ϣ��������
		for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {
				// 5�Ƿ�Ϊ���ֶΣ���ͨ��Ԫ�أ�
				// 5.1���ֶ�����
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
				// 6�ϴ��ֶΣ��ϴ���Ԫ�أ�
				// 6.1���ֶ�����fileItem.getFieldName()
				// 6.2�ϴ��ļ���
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
				// 6.3�ϴ�����,
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
		      System.err.println("·��[" + veido_path + "]��Ӧ����Ƶ�ļ�������!");
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
		    commands.add("8");// ������������ý�ȡ��Ƶ������ʱ�Ļ���
		    // commands.add("-t");
		    // commands.add("0.001");
		    commands.add("-s");
		    commands.add("700x700");
		    commands.add(pic);
		    try {
		      ProcessBuilder builder = new ProcessBuilder();
		      builder.command(commands);
		      builder.start();
		      System.out.println("��ȡ�ɹ�");
		      return true;
		    } catch (Exception e) {
		      e.printStackTrace();
		      return false;
		    }
		  }
	
	/**
	 * @���ܣ���ת���ϴ�����ƵΪFLV��ʽ���ڴ��ϴ�����Ƶ�н�ͼ��
	 * @��������upFilePath�� ����ָ��Ҫת����ʽ���ļ�·�����Լ�����ָ��Ҫ��ͼ����Ƶ��<br>
	 * @��������flvFilePath������ָ��ת��ΪFLV��ʽ����ļ��ı���·����<br>
	 * @��������cutPicPath�� ����ָ����ȡ��ͼƬ�ı���·��
	 * @���أ�boolean��ֵ
	 */
	private boolean convertVideo(String upFilePath, String flvFilePath,
			String cutPicPath) {
		String ffmpegPath = getServletContext().getRealPath("/videos/")
				+ "\\ffmpeg.exe"; // ��ȡ��web.xml�����õ�ת�����ߣ�ffmpeg.exe���Ĵ��·��
		// ����һ��List����������ת����Ƶ�ļ�Ϊflv��ʽ������
		/*List<String> convert = new ArrayList<String>();
		convert.add(ffmpegPath); // ���ת������·��
		convert.add("-i"); // ��Ӳ�����-i�����ò���ָ��Ҫת�����ļ�
		convert.add(upFilePath); // ���Ҫת����ʽ����Ƶ�ļ���·��
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
		convert.add("-y"); // ��Ӳ�����-y�����ò���ָ���������Ѵ��ڵ��ļ�
		convert.add(flvFilePath);
*/
		// ����һ��List�������������Ƶ�н�ȡͼƬ������
		List<String> cutpic = new ArrayList<String>();
		cutpic.add(ffmpegPath);
		cutpic.add("-i");
		cutpic.add(upFilePath); // ͬ�ϣ�ָ�����ļ���������ת��Ϊflv��ʽ֮ǰ���ļ���Ҳ������ת����flv�ļ���
		cutpic.add("-y");
		cutpic.add("-f");
		cutpic.add("image2");
		cutpic.add("-ss"); // ��Ӳ�����-ss�����ò���ָ����ȡ����ʼʱ��
		cutpic.add("9"); // �����ʼʱ��Ϊ��9��
		cutpic.add("-t"); // ��Ӳ�����-t�����ò���ָ������ʱ��
		cutpic.add("0.001"); // ��ӳ���ʱ��Ϊ1����
		cutpic.add("-s"); // ��Ӳ�����-s�����ò���ָ����ȡ��ͼƬ��С
		cutpic.add("350*240"); // ��ӽ�ȡ��ͼƬ��СΪ350*240
		cutpic.add(cutPicPath); // ��ӽ�ȡ��ͼƬ�ı���·��

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

		// �Դ����ʱ�� ��λ��s
		long time = (currentTime - startTime) / 1000 + 1;
		// �������� ��λ��byte/s
		double velocity = ((double) status.getBytesRead()) / (double) time;
		// ������ʱ�� ��λ��s
		double totalTime = status.getContentLength() / velocity;
		// ����ʣ��ʱ�� ��λ��s
		double timeLeft = totalTime - time;
		// ����ɵİٷֱ�
		int percent = (int) (100 * (double) status.getBytesRead() / (double) status.getContentLength());
		// ������� ��λ��M
		double length = ((double) status.getBytesRead()) / 1024 / 1024;
		// �ܳ��� ��λ��M
		double totalLength = ((double) status.getContentLength()) / 1024 / 1024;
		// ��ʽ���ٷֱ�||�������(M)||�ļ��ܳ���(M)||��������(K)||����ʱ��(s)||������ʱ��(s)||����ʣ��ʱ��(s)||�����ϴ��ڼ����ļ�
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
