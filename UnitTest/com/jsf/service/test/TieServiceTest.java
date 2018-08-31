package com.jsf.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsf.entity.Tie;
import com.jsf.service.TieService;

public class TieServiceTest {

	@Autowired
	private TieService tieservice;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		tieservice = applicationContext.getBean(TieService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelecttie() throws Exception {
		List<Tie> result = this.tieservice.selecttie();
		assertNotNull(result);
	}

	@Test
	public void testSelectmytie() throws Exception {
		Tie tie = new Tie();
		tie.setUserid(8);
		
		List<Tie> result = this.tieservice.selectmytie(tie);
		assertNotNull(result);
	}

}
