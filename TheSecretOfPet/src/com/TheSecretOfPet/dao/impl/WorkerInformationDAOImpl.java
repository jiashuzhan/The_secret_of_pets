package com.TheSecretOfPet.dao.impl;

import java.util.List;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.WorkerInformationDAO;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.entity.WorkerInformation;


public class WorkerInformationDAOImpl extends DAO<WorkerInformation> implements WorkerInformationDAO{

	@Override
	public WorkerInformation getWorkerInformation(String userName) {
		String sql = "select * from DriverWorkInformation where userName = ?";
		return get(sql, userName);
	}
	@Override
	public void addWorkerInformation(WorkerInformation workerInformation) {
		String sql = "insert into DriverWorkInformation (userName,petID,lineID,workStatus,restTime) values (?,?,?,?,?)";
		update(sql, workerInformation.getUserName(), workerInformation.getPetID(), workerInformation.getLineID(), workerInformation.getWorkStatus(),workerInformation.getRestTime());
	}

	@Override
	public List<WorkerInformation> getALLWorkerInformations() {
		String sql = "select * from DriverWorkInformation";
		return getForList(sql);
	}

}
