package com.TheSecretOfPet.dao.impl;

import java.util.List;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.PetDAO;
import com.TheSecretOfPet.entity.Pet;


/**
 * 宠物实体类数据访问接口的实现类
 * @author HQ
 *
 */
public class PetDAOImpl extends DAO<Pet> implements PetDAO{

	@Override
	public List<Pet> getAllPet() {
		String sql = "select * from Pet ";
		return getForList(sql);
	}

	@Override
	public Pet getPet(String petID) {
		String sql = "select * from Pet where petID = ? ";
		return get(sql, petID);
	}

	@Override
	public void addPet(Pet pet) {
		String sql = "insert into Pet (petID,innerTem,outerTem,lightStrength,petage,status,petType,petkg,workerName,petname) values (?,?,?,?,?,?,?,?,?,?)";
		update(sql, pet.getPetID(), pet.getInnerTem(), pet.getOuterTem(), pet.getLightStrength(), pet.getPetage(), pet.getStatus(), pet.getpetType(), pet.getPetkg(), pet.getWorkerName(), pet.getPetname());
	}

	@Override
	public void deletePet(String petID) {
		String sql = "delete from Pet where petID = ? ";
		update(sql, petID);
	}

	@Override
	public void updatePet(Pet pet) {
		String sql = "update Pet set innerTem = ? , outerTem = ? , lightStrength = ? , petage = ? , status = ? , petType = ? , petkg = ? , workerName = ? , petname = ? where petID = ?";
		update(sql, pet.getInnerTem(), pet.getOuterTem(), pet.getLightStrength(), pet.getPetage(), pet.getStatus(), pet.getpetType(), pet.getPetkg(),pet.getWorkerName(), pet.getPetname(), pet.getPetID());
	}

	@Override
	public boolean checkPet(String petID) {
		String sql = "select * from Pet where petID = ?";
		List<Pet> list = getForList(sql, petID);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}
	

}
