package com.TheSecretOfPet.information;

import java.io.Serializable;

import com.TheSecretOfPet.entity.Worker;


public class PetInfoRequest implements Serializable{


	private static final long serialVersionUID = -4979324912575729003L;

	private Worker worker;
	
	private String requestInfo = "PetInfoRequest";

	public PetInfoRequest(Worker worker) {
		this.worker = worker;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/*@Override
	public String toString() {
		return "BusInfoRequest [driver=" + worker + ", requestInfo="
				+ requestInfo + "]";
	}*/
	
	
}
