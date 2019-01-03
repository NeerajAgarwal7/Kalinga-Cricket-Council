package com.mindtree.kcc.dao;

import java.util.List;

import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.exceptions.DaoException;

public interface PlayerDao {

	public int insertPlayer(Player player) throws DaoException;

	public List<Player> allPlayers() throws DaoException;

	public Player playerById(int playerId) throws DaoException;

	public void updatePlayer(Player player) throws DaoException;

}
