package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.WorkerInformation;


public interface WorkerInformationDAO {

	public WorkerInformation getWorkerInformation(String userName);
	
	public void  addWorkerInformation(WorkerInformation workerInformation);
	
	public List<WorkerInformation> getALLWorkerInformations();

}
