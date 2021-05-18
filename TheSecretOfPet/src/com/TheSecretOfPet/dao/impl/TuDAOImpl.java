package com.TheSecretOfPet.dao.impl;

import java.util.List;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.TuDAO;
import com.TheSecretOfPet.dao.WorkerInformationDAO;
import com.TheSecretOfPet.entity.Tu;
import com.TheSecretOfPet.entity.WorkerInformation;

public class TuDAOImpl extends DAO<Tu> implements TuDAO {
	
	public Tu getTu(String userName) {
		String sql = "select * from Tu where username = ?";
		return get(sql, userName);
	}

	@Override
	public List<Tu> getALLTu() {
		String sql = "select * from Tu";
		return getForList(sql);
    }
}
