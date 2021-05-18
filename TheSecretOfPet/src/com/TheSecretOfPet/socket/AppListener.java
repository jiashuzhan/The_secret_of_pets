package com.TheSecretOfPet.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.LoginUser;
import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.information.PaySucess;
import com.TheSecretOfPet.information.PetInfoRequest;
import com.TheSecretOfPet.information.PetInnerinformationRefreshRequest;
import com.TheSecretOfPet.information.RegisterRequest;
import com.TheSecretOfPet.information.UpdateUserRequest;
import com.TheSecretOfPet.thread.LoginThread;
import com.TheSecretOfPet.thread.PaySuccessResponseThread;
import com.TheSecretOfPet.thread.PetInformationRefresh;
import com.TheSecretOfPet.thread.RegisterThread;
import com.TheSecretOfPet.thread.RequestPetInfoThread;
import com.TheSecretOfPet.thread.UpdatePetInfoThread;
import com.TheSecretOfPet.thread.UpdateUserThread;

import com.TheSecretOfPet.entity.CompanyMessage;
import com.TheSecretOfPet.information.AddpetRequest;
import com.TheSecretOfPet.thread.RequestManagerInfoThread;
import com.TheSecretOfPet.thread.AddpetThread;

public class AppListener implements Runnable{

	private static final int PORT = 7777;
	
	private ServerSocket serverSocket;
	
	private Socket socket;

	private ObjectInputStream objectInputStream;

	private ObjectOutputStream objectOutputStream;
	
	public void start(){
		this.getServerSocket();
		while(true){
			this.run();
		}
	}
	
	@Override
	public void run() {
		try {
			socket = serverSocket.accept();
			NecessaryInformation.socket = socket;
			Object object = receiveObject();
			System.out.println(object);
			handlerRequest(object, socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handlerRequest(Object object, Socket socket){
		if (object instanceof PetInnerinformationRefreshRequest) {
			new PetInformationRefresh((PetInnerinformationRefreshRequest) object, socket).run();
		}else if (object instanceof LoginUser) {
			new LoginThread((LoginUser) object, socket).run();
		}else if (object instanceof RegisterRequest) {
			new RegisterThread((RegisterRequest) object, socket).run();
		}else if (object instanceof PetInfoRequest) {
			new RequestPetInfoThread((PetInfoRequest) object, socket).run();
		}else if(object instanceof CompanyMessage){
			new RequestManagerInfoThread((CompanyMessage) object, socket).run();
		}else if (object instanceof AddpetRequest) {
			new AddpetThread((AddpetRequest) object, socket).run();
		}else if (object instanceof PetInformation) {
			new UpdatePetInfoThread((PetInformation) object, socket).run();
		}else if (object instanceof UpdateUserRequest) {
			new UpdateUserThread((UpdateUserRequest) object, socket).run();
		}else if (object instanceof PaySucess) {
			System.out.println("paying");
		}
	}

	public void getServerSocket(){
	try {
		serverSocket = new ServerSocket(PORT);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	public Object receiveObject(){
		Object object = null;
		try {
			 objectInputStream = new ObjectInputStream(
			          new BufferedInputStream(socket.getInputStream()));
			object = objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return object;
	}

	public void sendObject(Object obj){
		 try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void releaseServerSocket(){
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void releaseSocket(){
		try {
			objectInputStream.close();
			objectOutputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
