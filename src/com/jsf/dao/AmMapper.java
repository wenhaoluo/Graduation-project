package com.jsf.dao;

import org.springframework.stereotype.Repository;

import com.jsf.entity.Am;
import com.jsf.entity.User;



public interface AmMapper extends BaseMapper<Am>{
	public Am login(Am am);
}