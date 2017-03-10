package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.TestDao;
import com.fintech.paysix.vo.TestVO;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public List<TestVO> selectlist() throws SQLException {
		return testDao.selectlist();
	}
	
}
