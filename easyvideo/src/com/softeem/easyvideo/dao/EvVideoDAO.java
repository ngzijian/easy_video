package com.softeem.easyvideo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.easyvideo.db.DBUtils;
import com.softeem.easyvideo.db.DBUtils.CallBack;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.dto.EvVideo;
import com.softeem.easyvideo.utils.ServiceModel;
import com.softeem.easyvideo.utils.view.CategoryView;
import com.softeem.easyvideo.utils.view.VideoView;

public class EvVideoDAO implements BaseDAO<EvVideo> {

	@Override
	public boolean insert(EvVideo video) throws SQLException {
		String sql = "insert into ev_video(video_name,video_uploadtime,video_path,uid,cid,video_pic) values(?,?,?,?,?,?)";
		return DBUtils.exeUpdate(sql, video.getVideoName(), video.getVideoUploadtime(), video.getVideoPath(),
				video.getUid(), video.getCid(), video.getVideoPic());
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	public boolean incrViewcount(int id) throws SQLException {
		String sql = "update ev_video set video_viewcount=video_viewcount+1 where video_id=?";

		return DBUtils.exeUpdate(sql, id);
	}
	public boolean incrComms(int id) throws SQLException{
		String sql = "update ev_video set video_comms=video_comms+1 where video_id=?";
		return DBUtils.exeUpdate(sql, id);
	}

	@Override
	public boolean update(EvVideo t) {
		return false;
	}

	@Override
	public EvVideo findById(int id) throws SQLException {
		String sql = "select * from ev_video where video_id = ?";
		return DBUtils.exeQuery(sql, new CallBack<EvVideo>() {

			@Override
			public EvVideo getResult(ResultSet rs) {
				EvVideo video = null;
				try {
					while (rs.next()) {
						video = new VideoView();
						video.setVideoId(rs.getInt("video_id"));
						video.setVideoName(rs.getString("video_name"));
						video.setVideoUploadtime(rs.getTimestamp("video_uploadtime"));
						video.setVideoPath(rs.getString("video_path"));
						video.setVideoViewcount(rs.getInt("video_viewcount"));
						video.setVideoFavcount(rs.getInt("video_favcount"));
						video.setVideoStatus(rs.getInt("video_status"));
						video.setVideoPic(rs.getString("video_pic"));
						video.setVideoComms(rs.getInt("video_comms"));
						video.setVideoInfo(rs.getString("video_info"));
						video.setCid(rs.getInt("cid"));
						video.setUid(rs.getInt("uid"));
						video.setFavUid(rs.getString("fav_uid"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return video;
			}
		}, id);
	}

	public List<VideoView> findByCid(int cid) throws SQLException {

		String sql = "select v.*,u.* from ev_video v join ev_user u on v.uid = u.user_id where v.cid = ? order by rand() limit 6";
		return DBUtils.exeQuery(sql, new CallBack<List<VideoView>>() {

			@Override
			public List<VideoView> getResult(ResultSet rs) {
				List<VideoView> videos = new ArrayList<>();
				VideoView video = null;
				EvUser user = null;
				try {
					while (rs.next()) {
						video = new VideoView();
						video.setVideoId(rs.getInt("video_id"));
						video.setVideoName(rs.getString("video_name"));
						video.setVideoUploadtime(rs.getTimestamp("video_uploadtime"));
						video.setVideoPath(rs.getString("video_path"));
						video.setVideoViewcount(rs.getInt("video_viewcount"));
						video.setVideoFavcount(rs.getInt("video_favcount"));
						video.setVideoStatus(rs.getInt("video_status"));
						video.setVideoPic(rs.getString("video_pic"));
						video.setVideoComms(rs.getInt("video_comms"));
						user = new EvUser();
						user.setUserId(rs.getInt("user_id"));
						user.setUserNickname(rs.getString("user_nickname"));
						user.setUserPic(rs.getString("user_pic"));
						video.setUser(user);
						videos.add(video);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return videos;
			}
		}, cid);
	}

	@Override
	public List<EvVideo> findAll() {
		return null;
	}

	public List<VideoView> allVideosByCid(int cateId, int page, int pageSize) throws SQLException {

		String sql = "select v.*,u.* from ev_video v join ev_user u on v.uid = u.user_id where v.cid = ? order by v.video_uploadtime DESC limit ?,? ";
		return DBUtils.exeQuery(sql, new CallBack<List<VideoView>>() {

			@Override
			public List<VideoView> getResult(ResultSet rs) {
				List<VideoView> videos = new ArrayList<>();
				VideoView video = null;
				EvUser user = null;
				try {
					while (rs.next()) {
						video = new VideoView();
						video.setVideoId(rs.getInt("video_id"));
						video.setVideoName(rs.getString("video_name"));
						video.setVideoUploadtime(rs.getTimestamp("video_uploadtime"));
						video.setVideoPath(rs.getString("video_path"));
						video.setVideoViewcount(rs.getInt("video_viewcount"));
						video.setVideoFavcount(rs.getInt("video_favcount"));
						video.setVideoStatus(rs.getInt("video_status"));
						video.setVideoPic(rs.getString("video_pic"));
						video.setVideoComms(rs.getInt("video_comms"));
						user = new EvUser();
						user.setUserId(rs.getInt("user_id"));
						user.setUserNickname(rs.getString("user_nickname"));
						user.setUserPic(rs.getString("user_pic"));
						video.setUser(user);
						videos.add(video);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return videos;
			}
		}, cateId, page, pageSize);
	}

	public boolean fav(int videoId, int userId) {
		String sql = "update ev_video set video_favcount = video_favcount+1,fav_uid=CONCAT(IFNULL(fav_uid,''),?) where video_id = ?";
		try {
			return DBUtils.exeUpdate(sql, userId + ",", videoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<VideoView> rank() throws SQLException {

		String sql = "select v.*,u.* from ev_video v,ev_user u where v.uid=u.user_id order by video_favcount DESC limit 0,10;";
		return DBUtils.exeQuery(sql, new CallBack<List<VideoView>>() {

			@Override
			public List<VideoView> getResult(ResultSet rs) {
				List<VideoView> videos = new ArrayList<>();
				VideoView video = null;
				EvUser user = null;
				try {
					while (rs.next()) {
						video = new VideoView();
						video.setVideoId(rs.getInt("video_id"));
						video.setVideoName(rs.getString("video_name"));
						video.setVideoUploadtime(rs.getTimestamp("video_uploadtime"));
						video.setVideoPath(rs.getString("video_path"));
						video.setVideoViewcount(rs.getInt("video_viewcount"));
						video.setVideoFavcount(rs.getInt("video_favcount"));
						video.setVideoStatus(rs.getInt("video_status"));
						video.setVideoPic(rs.getString("video_pic"));
						video.setVideoComms(rs.getInt("video_comms"));
						user = new EvUser();
						user.setUserId(rs.getInt("user_id"));
						user.setUserNickname(rs.getString("user_nickname"));
						user.setUserPic(rs.getString("user_pic"));
						video.setUser(user);
						videos.add(video);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return videos;
			}
		} );
	}
	
}
