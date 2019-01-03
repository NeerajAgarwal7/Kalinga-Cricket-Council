package com.mindtree.kcc.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mindtree.kcc.dao.TeamDao;
import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.exceptions.DaoException;
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.TeamService;

public class TeamServiceImpl implements TeamService {

	TeamDao teamDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Transactional
	public Team addTeam(Team team) throws ServiceException {

		try {
			int id = teamDao.insertTeam(team);
			return teamDao.teamById(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	public Team getTeamById(int teamId) throws ServiceException {

		try {
			return teamDao.teamById(teamId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	public List<Team> getAllTeams() throws ServiceException {

		List<Team> teamList = new ArrayList<Team>();
		try {
			teamList = teamDao.allTeams();
			return teamList;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
