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

public class UserActionTest {

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
	public void testLoginAsCoachSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "4")
				.param("password", "66")
				.param("role", "教练"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("/WEB-INF/main/jlmain.jsp",result.getResponse().getForwardedUrl().toString());
	}
	
	@Test
	public void testLoginAsCoachUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "4")
				.param("password", "666")
				.param("role", "教练"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("用户名或密码错误或者身份错误",result.getRequest().getAttribute("msg"));
	}

	@Test
	public void testLoginAsCoachOverdue() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "666666")
				.param("password", "6")
				.param("role", "教练"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("您的会员已经过期,请充值",result.getRequest().getAttribute("vip"));
	}
	
	@Test
	public void testLoginAsStaffSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "345345")
				.param("password", "345345")
				.param("role", "员工"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("/WEB-INF/main/ygmain.jsp",result.getResponse().getForwardedUrl().toString());
	}
	
	@Test
	public void testLoginAsStaffUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "345345")
				.param("password", "3453451")
				.param("role", "员工"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("用户名或密码错误或者身份错误",result.getRequest().getAttribute("msg"));
	}

	@Test
	public void testLoginAsStaffOverdue() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "3")
				.param("password", "3")
				.param("role", "教练"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("您的会员已经过期,请充值",result.getRequest().getAttribute("vip"));
	}
	
	@Test
	public void testLoginAsMemberSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "l10111")
				.param("password", "jkld")
				.param("role", "会员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("/WEB-INF/main/hymain.jsp",result.getResponse().getForwardedUrl().toString());
	}
	
	@Test
	public void testLoginAsMemberUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "l10111")
				.param("password", "jkld1")
				.param("role", "会员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("用户名或密码错误或者身份错误",result.getRequest().getAttribute("msg"));
	}

	@Test
	public void testLoginAsMemberOverdue() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "l10113")
				.param("password", "jkld")
				.param("role", "会员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("您的会员已经过期,请充值",result.getRequest().getAttribute("vip"));
	}
	
	@Test
	public void testLoginAsAdminSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "2333")
				.param("password", "5555")
				.param("role", "管理员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("/WEB-INF/main/main.jsp",result.getResponse().getForwardedUrl().toString());
	}
	
	@Test
	public void testLoginAsAdminUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "2333")
				.param("password", "55555")
				.param("role", "管理员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("用户名或密码错误或者身份错误",result.getRequest().getAttribute("msg"));
	}

	@Test
	public void testLoginAsAdminOverdue() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/login")
				.param("username", "testadmin")
				.param("password", "Password01+")
				.param("role", "管理员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("您的会员已经过期,请充值",result.getRequest().getAttribute("vip"));
	}
	
	@Test
	public void testLogout() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/logout")
				.param("username", "2333")
				.param("password", "5555")
				.param("role", "管理员"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		assertEquals("/login.jsp",result.getResponse().getForwardedUrl().toString());
	}

	@Test
	public void testInsertSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/insert")
				.param("userid", "100")
				.param("username", "testinsert")
				.param("password", "testinsert")
				.param("role", "会员")
				.param("sex", "男")
				.param("truename", "tester")
				.param("birth", "2018-03-05")
				.param("phone", "1234567")
				.param("vipendtime", "2018-03-27"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testInsertUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/insert")
				.param("userid", "  ")
				.param("username", "  ")
				.param("password", "  ")
				.param("role", "  ")
				.param("sex", "  ")
				.param("truename", "  ")
				.param("birth", "  ")
				.param("phone", "  ")
				.param("vipendtime", "  "))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testUpdateSuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/update")
				.param("userid", "19")
				.param("username", "testinsert")
				.param("password", "testinsert")
				.param("role", "会员")
				.param("sex", "男")
				.param("truename", "tester")
				.param("birth", "2018-03-05")
				.param("phone", "1234567")
				.param("vipendtime", "2018-03-27"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testUpdateUnsuccess() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/update")
				.param("userid", " ")
				.param("username", " ")
				.param("password", " ")
				.param("role", " ")
				.param("sex", " ")
				.param("truename", " ")
				.param("birth", " ")
				.param("phone", " ")
				.param("vipendtime", " "))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testDeleteListSuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/user/deleteList")
				.param("pks", "46", "47", "48"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test(expected=Exception.class)
	@Ignore
	public void testDeleteListUnsuccess() throws Exception {
		MvcResult result = mockmvc.perform(get("/user/deleteList")
				.param("pks", " "))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testSelectPage() throws Exception {
		MvcResult result = mockmvc.perform(get("/user/selectPage")
				.param("role", "管理员")
				.param("page", "1")
				.param("rows", "10"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void testSelectPageUseDyc() throws Exception {
		MvcResult result = this.mockmvc
				.perform(get("/user/insert")
				.param("userid", "19")
				.param("username", "testadmin")
				.param("password", "testinsert")
				.param("role", "会员")
				.param("sex", "男")
				.param("truename", "tester")
				.param("birth", "2018-03-05")
				.param("phone", "1234567")
				.param("vipendtime", "2018-03-27"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

}
