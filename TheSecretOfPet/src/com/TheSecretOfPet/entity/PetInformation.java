package com.TheSecretOfPet.entity;

import java.io.Serializable;

public class PetInformation  implements Serializable{

	private static final long serialVersionUID = 7183409992154000765L;

	private String petID;
	
	private int petStatus;
	
	private int petType;
	
	private float roomTemperature;
	
	private float petTemperature;
	
	private float petLongitude;
	
	private float petLatitude;
	
	private float lightStrength;
	
	private int lightStatusOne;
	
	private int lightStatusTwo;
	
	private int lightStatusThree;
	
	private int lightStatusFour;

	public PetInformation(String petID, int petStatus, int petType,
			float roomTemperature, float petTemperature,
			float petLongitude, float petLatitude, float lightStrength,
			int lightStatusOne, int lightStatusTwo, int lightStatusThree,
			int lightStatusFour) {
		this.petID = petID;
		this.petStatus = petStatus;
		this.petType = petType;
		this.roomTemperature = roomTemperature;
		this.petTemperature = petTemperature;
		this.petLongitude = petLongitude;
		this.petLatitude = petLatitude;
		this.lightStrength = lightStrength;
		this.lightStatusOne = lightStatusOne;
		this.lightStatusTwo = lightStatusTwo;
		this.lightStatusThree = lightStatusThree;
		this.lightStatusFour = lightStatusFour;
	}

	public PetInformation(){
		
	}

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public int getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(int petStatus) {
		this.petStatus = petStatus;
	}

	public int getpetType() {
		return petType;
	}

	public void setpetType(int petType) {
		this.petType = petType;
	}
	
	public float getroomTemperature() {
		return roomTemperature;
	}

	public void setroomTemperature(float roomTemperature) {
		this.roomTemperature = roomTemperature;
	}

	public float getPetTemperature() {
		return petTemperature;
	}

	public void setPetTemperature(float petTemperature) {
		this.petTemperature = petTemperature;
	}

	public float getPetLongitude() {
		return petLongitude;
	}

	public void setPetLongitude(float petLongitude) {
		this.petLongitude = petLongitude;
	}

	public float getPetLatitude() {
		return petLatitude;
	}

	public void setPetLatitude(float petLatitude) {
		this.petLatitude = petLatitude;
	}

	public float getLightStrength() {
		return lightStrength;
	}

	public void setLightStrength(float lightStrength) {
		this.lightStrength = lightStrength;
	}

	public int getLightStatusOne() {
		return lightStatusOne;
	}

	public void setLightStatusOne(int lightStatusOne) {
		this.lightStatusOne = lightStatusOne;
	}

	public int getLightStatusTwo() {
		return lightStatusTwo;
	}

	public void setLightStatusTwo(int lightStatusTwo) {
		this.lightStatusTwo = lightStatusTwo;
	}

	public int getLightStatusThree() {
		return lightStatusThree;
	}

	public void setLightStatusThree(int lightStatusThree) {
		this.lightStatusThree = lightStatusThree;
	}

	public int getLightStatusFour() {
		return lightStatusFour;
	}

	public void setLightStatusFour(int lightStatusFour) {
		this.lightStatusFour = lightStatusFour;
	}

	@Override
	public String toString() {
		return "PetInnerInformation [petID=" + petID + ", petStatus="
				+ petStatus + ", petType=" + petType+ ", roomTemperature="
				+ roomTemperature + ", petTemperature="
				+ petTemperature + ", petLongitude=" + petLongitude
				+ ", petLatitude=" + petLatitude + ", lightStrength="
				+ lightStrength + ", lightStatusOne=" + lightStatusOne
				+ ", lightStatusTwo=" + lightStatusTwo + ", lightStatusThree="
				+ lightStatusThree + ", lightStatusFour=" + lightStatusFour
				+ "]";
	}

	
}

