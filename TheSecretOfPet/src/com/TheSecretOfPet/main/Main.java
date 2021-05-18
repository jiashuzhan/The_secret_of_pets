package com.TheSecretOfPet.main;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.socket.AppListener;


public class Main {

	public static void main(String[] args) {
		new NecessaryInformation().packageComm.start();
		new AppListener().start();
	}
	
}
//C:\Users\Administrator\AppData\Local\Android\Sdk
