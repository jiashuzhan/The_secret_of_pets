package com.TheSecretOfPet.dao.impl;

import java.util.List;

import com.TheSecretOfPet.dao.DAO;
import com.TheSecretOfPet.dao.WorkerDAO;
import com.TheSecretOfPet.entity.Worker;


/**
 * Worker实体类数据访问接口的实现类
 * @author HQ
 *
 */
public class WorkerDAOImpl extends DAO<Worker> implements WorkerDAO{

	@Override
	public List<Worker> getAllWorker() {
		String sql = "select * from Driver";
		return getForList(sql);
	}

	@Override
	public Worker getWorker(String userName) {
		String sql = "select * from Driver where userName = ?";
		return get(sql, userName);
	}

	@Override
	public void addWorker(Worker worker) {
		String sql = "insert into Driver (userName,password,workerName,workersex,workerYears,healthExam,petID,telephone) values (?,?,?,?,?,?,?,?)";
		update(sql, worker.getUserName(), worker.getPassword(), worker.getWorkerName(), worker.getworkersex(), worker.getWorkerYears(), worker.getHealthExam(), worker.getPetID(), worker.getTelephone());
	}

	@Override
	public void deleteWorker(String userName) {
		String sql = "delete from Driver where userName = ?";
		update(sql, userName);
	}

	@Override
	public void updateWorker(Worker worker) {
		String sql = "update Driver set password = ? , workerName = ? , workersex = ? , workerYears = ? , healthExam = ? , petID = ? , telephone = ? where userName = ?";
		update(sql, worker.getPassword(), worker.getWorkerName(), worker.getworkersex(), worker.getWorkerYears(), worker.getHealthExam(), worker.getPetID(), worker.getTelephone(), worker.getUserName());
	}

	@Override
	public boolean checkWorker(String userName, String password) {
		String sql = "select * from Driver where userName = ? and password = ?";
		List<Worker> list = getForList(sql, userName, password);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkWorker(String userName) {
		String sql = "select * from Driver where userName = ?";
		List<Worker> list = getForList(sql, userName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
