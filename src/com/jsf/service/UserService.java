package com.jsf.service;



import java.util.List;

import com.jsf.entity.Page;
import com.jsf.entity.User;

public interface UserService extends BaseService<User>{
	public User login(User user);
	public int updatevip(User user) throws Exception;
	public int insertvip(User user) throws Exception;
	public User selectuser(int id)throws Exception;
	public List<User> select1();


}
