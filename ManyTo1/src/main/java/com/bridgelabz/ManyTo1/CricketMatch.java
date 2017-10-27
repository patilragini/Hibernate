package com.bridgelabz.ManyTo1;

public class CricketMatch {
	
	private int id;
	private String team1;
	private String team2;
	private String type;
	private String umpire;
	private Stadium stadium;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1=team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2=team2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getUmpire() {
		return umpire;
	}
	public void setUmpire(String umpire) {
		this.umpire=umpire;
	}
	public Stadium getStadium() {
		return stadium;
	}
	public void setStadium(Stadium stadium) {
		this.stadium=stadium;
	}
	@Override
    public String toString() {
      return "Passport [id=" + id + ", team1=" + team1 + ", team2="
              + team2 + ", umpire=" + umpire + ", type=" + type
              +  "]";
    }    

}