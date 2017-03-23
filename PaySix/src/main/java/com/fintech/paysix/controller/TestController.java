package com.fintech.paysix.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.fintech.paysix.payment.Blocko;
import com.fintech.paysix.service.TestService;
import com.google.gson.Gson;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	private Gson gson = new Gson();

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request) throws SQLException {
		return gson.toJson(null);
	}

	@ResponseBody
	@RequestMapping(value = "/test_all", method = RequestMethod.GET)
	public String test_all(HttpServletRequest request) throws SQLException {
		return gson.toJson(testService.selectlist());

	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("/html/index");
	}

	@ResponseBody
	@RequestMapping(value = "/kakao/test", method = RequestMethod.GET)
	public String kakao_test() throws Exception {
//		String api_key = "5592113990569795";
//		String api_secret = "qLigXLFBK44nVjwFKVGZVK1vpjMAdEGEqYVnJAZuF3SAnog7kX7fH8L7sxIFcojCne06PZBu3t4rSkyd";

		Blocko client = new Blocko();
		client.getMyBalance(Blocko.ADDRESS);
		client.getTranscation(Blocko.ADDRESS);
		return gson.toJson(client.create_key());
	}

}
