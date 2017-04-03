package com.fintech.paysix.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.OrderDao;
import com.fintech.paysix.vo.OrderVO;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductService productService;
	/**
	 * 	[	Order Service	]
	 * 
	 * 	1. order payment
	 */
	
	
	// 1. orderPayment
	public int orderPayment(int order_no, int order_store_fk, int order_product_fk, int order_product_price, int order_user_fk){
		OrderVO order = new OrderVO();
		order.setOrder_no(order_no);
		order.setOrder_store_fk(order_store_fk);
		order.setOrder_product_fk(order_product_fk);
		order.setOrder_product_price(order_product_price);
		order.setOrder_user_fk(order_user_fk);
		

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("product_store_fk", String.valueOf(order_store_fk));
		map.put("product_seq", String.valueOf(order_product_fk));
		
		//	update purchase cnt
		productService.updatePurchaseCnt(map);		
		return orderDao.orderPayment(order);
	} 
}
