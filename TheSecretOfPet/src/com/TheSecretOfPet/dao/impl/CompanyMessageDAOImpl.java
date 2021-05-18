package com.TheSecretOfPet.dao.impl;

import java.sql.Date;
import java.util.List;

import com.TheSecretOfPet.dao.CompanyMessageDAO;
import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.entity.CompanyMessage;

public class CompanyMessageDAOImpl extends DAO<CompanyMessage> implements CompanyMessageDAO{

	@Override
	public List<CompanyMessage> getNewCompanyMessages(Date date) {
		String sql = "select * from CompanyMessage where date = ?";
		return getForList(sql, date);
	}

	@Override
	public CompanyMessage getCompanyMessage(int id) {
		String sql = "select * from CompanyMessage where id = ?";
		return get(sql, id);
	}

	@Override
	public void addCompanyMessage(CompanyMessage companyMessage) {
		String sql = "insert into CompanyMessage (theme,information,reporter,date,id) values (?,?,?,?,?)";
		update(sql, "¡¾"+companyMessage.getTheme()+"¡¿", companyMessage.getInformation(), companyMessage.getReporter(), new Date(companyMessage.getDate().getTime()), companyMessage.getId());
	}

	@Override
	public void deleteCompanyMessage(int id) {
		String sql = "delete from CompanyMessage where id = ?";
		update(sql, id);
	}

}
