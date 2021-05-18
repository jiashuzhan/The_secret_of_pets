package com.TheSecretOfPet.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.UpdateUserRequest;
import com.TheSecretOfPet.utils.LogUtils;


/**
 * 用户修改线程类，与Android客户端交互
 * 该线程接收：Customer类
 * @author HQ
 *
 */
public class UpdateUserThread implements Runnable{

//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;
	
//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;

	private WorkerDAOImpl workerDAOImpl = new WorkerDAOImpl();
	
	private UpdateUserRequest updateUserRequest;
	
	public UpdateUserThread(UpdateUserRequest updateUserRequest, Socket socket) {
		this.updateUserRequest = updateUserRequest;
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
		Worker worker = updateUserRequest.getWorker();
		LogUtils.writeLine("A Customer Update Request");
		if(worker != null){
			String userName = worker.getUserName();
			if (workerDAOImpl.checkWorker(userName)) {
				workerDAOImpl.updateWorker(worker);
				LogUtils.writeLine("Update Sucess : " + worker.toString());
			}else {
				LogUtils.writeLine("Update Error : Customer is not exists " + worker.toString());
			}
		}else{
			LogUtils.writeLine("Update Error : Customer = null"); 
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
