package com.TheSecretOfPet.dao;

import java.sql.Date;

import com.TheSecretOfPet.entity.UpdateInformation;


/**
 * ���ݱ������Ϣʵ�������ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface UpdateInformationDAO {

	public Date getUpdateInformationDate(String tableName);
	
	public UpdateInformation getUpdateInformation(String tableName);
	
	public void addUpdateInformation(UpdateInformation updateInformation);
	
	public void updateUpdateInformation(UpdateInformation updateInformation);
}
