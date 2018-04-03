package com.softeem.easyvideo.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class EvVideoDAOTest {
	private static EvVideoDAO dao = new EvVideoDAO();

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCid() throws SQLException {
		dao.findByCid(7);
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
