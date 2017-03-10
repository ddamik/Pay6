package com.fintech.paysix.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.LogService;
import com.google.gson.Gson;

@Controller
public class LogController {

	@Autowired
	private LogService logService;
	private Gson gson = new Gson();
	
	
	/*
	 * 	1. 주문(로그 데이터 생성)
	 * 	2. 사업자( 주문 리스트 )
	 * 	3. 결제상태 변경
	 * 	99. 랜덤 더미 데이터 생성	  
	 */
	
	
	//	1. 주문(로그 데이터 생성)
	@ResponseBody
	@RequestMapping(value="/log/insert", method=RequestMethod.POST, produces="application/json;text/plain;charset=UTF-8")
	public String insert(HttpServletRequest request) throws SQLException {
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		String pid = request.getParameter("pid");
		String userid = request.getParameter("userid");
		String paymethod = request.getParameter("paymethod");
		
		return gson.toJson(logService.insert(tno, pid, userid, paymethod));
	}
	
	
	//	2. 사업자( 주문 리스트 )
	@ResponseBody
	@RequestMapping(value="/log/owner/order_list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String owner_list(HttpServletRequest request) throws SQLException {
		String sid = request.getParameter("sid");
		return gson.toJson(logService.owner_order_list(sid));
	}
	
	

	
	//	3. 결제상태 변경
	@ResponseBody
	@RequestMapping(value="/log/update_status", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String update_status(
			@RequestParam("seqid") int seqid) throws SQLException {			
		return gson.toJson(logService.update_status(seqid));
	}
	
	
	
	
	
	//	99. 랜덤 더미 데이터 생성
	@ResponseBody
	@RequestMapping(value="/log/create_data", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public void creat_data() throws SQLException{
		logService.randomData();
	}
}
