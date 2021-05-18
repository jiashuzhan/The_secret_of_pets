package com.TheSecretOfPet.information;

import java.io.Serializable;

import com.TheSecretOfPet.entity.Pet;


public class AddpetRequest implements Serializable{


	private static final long serialVersionUID = -8289961802511723235L;

	private Pet pet;
	
	private String requestInfo = "RegisterRequest";

	public AddpetRequest(Pet pet) {
		this.pet= pet;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "AddpetRequest [pet=" + pet + ", requestInfo="
				+ requestInfo + "]";
	}
	
	
}
