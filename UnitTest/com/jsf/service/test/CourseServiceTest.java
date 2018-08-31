package com.jsf.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsf.entity.Course;
import com.jsf.entity.Page;
import com.jsf.entity.User;
import com.jsf.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class CourseServiceTest {

	@Autowired
    private CourseService courseservice;
	
//	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		
//		courseservice = applicationContext.getBean(CourseService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectPageListteacher() {
		User user = new User();
		user.setUserid(19);
		
		Page page = new Page();
		page.setPage(1);
		page.setRows(10);
		Page<Course> result = this.courseservice.selectPageListteacher(page);
		assertNotNull(result);
	}

}
