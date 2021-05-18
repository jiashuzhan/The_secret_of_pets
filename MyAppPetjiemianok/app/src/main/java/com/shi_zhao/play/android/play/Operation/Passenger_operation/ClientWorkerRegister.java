package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.RegisterRequest;
import com.TheSecretOfPet.information.RegisterStatus;
import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientWorkerRegister {
    private int port = 7777;
    private String host = "10.64.130.157";
    private Socket socket = null;
    public ClientWorkerRegister(){
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ClientWorkerRegister(String host, int port){
        this.host = host;
        this.port = port;
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(Worker worker){

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(worker);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(RegisterRequest registerRequest){

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(registerRequest);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int receive(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object object = inputStream.readObject();
            RegisterStatus registerStatus = (RegisterStatus)object;
            /*if(registerStatus.getStatus() == ErrorTypeInformation.REGISTER_SUCCESS){
                inputStream = new ObjectInputStream(socket.getInputStream());
                Object secondObject = inputStream.readObject();
                NecessaryInformation.allRoadLineStation = (AllRoadLineStation)secondObject;
            }*/
            return registerStatus.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ErrorTypeInformation.REGISTER_OTHER_ERROR;
    }

}
