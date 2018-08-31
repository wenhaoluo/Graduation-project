package com.jsf.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.CourseMapper;
import com.jsf.entity.Course;
import com.jsf.entity.Page;

public class CourseMapperTest {
	@Autowired
	private CourseMapper courseMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

		courseMapper = applicationContext.getBean(CourseMapper.class);
	}
	
	@After
	public void tearDown() throws Exception{
		
	};
	
	@Test
	public void InsertCourseTest() {
		Course course = new Course();
		course.setCourseid(4);
		course.setYytime("2018-11-16 02:05:09");
		course.setClassover(false);
		course.setTeacherid(17);
		course.setStudentid(1);
		course.setCid(2);
		
		Integer record = this.courseMapper.insert(course);
		Integer Expected = 1;
		assertEquals(Expected,record);
		
	}
	
	@Test
	public void UpdateCourseTest() {
		Course course = new Course();
		course.setCourseid(4);
		course.setYytime("2018-11-16 02:05:09");
		course.setClassover(false);
		course.setTeacherid(17);
		course.setStudentid(1);
		course.setCid(3);
		Integer record = this.courseMapper.update(course);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectPageListTeacher() {
		Page<Course> page = new Page<Course>();
		page.setPage(1);
		page.setRows(10);
		page.setUserid(19);
		
		List<Course> record = this.courseMapper.selectPageListteacher(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountTeacherTest(){
		Course course = new Course();
		
		Page page = new Page();
		page.setUserid(17);
		page.setParamEntity(course);
		
		Integer record = this.courseMapper.selectPageCountteacher(page);
		Integer Expected = 7;
		assertEquals(Expected,record);
	}
	

	@Test
	public void SelectPageListUseDycTest() {
		Map<String,String> m = new HashMap<String,String>();
		m.put("cname", "哑铃卧推");
		
		Page page = new Page();
		page.setPage(1);
		page.setRows(10);
		page.setUserid(17);
		page.setParamEntity(m);
		List<Course> record = this.courseMapper.selectPageListUseDyc(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountUseDyTest(){
		Course course = new Course();
		
		Page page = new Page();
		page.setUserid(1);
		page.setParamEntity(course);
		
		Integer record = this.courseMapper.selectPageCountUseDyc(page);
		Integer Expected = 8;
		assertEquals(Expected,record);
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"58","59","60"};
		Integer record = this.courseMapper.deleteList(arr);
		Integer Expected = 3;
		assertEquals(Expected,record);
	}
	
}
