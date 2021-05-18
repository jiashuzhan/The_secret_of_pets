package com.TheSecretOfPet.commport;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.TooManyListenersException;

import com.TheSecretOfPet.dao.impl.PetInformationDAOImpl;
import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.information.NecessaryInformation;
import com.TheSecretOfPet.information.PaySucess;
import com.TheSecretOfPet.thread.PaySuccessResponseThread;


public class PackageComm implements SerialPortEventListener,Runnable{

	private static final byte start_1 = 0x0A;
	
	private static final byte start_2 = 0x0A;
	
	private static final byte end_1 = (byte)0xAA;
	
	private static final byte end_2 = (byte)0xAB;
	
	private static final byte end_3 = (byte)0xAC;
	
	private CommPortIdentifier portIdentifier;
	
    private int delayRead = 100;
    
   // private int numBytes; 
    
    private static byte[] readBuffer = new byte[1024]; // 4k的buffer空间,缓存串口读入的数据
    
    private InputStream inputStream;
    
    private OutputStream outputStream;
    
    private SerialPort serialPort;
    
    private HashMap serialParams;
    
    private static Boolean isOpen = false;
    
    public static final String PARAMS_DELAY = "delay read"; // 延时等待端口数据准备的时间
    
    public static final String PARAMS_TIMEOUT = "timeout"; // 超时时间
    
    public static final String PARAMS_PORT = "port name"; // 端口名称
    
    public static final String PARAMS_DATABITS = "data bits"; // 数据位
    
    public static final String PARAMS_STOPBITS = "stop bits"; // 停止位
    
    public static final String PARAMS_PARITY = "parity"; // 奇偶校验
    
    public static final String PARAMS_RATE = "rate"; // 波特率

	private byte[] length = new byte[2];
	
	private byte[] busId = new byte[4];
	
	private byte busStatus;
	
	private byte busType;
	
	private byte[] busTemperate = new byte[2];
	
	private byte[] personaltemperate = new byte[2];
	
	private byte[] longitude  = new byte[4];
	
	private byte[] latitude = new byte[4];
	
	private byte[] lightStrength = new byte[2];
	
	private byte light_one;
	
	private byte light_two;
	
	private byte light_three;
	
	private byte light_four;
	
	private byte light_one_status;
	
	private byte light_two_status;
	
	private byte light_three_status;
	
	private byte light_four_status;
	
	private byte[] rssi = new byte[2];
	
	private byte[] crc = new byte[4];
	private String bus_id_inner;
	
    public PetInformationDAOImpl petInformationDAOImpl = new PetInformationDAOImpl();
    
    public PetInformation petInformation = null;
    
    public static void main(String[] args){
 
    	PackageComm packageComm = new PackageComm();
    	packageComm.start();
    	packageComm.sendToComm(new PetInformation("1429210036",1,1,1,1,1,1,1,1,1,1,1));
    }
    
