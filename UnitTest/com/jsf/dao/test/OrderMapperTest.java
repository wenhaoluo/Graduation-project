package com.jsf.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.OrderMapper;
import com.jsf.entity.Order;
import com.jsf.entity.Page;
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
public class OrderMapperTest {
	@Autowired
	private OrderMapper OrderMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		OrderMapper = applicationContext.getBean(OrderMapper.class);
	}
	
	@After
	public void tearDown() throws Exception{
		
	};
	
	@Test
	public void InsertOrderTest() {
		Order order = new Order();
		order.setOrderid(100);
		order.setOrdertime("2018-02-28 13:49:03");
		order.setOrderprice(1200);
		order.setEmpid(17);
		order.setUserid(19);
		Integer record = this.OrderMapper.insert(order);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	

	@Test
	public void SelectPageListUseDycTest() {
		Page page = new Page();
		page.setStarttime("2018-02-01 22:31:43");
		page.setEndtime("2018-02-28 22:31:43");
		page.setPage(1);
		page.setRows(10);
		List<Order> record = this.OrderMapper.selectPageListUseDyc(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountUseDycTest() {
		Page page = new Page();
		Integer record = this.OrderMapper.selectPageCountUseDyc(page);
		Integer Expected = 42;
		assertEquals(Expected,record);
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"142","143"};
		Integer record = this.OrderMapper.deleteList(arr);
		Integer Expected = 2;
		assertEquals(Expected,record);
	}
	
}
