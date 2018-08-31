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

public class JsclassActionTest {

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
	public void testInsertSuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/insert")
				.param("cname", "testInsertSuccessCname")
				.param("ctext", "testInsertSuccessCtext"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected = Exception.class)
	@Ignore
	public void testInsertUnsuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/insert")
				.param("xx", " ")
				.param("xxx", " "))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testUpdateSuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/update")
				.param("cname", "testupdateCname")
				.param("ctext", "testupdateCtext"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	
	@Test(expected=Exception.class)
	@Ignore
	public void testUpdateUnsuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/update")
				.param("xx", " ")
				.param("xxx", " "))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}
	
	@Test
	public void testDeleteListSuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/deleteList")
				.param("pks", "580", "581", "582"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testDeleteListUnsuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/deleteList")
				.param("pks", "1000", "2000", "3000"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	//no selectPage mapper method
	@Test
	@Ignore
	public void testSelectPage() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/selectPage")
				.param("page","1")
				.param("rows", "10"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	//no selectPageUseDyc mapper method
	@Test
	@Ignore
	public void testSelectPageUseDyc() throws Exception {
		MvcResult result = mockmvc.perform(get("/jsclass/selectPage")
				.param("page","1")
				.param("rows", "10")
				.param("cid", "1000")
				.param("cname", "testCname")
				.param("ctext", "testCtext"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

}
