package com.TheSecretOfPet.information;

import java.io.Serializable;

public class LoginStatus implements Serializable{


	private static final long serialVersionUID = -3854346247276920818L;

	private int status;
	
	private int isUpdate;

	public LoginStatus(){
		
	}
	
	public LoginStatus(int status, int isUpdate) {
		this.status = status;
		this.isUpdate = isUpdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	@Override
	public String toString() {
		return "LoginStatus [status=" + status + ", isUpdate=" + isUpdate + "]";
	}

	
	
}
