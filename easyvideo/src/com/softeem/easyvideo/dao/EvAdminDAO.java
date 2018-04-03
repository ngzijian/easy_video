package com.softeem.easyvideo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.softeem.easyvideo.db.DBUtils;
import com.softeem.easyvideo.db.DBUtils.CallBack;
import com.softeem.easyvideo.dto.EvAdmin;

public class EvAdminDAO implements BaseDAO<EvAdmin> {

	@Override
	public boolean insert(EvAdmin t) throws SQLException {
		String sql = "insert into ev_admin(username,password) values(?,?)";
		return DBUtils.exeUpdate(sql, t.getAdName(),t.getAdPass());
	}

	@Override
	public boolean deleteById(int id) throws SQLException {
		String sql = "delete from ev_admin where id=?";
		return DBUtils.exeUpdate(sql, id);
	}

	public boolean updatePasword(EvAdmin t) throws SQLException{
		String sql = "update ev_admin set password=? where id=?";
		return DBUtils.exeUpdate(sql, t.getAdPass(),t.getAdId());
	}
	
	public boolean updateStatus(EvAdmin t) throws SQLException{
		String sql = "update ev_admin set status=? where id=?";
		return DBUtils.exeUpdate(sql, t.getAdState(),t.getAdId());
	}
	
	@Override
	public boolean update(EvAdmin t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvAdmin findById(final int id) throws SQLException {
		String sql = "select username,password,status from ev_admin where id=?";
		return DBUtils.exeQuery(sql, new CallBack<EvAdmin>() {
			@Override
			public EvAdmin getResult(ResultSet rs) {
				EvAdmin admin = null;
				try {
					if(rs.next()){
						admin = new EvAdmin();
						admin.setAdId(id);
						admin.setAdPass(rs.getString("password"));
						admin.setAdState(rs.getInt("status"));
						admin.setAdName(rs.getString("username"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return admin;
			}
		}, id);
	}

	@Override
	public List<EvAdmin> findAll() throws SQLException {
		String sql = "select id,username,password,status from ev_admin";
		
		return DBUtils.exeQuery(sql, new DBUtils.CallBack<List<EvAdmin>>() {
			@Override
			public List<EvAdmin> getResult(ResultSet rs) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	/**
	 * 根据用户名查询管理员对象
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public EvAdmin findByUsername(final String username) throws SQLException{
		String sql = "select * from ev_admin where username=?";
		return DBUtils.exeQuery(sql, new CallBack<EvAdmin>() {
			@Override
			public EvAdmin getResult(ResultSet rs) {
				EvAdmin admin = null;
				try {
					if(rs.next()){
						admin = new EvAdmin();
						admin.setAdId(rs.getInt("id"));
						admin.setAdPass(rs.getString("password"));
						admin.setAdState(rs.getInt("status"));
						admin.setAdName(rs.getString("username"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return admin;
			}
		}, username);
	}
	
}
