package com.TheSecretOfPet.dao;

import java.util.List;

import com.TheSecretOfPet.entity.Worker;

/**
 * �û�ʵ�������ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface WorkerDAO {

	/*��������û�*/
	public List<Worker> getAllWorker();
	
	/*�����û�����ö�Ӧ�û�*/
	public Worker getWorker(String userName);
	
	/*����û�*/
	public void addWorker(Worker Worker);
	
	/*ɾ���û�*/
	public void deleteWorker(String userName);
	
	/*�����û�*/
	public void updateWorker(Worker Worker);
	
	/*�����û����������û��Ƿ����*/
	public boolean checkWorker(String userName, String password);

	/*�����û������˾�û��Ƿ����*/
	public boolean checkWorker(String userName);
}

