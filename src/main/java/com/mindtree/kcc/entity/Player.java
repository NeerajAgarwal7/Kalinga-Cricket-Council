package com.mindtree.kcc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {

	@Id
	private int id;
	private String name;
	private String type;
	private int age;
	private double battingAvg;
	private double bowlingAvg;
	@ManyToOne
	@JoinColumn(name = "teamId")
	public Team team;

	public Player() {
		super();
	}

	public Player(int id, String name, String type, int age, double battingAvg, double bowlingAvg) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.battingAvg = battingAvg;
		this.bowlingAvg = bowlingAvg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public double getBowlingAvg() {
		return bowlingAvg;
	}

	public void setBowlingAvg(double bowlingAvg) {
		this.bowlingAvg = bowlingAvg;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", battingAvg=" + battingAvg
				+ ", bowlingAvg=" + bowlingAvg + "]";
	}

}
