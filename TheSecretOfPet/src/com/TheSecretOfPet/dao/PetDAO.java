package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.Pet;


/**
 * ����ʵ�������ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface PetDAO {

	/*��ȡ����*/
	public List<Pet> getAllPet();
	
	/*���ݺŻ�ȡ*/
	public Pet getPet(String petID);
	
	/*���*/
	public void addPet(Pet pet);
	
	/*ɾ��*/
	public void deletePet(String petID);
	
	/*����*/
	public void updatePet(Pet pet);
	
	/*���ݺż���Ƿ����*/
	public boolean checkPet(String petID);
}
