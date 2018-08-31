package com.jsf.service;

import com.jsf.entity.Course;
import com.jsf.entity.Page;


public interface CourseService extends BaseService<Course>{
	//通过多条件分页查询
	public Page<Course> selectPageListteacher(Page<Course> page); 
}
