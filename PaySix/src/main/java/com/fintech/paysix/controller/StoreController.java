package com.fintech.paysix.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.StoreService;
import com.fintech.paysix.vo.StoreVO;
import com.google.gson.Gson;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	private Gson gson = new Gson();

	
	/*
	 * 	1. store list
	 * 	2. store order info
	 * 	3. store name
	 * 	4. store registe
	 */
	
	
	//	1. store list
	@ResponseBody
	@RequestMapping(value = "/store/list", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_list(
			@RequestParam("category") String category) throws SQLException {
		System.out.println(category);
		return gson.toJson(storeService.store_list(category));
	}

	
	//	2. store order info
	@ResponseBody
	@RequestMapping(value = "/store/order_info", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_order_info(HttpServletRequest request) throws SQLException {
		String sid = request.getParameter("sid");
		return gson.toJson(storeService.store_order_info(sid));
	}


	//	3. store name
	@ResponseBody
	@RequestMapping(value = "/store/get_name", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_get_name(@RequestParam("sid") String sid) throws SQLException {		
		return gson.toJson(storeService.get_store_name(sid));
	}
	
	
	//	4. store registe
	@ResponseBody
	@RequestMapping(value = "/store/registe", method = RequestMethod.POST, produces = "application/json;text/plain;charset=UTF-8")
	public String store_registe(HttpServletRequest request) throws SQLException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String stel = request.getParameter("stel");
		String simgurl = request.getParameter("simgurl");
		String rname = request.getParameter("rname");

		return gson.toJson(storeService.store_registe(sid, sname, saddr, stel, simgurl, rname));
	}

	
	
	
	
	/*
	 * 	hackaton
	 * 
	 */
	
	//	1. market list
	@ResponseBody
	@RequestMapping(value = "/market/list_province", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String market_list_province(
			@RequestParam("s_province") String s_province) throws SQLException {
		return gson.toJson(storeService.market_list(s_province));
	}
		 
	
	//	4. market store list category
	@ResponseBody
	@RequestMapping(value = "/market/store_list_category", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String market_store_list_category(
			@RequestParam("s_province") String s_province,
			@RequestParam("s_category") String s_category,
			@RequestParam("sid") String sid) throws SQLException {
		return gson.toJson(storeService.market_store_list_category(s_category, s_province, sid));
	}
	
	@ResponseBody
	@RequestMapping(value = "/market/get_market_province", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String get_market_province(
			@RequestParam("sid") String sid) throws SQLException {
		return gson.toJson(storeService.get_market_province(sid));
	}
	
	
	
	//	5. market registe
	@ResponseBody
	@RequestMapping(value = "/market/registe", method = RequestMethod.POST, produces = "application/json;text/plain;charset=UTF-8")
	public String market_registe(HttpServletRequest request) throws SQLException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String stel = request.getParameter("stel");
		String simgurl = request.getParameter("simgurl");
		String s_province = request.getParameter("s_province");

		return gson.toJson(storeService.market_registe(sid, sname, saddr, stel, simgurl, s_province));
	}
}
