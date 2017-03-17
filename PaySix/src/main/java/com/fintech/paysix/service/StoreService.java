package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.StoreDao;
import com.fintech.paysix.vo.StoreVO;

import exception.ExceptionNumber;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;
	
	
	@Autowired
	private LogService logService;
	
	/*
	 * 	1. store list
	 */
	
	
	// 1. store list
	public List<StoreVO> store_list() throws SQLException {
		List<StoreVO> list = storeDao.store_list();		
		for (StoreVO vo : list) {
			vo.setEtc1(logService.best_product(vo.getSid()).getPid());
		}
		return list;
	}
	
	
	public StoreVO store_order_info(String sid) throws SQLException {
		return storeDao.store_order_info(sid);
	}
	
	public int store_registe(String sid, String sname, String saddr, String stel, String simgurl, String rname) throws SQLException {		
		StoreVO vo = new StoreVO(sid, sname, saddr, stel, simgurl, rname);
		if( storeDao.store_registe(vo) > 0 ) return ExceptionNumber.REGISTE_STORE_SUCCESS;
		else return ExceptionNumber.REGISTE_STORE_FAIL;
	}
	
}
