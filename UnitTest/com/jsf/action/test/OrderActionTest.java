package com.jsf.action.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml",
		"classpath*:applicationContext.xml"}) 

public class OrderActionTest {

	@Autowired
	protected WebApplicationContext wac;
	
	private MockMvc mockmvc;
	
	@Before
	public void setUp() throws Exception {
		mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertMonthSuccess() throws Exception {
		MvcResult result =  this.mockmvc
				.perform(get("/order/updatevip")
				.param("orderid", "100")
				.param("ordertime", "2018-02-01 11:11:11")
//				.param("orderprice","500")
				.param("empid","19")
				.param("userid", "19")
				.param("username", "6666")
				.param("password", "6666")
				.param("role","管理员")
				.param("sex", "男")
				.param("truename", "测试人员")
				.param("birth", "2017-03-08")
				.param("phone","1234567")
				.param("vipendtime", "2017-03-19")
				.param("number","1"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();	
	}

	@Test
	public void testInsertQuartlySuccess() throws Exception {
		MvcResult result =  this.mockmvc
				.perform(get("/order/updatevip")
				.param("orderid", "100")
				.param("ordertime", "2018-02-01 11:11:11")
				.param("empid","19")
				.param("userid", "19")
				.param("username", "6666")
				.param("password", "6666")
				.param("role","管理员")
				.param("sex", "男")
				.param("truename", "测试人员")
				.param("birth", "2017-03-08")
				.param("phone","1234567")
				.param("vipendtime", "2017-03-19")
				.param("number","3"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();	
	}
	
	@Test
	public void testInsertYearSuccess() throws Exception {
		MvcResult result =  this.mockmvc
				.perform(get("/order/updatevip")
				.param("orderid", "100")
				.param("ordertime", "2018-02-01 11:11:11")
				.param("empid","19")
				.param("userid", "19")
				.param("username", "6666")
				.param("password", "6666")
				.param("role","管理员")
				.param("sex", "男")
				.param("truename", "测试人员")
				.param("birth", "2017-03-08")
				.param("phone","1234567")
				.param("vipendtime", "2017-03-19")
				.param("number","12"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();	
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testInsertUnsuccess() throws Exception {
		MvcResult result =  this.mockmvc
				.perform(get("/order/updatevip")
				.param("orderid", "100")
				.param("ordertime", "2018-02-01 11:11:11")
				.param("empid","19")
				.param("userid", "19")
				.param("username", "6666")
				.param("password", "6666")
				.param("role","管理员")
				.param("sex", "男")
				.param("truename", "测试人员")
				.param("birth", "2017-03-08")
				.param("phone","1234567")
				.param("vipendtime", "2015-03-19")
				.param("number","1"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();	
	}
	
	@Test
	public void testSelectPageUseDyc() throws Exception {
		MvcResult result =  this.mockmvc
				.perform(get("/order/selectPageUseDyc")
				.param("page","1")
				.param("rows", "10")
				.param("starttime", "2018-02-01 14:19:31")
				.param("endtime","2016-02-28 14:19:31"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();	
	}

}
