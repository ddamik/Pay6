package com.fintech.paysix;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fintech.paysix.service.LogService;

public class LogTestController {

	@Autowired
	private LogService logService;
	
	@Test
	public void init(){
		System.out.println("Pay6 Hello world");
	}
	
	@Test
	public void init_2(){
		System.out.println("Test 2");
	}
}
