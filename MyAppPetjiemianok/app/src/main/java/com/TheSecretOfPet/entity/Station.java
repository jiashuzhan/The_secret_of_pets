package com.TheSecretOfPet.entity;

import java.io.Serializable;


public class Station implements Serializable{

	private static final long serialVersionUID = 3627678062943349886L;

	private int stationID;
	
	private String stationName;
	
	private int lineID;

	public Station() {
		
	}

	public Station(int stationID, String stationName, int lineID) {
		this.stationID = stationID;
		this.stationName = stationName;
		this.lineID = lineID;
	}

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	@Override
	public String toString() {
		return "Station [stationID=" + stationID + ", stationName="
				+ stationName + ", lineID=" + lineID + "]";
	}
	
	
}
