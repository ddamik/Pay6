package com.fintech.paysix.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fintech.paysix.service.StoreService;
import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	private Gson gson = new Gson();

	
	/**
	 * 	1. store list
	 * @throws SQLException 
	 */
	
	
	//	1. store list
	@ResponseBody
	@RequestMapping(value="/store/list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String storeCategory(
			@RequestParam("store_category") String store_category) throws SQLException {
		System.out.println("[ Store Controller ] StoreCategory: " + store_category);
		return gson.toJson(storeService.storeCategory(store_category));
	}

}
