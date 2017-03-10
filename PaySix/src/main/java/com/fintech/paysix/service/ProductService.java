package com.fintech.paysix.service;

import java.sql.SQLException;
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
	
	
	/*
	 * 	1. �α�޴� Top3
	 *  2. Top3 ���� �޴�
	 *  3. �󼼸޴�
	 *  4. ���� �� �ø���
	 *  5. ��ȸ �� �ø���
	 */
	
	//	1. �α�޴� Top3
	public List<ProductVO> popular_list(int sid) throws SQLException{
		return productDao.popular_list(sid);
	}
	
	
	//	2. Top3 ���� �޴�
	public List<ProductVO> all_list(int sid) throws SQLException{
		return productDao.all_list(sid);
	}
	
	
	//	3. �޴� �󼼺���
	public ProductVO detail(String pid) throws SQLException{
		
		ProductVO product = productDao.detail(pid);
		if( product != null ) {
			//	Product ������ �������� ����.
			//	��ȸ�� �ø���.
			int update_vcount = this.vcount_up(pid);
			if( update_vcount == ExceptionNumber.SQL_UPDATE_SUCCESS ) return product; 
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
}
