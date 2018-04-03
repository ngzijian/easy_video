package com.softeem.easyvideo.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * JSON���ݵ���Ӧ����
 * @author mrchai
 *
 */
public class ResponseUtils {

	public static void response(HttpServletResponse resp,ServiceModel model) throws IOException{
		String json = JSON.toJSONString(model);
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
	}

}
