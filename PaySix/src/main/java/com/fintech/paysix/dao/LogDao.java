package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.LogVO;
import com.fintech.paysix.vo.OwnerOrderVO;

@Repository
public class LogDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	/*
	 * 	1. insert log
	 * 	2. order list
	 * 	3. update status
	 */
	
	
	//	1. ordering( insert log )
	public int insert(LogVO log) throws SQLException {
		return session.insert("LogMapper.insert_log", log);
	}
	
	
	
	//	2. order list
	public List<OwnerOrderVO> owner_order_list(HashMap<String, String> map) throws SQLException {
		return session.selectList("onwer_order_list", map);
	}
	
	
	
	//	3. update status
	public int update_status(int seqid) throws SQLException {
		return session.update("LogMapper.update_status", seqid);
	}
}
