package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.PetInformation;


public interface PetInformationDAO {

	public List<PetInformation> selectAllPetInformations();
	
	public void updatePetInformation(PetInformation petInformation);
	
	public void addPetInformation(PetInformation petInformation);//shuzhan3/10
	
	public boolean checkPetID(String petID);
	
	public PetInformation selectPetInformationByPetId(String petId);
}