package com.jsf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jsf.entity.Course;
import com.jsf.entity.Page;



public interface CourseMapper extends BaseMapper<Course>{
	//通过关键字分页查询数据列表
	public List<Course> selectPageListteacher(Page<Course> page);
			
	//通过关键字分页查询，返回总记录数
	public Integer selectPageCountteacher(Page<Course> page);
	
	//通过关键字分页查询，返回总记录数
	public Integer selectapplycourse(Page<Course> page);
	
	//通过关键字分页查询，返回总记录数
	public Integer updateclassover(Page<Course> page);
}