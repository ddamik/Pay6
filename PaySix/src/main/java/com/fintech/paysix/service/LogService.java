package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.LogDao;
import com.fintech.paysix.dao.ProductDao;
import com.fintech.paysix.vo.LogVO;
import com.fintech.paysix.vo.OwnerOrderVO;

import exception.ExceptionNumber;

@Service
public class LogService {

	@Autowired
	private LogDao logDao;
	
	@Autowired
	private ProductService productService;
	
	/*
	 * 	1. Log 单捞磐积己(林巩)
	 * 	2. Onwer Order List
	 */
	
	
	//	1. Log 单捞磐积己
	public int insert(int tno, String pid, String userid, String paymethod) throws SQLException {
		
		int orderno = 152;
		String status = "status";
		Date endtime = null;
		
		LogVO log = new LogVO(tno, orderno, status, pid, userid, paymethod, endtime);
		
		if( logDao.insert(log) > 0 ) {
			//	林巩 己傍
			//	林巩 荐 棵府扁
			if( productService.pcount_up(pid) > 0 ) return orderno;
			else return ExceptionNumber.SQL_UPDATE_FAIL;
		}
		else return ExceptionNumber.SQL_INSERT_FAIL;
	}
	
	
	
	//	2. Onwer Order List
	public List<OwnerOrderVO> owner_order_list(String sid) throws SQLException {
		
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
	
	
	
	
	//	3. update status
	public int update_status(int seqid) throws SQLException {	
		if(logDao.update_status(seqid) > 0) return ExceptionNumber.UPDATE_STATUS_SUCCESS;
		else return ExceptionNumber.UPDATE_STATUS_FAIL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	Random Data
	public void randomData() throws SQLException{
		
		Random random = new Random();
		random.nextInt(15);
		
		int tno;
		int orderno = 0;
		
		String status;
		String userid;
		String paymethod;
		String pid;		
		
		String arrPaymethod[] = new String[4];
		arrPaymethod[0] = "credit";
		arrPaymethod[1] = "nh_api";
		arrPaymethod[2] = "bitcoin";
		arrPaymethod[3] = "elc_code";	
		
		
		LogVO vo;
		for(int i=1; i<101; i++){
			tno = random.nextInt(15);
			orderno++;
			pid = "1001000" + (random.nextInt(5)+1);
			if(tno%2==0) status = "1";
			else status = "2";
			
			userid = "user_" + orderno;
			paymethod = arrPaymethod[random.nextInt(4) + 1];
			
			vo = new LogVO(tno, orderno, status, pid, userid, paymethod, null);
			logDao.insert(vo);
		}
		
	}
}
