package com.mindtree.kcc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.entity.TeamDTO;
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.PlayerService;
import com.mindtree.kcc.service.TeamService;

@RestController
public class TeamController {
	static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	static TeamService teamSer = (TeamService) context.getBean("teamService");
	static PlayerService playerSer = (PlayerService) context.getBean("playerService");
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String playerHome() {
		return "TeamHome";
	}

	@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
	public ModelAndView addTeam() {

		ModelAndView model = new ModelAndView("addTeam", "command", new TeamDTO());
		try {
			model.addObject("unsoldPlayerList", playerSer.getUnsoldPlayers());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
	public String addTeamToDb(@ModelAttribute("SpringWeb") TeamDTO teamDto, ModelMap model, HttpServletRequest req) {
		Team team = new Team();
		team.setTeamId(teamDto.getTeamId());
		team.setCountry(teamDto.getCountry());
		team.setName(teamDto.getName());
		List<Player> playerList = new ArrayList<>();

		teamDto.getIds().forEach(i -> {
			try {
				playerList.add(playerSer.getPlayerById(i));
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		});
		team.setPlayers(playerList);
		try {
			teamSer.addTeam(team);
			teamDto.getIds().forEach(i -> {
				try {
					Player p = playerSer.getPlayerById(i);
					p.setTeam(team);
					playerSer.updatePlayer(p);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			});
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("teamId", team.getTeamId());
		model.addAttribute("teamName", team.getName());
		model.addAttribute("country", team.getCountry());
		model.addAttribute("playerName", team.getPlayers());
		return "teamResult";

	}
	
	@RequestMapping(value="/displayTeamList",method=RequestMethod.GET)
	public ModelAndView displayTeamList() {
		ModelAndView model = new ModelAndView();
		try {
			ArrayList<Team> teamList = (ArrayList<Team>) teamSer.getAllTeams();
			model.addObject("teamList", teamList);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return model;
	}
}
