package com.TheSecretOfPet.entity;

import java.io.Serializable;

public class WorkerInformation implements Serializable{


	private static final long serialVersionUID = 6674844849834974901L;

	private String userName;
	
	private String petID;
	
	private int lineID;
	
	private String workStatus;
	
	private int restTime;
	
	public WorkerInformation(){
		
	}

	public WorkerInformation(String userName, String petID, int lineID,
			String workStatus, int restTime) {
		this.userName = userName;
		this.petID = petID;
		this.lineID = lineID;
		this.workStatus = workStatus;
		this.restTime = restTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public int getRestTime() {
		return restTime;
	}

	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}

	@Override
	public String toString() {
		return "DriverWorkInformation [userName=" + userName + ", busID="
				+ petID + ", lineID=" + lineID + ", workStatus=" + workStatus
				+ ", restTime=" + restTime + "]";
	}
	
	
}
