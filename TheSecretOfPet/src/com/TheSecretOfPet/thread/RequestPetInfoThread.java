package com.TheSecretOfPet.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.TheSecretOfPet.dao.impl.PetDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.PetInfoRequest;
import com.TheSecretOfPet.utils.LogUtils;


/**
 * 请求宠物信息线程类，与Android客户端交互
 * 该线程接收：Driver类
 * 该线程发送：Bus类
 * @author HQ
 *
 */
public class RequestPetInfoThread implements Runnable{

//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;

//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;
	
	private WorkerDAOImpl workerDAOImpl = new WorkerDAOImpl();
	
	private PetDAOImpl petDAOImpl = new PetDAOImpl();
	
	private PetInfoRequest petInfoRequest;
	
	public RequestPetInfoThread(PetInfoRequest petInfoRequest, Socket socket) {
		this.petInfoRequest = petInfoRequest;
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
		Worker driver = petInfoRequest.getWorker();
		LogUtils.writeLine("A Driver Bus Information Request");
		if(driver != null){
			String userName = driver.getUserName();
			String password = driver.getPassword();
			String petID = driver.getPetID();
			if (workerDAOImpl.checkWorker(userName, password)) {
				Pet pet = petDAOImpl.getPet(petID);
				LogUtils.writeLine("Request Sucess : " + driver.toString());
				this.sendObject(pet);
				LogUtils.writeLine("Send Bus Information Sucess");
			}else{
				LogUtils.writeLine("Request Error : Driver is not exists");
			}
		}else {
			LogUtils.writeLine("Request Error : Driver = null");
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
