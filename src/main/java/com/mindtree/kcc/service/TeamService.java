package com.mindtree.kcc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.exceptions.ServiceException;

public interface TeamService {

	@Transactional
	public Team addTeam(Team team) throws ServiceException;

	public Team getTeamById(int teamId) throws ServiceException;

	public List<Team> getAllTeams() throws ServiceException;

}
