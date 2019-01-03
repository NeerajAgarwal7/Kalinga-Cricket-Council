package com.mindtree.kcc.service.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.mindtree.kcc.dao.PlayerDao;
import com.mindtree.kcc.entity.AvgComparator;
import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.exceptions.DaoException;
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	PlayerDao playerDao;

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Transactional
	public Player addPlayer(Player player) throws ServiceException {

		try {
			int id = playerDao.insertPlayer(player);
			return playerDao.playerById(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	public List<Player> getAllPlayers() throws ServiceException {

		try {
			List<Player> playerList = playerDao.allPlayers();
			Collections.sort(playerList, new AvgComparator());
			return playerList;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	
	public List<Player> getUnsoldPlayers() throws ServiceException{
		try {
			List<Player> unsoldPlayerList = playerDao.allPlayers();
			unsoldPlayerList = unsoldPlayerList.stream().filter(i -> i.team==null).collect(Collectors.toList());
			System.out.println(unsoldPlayerList);
			return unsoldPlayerList;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	public Player getPlayerById(int playerId) throws ServiceException {
		
		try {
			return playerDao.playerById(playerId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public void updatePlayer(Player player) throws ServiceException {

		try {
			playerDao.updatePlayer(player);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		
	}

}
