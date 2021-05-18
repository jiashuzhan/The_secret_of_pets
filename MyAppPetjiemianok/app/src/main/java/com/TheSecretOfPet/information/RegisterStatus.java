package com.TheSecretOfPet.information;

import java.io.Serializable;

public class RegisterStatus implements Serializable{

	private static final long serialVersionUID = -852176709854339347L;
	
	private int status;

	public RegisterStatus(){
		
	}
	public RegisterStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RegisterStatus [status=" + status + "]";
	}
	
	
}
