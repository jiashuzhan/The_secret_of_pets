package com.TheSecretOfPet.dao.impl;

import java.sql.Date;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.UpdateInformationDAO;
import com.TheSecretOfPet.entity.UpdateInformation;


public class UpdateInformationDAOImpl extends DAO<UpdateInformation> implements UpdateInformationDAO{

	@Override
	public UpdateInformation getUpdateInformation(String tableName) {
		String sql = "select * from UpdateInformation where tableName = ?";
		return get(sql, tableName);
	}

	@Override
	public void addUpdateInformation(UpdateInformation updateInformation) {
		String sql = "insert into UpdateInformation (tableName,updateTime) values (?,?)";
		update(sql, updateInformation.getTableName(), updateInformation.getUpdateTime());
	}

	@Override
	public void updateUpdateInformation(UpdateInformation updateInformation) {
		String sql = "update UpdateInformation set updateTime = ? where tableName = ?";
		update(sql, updateInformation.getUpdateTime(), updateInformation.getTableName());
	}

	@Override
	public Date getUpdateInformationDate(String tableName) {
		return getUpdateInformation(tableName).getUpdateTime();
	}

	
}
