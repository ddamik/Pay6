package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.StoreDao;
import com.fintech.paysix.vo.StoreVO;

import exception.ExceptionNumber;
import exception.PublicStaticNaming;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;

	/**
	 * 1. store list
	 */

	// 1. store list
	public List<StoreVO> storeCategory(String store_category) throws SQLException {

		List<StoreVO> list;
		if (store_category.equals("all"))
			list = storeDao.storeAll();
		else
			list = storeDao.storeCategory(store_category);

		for (StoreVO vo : list) {
			if (vo.getStore_name().equals("¹ö°ÅÅ·"))
				vo.setStore_etc1(PublicStaticNaming.BURGER_KING);
			else if (vo.getStore_name().toUpperCase().equals("GONG CHA"))
				vo.setStore_etc1(PublicStaticNaming.GONG_CHA);
			else if (vo.getStore_name().toUpperCase().equals("JUICY"))
				vo.setStore_etc1(PublicStaticNaming.JUICY);
			else if (vo.getStore_name().toUpperCase().equals("KFC"))
				vo.setStore_etc1(PublicStaticNaming.KFC);
			else if (vo.getStore_name().equals("½ºÅ¸¹÷½º"))
				vo.setStore_etc1(PublicStaticNaming.STARBUCKS);
			else if (vo.getStore_name().equals("Åõ½æ"))
				vo.setStore_etc1(PublicStaticNaming.TWOSOME);

		}

		return list;
	}

	// 2. store name
	public StoreVO storeName(int store_seq) throws SQLException {
		return storeDao.storeName(store_seq);
	}

}
