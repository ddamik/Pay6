package com.fintech.paysix.dao;

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
	public List<StoreVO> store_list(){
		return session.selectList("StoreMapper.store_list");
	}
}
