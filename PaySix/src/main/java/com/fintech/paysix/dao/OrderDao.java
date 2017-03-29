package com.fintech.paysix.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.OrderVO;

@Repository
public class OrderDao {

	@Autowired
	private SqlSessionTemplate session;

	public int order_insert(OrderVO order) {
		return session.insert("OrderMapper.order_insert", order);
	}
}
