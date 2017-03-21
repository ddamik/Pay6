package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.LogVO;
import com.fintech.paysix.vo.OwnerOrderVO;
import com.fintech.paysix.vo.StoreVO;

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
		return session.selectList("LogMapper.onwer_order_list", map);
	}
	
	
	
	//	3. update status
	public int update_status(int seqid) throws SQLException {
		return session.update("LogMapper.update_status", seqid);
	}
	
	
	
	
	//	4. 어제 00시 ~ 현재시간까지 데이터
	public List<LogVO> currentTime_salesData(HashMap<String, String> map){
		return session.selectList("LogMapper.currentTime_salesData", map);
	}
	
	
	
	
	//	5. 어제 00시 ~ 현재시간까지 데이터
	public List<LogVO> yesterday_fromMidNight_salesData(HashMap<String, String> map){
		return session.selectList("LogMapper.yesterday_fromMidNight_salesData", map);
	}
	
	public List<LogVO> today_fromMidNight_salesData(HashMap<String, String> map){
		return session.selectList("LogMapper.today_fromMidNight_salesData", map);
	}	
	
	
	
	public LogVO best_product(String sid){
		return session.selectOne("LogMapper.best_product", sid);
	}
	
	
	public LogVO order_number(String pid) throws SQLException{
		return session.selectOne("LogMapper.order_number", pid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//	Random
	public int insert_random(LogVO vo){
		return session.insert("LogMapper.insert_random_log", vo);
	}
}
