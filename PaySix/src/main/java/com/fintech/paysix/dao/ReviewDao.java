package com.fintech.paysix.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDao {

	@Autowired
	private SqlSessionTemplate session;
}
