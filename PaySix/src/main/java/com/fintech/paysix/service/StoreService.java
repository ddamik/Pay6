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
	 * 1. store list all 2. store list category 3. store order info 4. get store
	 * name 5. store registe
	 */

	// 1. store list
	public List<StoreVO> store_list(String s_category) throws SQLException {
		List<StoreVO> list;

		if (s_category.equals("all"))
			list = storeDao.store_list_all();
		else
			list = storeDao.store_list(s_category);

		LogVO product;

		for (StoreVO vo : list) {
			System.out.println("List: " + vo.getSid());
			product = logService.best_product(vo.getSid());
			vo.setEtc1(product.getPid());
			vo.setEtc2(productService.product_detail(product.getPid()).getpName());
		}
		return list;
	}

	// 3. store order info
	public StoreVO store_order_info(String sid) throws SQLException {
		return storeDao.store_order_info(sid);
	}

	// 4. get store name
	public StoreVO get_store_name(String sid) throws SQLException {
		return storeDao.get_store_name(sid);
	}

	// 5. store registe
	public int store_registe(String sid, String sname, String saddr, String stel, String simgurl, String rname)
			throws SQLException {
		StoreVO vo = new StoreVO(sid, sname, saddr, stel, simgurl, rname);
		if (storeDao.store_registe(vo) > 0)
			return ExceptionNumber.REGISTE_STORE_SUCCESS;
		else
			return ExceptionNumber.REGISTE_STORE_FAIL;
	}

	/*
	 * hackaton 1.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// 1. market list
	public List<StoreVO> market_list(String s_province) throws SQLException {
		if (s_province.equals("all"))
			return storeDao.market_list();
		else
			return storeDao.market_list_province(s_province);
	}
 

	// 4. market store list category
	public List<StoreVO> market_store_list_category(String s_category, String s_province, String sid) throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("s_province", s_province);
		map.put("sid", sid);
		
		System.out.println(s_category);
		if (s_category.equals("all")) {
			return storeDao.market_store_list(map);
		} else {
			map.put("s_category", s_category);
			
			return storeDao.market_store_list_category(map);
		}
	}

	
	public StoreVO get_market_province(String sid) throws SQLException {
		return storeDao.get_market_province(sid);
	}
	
	// 6. market list
	public int market_registe(String sid, String sname, String saddr, String stel, String simgurl, String s_province)
			throws SQLException {

		int hackaton = 1;
		int market = 1;

		StoreVO vo = new StoreVO(sid, sname, saddr, stel, simgurl, s_province, hackaton, market);
		if (storeDao.market_registe(vo) > 0)
			return ExceptionNumber.REGISTE_STORE_SUCCESS;
		else
			return ExceptionNumber.REGISTE_STORE_FAIL;
	}

}