    public PackageComm(){
    	if(isOpen){
    		close();
    	}
    	try {
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM1");
			serialPort = (SerialPort)portIdentifier.open("send", 5000);
			serialPort.setSerialPortParams(38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			outputStream = serialPort.getOutputStream();
			inputStream = serialPort.getInputStream();
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		
		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			System.out.println("No such PortException");
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			System.out.println("This Port is used");
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			System.out.println("This Control Is Not Support");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("This Port Open Wrong");
		} catch (TooManyListenersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public PackageComm(HashMap hashMap){
    	if(isOpen){
    		close();
    	}
    	serialParams = hashMap;
    	int timeout = Integer.parseInt(serialParams.get(PARAMS_TIMEOUT).toString());
    	int rate = Integer.parseInt(serialParams.get(PARAMS_RATE).toString());
    	int dataBits = Integer.parseInt(serialParams.get(PARAMS_DATABITS).toString());
    	int stopBits = Integer.parseInt(serialParams.get(PARAMS_STOPBITS).toString());
    	int parity = Integer.parseInt(serialParams.get(PARAMS_PARITY).toString());
    	String port = serialParams.get(PARAMS_PORT).toString();

    	try {
			portIdentifier = CommPortIdentifier.getPortIdentifier(port);
			serialPort = (SerialPort)portIdentifier.open("portComm1", timeout);
			inputStream = serialPort.getInputStream();
			outputStream = serialPort.getOutputStream();
			serialPort.setSerialPortParams(rate, dataBits, stopBits, parity);
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			isOpen = true;
    	} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TooManyListenersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void close(){
    	if(isOpen){
    		serialPort.notifyOnDataAvailable(false);
    		serialPort.removeEventListener();
    		try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("CommPort Close Error");
			}
    		isOpen = false;
    	}
    }
    
    public void start(){
		Thread readThread = new Thread(this);
		readThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Wating For Read");
	}

	public void sendToComm(PetInformation petInformation){
		byte[] sendInfo = new byte[21];
		sendInfo[0] = start_1;
		sendInfo[1] = start_2;
		sendInfo[2] = 0x00;
		sendInfo[3] = 0x00;
		if(petInformation.getPetID().equals("1429210036")){
			sendInfo[4]=0x01;
			sendInfo[5]=0x00;
			sendInfo[6]=0x00;
			sendInfo[7]=0x00;
		}else{
			sendInfo[4]=0x01;
			sendInfo[5]=0x00;
			sendInfo[6]=0x00;
			sendInfo[7]=0x00;
		}
		if (petInformation.getLightStatusOne() == 1) {
			sendInfo[8] = 0x01;
			sendInfo[9] = 0x01;
		}else{
			sendInfo[8] = 0x01;
			sendInfo[9] = 0x00;
		}
		if (petInformation.getLightStatusTwo() == 1) {
			sendInfo[10] = 0x02;
			sendInfo[11] = 0x01;
		}else{
			sendInfo[10] = 0x02;
			sendInfo[11] = 0x00;
		}
		if (petInformation.getLightStatusThree() == 1) {
			sendInfo[12] = 0x03;
			sendInfo[13] = 0x01;
		}else{
			sendInfo[12] = 0x03;
			sendInfo[13] = 0x00;
		}
		if (petInformation.getLightStatusFour() == 1) {
			sendInfo[14] = 0x04;
			sendInfo[15] = 0x01;
		}else{
			sendInfo[14] = 0x04;
			sendInfo[15] = 0x00;
		}
		sendInfo[16] = 0x00;
		sendInfo[17] = 0x00;
		sendInfo[18] = end_1;
		sendInfo[19] = end_2;
		sendInfo[20] = end_3;
		run(sendInfo);
	}
	
	public void run(byte[] data){
		try{
			byte[] sendData = new byte[1];
			for(int i = 0 ; i < data.length ; i++){
				sendData[0] = data[i];
				outputStream.write(sendData);
				System.out.print(byteToHex(sendData[0])+" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	 /**
     * 错误类型
	 * BI Break interrupt 通讯中断
	 * FE Framing error 帧错误
	 * CD Carrier detect 载波侦听
	 * OE Overrun error 溢位错误
	 * CTS Clear to send 清除发送
	 * PE Parity error 奇偶检验错误 
	 * DSR Data set ready 数据设备准备好
	 * RI Ring indicator 响铃侦测
	 * DATA_AVAILABLE 串口中的可用数据
	 * OUTPUT_BUFFER_EMPTY 输出缓冲区已清空
 */
	@Override
	public void serialEvent(SerialPortEvent event) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(delayRead);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		switch (event.getEventType()){
			case SerialPortEvent.BI:
				System.out.println("通讯中断");
				break;
			case SerialPortEvent.OE:
				System.out.println("溢位错误");
				break;
	        case SerialPortEvent.FE:
	        	System.out.println("帧错误");
				break;
	        case SerialPortEvent.PE: 
	        	System.out.println("奇偶检验错误");
				break;
	        case SerialPortEvent.CD: 
	        	System.out.println("载波侦听");
				break;
	        case SerialPortEvent.CTS:
	        	System.out.println("清除发送");
				break;
	        case SerialPortEvent.DSR: 
	        	System.out.println("数据设备准备好");
				break;
	        case SerialPortEvent.RI:
	        	System.out.println("响铃侦测 ");
				break;
	        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
	        	break;
	        case SerialPortEvent.DATA_AVAILABLE:
	        	/*In Can Be Delete*/
	        	try{
	        		/*从串口接收*/
	        		while(inputStream.available()>0){
	        			byte[] str = new byte[41];
	        			inputStream.read(str);
	        			if (str[0] == 0x0A) {
		        			bytesToDatas(str);
						}else {
							new PaySuccessResponseThread(NecessaryInformation.socket).run();
						}
	        			System.out.print(petInformation.toString() + "COMM");
	        			if (petInformation != null) {
	        				petInformationDAOImpl.updatePetInformation(petInformation);
	        				System.out.println(petInformation.toString());/////////////////修改了本来有注释
	        			}
	        		}
	        	}catch(IOException e){
	        		e.printStackTrace();
	        	}
	        	break;
		}
	}
	
	private PetInformation bytesToDatas(byte[] data){
		petInformation = null;
		if(data[0]==start_1 && data[1] == start_2 && data[38] ==end_1&& data[39] ==end_2&& data[40] ==end_3){
			
			length[0] = data[2];
			length[1] = data[3];
			int length_i = bytesToShort(length);
			if(length_i == 32){
				petInformation = new PetInformation();
				busId[0] = data[4];
				busId[1] = data[5];
				busId[2] = data[6];
				busId[3] = data[7];
				if(bytesToInt(busId)==1){
					bus_id_inner = "123456789";
				}
				busStatus = data[8];
				busType = data[9];
				busTemperate[0] = data[10];
				busTemperate[1] = data[11];
				personaltemperate[0] = data[12];
				personaltemperate[1] = data[13];
				longitude[0] = data[14];
				longitude[1] = data[15];
				longitude[2] = data[16];
				longitude[3] = data[17];
				latitude[0] = data[18];
				latitude[1] = data[19];
				latitude[2] = data[20];
				latitude[3] = data[21];
				lightStrength[0] = data[22];
				lightStrength[1] = data[23];
				light_one = data[24];
				light_one_status = data[25];
				light_two = data[26];
				light_two_status = data[27];
				light_three = data[28];
				light_three_status = data[29];
				light_four = data[30];
				light_four_status = data[31];
				rssi[0] = data[32];
				rssi[1] = data[33];
				crc[0] = data[34];
				crc[1] = data[35];
				crc[2] = data[36];
				crc[3] = data[37];
				petInformation.setPetID(bus_id_inner);
				petInformation.setPetLatitude((float)(bytesToInt(latitude)/100000*1.0));
				petInformation.setPetLongitude((float)(bytesToInt(longitude)/100000*1.0));
				petInformation.setPetStatus(oneByteToInt(busStatus));
				petInformation.setroomTemperature(bytesToShort(busTemperate));
				petInformation.setpetType(oneByteToInt(busType));
				petInformation.setLightStatusFour(oneByteToInt(light_four_status));
				petInformation.setLightStatusOne(oneByteToInt(light_one_status));
				petInformation.setLightStatusThree(oneByteToInt(light_three_status));
				petInformation.setLightStatusTwo(oneByteToInt(light_two_status));
				petInformation.setLightStrength(bytesToShort(lightStrength));
				petInformation.setPetTemperature(bytesToShort(personaltemperate));
			}else{
				System.out.println("Can't receive for wrong length!");
				for(int i = 0 ; i < 41 ;i++){
					System.out.println(byteToHex(data[2]));
				}
			}
		}else{
			System.out.println("Wrong Start Or Wrong End!");
		}
		return petInformation;
	}
	
	public String byteToHex(byte b) {
        int i = b & 0xFF;
        return Integer.toHexString(i);
	}
	
	public int oneByteToInt(byte b){
		byte[] one_int =new byte[4];
		one_int[0] = b;
		one_int[1] = 0x00;
		one_int[2] = 0x00;
		one_int[3] = 0x00;
		return bytesToInt(one_int);
	}

	public  int crc16(byte[] data) {
		try {
			int crc;
			int r;
			byte sbit;
			int tc;
			crc = 0x0000FFFF;
			for (int i = 0; i < data.length; i++) {
				tc = (int) (crc >>> 8);
				crc = (int) (tc ^ data[i]);
				for (r = 0; r < 8; r++) {
					sbit = (byte) (crc & 0x00000001);
					crc >>>= 1;
					if (sbit != 0)
						crc ^= 0x0000A001;
				}
			}
			
			return crc;
		} catch (Exception ex) {
			return 0;
		}
}

	public  byte[] shortToByte(short value) {
	     byte[] bytes = new byte[2];
	     bytes[1] = (byte) (value >> 8);
	     bytes[0] = (byte) (value >> 0);
	     return bytes;
	}

	public short bytesToShort(byte[] bytes) {
	    return (short) (((bytes[1] << 8) | bytes[0] & 0xff));
	}

	public static int bytesToInt(byte[] bytes) {
	    return (int) ((((bytes[3] & 0xff) << 24)
	            | ((bytes[2] & 0xff) << 16)
	            | ((bytes[1] & 0xff) << 8) | ((bytes[0] & 0xff) << 0)));
	}

	public  byte[] intToBytes(int value) {
	        byte[] bytes = new byte[4];
	        bytes[3] = (byte) (value >> 24);
	        bytes[2] = (byte) (value >> 16);
	        bytes[1] = (byte) (value >> 8);
	        bytes[0] = (byte) (value >> 0);
	        return bytes;
	}
	
}
