package com.mindtree.kcc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.exceptions.ServiceException;

public interface PlayerService {

	@Transactional
	public Player addPlayer(Player player) throws ServiceException;

	public Player getPlayerById(int playerId) throws ServiceException;

	public List<Player> getAllPlayers() throws ServiceException;
	
	public List<Player> getUnsoldPlayers() throws ServiceException;
	
	public void updatePlayer(Player player) throws ServiceException;
}
