package com.softeem.easyvideo.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;

public class DBUtils {
	
//	private static  String DRIVER;
	private static  String URL;
	private static  String USER;
	private static  String PASSWORD;
	private static  int INIT_SIZE;
	private static  int MIN_IDLE;
	private static  int MAX_ACTIVE;
	private static  long MAX_WAIT;
	private static DruidDataSource dds;
	static{
		InputStream is = null;
		dds = new DruidDataSource();
		try {
			is = DBUtils.class.getResourceAsStream("jdbc.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			URL=prop.getProperty("url");
			USER=prop.getProperty("user");
			PASSWORD=prop.getProperty("password");
			INIT_SIZE=Integer.parseInt(prop.getProperty("initSize"));
			MIN_IDLE=Integer.parseInt(prop.getProperty("minIdle"));
			MAX_ACTIVE=Integer.parseInt(prop.getProperty("maxActive"));
			MAX_WAIT=Integer.parseInt(prop.getProperty("maxWait"));
//			System.out.println(URL+USER+PASSWORD+INIT_SIZE+MIN_IDEL+MAX_ACTIVE+MAX_WAIT);
			dds.setUrl(URL);
			dds.setUsername(USER);
			dds.setPassword(PASSWORD);
			dds.setInitialSize(INIT_SIZE);
			dds.setMinIdle(MIN_IDLE);
			dds.setMaxActive(MAX_ACTIVE);
			dds.setMaxWait(MAX_WAIT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Connection getConn(){
		try {
			return dds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param sql
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	public static boolean exeUpdate(String sql,Object... objs) throws SQLException{
		Connection conn = DBUtils.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i=0;i<objs.length;i++){
			ps.setObject(i+1, objs[i]);
			
		}
		int i = ps.executeUpdate();
		ps.close();
		conn.close();
		if(i>0){
			return true;
		}
		return false;
	}
	public static <T> T exeQuery(String sql,CallBack<T> call,Object... objs) throws SQLException{
		Connection conn = DBUtils.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i=0;i<objs.length;i++){
			ps.setObject(i+1, objs[i]);
			
		}
		ResultSet rs = ps.executeQuery();
		return call.getResult(rs);
	}
	
	public interface CallBack<T>{
		public T getResult(ResultSet rs);
	}
	
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
