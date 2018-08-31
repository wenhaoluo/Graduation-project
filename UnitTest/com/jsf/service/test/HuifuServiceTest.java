package com.jsf.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsf.entity.Huifu;
import com.jsf.service.HuifuService;

public class HuifuServiceTest {

	@Autowired
	private HuifuService huifuservice;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		huifuservice = applicationContext.getBean(HuifuService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelecthuifu() throws Exception {
		List<Huifu> result = huifuservice.selecthuifu();
		assertNotNull(result);
	}

}
