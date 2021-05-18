package com.TheSecretOfPet.dao;

import java.sql.Date;

import com.TheSecretOfPet.entity.UpdateInformation;


/**
 * 数据表更新信息实体类数据访问接口
 * @author Administrator
 *
 */
public interface UpdateInformationDAO {

	public Date getUpdateInformationDate(String tableName);
	
	public UpdateInformation getUpdateInformation(String tableName);
	
	public void addUpdateInformation(UpdateInformation updateInformation);
	
	public void updateUpdateInformation(UpdateInformation updateInformation);
}
