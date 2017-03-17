package com.fintech.paysix.payment;

import java.io.IOException;
import java.security.PublicKey;

import javax.swing.plaf.synth.SynthSeparatorUI;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.exception.MalformedInputException;
import io.blocko.coinstack.model.CredentialsProvider;
import io.blocko.coinstack.model.Transaction;
import io.blocko.apache.commons.codec.binary.Hex;
import io.blocko.coinstack.AbstractEndpoint;

public class Blocko {

	public static final String PRIVATE_KEY = "L5M4XfsZ8F19h3kWHkaHyQ72mtMuRntEuD7Bff97H5iXcJcBSNhd";
	public static final String PUBLIC_KEY = "035d3ecdd3e040140a29036a856248637a5b5f8fcb51977a20e7910ba1025f8bbc";
	public static final String ADDRESS = "1EkjuEMrDkmXhUVC4N19w1PD82LZiGS6Kx";

	/*
	 * CredentialsProvider: API KEY와 접속할 서버를 가르키는 Endpoint를 관리.
	 * 
	 */
	static CoinStackClient client = new CoinStackClient(new CredentialsProvider() {
		@Override
		public String getAccessKey() {
			return "0";
		}

		@Override
		public String getSecretKey() {
			return "0";
		}
	}, new AbstractEndpoint() {
		public boolean mainnet() {
			return true;
		}

		public PublicKey getPublicKey() {
			return null;
		}

		public String endpoint() {
			return "http://testchain.blocko.io";
		}
	});

	public String create_key() throws IOException, CoinStackException {
		// 개인키 생성
		// String newPrivateKeyWIF = ECKey.createNewPrivateKey();
		// System.out.println("private key: " + newPrivateKeyWIF);

		// 공개키 생성
		// String newPublicKey =
		// Hex.encodeHexString(ECKey.derivePubKey(newPrivateKeyWIF));
		// System.out.println("public key: " + newPublicKey);

		// 비트코인 주소생성
		// String your_wallet_address = ECKey.deriveAddress(newPrivateKeyWIF);
		// System.out.println("address: " + your_wallet_address);

		// toAddress: Pay6의 주소, 고객이 보내는 주소
		// Address Balance 조회(내 비트코인 수 확인)
		long balance = client.getBalance(this.ADDRESS);

		return "";
	}

	// balance(잔액) 확인.
	public long getMyBalance(String address) throws IOException, CoinStackException {
		return client.getBalance(address);
	}

	// address별 Transaction 조회
	public String[] getTransactionList(String address) throws IOException, CoinStackException {
		return client.getTransactions(address);
	}

	// send satoshi
	public void send_satoshi(double satoshi, double custom_fee, String toAddress, String user_private_key)
			throws IOException, CoinStackException {

		// 0.0001: 10000 satoshi
		// amount: satoshi로 변경
		// fee: 네트워크 망에 올릴때의 값. ( 빠른 거래 처리를 위한 수수료를 동시에 보낸다. )
		long amount = io.blocko.coinstack.Math.convertToSatoshi(Double.toString(satoshi)); // 20000
		long fee = io.blocko.coinstack.Math.convertToSatoshi(Double.toString(custom_fee)); // 10000

		// Create Transcation
		// addOutput: address로 amount만큼의 사토시를 보낸다.
		// setFee: 수수료는 fee만큼
		// setData: 문서를 남겨서, 그 거래가 무슨 거래인지 확인 하는 부분.
		TransactionBuilder builder = new TransactionBuilder();
		builder.addOutput(toAddress, amount);
		builder.setFee(fee);
		builder.setData("DATA_AT_OP_RETURN".getBytes());

		// sign the transaction using the private key 서명
		// private key를 이용하여 서명을 만든다.
		String signedTx = client.createSignedTransaction(builder, user_private_key);

		// send the signed transaction 전송
		// 거래가 됐는지 확인하려면 다시 조회해야한다.
		client.sendTransaction(signedTx);
	}
	
	
	//	거래 내역 조회
	public String getTranscation(String address) throws IOException, CoinStackException{
		String[] transcations = client.getTransactions(address);
		Transaction tx = client.getTransaction(transcations[0]);
		return transcations[0];
	}
	
	
	 
}
