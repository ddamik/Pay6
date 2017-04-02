package com.fintech.paysix.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.paysix.vo.ProductVO;

@Repository
public class ProductDao {

	@Autowired
	private SqlSessionTemplate session;
	
	
	//	1. product list	
	public List<ProductVO> productList(int product_store_fk) throws SQLException {
		return session.selectList("ProductMapper.product_all", product_store_fk);
	}
	
	//	2. insert product
	public int insertProduct(ProductVO product) throws SQLException {
		return session.insert("ProductMapper.product_insert", product);
	}
	
	//	3. product detail
	public ProductVO productDetail(HashMap<String, String> map) throws SQLException {
		return session.selectOne("ProductMapper.product_detail", map);
	}
}
