package com.mindtree.kcc.dao;

import java.util.List;

import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.exceptions.DaoException;

public interface TeamDao {
	
	public int insertTeam(Team team) throws DaoException;
	public Team teamById(int teamId) throws DaoException;
	public List<Team> allTeams() throws DaoException;

}
