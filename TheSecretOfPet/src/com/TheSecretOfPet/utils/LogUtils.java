package com.TheSecretOfPet.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Log工具类
 * @author Administrator
 *
 */
public class LogUtils {

	private static String filePath;
	
	private static File log;
	
	static{
		filePath = "D:\\MyEclipse 2015\\workspace\\IntelligentBusServer\\log\\Log.txt";
		log = new File(filePath);
	}
	
	/**
	 * 创建日志文件
	 */
	public static void creatLog(){
		if (!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 向日志文件写入一行
	 * @param s
	 */
	public static void writeLine(String s){
		Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String time = simpleDateFormat.format(date);
		try {
			FileWriter fileWriter = new FileWriter(log, true);
			fileWriter.write(time + " :  [ " + s + " ]" + "\n");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向日志文件写入
	 * @param s
	 */
	public static void write(String s){
		try {
			FileWriter fileWriter = new FileWriter(log, true);
			fileWriter.write(s);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
