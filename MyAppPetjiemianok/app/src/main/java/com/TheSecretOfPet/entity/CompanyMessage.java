package com.TheSecretOfPet.entity;

import java.io.Serializable;
import java.util.Date;

public class CompanyMessage implements Serializable{


	private static final long serialVersionUID = -1794273077360747589L;

	private String theme;
	
	private String information;
	
	private String reporter;
	
	private Date date;
	
	private int id;

	public CompanyMessage(){
		
	}

	public CompanyMessage(String theme, String information, String reporter,
			Date date, int id) {
		this.theme = theme;
		this.information = information;
		this.reporter = reporter;
		this.date = date;
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CompanyMessage [theme=" + theme + ", information="
				+ information + ", reporter=" + reporter + ", date=" + date
				+ ", id=" + id + "]";
	}
	
	

}
