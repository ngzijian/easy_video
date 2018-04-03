package com.softeem.easyvideo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.softeem.easyvideo.db.DBUtils;
import com.softeem.easyvideo.db.DBUtils.CallBack;
import com.softeem.easyvideo.dto.EvUser;

public class EvUserDAO implements BaseDAO<EvUser> {

	@Override
	public boolean insert(EvUser t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EvUser t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvUser findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EvUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public EvUser findByEmail(String email) throws SQLException{
		String sql="select * from ev_user where user_email = ?";
		return DBUtils.exeQuery(sql, new CallBack<EvUser>() {

			@Override
			public EvUser getResult(ResultSet rs) {
				EvUser user = null;
				try {
					if(rs.next()){
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
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
		},email);
		
	}

}
