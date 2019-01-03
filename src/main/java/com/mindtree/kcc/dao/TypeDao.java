package com.mindtree.kcc.dao;

import com.mindtree.kcc.entity.Type;
import com.mindtree.kcc.exceptions.DaoException;

public interface TypeDao {

	public Type getTypeById(int id) throws DaoException;
	
}
