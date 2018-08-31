package com.jsf.action.test;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.jsf.action.AmAction;
import com.jsf.dao.JsclassMapper;
import com.jsf.entity.Am;
import com.jsf.service.AmService;
import com.jsf.service.impl.AmServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml",
		"classpath*:applicationContext.xml"})      //加载Spring配置文件

public class AmActionTest {

	@Autowired
	protected WebApplicationContext wac;
	
//	@Mock
//	private AmService amservice;
	
//	@InjectMocks
//	private AmAction amaction;			//需要测试的action
	
	private MockMvc mockmvc;			//SpringMvc提供的Controller测试类
	
//	private MockHttpServletRequest request;

//	private MockHttpSession session;
	
//	private static String xmlPath = "classpath:applicationContext.xml";
//	
//	@Before
//	public void setUp() throws Exception{
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//				xmlPath//, "classpath:generatorConfig.xml", "classpath:myBatis-config.xml", "classpath:spring-mvc.xml"
//				);
//		wac = new ClassPathXmlApplicationContext("classpath*:spring-mvc.xml")
//		mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
//		//JsClassMapper = applicationContext.getBean(JsclassMapper.class);
//	}
	
	
	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);			//初始化MockitoAnnotation
		mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
//		request = new MockHttpServletRequest();
//		session = new MockHttpSession();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginSuccess() throws Exception{
		Am am = new Am();
		am.setAmpassword("123");
		am.setAmusername("123");
		am.setAmid(10000);
		MvcResult result = this.mockmvc
				.perform(get("/am/login")
				.param("amusername", am.getAmusername())
				.param("ampassword", am.getAmpassword()))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		Am resultam = (Am) result.getRequest().getSession().getAttribute("user");
		assertEquals(am.getAmid(),resultam.getAmid());
	}
	
	@Test
	@Ignore
	public void testLoginUnSuccess() throws Exception{
		MvcResult result =  this.mockmvc
		.perform(get("/am/login").param("amusername", "123").param("ampassword", "1234"))
		.andExpect(status().isOk())
		.andDo(print())
		.andReturn();
		assertEquals("用户名或密码错误或者身份错误",result.getRequest().getAttribute("msg"));
	}

	
//	private HttpSession getLoginSession(String a,String b) throws Exception{  
//        MvcResult result = this.mockmvc  
//                                .perform((get("/login"))
//                                .param("amusername",a)
//                                .param("ampassword",b))
//                                .andExpect(status().isOk())  
//                                .andReturn();  
//        return result.getRequest().getSession();  
//    }
	

}
