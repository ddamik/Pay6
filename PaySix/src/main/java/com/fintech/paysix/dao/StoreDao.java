package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.StoreVO;

@Repository
public class StoreDao {

	@Autowired
	private SqlSessionTemplate session;
	
 
	 
	
	/**
	 * 	1. store all
	 * 	2. store category
	 */
	
	
	//	1. store all
	public List<StoreVO> storeAll() throws SQLException {
		return session.selectList("StoreMapper.store_all");
	}
	
	//	2. store category
	public List<StoreVO> storeCategory(String store_category) throws SQLException {
		return session.selectList("StoreMapper.store_category", store_category);
	}
	
	//	3. store name
	public StoreVO storeName(int store_seq) throws SQLException {
		return session.selectOne("StoreMapper.store_name", store_seq);
	}
}
