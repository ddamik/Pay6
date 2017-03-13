package com.fintech.paysix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public class IamPortControllerTest {

	IamportClient client;

	@Before
	public void setup() {
		String test_api_key = "";
		String test_api_secret = "";
		client = new IamportClient(test_api_key, test_api_secret);
	}

	@Test
	public void testGetToken() {
		IamportResponse<AccessToken> auth_response = client.getAuth();
		assertNotNull(auth_response.getResponse());
		assertNotNull(auth_response.getResponse().getToken());
		
		System.out.println(auth_response.getResponse().getToken());
	}

	@Test
	public void testPaymentByImpUid() {
		String test_imp_uid = "";
		IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);
		assertNotNull(payment_response.getResponse());
		assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
	}

	@Test
	public void testCancelPaymentAlreadyCancelledImpUid() {
		
		String test_already_cancelled_imp_uid = "imp_448280090638";
		
		// imp_uid를 통한 전액취소
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
	}

	@Test
	public void testCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		
		// merchant_uid를 통한 전액취소
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}

	@Test
	public void testPartialCancelPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_448280090638";
		
		// imp_uid를 통한 500원 부분취소
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}

	@Test
	public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		
		// merchant_uid를 통한 500원 부분취소
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}

	@Test
	public void testCancelVbankPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_1416557733458";
		
		// imp_uid를 통한 500원 부분취소
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}

	@Test
	public void testPartialCancelVbankPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1416557727868";
		
		// merchant_uid를 통한 500원 부분취소
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); 
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	
	private String getRandomMerchantUid() {
		DateFormat df = new SimpleDateFormat("$$hhmmssSS");
		int n = (int) (Math.random() * 100) + 1;
		
		return df.format(new Date()) + "_" + n;
	}
	
	private void assertDateEquals(Date d1, Date d2) {
		assertEquals(d1.getTime() / 1000L, d2.getTime() / 1000L);
	}
}
