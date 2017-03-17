package com.fintech.paysix.service;


import java.sql.SQLException;
import java.util.HashMap;
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
	public List<ReviewVO> review_list(String pid) throws SQLException {
		return reviewDao.review_list(pid);
	}
	
	
	
	//	3. 리뷰 더보기
	public List<ReviewVO> review_more(String pid, String seqid) throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pid", pid);
		map.put("seqid", seqid);
		return reviewDao.review_more(map);
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

		String user[] = new String[6];
		user[0] = "이승화";
		user[1] = "이승준";
		user[2] = "박조현";
		user[3] = "이승호";
		user[4] = "재영";
		user[5] = "재익";
		
		
		for(int i=0; i<10; i++) {
			String title = arrContents[random.nextInt(5)];		
			String contents = arrContents[random.nextInt(5)];
			String editor = user[random.nextInt(6)];
			this.review_registe(pid, title, contents, editor);
		}
		return 0;
	}
}
