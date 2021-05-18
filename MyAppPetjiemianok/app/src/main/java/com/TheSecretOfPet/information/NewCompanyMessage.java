package com.TheSecretOfPet.information;

import java.io.Serializable;
import java.util.List;

import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.entity.CompanyMessage;
import com.TheSecretOfPet.entity.WorkerInformation;
import com.TheSecretOfPet.entity.Tu;


public class NewCompanyMessage implements Serializable{



	private static final long serialVersionUID = 2852712091708007107L;

	private List<CompanyMessage> companyMessages;

	private WorkerInformation workerInformation;
	private Tu tu;

	private List<PetInformation> petInformations;

	private String userName;

	public NewCompanyMessage(String userName){
		this.userName = userName;
	}

	public NewCompanyMessage(){

	}
	public NewCompanyMessage(List<CompanyMessage> companyMessages) {
		this.companyMessages = companyMessages;
	}
	public List<CompanyMessage> getCompanyMessages() {
		return companyMessages;
	}

	public void setCompanyMessages(List<CompanyMessage> companyMessages) {
		this.companyMessages = companyMessages;
	}

	public WorkerInformation getWorkerInformation() {
		return workerInformation;
	}

	public void setWorkerInformation(WorkerInformation workerInformation) {
		this.workerInformation = workerInformation;
	}
	public Tu getTu() {
		return tu;
	}

	public void setTu(Tu tu) {
		this.tu = tu;
	}
	public List<PetInformation> getPetInformations() {
		return petInformations;
	}

	public void setPetInformations(
			List<PetInformation> petInformations) {
		this.petInformations = petInformations;
	}

	@Override
	public String toString() {
		return "NewCompanyMessage [companyMessages=" + companyMessages
				+ ", driverWorkInformation=" + workerInformation + "]";
	}



}
