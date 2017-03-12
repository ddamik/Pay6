package com.fintech.paysix.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.ReviewDao;
import com.fintech.paysix.vo.ReviewVO;

import exception.ExceptionNumber;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private ProductService productService;

	/*
	 * 1. 리뷰 등록 2. 리뷰 리스트
	 */

	// 1. 리뷰 등록
	public int review_registe(String pid, String title, String contents, String editor) throws SQLException {
		ReviewVO review = new ReviewVO(pid, title, contents, editor);
		if (reviewDao.review_registe(review) > 0) {
			// 상품 리뷰수 증가
			if( productService.rcount_up(pid) == ExceptionNumber.REVIEW_COUNT_UP_SUCCESS ) return ExceptionNumber.REGISTE_REVIEW_SUCCESS;
			else return ExceptionNumber.REGISTE_REVIEW_FAIL;
		} else
			return ExceptionNumber.REGISTE_REVIEW_FAIL;
	}

	// 2. 리뷰 리스트
	public List<ReviewVO> review_list(String pid) {
		return reviewDao.review_list(pid);
	}

	// 랜덤 리뷰 등록
	public int randomReview(String pid) throws SQLException {
		
		Random random = new Random();
		
		String arrContents[] = new String[5];
		arrContents[0] = "맜있어요!";
		arrContents[1] = "제 입맛에 딱이네요!";
		arrContents[2] = "제 입맛이랑은 안어울렸어요!";
		arrContents[3] = "강력 추천합니다!";
		arrContents[4] = "서비스가 정말 좋았어요!";		

		
		for(int i=0; i<10; i++) {
			String title = arrContents[random.nextInt(5)];		
			String contents = arrContents[random.nextInt(5)];
			String editor = "user_" + random.nextInt(5);
			this.review_registe(pid, title, contents, editor);
		}
		return 0;
	}
}
