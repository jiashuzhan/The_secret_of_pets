package com.TheSecretOfPet.information;

import java.io.Serializable;

import com.TheSecretOfPet.entity.Worker;


public class RegisterRequest implements Serializable{


	private static final long serialVersionUID = -8018800999988383268L;

	private Worker worker;
	
	private String requestInfo = "RegisterRequest";

	public RegisterRequest(Worker worker) {
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
		return "RegisterRequest [worker=" + worker + ", requestInfo="
				+ requestInfo + "]";
	}
	
	
}
