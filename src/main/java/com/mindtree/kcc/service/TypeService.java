package com.mindtree.kcc.service;

import com.mindtree.kcc.entity.Type;
import com.mindtree.kcc.exceptions.ServiceException;

public interface TypeService {

	public Type getTypeById(int id) throws ServiceException;

}
