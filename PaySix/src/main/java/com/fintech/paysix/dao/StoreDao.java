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
	
	/*
	 * 	0. store list all
	 * 	1. store list category
	 * 	2. store order info
	 * 	3. store name
	 * 	4. store registe
	 */
	
	
	
	//	0. store list all
	public List<StoreVO> store_list_all() throws SQLException{
		return session.selectList("StoreMapper.store_list_all");
	}

	//	1. store list category
	public List<StoreVO> store_list(String s_category) throws SQLException {
		return session.selectList("StoreMapper.store_list", s_category);
	}
	
	//	2. store order info
	public StoreVO store_order_info(String sid) throws SQLException {
		return session.selectOne("StoreMapper.store_order_info", sid);
	}
	
	//	3. store name
	public StoreVO get_store_name(String sid) throws SQLException{
		return session.selectOne("StoreMapper.get_store_name", sid);
	}
	
	//	4. store registe
	public int store_registe(StoreVO store) throws SQLException {
		return session.insert("StoreMapper.registe_store", store);
	}
	
	//	5. market registe
	public int market_registe(StoreVO store) throws SQLException {
		return session.insert("StoreMapper.registe_market", store);
	}
	
	
	
	
	
	/*
	 * 	hacakton
	 * 	1. market list
	 */
	
	//	1. market list
	public List<StoreVO> market_list() throws SQLException {
		return session.selectList("StoreMapper.market_list");
	}
	
	//	2. market list s_province
	public List<StoreVO> market_list_province(String s_province) throws SQLException {
		return session.selectList("StoreMapper.market_list_province", s_province);
	}
	
	//	3. market store list
	public List<StoreVO> market_store_list(HashMap<String, String> map) throws SQLException {
		return session.selectList("StoreMapper.market_store_list_all", map);
	}
	
	//	4. market store list category
	public List<StoreVO> market_store_list_category(HashMap<String, String> map) throws SQLException {
		return session.selectList("StoreMapper.market_store_list_category", map);
	}
	
	public StoreVO get_market_province(String sid) throws SQLException {
		return session.selectOne("StoreMapper.get_market_province", sid);
	}
}
