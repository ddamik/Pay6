package com.fintech.paysix.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.OrderVO;
import com.fintech.paysix.vo.ReviewVO;

@Repository
public class ReviewDao {

	@Autowired	
	private SqlSessionTemplate session;
	
	/**
	 * 	[	Review Dao	]
	 * 
	 *  1. insert review
	 *  2. review list
	 */
	
	
	// 1. order payment
	public int insertReview(ReviewVO review){
		return session.insert("ReviewMapper.insert_review", review);
	}
	
	// 2. review list
	public List<ReviewVO> reviewList(ReviewVO review){
		return session.selectList("ReviewMapper.review_list", review);
	}
}
