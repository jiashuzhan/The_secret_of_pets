package com.TheSecretOfPet.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.TheSecretOfPet.dao.impl.CompanyMessageDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
//import com.IntelligentBusServer.dao.impl.ManagerDAOImpl;=========
import com.TheSecretOfPet.entity.CompanyMessage;
//import com.IntelligentBusServer.entity.Manager;========
//import com.IntelligentBusServer.information.ManagerInfoRequest;=====
import com.TheSecretOfPet.utils.LogUtils;

/**
 * 请求经理信息线程类，与Android客户端交互
 * 该线程接收：ManagerInfoRequest类
 * 该线程发送：Manager类
 * @author HQ
 *
 */
public class RequestManagerInfoThread implements Runnable{
	
//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;

//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;
	
	private CompanyMessageDAOImpl companyMessageDAOImpl = new CompanyMessageDAOImpl();

	private CompanyMessage companyMessage;
	
	public RequestManagerInfoThread(CompanyMessage companyMessage, Socket socket) {
		this.companyMessage = companyMessage;
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
		LogUtils.writeLine("A Driver ManagerInfo Request");
		if(companyMessage != null){
			if (companyMessage.getInformation() != null) {
				companyMessageDAOImpl.addCompanyMessage(companyMessage);
				System.out.println("Add CompanyMessage Sucess");
				LogUtils.writeLine("Add CompanyMessage Sucess");
			}else {
				LogUtils.writeLine("Request Error : CompanyMessage is empty");
			}
		}else {
			LogUtils.writeLine("Request Error : CompanyMessage = null");
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
