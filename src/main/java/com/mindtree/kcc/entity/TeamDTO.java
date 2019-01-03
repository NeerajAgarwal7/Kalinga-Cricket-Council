package com.mindtree.kcc.entity;

import java.util.List;

public class TeamDTO {

	private int teamId;
	private String name;
	private List<Integer> ids;
	private String country;

	public TeamDTO() {
		super();
	}

	public TeamDTO(int teamId, String name, List<Integer> ids, String country) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.ids = ids;
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

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "TeamDTO [teamId=" + teamId + ", name=" + name + ", ids=" + ids + ", country=" + country + "]";
	}

}
