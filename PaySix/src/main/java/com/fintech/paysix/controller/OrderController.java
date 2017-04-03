package com.fintech.paysix.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.OrderService;
import com.google.gson.Gson;

//
//import com.siot.IamportRestClient.IamportClient;
//import com.siot.IamportRestClient.response.AccessToken;
//import com.siot.IamportRestClient.response.IamportResponse;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	private Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value = "/order/complete", method = RequestMethod.POST, produces = "application/json;text/plain;charset=UTF-8")
	public String payment(HttpServletRequest request) {
//
//		String test_api_key = "5592113990569795";
//		String test_api_secret = "qLigXLFBK44nVjwFKVGZVK1vpjMAdEGEqYVnJAZuF3SAnog7kX7fH8L7sxIFcojCne06PZBu3t4rSkyd";
//		IamportClient client = new IamportClient(test_api_key, test_api_secret);
//		
//		IamportResponse<AccessToken> auth_response = client.getAuth();
//		System.out.println(auth_response.getResponse());
//		System.out.println(auth_response.getResponse().getToken());
//		
		
		//
		// String imp_uid = request.getParameter("imp_uid");
		// System.out.println("[ Payment ] imp_uid: " + imp_uid);
		//
		//
		// List<HttpMessageConverter<?>> converters = new
		// ArrayList<HttpMessageConverter<?>>();
		// converters.add(new FormHttpMessageConverter());
		// converters.add(new StringHttpMessageConverter());
		//
		// RestTemplate restTemplate = new RestTemplate();
		// restTemplate.setMessageConverters(converters);
		//
		// String imp_key = "5592113990569795";
		// String imp_secret =
		// "qLigXLFBK44nVjwFKVGZVK1vpjMAdEGEqYVnJAZuF3SAnog7kX7fH8L7sxIFcojCne06PZBu3t4rSkyd";
		// // parameter 세팅
		// MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
		// String>();
		// map.add("imp_key", imp_key);
		// map.add("imp_secret", imp_secret);
		//
		// String url = "https://api.iamport.kr/users/getToken";
		// // post
		// String result = restTemplate.postForObject(url, map, String.class);
		// System.out.println(result);
		//
		//
		//
		//
		//
		//
		// String access_token = "3db5744ad8cdeacd480420422c77c2684978a64f";
		// // parameter 세팅
		// MultiValueMap<String, String> paymentMap = new
		// LinkedMultiValueMap<String, String>();
		// map.add("access_token", access_token);
		// map.add("imp_uid", imp_uid);
		//
		// String paymentUrl = "https://api.iamport.kr/payments/{imp_url}";
		// // post
		//
		//
		//
		/*
		 * 0. get imp_uid 1. iamport로부터 결제정보 조회 2. 결제되어있어야 하는 금액 조회
		 */

		// String url2 = "https://api.iamport.kr/users/getToken";
		// String imp_key = "5592113990569795";
		// String imp_secret =
		// "qLigXLFBK44nVjwFKVGZVK1vpjMAdEGEqYVnJAZuF3SAnog7kX7fH8L7sxIFcojCne06PZBu3t4rSkyd";
		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//
		// MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
		// String>();
		// map.add("imp_key", imp_key);
		// map.add("imp_secret", imp_secret);
		//
		// RestTemplate restTempalate = new RestTemplate();
		// HttpEntity<MultiValueMap<String, String>> request2 = new
		// HttpEntity<MultiValueMap<String, String>>(map, headers);
		// ResponseEntity<String> response = restTempalate.postForEntity( url2,
		// request2 , String.class );
		//
		// System.out.println(response);
		// HashMap<String, String> vars = new HashMap<String, String>();
		// vars.put("imp_uid", imp_uid);
		//
		// String iamport_url = "https://api.iamport.kr";
		// RestTemplate restTempalate = new RestTemplate();
		//
		//
		// String result = restTempalate.getForObject(iamport_url +
		// "/payments/{imp_uid}", String.class, vars);
		// System.out.println("[ OrderController ] result: " + result);
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/order/payment", method = RequestMethod.POST, produces = "application/json;text/plain;charset=UTF-8")
	public String orderPayment(HttpServletRequest request) throws NumberFormatException {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		int order_store_fk = Integer.parseInt(request.getParameter("order_store_fk"));
		int order_product_fk = Integer.parseInt(request.getParameter("order_product_fk"));
		int order_product_price = Integer.parseInt(request.getParameter("order_product_price"));
		int order_user_fk = Integer.parseInt(request.getParameter("order_user_fk"));
		
		return gson.toJson(orderService.orderPayment(order_no, order_store_fk, order_product_fk, order_product_price, order_user_fk));
	}
}
