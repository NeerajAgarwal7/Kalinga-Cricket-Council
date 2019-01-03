package com.mindtree.kcc.dao.daoimpl;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.kcc.dao.TypeDao;
import com.mindtree.kcc.entity.Type;
import com.mindtree.kcc.exceptions.DaoException;

public class TypeDaoImpl implements TypeDao {
	

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public Type getTypeById(int id) throws DaoException {
		try {
		return template.get(Type.class, id);
		}catch(Exception e) {
			throw new DaoException(e.getMessage(),e.getCause());
		}
	}

}
