package com.jsf.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.CourseMapper;
import com.jsf.entity.Course;
import com.jsf.entity.Page;
import com.jsf.service.CourseService;


@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService{
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public Page<Course> selectPageListteacher(Page<Course> page) {
		// TODO Auto-generated method stub
		page.setList(courseMapper.selectPageListteacher(page));
		page.setTotalRecord(courseMapper.selectPageCountteacher(page));
		return page;
	}


}
