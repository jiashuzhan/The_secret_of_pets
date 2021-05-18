package com.TheSecretOfPet.information;

import java.net.Socket;

import com.TheSecretOfPet.commport.PackageComm;


public class NecessaryInformation {

	public static final int USER_LOGIN_TYPE_CUSTOMER = 0;
	public static final int USER_LOGIN_TYPE_DRIVER = 1;
	public static final int USER_LOGIN_TYPE_MANAGER = 2;
	
	public static final int SQL_IS_UPDATE = 3;
	public static final int SQL_IS_NOT_UPDATE = 4;
	public static PackageComm packageComm = new PackageComm();
	
	public static Socket socket = null;
}
