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

import com.jsf.entity.Huifu;
import com.jsf.entity.Tie;

@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml",
		"classpath*:applicationContext.xml"})

public class TieActionTest {

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
	public void testSelecttie() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/selecttie"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertNotNull(result.getRequest().getAttribute("tie"));
		assertNotNull(result.getRequest().getAttribute("huifu"));
	}

	@Test
	public void testSelectmytie() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/selectmytie")
				.param("userid", "8"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertNotNull(result.getRequest().getAttribute("mytie"));
		assertNotNull(result.getRequest().getAttribute("tiehuifu"));
	}

	@Test
	public void testInsertTieHttpServletRequestHttpSessionSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/inserttie")
				.param("tieid", "100")
				.param("tietitle", "标题")
				.param("tieauthor", "测试作者")
				.param("tiecontext", "测试内容")
				.param("userid", "100"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("success",result.getResponse().getContentAsString());
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testInsertTieHttpServletRequestHttpSessionUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/inserttie")
				.param("tieid", " ")
				.param("tietitle"," ")
				.param("tieauthor","  ")
				.param("tiecontext","  ")
				.param("userid"," "))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testInsertHuifuHttpServletRequestHttpSessionSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/inserthuifu")
				.param("hfid", "100")
				.param("hfauthor", "测试回复作者")
				.param("hfcontext", "测试回复内容")
				.param("tieid", "100")
				.param("userid", "200"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("success",result.getResponse().getContentAsString());
	}

	@Test(expected=Exception.class)
	@Ignore
	public void testInsertHuifuHttpServletRequestHttpSessionUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/inserthuifu")
				.param("hfid", " ")
				.param("hfauthor", " ")
				.param("hfcontext", "   ")
				.param("tieid", " ")
				.param("userid", " "))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test
	public void testInsertTieSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/insert")
				.param("tieid", "100")
				.param("tietitle","测试标题")
				.param("tieauthor","测试作者")
				.param("tiecontext","测试内容 ")
				.param("tieDate", "2018-02-27 08:36:16")
				.param("userid","19"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testInsertTieUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/insert")
				.param("tieid", " ")
				.param("tietitle"," ")
				.param("tieauthor"," ")
				.param("tiecontext"," ")
				.param("tieDate", "2018-02-27 08:36:16")
				.param("userid","19"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testUpdateSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/update")
				.param("tieid", "100")
				.param("tietitle","测试标题")
				.param("tieauthor","测试作者")
				.param("tiecontext","测试内容 ")
				.param("tieDate", "2018-02-27 08:36:16")
				.param("userid","19"))			
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testUpdateUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/tie/update")
				.param("tieid", " ")
				.param("tietitle"," ")
				.param("tieauthor"," ")
				.param("tiecontext","  ")
				.param("tieDate", " ")
				.param("userid"," "))			
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	//控制台报错
	@Test
	public void testDeleteList() throws Exception {
		MvcResult result = mockmvc.perform(get("/tie/deleteList")
				.param("pks", "22", "23", "24"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testSelectPage() throws Exception {
		MvcResult result = mockmvc.perform(get("/tie/selectPage")
				.param("keyWord", "提问1")
				.param("page","1")
				.param("rows","10"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	//没有返回body
	@Test
	public void testSelectPageUseDyctie() throws Exception {
		MvcResult result = mockmvc.perform(get("/tie/selectPageUseDyctie")
				.param("tieid", "22")
				.param("tietitle", "提问1")
				.param("tieauthor", "人员1")
				.param("tiecontext","提问1 ")
				.param("tieDate", "2018-02-26 16:17:56")
				.param("userid","90")
				.param("page","1")
				.param("rows","10"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

}
