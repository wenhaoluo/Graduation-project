package com.jsf.dao;

import java.util.List;


import com.jsf.entity.Tie;



public interface TieMapper extends BaseMapper<Tie>{
	public List<Tie> selecttie();
	public List<Tie> selectmytie(Tie tie);
 
}