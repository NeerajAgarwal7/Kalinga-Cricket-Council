package com.mindtree.kcc.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.kcc.dao.TeamDao;
import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.exceptions.DaoException;

@Repository
public class TeamDaoImpl implements TeamDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public int insertTeam(Team team) throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			int id = (Integer) s.save(team);
			s.beginTransaction().commit();
			return id;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	public Team teamById(int teamId) throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			Team team = template.get(Team.class, teamId);
			s.beginTransaction().commit();
			return team;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	public List<Team> allTeams() throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			List<Team> teamList = new ArrayList<Team>();
			teamList = template.loadAll(Team.class);
			s.beginTransaction().commit();
			return teamList;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}
}
