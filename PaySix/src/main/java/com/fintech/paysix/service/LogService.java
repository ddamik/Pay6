package com.fintech.paysix.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.LogDao;
import com.fintech.paysix.payment.Blocko;
import com.fintech.paysix.vo.LogVO;
import com.fintech.paysix.vo.OwnerOrderVO;

import exception.CustomFunction;
import exception.ExceptionNumber;
import io.blocko.coinstack.exception.CoinStackException;

@Service
public class LogService {

	@Autowired
	private LogDao logDao;

	@Autowired
	private ProductService productService;
	private CustomFunction custom = new CustomFunction();
	/*
	 * 1. Log �����ͻ���(�ֹ�) 2. Onwer Order List 3. update status
	 * 
	 */

	// 1. Log �����ͻ���
	public int insert(int tno, String pid, String userid, String paymethod, String amount) throws SQLException, IOException, CoinStackException {

		int orderno = 152;
		String status = "status";
		Date endtime = null;
 
		double satoshi = 0.0001; 
		double fee = 0.0001;
		
		System.out.println(satoshi);
		LogVO log = new LogVO(tno, orderno, status, pid, userid, paymethod, endtime);

		if (logDao.insert(log) > 0) {
			// �ֹ� ����
			// �ֹ� �� �ø���
			if (productService.pcount_up(pid) > 0){
				Blocko blocko = new Blocko();
				blocko.send_satoshi(satoshi, fee, ExceptionNumber.BITCOIN_SNED_ADDRESS, Blocko.PRIVATE_KEY);
				return orderno;
			} else
				return ExceptionNumber.SQL_UPDATE_FAIL;
		} else
			return ExceptionNumber.SQL_INSERT_FAIL;
	}

	// 2. Onwer Order List
	public List<OwnerOrderVO> owner_order_list(String sid) throws SQLException {

		/*
		 * result status 1, 2 ��ģ ��
		 */
		List<OwnerOrderVO> result = new ArrayList<OwnerOrderVO>();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sid", sid);
		map.put("status", "1");

		for (OwnerOrderVO vo : logDao.owner_order_list(map)) {
			result.add(vo);
		}

		map.put("status", "2");
		for (OwnerOrderVO vo : logDao.owner_order_list(map)) {
			result.add(vo);
		}

		return result;
	}

	// 3. update status
	public int update_status(int seqid) throws SQLException {
		if (logDao.update_status(seqid) > 0)
			return ExceptionNumber.UPDATE_STATUS_SUCCESS;
		else
			return ExceptionNumber.UPDATE_STATUS_FAIL;
	}

	// 4. ��� ������( ���� �ð��� �Ǹŷ� )
	public HashMap<String, List<LogVO>> sales_rate_currentTime(int sid) {

		/*
		 * custom: ��¥ �����͸� �������� �Լ�
		 * 
		 * today_currentTime: ���� �ð��� ������.
		 *
		 * today_map: ���ó�¥�� ���� Hashmap current_time: ���� �ð� pid: �޾ƿ� sid(����)�� �Ǹ�
		 * ������ ���ϱ� ���� ��, log ���̺��� sid �÷��� ��� ���
		 * 
		 * 
		 * yesterday_map: ������¥�� ���� Hashmap, today_map�� ���� result: ���� �����Ϳ� ����
		 * �����͸� ��ģ ����Ʈ
		 */

		HashMap<String, String> today_map = new HashMap<String, String>();
		String today_currentTime = custom.getToday_currentTime();
		today_map.put("current_time", today_currentTime);
		today_map.put("pid", String.valueOf(sid));

		HashMap<String, String> yesterday_map = new HashMap<String, String>();
		String yesterday_currentTime = custom.getYester_currentTime();
		yesterday_map.put("current_time", yesterday_currentTime);
		yesterday_map.put("pid", String.valueOf(sid));

		List<LogVO> yesterday_data = logDao.currentTime_salesData(yesterday_map);
		List<LogVO> today_data = logDao.currentTime_salesData(today_map);

		HashMap<String, List<LogVO>> result = new HashMap<String, List<LogVO>>();
		result.put("yesterday", yesterday_data);
		result.put("today", today_data);
		return result;
	}

	// 5. �Ǹŷ�( ����ð� ���� )
	public HashMap<String, List<LogVO>> sales_rate_fromMidNight(int sid) {

		/*
		 * 4�� sales_rate_currentTime�� �����ϴ�. midnight: 00~���� �ð������� �����͸� ���ϱ� ���� ���
		 */

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pid", String.valueOf(sid));

		List<LogVO> today_data = logDao.today_fromMidNight_salesData(map);
		List<LogVO> yesterday_data = logDao.yesterday_fromMidNight_salesData(map);

		/*
		 * Result Data
		 */
		HashMap<String, List<LogVO>> result = new HashMap<String, List<LogVO>>();
		result.put("yesterday", yesterday_data);
		result.put("today", today_data);
		return result;

	}

	
	public LogVO best_product(String sid){
		return logDao.best_product(sid); 
	}
	
	
	// Random Data
	public void randomData() throws SQLException, ParseException {

		String sid[] = new String[4];
		sid[0] = "1001";
		sid[1] = "1002";
		sid[2] = "1003";
		sid[3] = "1004";

		String arrPid[] = new String[3];
		arrPid[0] = "0001";
		arrPid[1] = "0002";
		arrPid[2] = "0003";

		String arrPaymethod[] = new String[4];
		arrPaymethod[0] = "credit";
		arrPaymethod[1] = "nh_api";
		arrPaymethod[2] = "bitcoin";
		arrPaymethod[3] = "elc_code";

		String user[] = new String[6];
		user[0] = "�̽�ȭ";
		user[1] = "�̽���";
		user[2] = "������";
		user[3] = "�̽�ȣ";
		user[4] = "�翵";
		user[5] = "����";

		Random random = new Random();

		CustomFunction custom = new CustomFunction();
		String yester = custom.getToday_currentTime();

		int minute;

		int tno;
		int orderno = 0;

		String status;
		String userid;
		String paymethod;

		int ranSid;
		int ranPid;
		String pid;

		LogVO vo;
		for (int i = 1; i < 101; i++) {

			tno = random.nextInt(15);
			orderno++;

			ranSid = random.nextInt(4);
			ranPid = random.nextInt(3);
			pid = sid[ranSid] + arrPid[ranPid];

			if (tno % 2 == 0)
				status = "1";
			else
				status = "2";

			userid = user[random.nextInt(6)];
			paymethod = arrPaymethod[random.nextInt(4)];

			minute = random.nextInt(60);
			String strMinute = String.valueOf(minute);
			
			yester += ":" + strMinute + ":00";
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ordertime = new Date();
			ordertime = transFormat.parse(yester);

			vo = new LogVO(tno, orderno, status, pid, userid, paymethod, ordertime, null);
			if( logDao.insert_random(vo) > 0 ) productService.pcount_up(pid);
		}
	}
}
