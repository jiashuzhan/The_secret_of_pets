package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.Tu;


public interface TuDAO {
	
	public Tu getTu(String userName);
	public List<Tu> getALLTu();

}
