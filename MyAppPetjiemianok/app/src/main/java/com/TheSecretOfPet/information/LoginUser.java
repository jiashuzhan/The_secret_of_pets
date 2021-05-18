package com.TheSecretOfPet.information;

import java.io.Serializable;
import java.util.Date;

import com.TheSecretOfPet.entity.User;


public class LoginUser extends User implements Serializable{



	private static final long serialVersionUID = -8220732098231079367L;

	private int loginType = 4;
	
	private Date utilDate;

	public LoginUser(){
		
	}
	
	public LoginUser(String userName, String password, int loginType, Date utilDate) {
		super(userName,password);
		this.loginType = loginType;
		this.utilDate = utilDate;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}

	@Override
	public String toString() {
		return "LoginUser [loginType=" + loginType + ", utilDate=" + utilDate
				+ super.toString() + "]";
	}
	
	
}
