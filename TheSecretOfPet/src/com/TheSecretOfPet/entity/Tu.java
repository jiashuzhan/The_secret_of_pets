package com.TheSecretOfPet.entity;

import java.io.Serializable;

public class Tu implements Serializable{

	private static final long serialVersionUID = -123596931429338209L;
	
	private String username;
	private String seven;
	private String oneone;
	private String onefive;
	private String onenine;
	private String twothree;
	private String three;
	
    public Tu() {
		
	}
	public Tu(String username,String seven,String oneone,String onefive,String onenine,String twothree,String three) {
		this.username=username;
		this.seven=seven;
		this.oneone=oneone;
		this.onefive=onefive;
		this.onenine=onenine;
		this.twothree=twothree;
		this.three=three;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSeven() {
		return seven;
	}
	public void setSeven(String seven) {
		this.seven = seven;
	}
	public String getOneone() {
		return oneone;
	}
	public void setOneone(String oneone) {
		this.oneone = oneone;
	}
	public String getOnefive() {
		return onefive;
	}
	public void setOnefive(String onefive) {
		this.onefive = onefive;
	}
	public String getOnenine() {
		return onenine;
	}
	public void setOnenine(String onenine) {
		this.onenine = onenine;
	}
	public String getTwothree() {
		return twothree;
	}
	public void setTwothree(String twothree) {
		this.twothree = twothree;
	}
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	
	public String toString() {
		return "Tu [username=" +username + ", seven=" + seven +", oneone=" + oneone + ", onefive="
				+ onefive + ", onenine=" + onenine
				+ ", twothree=" + twothree + ", three=" + three
				+ "]";
	}

}
