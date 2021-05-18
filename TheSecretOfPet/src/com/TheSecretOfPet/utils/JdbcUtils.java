package com.TheSecretOfPet.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc������
 * @author Administrator
 *
 */
public class JdbcUtils {

	private static ComboPooledDataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("IntelligentBus");
	}
	
	/**
	 * �������
	 * @return 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * �ر�����
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
		try{
			if(connection != null){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
