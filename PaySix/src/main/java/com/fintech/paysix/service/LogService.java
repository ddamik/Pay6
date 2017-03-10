package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.LogDao;
import com.fintech.paysix.dao.ProductDao;
import com.fintech.paysix.vo.LogVO;

import exception.ExceptionNumber;

@Service
public class LogService {

	@Autowired
	private LogDao logDao;
	
	@Autowired
	private ProductService productService;
	
	/*
	 * 	1. Log 单捞磐积己(林巩)
	 */
	
	
	//	1. Log 单捞磐积己
	public int insert(int tno, String pid, String userid, String paymethod) throws SQLException {
		
		int orderno = 152;
		String status = "status";
		Date endtime = null;
		
		LogVO log = new LogVO(tno, orderno, status, pid, userid, paymethod, endtime);
		
		if( logDao.insert(log) > 0 ) {
			//	林巩 己傍
			//	林巩 荐 棵府扁
			if( productService.pcount_up(pid) > 0 ) return orderno;
			else return ExceptionNumber.SQL_UPDATE_FAIL;
		}
		else return ExceptionNumber.SQL_INSERT_FAIL;
	}
}
