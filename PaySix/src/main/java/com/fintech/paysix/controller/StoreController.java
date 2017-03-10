package com.fintech.paysix.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.StoreService;
import com.google.gson.Gson;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	private Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value="/store/list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String store_list(HttpServletRequest request){
		return gson.toJson(storeService.store_list());
	}
}
