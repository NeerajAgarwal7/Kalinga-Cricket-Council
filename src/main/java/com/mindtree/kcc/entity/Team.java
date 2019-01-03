package com.mindtree.kcc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	private int teamId;
	private String name;
	@OneToMany(targetEntity=Player.class,mappedBy="team")
	private List<Player> players;
	private String country;
	public Team() {
		super();
	}
	public Team(int teamId, String name, List<Player> players, String country) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.players = players;
		this.country = country;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", players=" + players + ", country=" + country + "]";
	}
}
