package com.TheSecretOfPet.entity;

import java.io.Serializable;

public class Pet implements Serializable{


	private static final long serialVersionUID = 4516404564752071641L;

	private String petID;
	
	private float innerTem;
	
	private float outerTem;
	
	private float lightStrength;
	
	private int petage;
	
	private int status;
	
	private String petType;
	
	private float petkg;
	
	private String workerName;
	
	private String petname;

	public Pet() {
		
	}

	public Pet(String petID, float innerTem, float outerTem,
			float lightStrength, int petage, int status,
			String petType, float petkg,
			String workerName, String petname) {
		this.petID = petID;
		this.innerTem = innerTem;
		this.outerTem = outerTem;
		this.lightStrength = lightStrength;
		this.petage = petage;
		this.status = status;
		this.petType = petType;
		this.petkg = petkg;
		this.workerName = workerName;
		this.petname = petname;
	}

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public float getInnerTem() {
		return innerTem;
	}

	public void setInnerTem(float innerTem) {
		this.innerTem = innerTem;
	}

	public float getOuterTem() {
		return outerTem;
	}

	public void setOuterTem(float outerTem) {
		this.outerTem = outerTem;
	}

	public float getLightStrength() {
		return lightStrength;
	}

	public void setLightStrength(float lightStrength) {
		this.lightStrength = lightStrength;
	}

	public int getPetage() {
		return petage;
	}

	public void setPetage(int petage) {
		this.petage = petage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getpetType() {
		return petType;
	}

	public void setpetType(String petType) {
		this.petType = petType;
	}


	public float getPetkg() {
		return petkg;
	}

	public void setPetkg(float petkg) {
		this.petkg = petkg;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getPetname() {
		return petname;
	}

	public void setLineID(String petname) {
		this.petname = petname;
	}

	@Override
	public String toString() {
		return "Pet [petID=" + petID + ", innerTem=" + innerTem + ", outerTem="
				+ outerTem + ", lightStrength=" + lightStrength
				+ ", petage=" + petage + ", status=" + status
				+ ", petType=" + petType+ ", petkg=" + petkg + ", workerName="
				+ workerName + ", petname=" + petname + "]";
	}

}
