package tzc.bean;
import java.sql.*;

import tzc.bean.sqlBean;
public class teacher {
	String id;
	String name;
	String password;
	String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ResultSet getCourse(){
		String sql="select course.name "+
			"from classes,course "+
			"where classes.tea_id='"+id+"' "+
			"and course.id=classes.cour_id";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public boolean hasLogin(String id){
		boolean f=true;
		String sql="select id from teacher where id ='"+id+"'";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){f=false;}
			else f=true;
		}catch(Exception e){e.getMessage();}
		return f;
	}
	public void addTeacher(){
		String sql="insert into teacher(id,name,title,password)"+
			"values('"+id+"','"+name+"','"+title+
					"','"+password+"')";
			sqlBean db=new sqlBean();
			db.executeInsert(sql);
		}
	public ResultSet getAll(){
		String sql="select * from teacher ";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public void update(){
		String sql="update teacher set name='"+name+"',"+"title='"+title+"',password='"+password+"' "+" where id='"+id+"' ";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public int delete(String id){
		int num=0;
		String sql="delete from teacher where id ='"+id+"' ";
		sqlBean db =new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
}
