package com.TheSecretOfPet.information;

import java.io.Serializable;

import com.TheSecretOfPet.entity.Worker;


public class PetInnerinformationRefreshRequest implements Serializable{

	private static final long serialVersionUID = 8222858122601265341L;

	private Worker worker;
	
	private String requestInfo = "PetInnerinformationRefreshRequest";

	public PetInnerinformationRefreshRequest(Worker worker) {
		this.worker = worker;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	@Override
	public String toString() {
		return "BusInnerinformationRefreshRequest [driver=" + worker
				+ ", requestInfo=" + requestInfo + "]";
	}
	
	
}
