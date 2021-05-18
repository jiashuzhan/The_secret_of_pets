package com.TheSecretOfPet.information;

import java.io.Serializable;

import com.TheSecretOfPet.entity.Worker;


public class UpdateUserRequest implements Serializable{

	private static final long serialVersionUID = -5439743590259513165L;

	private Worker worker;
	
	private String requestInfo = "UpdateUserRequest";
	
	public UpdateUserRequest(Worker worker) {
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
		return "UpdateUserRequest [customer=" + worker + ", requestInfo="
				+ requestInfo + "]";
	}
	
	
}
