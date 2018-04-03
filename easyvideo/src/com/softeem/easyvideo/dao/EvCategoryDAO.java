package com.softeem.easyvideo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.easyvideo.db.DBUtils;
import com.softeem.easyvideo.db.DBUtils.CallBack;
import com.softeem.easyvideo.dto.EvCategory;

public class EvCategoryDAO implements BaseDAO<EvCategory> {

	@Override
	public boolean insert(EvCategory t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EvCategory t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EvCategory findById(int id) throws SQLException {
		String sql= "select * from ev_category where cate_id = ?";
		return DBUtils.exeQuery(sql, new CallBack<EvCategory>() {

			@Override
			public EvCategory getResult(ResultSet rs) {
				EvCategory cate = null;
				try {
					while(rs.next()){
						cate = new EvCategory();
						cate.setCateId(rs.getInt("cate_Id"));
						cate.setCateName(rs.getString("cate_name"));
						cate.setCateSummary(rs.getString("cate_summary"));
						cate.setCateInserttime(rs.getTimestamp("cate_inserttime"));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return cate;
			}
		}, id);
	}

	@Override
	public List<EvCategory> findAll() throws SQLException {
		String sql = "select cate_id,cate_name,cate_summary,cate_inserttime from ev_category";
		return DBUtils.exeQuery(sql, new CallBack<List<EvCategory>>() {

			@Override
			public List<EvCategory> getResult(ResultSet rs) {
				
				List<EvCategory> list = new ArrayList<>();
				EvCategory category =null;
				try {
					while(rs.next()){
						category = new EvCategory();
						category.setCateId(rs.getInt("cate_id"));
						category.setCateName(rs.getString("cate_name"));
						category.setCateSummary(rs.getString("cate_summary"));
						category.setCateInserttime(rs.getTimestamp("cate_inserttime"));
						list.add(category);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

}
