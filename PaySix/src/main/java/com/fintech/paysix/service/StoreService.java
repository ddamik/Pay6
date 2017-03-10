package com.fintech.paysix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.StoreDao;
import com.fintech.paysix.vo.StoreVO;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;
	
	
	/*
	 * 	1. store list
	 */
	
	
	// 1. store list
	public List<StoreVO> store_list(){
		return storeDao.store_list();
	}
}
