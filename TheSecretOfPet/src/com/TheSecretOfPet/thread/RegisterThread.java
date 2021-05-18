package com.TheSecretOfPet.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerInformationDAOImpl;
import com.TheSecretOfPet.entity.User;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.entity.WorkerInformation;
import com.TheSecretOfPet.information.ErrorTypeInformation;
import com.TheSecretOfPet.information.RegisterRequest;
import com.TheSecretOfPet.information.RegisterStatus;
import com.TheSecretOfPet.utils.LogUtils;


/**
 * 用户注册线程类，与Android客户端交互
 * 该线程接收：Customer类
 * 该线程发送：AllRoadLineStation类
 * @author HQ
 *
 */
public class RegisterThread implements Runnable{

//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;
	
	
	private ObjectOutputStream objectOutputStream;
	
	private WorkerDAOImpl workerDAOImpl = new WorkerDAOImpl();
	private WorkerInformationDAOImpl workerInformationDAOImpl=new WorkerInformationDAOImpl();

	private RegisterRequest registerRequest;
	
	public RegisterThread(RegisterRequest registerRequest, Socket socket) {
		this.registerRequest = registerRequest;
		this.socket = socket;
	}
	

	
	@Override
	public void run() {
		Worker worker = registerRequest.getWorker();
		System.out.println(worker);
		LogUtils.writeLine("A Worker Register Request");
		if (worker != null) {
			String userName = worker.getUserName();
			if (workerDAOImpl.checkWorker(userName)) {
				this.sendObject(new RegisterStatus(ErrorTypeInformation.REGISTER_EXISTED));
				LogUtils.writeLine("Register Error : Customer's username is exists "+worker.toString());
			}else {
				
				String petID=worker.getPetID();
				WorkerInformation workerInformation=new WorkerInformation(userName,petID,202,"工作中",5);
				workerInformationDAOImpl.addWorkerInformation(workerInformation);
				workerDAOImpl.addWorker(worker);
				RegisterStatus registerStatus = new RegisterStatus(ErrorTypeInformation.REGISTER_SUCCESS);
				this.sendObject(registerStatus);
				System.out.println(registerStatus);
				LogUtils.writeLine("Register Sucess : "+worker.toString());
				/*this.sendObject(new AllRoadLineStation());
				LogUtils.writeLine("Send All RoadLines And Stations Information Sucess");*/
			}
		}else {
			this.sendObject(new RegisterStatus(ErrorTypeInformation.REGISTER_OTHER_ERROR));
			LogUtils.writeLine("Register Error : Customer = null");
		}
		
	}
	

	
	public void sendObject(Object obj){
		 try {
			objectOutputStream = new ObjectOutputStream(socket
				     .getOutputStream());
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
