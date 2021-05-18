package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.information.AddpetRequest;
import com.TheSecretOfPet.information.RegisterStatus;
import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientAddpet {
    private int port = 7777;
    private String host = "10.64.130.157";
    private Socket socket = null;
    public ClientAddpet(){
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ClientAddpet(String host, int port){
        this.host = host;
        this.port = port;
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(Pet pet){

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(pet);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(AddpetRequest addpetRequest){

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(addpetRequest);
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
            return registerStatus.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ErrorTypeInformation.REGISTER_OTHER_ERROR;
    }

}
