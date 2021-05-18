package com.TheSecretOfPet.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.information.PaySucess;


public class PaySuccessResponseThread implements Runnable{

	private Socket socket;
	
	private ObjectOutputStream objectOutputStream;
	
	public PaySuccessResponseThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		this.sendObject(new PaySucess("success", true));
		System.out.println("pay success");
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
