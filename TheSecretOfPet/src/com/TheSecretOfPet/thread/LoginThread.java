package com.TheSecretOfPet.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.dao.impl.UpdateInformationDAOImpl;
import com.TheSecretOfPet.dao.impl.WorkerDAOImpl;
import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.entity.UpdateInformation;
import com.TheSecretOfPet.entity.User;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.ErrorTypeInformation;
import com.TheSecretOfPet.information.LoginStatus;
import com.TheSecretOfPet.information.LoginUser;
import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.utils.LogUtils;
import com.TheSecretOfPet.information.NewCompanyMessage;


/**
 * 用户登录线程类，与Android客户端交互
 * 该线程接收：LoginUser类
 * 该线程发送：LoginStatus类  + Customer类||Driver类||Manager类
 * @author HQ
 *
 */
public class LoginThread implements Runnable{

private static final int PORT_NUMBER = 7777;
	
//	private ServerSocket serverSocket;
	
	private Socket socket;
	
//	private ObjectInputStream objectInputStream;
	
	private ObjectOutputStream objectOutputStream;

	private WorkerDAOImpl workerDAOImpl = new WorkerDAOImpl();
	
	private UpdateInformationDAOImpl updateInformationDAOImpl = new UpdateInformationDAOImpl();
	
	private PetInformationDAOImpl petInformationDAOImpl = new PetInformationDAOImpl();
	
	private boolean isUpdate;
	
	private LoginUser loginUser;
	
	public LoginThread(LoginUser loginUser, Socket socket) {
		this.loginUser = loginUser;
		this.socket = socket;
	}	
	
	@Override
	public void run() {
		System.out.println(loginUser.toString());
		LogUtils.writeLine("An User Login Request");
		if (loginUser != null) {
			int loginType = loginUser.getLoginType();
			System.out.println(loginType);
			Date loginUserDate = new Date(loginUser.getUtilDate().getTime());
			String userName = loginUser.getUserName();
			String password = loginUser.getPassword();
			switch(loginType){
			
				
				case NecessaryInformation.USER_LOGIN_TYPE_DRIVER:
					if (workerDAOImpl.checkWorker(userName)) {
						if (workerDAOImpl.checkWorker(userName, password)) {
							this.sendObject(new LoginStatus(ErrorTypeInformation.SUCCESS_NONE_ERROR, NecessaryInformation.SQL_IS_NOT_UPDATE));
							Worker user = workerDAOImpl.getWorker(userName);
							this.sendObject(user);
							System.out.println(user.toString());
							LogUtils.writeLine("Login Sucess : "+user.toString());
							NewCompanyMessage newCompanyMessage = new NewCompanyMessage(user.getUserName());
							List<PetInformation> petInformations = new ArrayList<PetInformation>();
							petInformations.add(petInformationDAOImpl.selectPetInformationByPetId(user.getPetID()));
							newCompanyMessage.setPetInformations(petInformations);
							this.sendObject(newCompanyMessage);
							LogUtils.writeLine("Send NewCompanyMessage Sucess");
							System.out.println("send success");
						}else {
							this.sendObject(new LoginStatus(ErrorTypeInformation.PASSWORD_ERROR, NecessaryInformation.SQL_IS_NOT_UPDATE));
							LogUtils.writeLine("Login Error : Driver password error");
						}
					}else {
						this.sendObject(new LoginStatus(ErrorTypeInformation.NONE_USERNAME_ERROR, NecessaryInformation.SQL_IS_NOT_UPDATE));
						LogUtils.writeLine("Login Error : Driver is not exist");
					}
					break;
					
			}
		}else {
			LogUtils.writeLine("Login Error : LoginUser = null");
		}
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
