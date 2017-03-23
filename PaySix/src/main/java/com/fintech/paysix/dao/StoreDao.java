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
	
	
	public List<StoreVO> store_list_all() throws SQLException{
		return session.selectList("StoreMapper.store_list_all");
	}
	// 1. store list
	public List<StoreVO> store_list(String s_category) throws SQLException {
		return session.selectList("StoreMapper.store_list", s_category);
	}
	
	
	public StoreVO store_order_info(String sid) throws SQLException {
		return session.selectOne("StoreMapper.store_order_info", sid);
	}
	
	
	public StoreVO get_store_name(String sid) throws SQLException{
		return session.selectOne("StoreMapper.get_store_name", sid);
	}
	
	public int store_registe(StoreVO store) throws SQLException {
		return session.insert("StoreMapper.registe_store", store);
	}
}
