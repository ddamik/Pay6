package com.fintech.paysix;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fintech.paysix.dao.OrderDao;
import com.fintech.paysix.vo.OrderVO;

public class OrderTestController {

	 
    @Autowired
    OrderDao orderDao;
    
    
    @Before
    public void setUp() throws Exception {
    	System.out.println("[ Start Order Test ]");
    }
 
    @Test
    public void testCreateOrder() throws Exception {
        OrderVO order = new OrderVO();
        
        order.setOrder_no(1);
        order.setOrder_status(1);
        order.setOrder_product_fk(0);
        order.setOrder_store_fk(0);
        order.setOrder_user_fk(0);
       
        System.out.println("OrderVO: " + order.toString());
        System.out.println(orderDao.order_insert(order));
    }
    
}
