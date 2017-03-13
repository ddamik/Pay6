package com.fintech.paysix.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.nio.charset.Charset;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fintech.paysix.service.TestService;
import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;

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
		String api_key = "5592113990569795";
		String api_secret = "i0txyjZ4RUm11IXWKxAGfudc5K0YtzyMz2j8ljccdzeeicb2JLJYgWbmHbkaKTWkVgshzFuMfI0xVcAF";

		// IamportClient client = new IamportClient(api_key, api_secret);
		// IamportResponse<AccessToken> auth_response = client.getAuth();
		// assertNotNull(auth_response.getResponse());
		// assertNotNull(auth_response.getResponse().getToken());

		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("api_key", api_key);
		parameters.add("api_secret", api_secret);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		
		final String url = "https://api.iamport.kr";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url + "/payment/imp_593292756753", String.class);
		System.out.println(result);


		
		return null;
	}
}
