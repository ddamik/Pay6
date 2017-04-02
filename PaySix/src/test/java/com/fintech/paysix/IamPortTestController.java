package com.fintech.paysix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull; 

import org.junit.Before;
import org.junit.Test; 

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public class IamPortTestController {

	IamportClient client;

	@Before
	public void setUp() throws Exception {
		String test_api_key = "5592113990569795";
		String test_api_secret = "qLigXLFBK44nVjwFKVGZVK1vpjMAdEGEqYVnJAZuF3SAnog7kX7fH8L7sxIFcojCne06PZBu3t4rSkyd";
		client = new IamportClient(test_api_key, test_api_secret);
	}

	@Test
	public void testGetToken() {
		IamportResponse<AccessToken> auth_response = client.getAuth();
		System.out.println(auth_response.getResponse());
		System.out.println(auth_response.getResponse().getToken());
	}

	@Test
	public void testPaymentByImpUid() {
		String test_imp_uid = "imp_448280090638";
		IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);
		System.out.println("[ PaymentByImpUid ] Payment Response: " + payment_response.getResponse().getImpUid());
		assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
		System.out.println(payment_response.getResponse().getImpUid());
	}

}
