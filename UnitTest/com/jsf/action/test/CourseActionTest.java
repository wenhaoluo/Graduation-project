package com.jsf.action.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

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
		"classpath*:applicationContext.xml"})      //加载Spring配置文件

public class CourseActionTest {

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
	public void testInsertSuccess() throws Exception{
		MvcResult result = mockmvc.perform(get("/course/insert")
				.param("courseid", "1000")
				.param("yytime", "2018-11-16 02:05:09")
				.param("classover", "1")
				.param("teacherid", "8")
				.param("studentid", "19")
				.param("cid", "566"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testInsertUnsuccess() throws Exception{
		MvcResult result = mockmvc.perform(get("/course/insert")
				.param("courseid", "1")
				.param("yytime", "2018-11-16 02:05:09")
				.param("classover", "1")
				.param("teacherid", "8")
				.param("studentid", "19")
				.param("cid", "566"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testDeleteListSuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/course/deleteList")
				.param("pks", "1", "2", "3"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testDeleteListUnsuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/course/deleteList")
				.param("pks", "1000", "2000", "3000"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testSelectPageListteacher() throws Exception {
		MvcResult result = mockmvc.perform(get("/course/selectPageListteacher")
				.param("page", "1")
				.param("rows", "5")
				.param("userid", "17")
				.param("couseid","100")
				.param("yytime", "2018-02-01 17:47:43")
				.param("classover", "1")
				.param("teacherid", "17")
				.param("studentid", "90")
				.param("cid", "56"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();			
	}

	@Test
	public void testSelectPageUseDyc() throws Exception {
		MvcResult result = mockmvc.perform(get("/course/selectPageUseDyc")
				.param("page", "1")
				.param("rows", "10")
				.param("userid", "17")
				.param("couseid","80")
				.param("yytime", "2017-11-11 11:11:11")
				.param("classover", "0")
				.param("teacherid", "17")
				.param("studentid", "19")
				.param("cid", "570"))
				.andExpect(status().is(200))
				.andDo(print())
				.andReturn();	
	}

}
