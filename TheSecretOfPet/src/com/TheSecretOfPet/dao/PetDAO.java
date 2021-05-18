package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.Pet;


/**
 * 宠物实体类数据访问接口
 * @author Administrator
 *
 */
public interface PetDAO {

	/*获取所有*/
	public List<Pet> getAllPet();
	
	/*根据号获取*/
	public Pet getPet(String petID);
	
	/*添加*/
	public void addPet(Pet pet);
	
	/*删除*/
	public void deletePet(String petID);
	
	/*更新*/
	public void updatePet(Pet pet);
	
	/*根据号检查是否存在*/
	public boolean checkPet(String petID);
}
