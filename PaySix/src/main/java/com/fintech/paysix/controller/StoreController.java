package com.fintech.paysix.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.StoreService;
import com.google.gson.Gson;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	private Gson gson = new Gson();

	@ResponseBody
	@RequestMapping(value = "/store/list", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_list(
			@RequestParam("category") String category) throws SQLException {
		System.out.println(category);
		return gson.toJson(storeService.store_list(category));
	}

	@ResponseBody
	@RequestMapping(value = "/store/order_info", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_order_info(HttpServletRequest request) throws SQLException {
		String sid = request.getParameter("sid");
		return gson.toJson(storeService.store_order_info(sid));
	}


	@ResponseBody
	@RequestMapping(value = "/store/get_name", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String store_get_name(@RequestParam("sid") String sid) throws SQLException {		
		return gson.toJson(storeService.get_store_name(sid));
	}
	
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

}
