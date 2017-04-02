package com.fintech.paysix.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.ProductDao;
import com.fintech.paysix.vo.ProductVO;
import com.fintech.paysix.vo.StoreVO;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private StoreService storeService;

	/**
	 * 
	 */

	// 1. product list
	public HashMap<String, Object> productList(int product_store_fk) throws SQLException {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store", storeService.storeName(product_store_fk));
		map.put("productList", productDao.productList(product_store_fk));
		return map;
	}

	// 2. insert Product
	public int insertProduct(int product_store_fk, String product_name, int product_price, String product_etc1) throws SQLException {

		ProductVO product = new ProductVO();
		
		product.setProduct_store_fk(product_store_fk);
		product.setProduct_name(product_name);
		product.setProduct_price(product_price);
		product.setProduct_etc1(product_etc1);		
		return productDao.insertProduct(product);
	}

	//	3. product detail
	public HashMap<String, Object> productDetail(int product_store_fk, int product_seq) throws SQLException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("product_store_fk", String.valueOf(product_store_fk));
		map.put("product_seq", String.valueOf(product_seq));
		
		StoreVO store = storeService.storeName(product_store_fk);
		ProductVO product = productDao.productDetail(map);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("store", store);
		result.put("product", product);
		return result;
	}
	
	
	
	/**
	 * Random Product
	 * 
	 * @throws SQLException
	 */

	public int createProduct(int product_store_fk) throws SQLException {

		StoreVO store = storeService.storeName(product_store_fk);

		String product[] = new String[15];
		// cafe
		product[0] = "아메리카노";
		product[1] = "카페라뗴";
		product[2] = "카라멜 마끼아또";
		product[3] = "카페모카";
		product[4] = "허니 브레드";

		// beverage
		product[5] = "딸기 바나나";
		product[6] = "딸기";
		product[7] = "망고";
		product[8] = "자몽";
		product[9] = "파인애플 바나나";

		// fastfood
		product[10] = "불고기버거";
		product[11] = "치즈버거";
		product[12] = "치킨버거";
		product[13] = "불갈비버거";
		product[14] = "빅맥";

		String product_name = "";
		int product_price = 0;

		int index=0;
		for (int i = 0; i < 5; i++) {			
			if (store.getStore_category().equals("cafe")) {
				index = i;
				product_price = 4000;
				product_name = product[index];
			} else if (store.getStore_category().equals("beverage")) {
				index = i+5;
				product_price = 3000;
				product_name = product[index];
			} else if (store.getStore_category().equals("fastfood")) {
				index = i+10;
				product_price = 8000;
				product_name = product[index];
			}
			this.insertProduct(product_store_fk, product_name, product_price, String.valueOf(index));
		}
		return 0;
	}
}
