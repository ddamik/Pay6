package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.ProductVO;

@Repository
public class ProductDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	
	/*
	 * 	1. �α�޴� Top3
	 *  2. Top3 ���� �޴�
	 *  3. �޴� �󼼺���
	 *  4. ���� �� �ø���
	 *  5. ��ȸ �� �ø���
	 */
	
	
	// 1. �α�޴� Top3
	public List<ProductVO> popular_list(int sid) throws SQLException {
		return session.selectList("ProductMapper.popular_list", sid);
	}
	
	
	// 2. Top3 ���� �޴�
	public List<ProductVO> all_list(int sid) throws SQLException {
		return session.selectList("ProductMapper.all_list", sid);
	}
	
	
	// 3. �޴� �󼼺���
	public ProductVO detail(String pid) throws SQLException{
		return session.selectOne("ProductMapper.detail", pid);
	}
	
	
	
	// 4. ���� �� �ø���
	public int pcount_up(String pid) throws SQLException {
		return session.update("ProductMapper.pcount_up", pid);
	}
	
	
	
	// 5. ��ȸ �� �ø���
	public int vcount_up(String pid) throws SQLException {
		return session.update("ProductMapper.vcount_up", pid);
	}	
}
