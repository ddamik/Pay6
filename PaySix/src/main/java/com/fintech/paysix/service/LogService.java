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
	 * 1. Log 데이터생성(주문) 2. Onwer Order List 3. update status
	 * 
	 */

	// 1. Log 데이터생성
	public int insert(int tno, String pid, String userid, String paymethod, String amount) throws SQLException, IOException, CoinStackException {

		int orderno = 152;
		String status = "status";
		Date endtime = null;
 
		double satoshi = 0.0001; 
		double fee = 0.0001;
		
		System.out.println(satoshi);
		LogVO log = new LogVO(tno, orderno, status, pid, userid, paymethod, endtime);

		if (logDao.insert(log) > 0) {
			// 주문 성공
			// 주문 수 올리기
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
		 * result status 1, 2 합친 값
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

	// 4. 통계 데이터( 현재 시간대 판매량 )
	public HashMap<String, List<LogVO>> sales_rate_currentTime(int sid) {

		/*
		 * custom: 날짜 데이터를 가져오는 함수
		 * 
		 * today_currentTime: 현재 시간을 가져옴.
		 *
		 * today_map: 오늘날짜에 관한 Hashmap current_time: 현재 시간 pid: 받아온 sid(상점)별 판매
		 * 통계랑을 구하기 위한 값, log 테이블에는 sid 컬럼이 없어서 사용
		 * 
		 * 
		 * yesterday_map: 어제날짜에 관한 Hashmap, today_map과 동일 result: 어제 데이터와 오늘
		 * 데이터를 합친 리스트
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

	// 5. 판매량( 현재시간 까지 )
	public HashMap<String, List<LogVO>> sales_rate_fromMidNight(int sid) {

		/*
		 * 4번 sales_rate_currentTime과 동일하다. midnight: 00~현재 시간까지의 데이터를 구하기 위해 사용
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
		user[0] = "이승화";
		user[1] = "이승준";
		user[2] = "박조현";
		user[3] = "이승호";
		user[4] = "재영";
		user[5] = "재익";

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
