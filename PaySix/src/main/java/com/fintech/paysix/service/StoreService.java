package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.StoreDao;
import com.fintech.paysix.vo.LogVO;
import com.fintech.paysix.vo.ProductVO;
import com.fintech.paysix.vo.StoreVO;

import exception.ExceptionNumber;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;
	
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private ProductService productService;
	/*
	 * 	1. store list
	 */
	
	
	// 1. store list
	public List<StoreVO> store_list(String s_category) throws SQLException {
		List<StoreVO> list;
		
		if( s_category.equals("all")) list = storeDao.store_list_all(); 
		else list = storeDao.store_list(s_category);
		
		LogVO product;
		
		
		for (StoreVO vo : list) {
			System.out.println("List: " + vo.getSid());
			product = logService.best_product(vo.getSid());
			vo.setEtc1(product.getPid());
			vo.setEtc2(productService.product_detail(product.getPid()).getpName());
		}
		return list;
	}
	
	
	public StoreVO store_order_info(String sid) throws SQLException {
		return storeDao.store_order_info(sid);
	}
	
	public StoreVO get_store_name(String sid) throws SQLException{
		return storeDao.get_store_name(sid);
	}
	public int store_registe(String sid, String sname, String saddr, String stel, String simgurl, String rname) throws SQLException {		
		StoreVO vo = new StoreVO(sid, sname, saddr, stel, simgurl, rname);
		if( storeDao.store_registe(vo) > 0 ) return ExceptionNumber.REGISTE_STORE_SUCCESS;
		else return ExceptionNumber.REGISTE_STORE_FAIL;
	}
	
}
