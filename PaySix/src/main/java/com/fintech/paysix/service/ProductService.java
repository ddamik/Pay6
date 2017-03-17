package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.ProductDao;
import com.fintech.paysix.vo.ProductVO;

import exception.ExceptionNumber;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private StoreService storeService;
	
	/*
	 * 	1. �α�޴� Top3
	 *  2. Top3 ���� �޴�
	 *  3. �󼼸޴�
	 *  4. ���� �� �ø���
	 *  5. ��ȸ �� �ø���
	 */
	
	//	1. �α�޴� Top3
	public List<ProductVO> popular_list(String sid) throws SQLException{
		return productDao.popular_list(sid);
	}
	
	
	//	2. Top3 ���� �޴�
	public List<ProductVO> all_list(String sid) throws SQLException{
		return productDao.all_list(sid);
	}
	
	
	//	3. �޴� �󼼺���
	public HashMap<String, Object> detail(String pid) throws SQLException{
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		ProductVO product = productDao.detail(pid);
		if( product != null ) {
			//	Product ������ �������� ����.
			//	��ȸ�� �ø���.
			int update_vcount = this.vcount_up(pid);
			if( update_vcount == ExceptionNumber.SQL_UPDATE_SUCCESS ) {
				map.put("sid", storeService.store_order_info(pid.substring(0, 4)));
				map.put("product", product);
				return map; 
			}
			else return null;
		}
		else return null;
	}
	
	
	
	// 4. ���� �� �ø���
	public int pcount_up(String pid) throws SQLException {
		return productDao.pcount_up(pid);
	}
	
	
	//	5. ��ȸ �� �ø���
	public int vcount_up(String pid) throws SQLException {
		if( productDao.vcount_up(pid) > 0 ) return ExceptionNumber.SQL_UPDATE_SUCCESS;
		else return ExceptionNumber.SQL_UPDATE_FAIL;
	}
	
	
	//	6. ���� �� ����
	public int rcount_up(String pid) throws SQLException {
		if( productDao.rcount_up(pid) > 0 ) return ExceptionNumber.REVIEW_COUNT_UP_SUCCESS;
		else return ExceptionNumber.REVIEW_COUNT_UP_FAIL;
	}
}
