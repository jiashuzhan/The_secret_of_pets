package com.TheSecretOfPet.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc工具类
 * @author Administrator
 *
 */
public class JdbcUtils {

	private static ComboPooledDataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("IntelligentBus");
	}
	
	/**
	 * 获得连接
	 * @return 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 关闭连接
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
