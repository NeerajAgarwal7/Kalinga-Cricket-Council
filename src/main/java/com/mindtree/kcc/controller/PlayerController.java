package com.mindtree.kcc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
import com.mindtree.kcc.exceptions.ServiceException;
import com.mindtree.kcc.service.PlayerService;

@RestController
public class PlayerController {

	static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	static PlayerService playerSer = (PlayerService) context.getBean("playerService");
	
	@RequestMapping(value="/player",method = RequestMethod.GET)
	public String playerHome(){
		return "PlayerHome";
	}
	
	@RequestMapping(value="/addPlayer",method=RequestMethod.GET)
	public ModelAndView addPlayer() {
		return new ModelAndView("addPlayer", "command", new Player());
	}
	
	@RequestMapping(value="/addPlayer",method=RequestMethod.POST)
	public String addPlayerToDb(@ModelAttribute("SpringWeb") Player player, ModelMap model, HttpServletRequest req) {
		try {
			playerSer.addPlayer(player);
			model.addAttribute("playerId", player.getId());
			model.addAttribute("playerAge", player.getAge());
			model.addAttribute("name", player.getName());
			model.addAttribute("battingAvg", player.getBattingAvg());
			model.addAttribute("bowlingAvg", player.getBowlingAvg());
			model.addAttribute("type", player.getType());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "result";
	}
	
	@RequestMapping(value="/displayPlayerList",method=RequestMethod.GET)
	public ModelAndView displayPlayerList() {
		ModelAndView model = new ModelAndView();
		try {
			ArrayList<Player> playerList = (ArrayList<Player>) playerSer.getAllPlayers();
			model.addObject("playerList", playerList);
			return model;
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	protected Map<String, Map<String,Integer>> referenceData(HttpServletRequest request) throws Exception {
		Map<String, Map<String,Integer>> referenceData = new HashMap<String, Map<String,Integer>>();
		Map<String,Integer> typeList = new LinkedHashMap<String,Integer>();
		typeList.put("batsman",1);
		typeList.put("bowler",2);
		typeList.put("allRounder",3);
		referenceData.put("typeLists", typeList);
		return referenceData;	
		
	}
}
