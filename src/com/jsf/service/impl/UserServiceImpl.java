package com.jsf.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.UserMapper;
import com.jsf.entity.Page;
import com.jsf.entity.User;
import com.jsf.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}


	@Override
	public int updatevip(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updatevip(user);
	}

	@Override
	public int insertvip(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.insertvip(user);
	}


	@Override
	public User selectuser(int id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectuser(id);
	}


	@Override
	public List<User> select1(){
		// TODO Auto-generated method stub
		return userMapper.select1();
	}







}
