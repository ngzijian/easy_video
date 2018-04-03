package com.softeem.easyvideo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.softeem.easyvideo.db.DBUtils;
import com.softeem.easyvideo.db.DBUtils.CallBack;
import com.softeem.easyvideo.dto.EvComm;
import com.softeem.easyvideo.dto.EvUser;
import com.softeem.easyvideo.utils.view.CommView;

public class EvCommDAO implements BaseDAO<EvComm> {

	@Override
	public boolean insert(EvComm t) {
		// TODO Auto-generated method stub
		return false;
	}
	public int insertRid(EvComm comm) throws SQLException {
		int id=0;  
		String sql="insert into ev_comm(comm_content,comm_ptime,vid,uid,pid) values(?,?,?,?,?);";
		Connection conn = DBUtils.getConn();
		PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, comm.getCommContent());
		statement.setTimestamp(2, comm.getCommPtime());
		statement.setInt(3, comm.getVid());
		statement.setInt(4, comm.getUid());
		statement.setInt(5, comm.getPid());
		int i = statement.executeUpdate();
		if(i>0){
			ResultSet rs = statement.getGeneratedKeys();
			while(rs.next()){
				id = rs.getInt(1);
			}
		}
		
		statement.close();
		conn.close();
		return id;
	}
	
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EvComm t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommView findById(int id) throws SQLException {
		String sql="select c.*,u.* from ev_comm c,ev_user u where comm_id=? and c.uid=u.user_id";
		
		return DBUtils.exeQuery(sql, new CallBack<CommView>() {

			@Override
			public CommView getResult(ResultSet rs) {
				CommView cmv = null;
				EvUser user = null;
				try {
					while(rs.next()){
						cmv = new CommView();
						cmv.setCommId(rs.getInt("comm_id"));
						cmv.setCommContent(rs.getString("comm_content"));
						cmv.setCommPtime(rs.getTimestamp("comm_ptime"));
						cmv.setPid(rs.getInt("pid"));
						cmv.setUid(rs.getInt("uid"));
						cmv.setVid(rs.getInt("vid"));
						user = new EvUser();
						user.setUserId(rs.getInt("user_id"));
						user.setUserNickname(rs.getString("user_nickname"));
						user.setUserPhone(rs.getString("user_phone"));
						user.setUserPassword(rs.getString("user_password"));
						user.setUserRegtime(rs.getTimestamp("user_regtime"));
						user.setUserSex(rs.getString("user_sex"));
						user.setUserEmail(rs.getString("user_email"));
						user.setUserBirth(rs.getDate("user_birth"));
						user.setUserPic(rs.getString("user_pic"));
						user.setUserStatus(rs.getInt("user_status"));
						cmv.setUser(user);
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return cmv;
			}
		}, id);
	}
	public List<CommView> getComms(int videoId ,int page, int pageSize) throws SQLException{
		
		String sql = "select c.*,u.* from ev_comm c,ev_user u where c.uid=u.user_id and c.vid=? order by comm_ptime DESC limit ?,?";
		return DBUtils.exeQuery(sql, new CallBack<List<CommView>>() {

			@Override
			public List<CommView> getResult(ResultSet rs) {
				List<CommView> cvs = new ArrayList<>();
				CommView cv = null;
				EvUser user = null;
				try {
					while(rs.next()){
						cv = new CommView();
						cv.setCommId(rs.getInt("comm_id"));
						cv.setCommContent(rs.getString("comm_content"));
						cv.setCommPtime(rs.getTimestamp("comm_ptime"));
						cv.setPid(rs.getInt("pid"));
						cv.setUid(rs.getInt("uid"));
						cv.setVid(rs.getInt("vid"));
						user = new EvUser();
						user.setUserId(rs.getInt("user_id"));
						user.setUserNickname(rs.getString("user_nickname"));
						user.setUserPhone(rs.getString("user_phone"));
						user.setUserPassword(rs.getString("user_password"));
						user.setUserRegtime(rs.getTimestamp("user_regtime"));
						user.setUserSex(rs.getString("user_sex"));
						user.setUserEmail(rs.getString("user_email"));
						user.setUserBirth(rs.getDate("user_birth"));
						user.setUserPic(rs.getString("user_pic"));
						user.setUserStatus(rs.getInt("user_status"));
						cv.setUser(user);
						if(cv.getPid()!=0){
							CommView view = findById(cv.getPid());
							cv.setCmv(view);
						}
						cvs.add(cv);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return cvs;
			}
		} ,videoId, page,pageSize);
	}

	@Override
	public List<EvComm> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
