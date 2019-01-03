package com.mindtree.kcc.service.serviceimpl;

import com.mindtree.kcc.dao.TypeDao;
import com.mindtree.kcc.entity.Type;
import com.mindtree.kcc.exceptions.DaoException;
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.TypeService;

public class TypeServiceImpl implements TypeService {

	TypeDao typeDao;

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public Type getTypeById(int id) throws ServiceException {

		try {
			typeDao.getTypeById(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

		return null;
	}

}
