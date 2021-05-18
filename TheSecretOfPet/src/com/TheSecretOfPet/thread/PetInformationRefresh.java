package com.TheSecretOfPet.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.ErrorTypeInformation;
import com.TheSecretOfPet.information.LoginStatus;
import com.TheSecretOfPet.information.PetInnerinformationRefreshRequest;
import com.TheSecretOfPet.utils.LogUtils;


public class PetInformationRefresh implements Runnable{
	
//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;
	
//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;
	
//	private CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	
	private WorkerDAOImpl workerDAOImpl = new WorkerDAOImpl();
	
	private PetInformationDAOImpl petInformationDAOImpl = new PetInformationDAOImpl();
	
//	private ManagerDAOImpl managerDAOImpl = new ManagerDAOImpl();
	
//	private UpdateInformationDAOImpl updateInformationDAOImpl = new UpdateInformationDAOImpl();
	
//	private boolean isUpdate;
	
	private PetInnerinformationRefreshRequest petInnerinformationRefreshRequest;
	
	public PetInformationRefresh(PetInnerinformationRefreshRequest petInnerinformationRefreshRequest, Socket socket){
		this.petInnerinformationRefreshRequest = petInnerinformationRefreshRequest;
		this.socket = socket;
	}
	
//	public void start(){
//		this.getServerSocket();
//		while(true){
//			this.run();
//		}
//	}
	
	@Override
	public void run() {
		Worker worker = petInnerinformationRefreshRequest.getWorker();
		System.out.println(worker.toString());
		LogUtils.writeLine("An Bus Innerinformation Refresh Request");
		if (worker != null) {
			String userName = worker.getUserName();
			String password = worker.getPassword();
				if (workerDAOImpl.checkWorker(userName)) {
					if (workerDAOImpl.checkWorker(userName, password)) {
						PetInformation busInnerInformation = petInformationDAOImpl.selectPetInformationByPetId(worker.getPetID());
						this.sendObject(busInnerInformation);
						LogUtils.writeLine("Send BusInnerInformation Sucess");
						System.out.println(busInnerInformation);
						System.out.println("send busInnerInformation success");
					}else {
						LogUtils.writeLine("Send BusInnerInformation Error : Driver password error");
					}
				}else {
					LogUtils.writeLine("Send BusInnerInformation Error : Driver is not exist");
				}
		}else {
			LogUtils.writeLine("Receive Error : Request = null");
		}
	}

//	public void getServerSocket(){
//		try {
//			serverSocket = new ServerSocket(PORT_NUMBER);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public Object receiveObject(){
//		Object object = null;
//		try {
//			 objectInputStream = new ObjectInputStream(
//			          new BufferedInputStream(socket.getInputStream()));
//			object = objectInputStream.readObject();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}  
//		return object;
//	}
	
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
	
//	public void releaseServerSocket(){
//		try {
//			serverSocket.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void releaseSocket(){
//		try {
//			objectInputStream.close();
//			objectOutputStream.close();
//			socket.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
