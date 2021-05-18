package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.Worker;

/**
 * 用户实体类数据访问接口
 * @author Administrator
 *
 */
public interface WorkerDAO {

	/*获得所有用户*/
	public List<Worker> getAllWorker();
	
	/*根据用户名获得对应用户*/
	public Worker getWorker(String userName);
	
	/*添加用户*/
	public void addWorker(Worker Worker);
	
	/*删除用户*/
	public void deleteWorker(String userName);
	
	/*更新用户*/
	public void updateWorker(Worker Worker);
	
	/*根据用户名密码检查用户是否存在*/
	public boolean checkWorker(String userName, String password);

	/*根据用户名检查司用户是否存在*/
	public boolean checkWorker(String userName);
}

