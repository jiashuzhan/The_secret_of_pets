package com.TheSecretOfPet.information;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.dao.impl.CompanyMessageDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerInformationDAOImpl;
import com.TheSecretOfPet.dao.impl.TuDAOImpl;
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
		this.init();
	}
	
	public void init(){
		CompanyMessageDAOImpl companyMessageDAOImpl = new CompanyMessageDAOImpl();
		this.companyMessages = companyMessageDAOImpl.getNewCompanyMessages(new Date(new java.util.Date().getTime()));
		System.out.println(companyMessages.toString());
		WorkerInformationDAOImpl WorkerInformationDAOImpl = new WorkerInformationDAOImpl();
		this.workerInformation = WorkerInformationDAOImpl.getWorkerInformation(userName);
		System.out.println(workerInformation.toString());//csz3/10
		PetInformationDAOImpl petInformationDAOImpl = new PetInformationDAOImpl();
		this.petInformations = petInformationDAOImpl.selectAllPetInformations();
		System.out.println(petInformations.toString());
		
		TuDAOImpl TuDAOImpl = new TuDAOImpl();
		this.tu = TuDAOImpl.getTu(userName);
		System.out.println(tu.toString());//csz3/10
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
