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
	
	//	
	@ResponseBody
	@RequestMapping(value="/log/insert", method=RequestMethod.POST, produces="application/json;text/plain;charset=UTF-8")
	public String insert(HttpServletRequest request) throws SQLException {
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		String pid = request.getParameter("pid");
		String userid = request.getParameter("userid");
		String paymethod = request.getParameter("paymethod");
		
		return gson.toJson(logService.insert(tno, pid, userid, paymethod));
	}
}
