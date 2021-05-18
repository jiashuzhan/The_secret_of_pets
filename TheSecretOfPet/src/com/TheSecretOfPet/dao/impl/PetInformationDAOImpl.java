package com.TheSecretOfPet.dao.impl;

import java.util.List;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.PetInformationDAO;
import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.entity.PetInformation;


public class PetInformationDAOImpl extends DAO<PetInformation> implements PetInformationDAO{

	@Override
	public List<PetInformation> selectAllPetInformations() {
		String sql = "select * from PetInnerInformation ";
		return getForList(sql);
	}

	@Override
	public void updatePetInformation(
			PetInformation busInnerInformation) {
		String sql = "update PetInnerInformation set petStatus = ? , petType = ? , roomTemperature = ? , petTemperature = ? , petLongitude = ? , petLatitude = ? , lightStrength = ? , lightStatusOne = ? , lightStatusTwo = ? , lightStatusThree = ? , lightStatusFour = ? where petID = ?";
		update(sql, busInnerInformation.getPetStatus(), busInnerInformation.getpetType(),busInnerInformation.getroomTemperature(), busInnerInformation.getPetTemperature(), busInnerInformation.getPetLongitude(), busInnerInformation.getPetLatitude(), busInnerInformation.getLightStrength(), busInnerInformation.getLightStatusOne(), busInnerInformation.getLightStatusTwo(), busInnerInformation.getLightStatusThree(), busInnerInformation.getLightStatusFour(), busInnerInformation.getPetID());
	}
	@Override
	public void addPetInformation(PetInformation petInformation) {
		String sql = "insert into PetInnerInformation (petID,petStatus,petType,roomTemperature,petTemperature,petLongitude,petLatitude,lightStrength,lightStatusOne,lightStatusTwo,lightStatusThree,lightStatusFour) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql, petInformation.getPetID(),petInformation.getPetStatus(), petInformation.getpetType(),petInformation.getroomTemperature(), petInformation.getPetTemperature(), petInformation.getPetLongitude(), petInformation.getPetLatitude(), petInformation.getLightStrength(), petInformation.getLightStatusOne(),petInformation.getLightStatusTwo(),petInformation.getLightStatusThree(), petInformation.getLightStatusFour());
	}
	@Override
	public boolean checkPetID(String petID) {
		String sql = "select * from PetInnerInformation where petID = ?";
		List<PetInformation> list = getForList(sql, petID);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PetInformation selectPetInformationByPetId(String petId) {
		String sql = "select * from PetInnerInformation where petID = ?";
		return get(sql, petId);
	}
	
	

}
