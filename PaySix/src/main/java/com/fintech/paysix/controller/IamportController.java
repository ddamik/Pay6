package com.fintech.paysix.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IamportController {

	
	@ResponseBody
	@RequestMapping(value="/payments/complete", method=RequestMethod.POST, produces="application/json;text/plain;charset=UTF-8")
	public String payment(HttpServletRequest request){
		
		String imp_uid = request.getParameter("imp_uid");
		System.out.println("[ Payment ] imp_uid: " + imp_uid);
		return null;
	}
}
