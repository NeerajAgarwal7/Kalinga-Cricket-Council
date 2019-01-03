package com.mindtree.kcc.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.kcc.dao.PlayerDao;
import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.exceptions.DaoException;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public int insertPlayer(Player player) throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			int id = (Integer) s.save(player);
			s.beginTransaction().commit();
			return id;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	public List<Player> allPlayers() throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			List<Player> playerList = new ArrayList<Player>();
			playerList = template.loadAll(Player.class);
			s.beginTransaction().commit();
			return playerList;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

	}

	public Player playerById(int playerId) throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			Player player = template.get(Player.class, playerId);
			s.beginTransaction().commit();
			return player;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}
	
	public void updatePlayer(Player player) throws DaoException {
		try {
			Session s = template.getSessionFactory().openSession();
			s.update(player);
			s.beginTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

}
