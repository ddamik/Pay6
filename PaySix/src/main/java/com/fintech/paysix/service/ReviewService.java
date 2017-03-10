package com.fintech.paysix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.ReviewDao;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;
}
