package com.fintech.paysix.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.ReviewService;
import com.google.gson.Gson;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	private Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value="/review/registe", method=RequestMethod.POST)
	public String review_registe(HttpServletRequest request) throws SQLException{
		
		String pid = request.getParameter("pid");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String editor = request.getParameter("editor");		
		
		return gson.toJson(reviewService.review_registe(pid, title, contents, editor));
	}
	
	
	@ResponseBody
	@RequestMapping(value="/review/list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String review_list(
			@RequestParam("pid") String pid) throws SQLException {	
		return gson.toJson(reviewService.review_list(pid));
	}
	
	
	@ResponseBody
	@RequestMapping(value="/review/more", method=RequestMethod.POST, produces="application/json;text/plain;charset=UTF-8")
	public String review_more(HttpServletRequest request) throws SQLException {	
		String pid = request.getParameter("pid");
		String seqid = request.getParameter("seqid");
		System.out.println(pid + " / " + seqid);
		return gson.toJson(reviewService.review_more(pid, seqid));
	}
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/review/create", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String review_create(
			@RequestParam("pid") String pid) throws SQLException{		
		return gson.toJson(reviewService.randomReview(pid));
	}
	
	
}
