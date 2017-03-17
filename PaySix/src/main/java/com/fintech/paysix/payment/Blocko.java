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
	 * CredentialsProvider: API KEY�� ������ ������ ����Ű�� Endpoint�� ����.
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
		// ����Ű ����
		// String newPrivateKeyWIF = ECKey.createNewPrivateKey();
		// System.out.println("private key: " + newPrivateKeyWIF);

		// ����Ű ����
		// String newPublicKey =
		// Hex.encodeHexString(ECKey.derivePubKey(newPrivateKeyWIF));
		// System.out.println("public key: " + newPublicKey);

		// ��Ʈ���� �ּһ���
		// String your_wallet_address = ECKey.deriveAddress(newPrivateKeyWIF);
		// System.out.println("address: " + your_wallet_address);

		// toAddress: Pay6�� �ּ�, ���� ������ �ּ�
		// Address Balance ��ȸ(�� ��Ʈ���� �� Ȯ��)
		long balance = client.getBalance(this.ADDRESS);

		return "";
	}

	// balance(�ܾ�) Ȯ��.
	public long getMyBalance(String address) throws IOException, CoinStackException {
		return client.getBalance(address);
	}

	// address�� Transaction ��ȸ
	public String[] getTransactionList(String address) throws IOException, CoinStackException {
		return client.getTransactions(address);
	}

	// send satoshi
	public void send_satoshi(double satoshi, double custom_fee, String toAddress, String user_private_key)
			throws IOException, CoinStackException {

		// 0.0001: 10000 satoshi
		// amount: satoshi�� ����
		// fee: ��Ʈ��ũ ���� �ø����� ��. ( ���� �ŷ� ó���� ���� �����Ḧ ���ÿ� ������. )
		long amount = io.blocko.coinstack.Math.convertToSatoshi(Double.toString(satoshi)); // 20000
		long fee = io.blocko.coinstack.Math.convertToSatoshi(Double.toString(custom_fee)); // 10000

		// Create Transcation
		// addOutput: address�� amount��ŭ�� ����ø� ������.
		// setFee: ������� fee��ŭ
		// setData: ������ ���ܼ�, �� �ŷ��� ���� �ŷ����� Ȯ�� �ϴ� �κ�.
		TransactionBuilder builder = new TransactionBuilder();
		builder.addOutput(toAddress, amount);
		builder.setFee(fee);
		builder.setData("DATA_AT_OP_RETURN".getBytes());

		// sign the transaction using the private key ����
		// private key�� �̿��Ͽ� ������ �����.
		String signedTx = client.createSignedTransaction(builder, user_private_key);

		// send the signed transaction ����
		// �ŷ��� �ƴ��� Ȯ���Ϸ��� �ٽ� ��ȸ�ؾ��Ѵ�.
		client.sendTransaction(signedTx);
	}
	
	
	//	�ŷ� ���� ��ȸ
	public String getTranscation(String address) throws IOException, CoinStackException{
		String[] transcations = client.getTransactions(address);
		Transaction tx = client.getTransaction(transcations[0]);
		return transcations[0];
	}
	
	
	 
}
