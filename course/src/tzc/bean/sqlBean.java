package tzc.bean;
import java.io.*;
import java.sql.*;
public class sqlBean{
public Connection conn=null;
public ResultSet rs=null;
//�������ݿ������ַ���
private String DatabaseDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
// DataSource����Դ����DSN
private String DatabaseConnStr="jdbc:sqlserver://localhost:1433;databaseName=ClassDB,'sa','123456'";
//���巽��
/* setXxx������������ֵ; getXxx���ڵõ�����ֵ*/


public void setDatabaseDriver (String Driver){
this.DatabaseDriver=Driver;
}
public String getDatabaseDriver(){
return (this. DatabaseDriver);
}
public void setDatabaseConnStr (String ConnStr){
this.DatabaseConnStr=ConnStr;
}
public String getDatabaseConnStr(){
return (this.DatabaseConnStr);
}
public sqlBean(){//���캯��
try{
Class.forName(DatabaseDriver);
}
catch (java.lang.ClassNotFoundException e){
System.err.println("�����������д���:"+e.getMessage());
System.out. print("ִ�в����д���:"+e.getMessage());//������ͻ���
}
}
//ִ�в�������ķ���

public int executeInsert(String sql)
{
	int num=0;
	try {
		conn=DriverManager.getConnection ("jdbc:sqlserver://localhost:1433;databaseName=ClassDB","sa","123456");
		Statement stmt=conn.createStatement();
		num=stmt.executeUpdate(sql);
	} catch (SQLException ex) {
		System.err.println("ִ�в����д���:"+ex.getMessage());
		System.out.println("ִ�в����д���:"+ex.getMessage());//������ͻ���
	}
	CloseDataBase();
	return num;
}

//ִ�в�ѯ�����ķ���
public ResultSet executeQuery (String sql)
{
	rs=null;
	try {
		conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ClassDB","sa","123456");
		Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
	} catch (SQLException ex) {
		System.err.println("ִ�в�ѯ�д���:"+ex.getMessage());
		System.out.println("ִ�в�ѯ�д���:"+ex.getMessage());//������ͻ���
	}
	return rs;
}

//ִ��ɾ�������ķ���

public int executeDelete(String sql){
int num=0;
try {
	conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ClassDB","sa","123456");
	Statement stmt=conn.createStatement();
	num=stmt.executeUpdate(sql);
} catch (SQLException ex) {
	System.err.println("ִ��ɾ���д���:"+ex.getMessage());
	System.out.println("ִ��ɾ���д���:"+ex.getMessage());//������ͻ���
}
CloseDataBase();
return num;
}
public void CloseDataBase (){
	try {
		conn.close();
	} catch (Exception end) {
		System.err.println("ִ�йر� Connection�����д���:"+end. getMessage());
		System.out.print("ִ�йر� Connection�����д���:"+end. getMessage());
				//������ͻ���
	}
}
}


