package com.jsf.service.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.AmMapper;
import com.jsf.entity.Am;
import com.jsf.entity.User;
import com.jsf.service.AmService;
import com.jsf.service.impl.AmServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
//@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
//@Transactional			//事务管理
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"}) 
public class AmServiceTest {
	
	@Autowired
    private AmService amservice;
	
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		amservice = applicationContext.getBean(AmService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		Am am = new Am();
		am.setAmpassword("123");
		am.setAmusername("123");
//		when(ammapper.login(am)).thenReturn(am);
		Am result = this.amservice.login(am);
		assertNotNull(result);
		
	}

}
