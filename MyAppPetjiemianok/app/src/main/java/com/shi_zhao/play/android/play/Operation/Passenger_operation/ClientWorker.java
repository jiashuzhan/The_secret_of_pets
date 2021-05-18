package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.PetInnerinformationRefreshRequest;
import com.TheSecretOfPet.information.LoginStatus;
import com.TheSecretOfPet.information.LoginUser;
import com.TheSecretOfPet.information.NewCompanyMessage;
import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientWorker {
    private int port = 7777;
    private String host = "10.64.130.157";
    private Socket socket = null;
    public ClientWorker(){
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientWorker(int port, String host){
        this.port = port;
        this.host = host;
    }
    public void send(LoginUser loginUser){

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(loginUser);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void  send(PetInformation innerInformation){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(innerInformation);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void  send(PetInnerinformationRefreshRequest petInnerinformationRefreshRequest){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(petInnerinformationRefreshRequest);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int receive(){
        Worker worker;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            Object object = inputStream.readObject();
            LoginStatus loginStatus = (LoginStatus)object;
            if(loginStatus.getStatus() == ErrorTypeInformation.SUCCESS_NONE_ERROR){
                inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                Object object1 = inputStream.readObject();
                if(object1 instanceof Worker){
                    worker = (Worker) object1;
                    NecessaryInformation.worker = worker;
                }
                inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                Object object2 = inputStream.readObject();
                if(object2 instanceof  NewCompanyMessage){
                    NewCompanyMessage newCompanyMessage= (NewCompanyMessage) object2;
                    NecessaryInformation.newCompanyMessage = newCompanyMessage;
                }
            }
            inputStream.close();
            socket.close();
            return loginStatus.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ErrorTypeInformation.OTHER_ERROR;
    }

    public int receiveBusInnerInformation(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            Object object = inputStream.readObject();
            PetInformation petInformation = (PetInformation)object;
            NecessaryInformation.newCompanyMessage.getPetInformations().clear();
            NecessaryInformation.newCompanyMessage.getPetInformations().add(petInformation);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}

