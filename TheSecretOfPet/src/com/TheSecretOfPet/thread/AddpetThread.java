package com.TheSecretOfPet.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.TheSecretOfPet.dao.impl.PetDAOImpl;
import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.information.ErrorTypeInformation;
import com.TheSecretOfPet.information.AddpetRequest;
import com.TheSecretOfPet.information.RegisterStatus;
import com.TheSecretOfPet.utils.LogUtils;


/**
 * 用户注册线程类，与Android客户端交互
 * 该线程接收：Customer类
 * 该线程发送：AllRoadLineStation类
 * @author HQ
 *
 */
public class AddpetThread implements Runnable{

//	private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;
	
	private ObjectOutputStream objectOutputStream;
	
	private PetInformationDAOImpl petInformationDAOImpl=new PetInformationDAOImpl();
	private PetDAOImpl petDAOImpl = new PetDAOImpl();
	
	private AddpetRequest addpetRequest;
	
	public AddpetThread(AddpetRequest addpetRequest, Socket socket) {
		this.addpetRequest = addpetRequest;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Pet pet = addpetRequest.getPet();
		System.out.println(pet);
		String petID=pet.getPetID();//
		//int petage=pet.getPetage();
		PetInformation petInformation =new PetInformation(petID,1,1,27,31,0,0,0,1,1,1,1);
		petInformationDAOImpl.addPetInformation(petInformation);LogUtils.writeLine("A PetInformation Add Request");
		LogUtils.writeLine("A Pet Add Request");
				petDAOImpl.addPet(pet);
				RegisterStatus registerStatus = new RegisterStatus(ErrorTypeInformation.REGISTER_SUCCESS);
				this.sendObject(registerStatus);
				System.out.println(registerStatus);
				LogUtils.writeLine("addpet Sucess : "+pet.toString());

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
