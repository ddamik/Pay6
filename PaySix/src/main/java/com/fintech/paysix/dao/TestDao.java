package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.TestVO;

@Repository
public class TestDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	public List<TestVO> selectlist() throws SQLException {
		return session.selectList("TestMapper.select");
	}
}
