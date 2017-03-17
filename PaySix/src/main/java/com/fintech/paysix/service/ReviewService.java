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
	 * 1. ���� ��� 2. ���� ����Ʈ
	 */

	// 1. ���� ���
	public int review_registe(String pid, String title, String contents, String editor) throws SQLException {
		ReviewVO review = new ReviewVO(pid, title, contents, editor);
		if (reviewDao.review_registe(review) > 0) {
			// ��ǰ ����� ����
			if( productService.rcount_up(pid) == ExceptionNumber.REVIEW_COUNT_UP_SUCCESS ) return ExceptionNumber.REGISTE_REVIEW_SUCCESS;
			else return ExceptionNumber.REGISTE_REVIEW_FAIL;
		} else
			return ExceptionNumber.REGISTE_REVIEW_FAIL;
	}

	// 2. ���� ����Ʈ
	public List<ReviewVO> review_list(String pid) throws SQLException {
		return reviewDao.review_list(pid);
	}
	
	
	
	//	3. ���� ������
	public List<ReviewVO> review_more(String pid, String seqid) throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pid", pid);
		map.put("seqid", seqid);
		return reviewDao.review_more(map);
	}

	// ���� ���� ���
	public int randomReview(String pid) throws SQLException {
		
		Random random = new Random();
		
		String arrContents[] = new String[5];
		arrContents[0] = "���־��!";
		arrContents[1] = "�� �Ը��� ���̳׿�!";
		arrContents[2] = "�� �Ը��̶��� �Ⱦ��Ⱦ��!";
		arrContents[3] = "���� ��õ�մϴ�!";
		arrContents[4] = "���񽺰� ���� ���Ҿ��!";		

		String user[] = new String[6];
		user[0] = "�̽�ȭ";
		user[1] = "�̽���";
		user[2] = "������";
		user[3] = "�̽�ȣ";
		user[4] = "�翵";
		user[5] = "����";
		
		
		for(int i=0; i<10; i++) {
			String title = arrContents[random.nextInt(5)];		
			String contents = arrContents[random.nextInt(5)];
			String editor = user[random.nextInt(6)];
			this.review_registe(pid, title, contents, editor);
		}
		return 0;
	}
}
