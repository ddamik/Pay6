package com.fintech.paysix.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.OrderVO;

@Repository
public class OrderDao {

	@Autowired	
	private SqlSessionTemplate session;
	
	/**
	 * 	[	Order Dao	]
	 * 
	 *  1. order payment
	 */
	
	
	// 1. order payment
	public int orderPayment(OrderVO order){
		return session.insert("OrderMapper.insert_order", order);
	}
}
