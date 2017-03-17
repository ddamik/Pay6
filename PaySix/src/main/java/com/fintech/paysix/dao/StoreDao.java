package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.StoreVO;

@Repository
public class StoreDao {

	@Autowired
	private SqlSessionTemplate session;
	
	/*
	 * 	1. store list
	 */
	
	// 1. store list
	public List<StoreVO> store_list() throws SQLException {
		return session.selectList("StoreMapper.store_list");
	}
	
	
	public StoreVO store_order_info(String sid) throws SQLException {
		return session.selectOne("StoreMapper.store_order_info", sid);
	}
	
	
	public int store_registe(StoreVO store) throws SQLException {
		return session.insert("StoreMapper.registe_store", store);
	}
}
