package com.fintech.paysix.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.LogVO;

@Repository
public class LogDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	/*
	 * 1. insert log
	 */
	
	public int insert(LogVO log) throws SQLException {
		return session.insert("LogMapper.insert_log", log);
	}
}
