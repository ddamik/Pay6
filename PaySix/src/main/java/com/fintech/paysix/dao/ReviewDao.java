package com.fintech.paysix.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.ReviewVO;

@Repository
public class ReviewDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	
	
	/*
	 * 	1. ¸®ºäµî·Ï
	 * 	2. ¸®ºä ¸®½ºÆ®
	 */
	
	
	//	1. ¸®ºäµî·Ï
	public int review_registe(ReviewVO review){
		return session.insert("ReviewMapper.review_registe", review);
	}
	
	
	
	//	2. ¸®ºä ¸®½ºÆ®
	public List<ReviewVO> review_list(String pid){
		return session.selectList("ReviewMapper.review_list", pid);
	}
}
