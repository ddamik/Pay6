package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.HashMap;
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
	public int review_registe(ReviewVO review) throws SQLException {
		return session.insert("ReviewMapper.review_registe", review);
	}
	
	
	
	//	2. ¸®ºä ¸®½ºÆ®
	public List<ReviewVO> review_list(String pid) throws SQLException{
		return session.selectList("ReviewMapper.review_list", pid);
	}
	
	//	3. ¸®ºä ´õº¸±â
	public List<ReviewVO> review_more(HashMap<String, String> map) throws SQLException{
		return session.selectList("ReviewMapper.review_more", map);
	}
}
