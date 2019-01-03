package com.mindtree.kss.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.kcc.entity.Player;
import com.mindtree.kcc.entity.Team;
import com.mindtree.kcc.entity.Type;
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.PlayerService;

public class MainApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ServiceException {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PlayerService playerSer = (PlayerService) context.getBean("playerService");
		
		Player player = new Player();
		player.setId(1);
		player.setAge(23);
		player.setBattingAvg(48);
		player.setName("Neeraj");
//		player.setType(new Type(1,"batsman"));
		
		Team team = new Team();
		team.setTeamId(1);
		team.setCountry("India");
		team.setName("dfghjk");

//		TeamService teamSer = (TeamService) context.getBean("teamService");
//		teamSer.addTeam(team);
		
		System.out.println(playerSer.addPlayer(player));
		
		
	}

}
