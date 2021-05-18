package com.TheSecretOfPet.entity;

import java.io.Serializable;

import com.TheSecretOfPet.entity.User;


/**
 *
 * @author Administrator
 *
 */
public class Worker extends User implements Serializable{
	

	private static final long serialVersionUID = -3449486180717985657L;

	private String workerName;
	
	private int workersex;
	
	private int workerYears;
	
	private int healthExam;
	
	private String petID;
	
	private String telephone;
	
	public Worker(){
		
	}

	public Worker(String userName, String password, String workerName,
			int workersex, int workerYears, int healthExam, String petID,
			String telephone) {
		super(userName, password);
		this.workerName = workerName;
		this.workersex = workersex;
		this.workerYears = workerYears;
		this.healthExam = healthExam;
		this.petID = petID;
		this.telephone = telephone;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public int getworkersex() {
		return workersex;
	}

	public void setWorkersex(int workersex) {
		this.workersex = workersex;
	}

	public int getWorkerYears() {
		return workerYears;
	}

	public void setWorkerYears(int workerYears) {
		this.workerYears = workerYears;
	}

	public int getHealthExam() {
		return healthExam;
	}

	public void setHealthExam(int healthExam) {
		this.healthExam = healthExam;
	}

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Driver [driverName=" + workerName + ", driversex=" + workersex
				+ ", drivingYears=" + workerYears + ", healthExam="
				+ healthExam + ", busID=" + petID + ", telephone=" + telephone
				+ "]";
	}

	
}
