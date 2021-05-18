package com.TheSecretOfPet.dao;

import java.sql.Date;
import java.util.List;

import com.TheSecretOfPet.entity.CompanyMessage;

public interface CompanyMessageDAO {

	public List<CompanyMessage> getNewCompanyMessages(Date date);
	
	public CompanyMessage getCompanyMessage(int id);
	
	public void addCompanyMessage(CompanyMessage companyMessage);
	
	public void deleteCompanyMessage(int id);
}
