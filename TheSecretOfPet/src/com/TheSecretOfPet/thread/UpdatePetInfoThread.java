package com.TheSecretOfPet.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.utils.LogUtils;


public class UpdatePetInfoThread implements Runnable{

	private static final int PORT_NUMBER = 7777;

//	private ServerSocket serverSocket;
	
	private Socket socket;
	
//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;
	
	private PetInformationDAOImpl petInformationDAOImpl = new PetInformationDAOImpl();
	
	private PetInformation petInformation;
	
	public UpdatePetInfoThread(PetInformation petInformation, Socket socket) {
		this.petInformation = petInformation;
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
		System.out.println(petInformation);
		LogUtils.writeLine("A BusInnerInformation Update Request");
		if(petInformation != null){
			String petID = petInformation.getPetID();
			if (petInformationDAOImpl.checkPetID(petID)) {
				petInformationDAOImpl.updatePetInformation(petInformation);
				new NecessaryInformation().packageComm.sendToComm(petInformation);
				LogUtils.writeLine("Update Sucess : " + petInformation.toString());
			}else {
				LogUtils.writeLine("Update Error : BusInnerInformation is not exists " + petInformation.toString());
			}
		}else{
			LogUtils.writeLine("Update Error : BusInnerInformation = null"); 
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
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
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
	
	public String messageToHex(PetInformation petInformation){
		String start_code = "";
		return null;
	}
	
	
}
