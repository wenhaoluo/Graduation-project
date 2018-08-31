package com.jsf.dao;

import java.util.List;

import com.jsf.entity.Page;
import com.jsf.entity.Tie;
import com.jsf.entity.User;




public interface UserMapper extends BaseMapper<User>{
	public User login(User user);
	public int updatevip(User user);
	public int insertvip(User user);
	public User selectuser(int id);

	public List<User> select1();
	

	
	
}