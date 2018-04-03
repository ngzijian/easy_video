package com.softeem.easyvideo.dao;

import java.util.List;

public interface BaseDAO<T> {

	public boolean insert(T t) throws Exception;
	
	public boolean deleteById(int id) throws Exception;
	
	public boolean update(T t) throws Exception;
	
	public T findById(int id) throws Exception;
	
	public List<T> findAll() throws Exception;
}
