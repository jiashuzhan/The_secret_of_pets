package com.TheSecretOfPet.information;

import java.io.Serializable;

public class PaySucess implements Serializable{

	private static final long serialVersionUID = -8028619272646294793L;

	private String msg;
	
	private boolean status = false;

	public PaySucess(String msg, boolean status) {
		this.msg = msg;
		this.status = status;
	}
	
	public PaySucess() {
		this.msg = "sucess";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaySucess [msg=" + msg + ", status=" + status + "]";
	}
	
	
}
