package tzc.bean;
import java.sql.*;

import tzc.bean.sqlBean;
public class course {
	private String id;
	private String name;
	private String dep;
	private String prepare;
	private int mark;
	  public void setPrepare(String s) { this.prepare = s; } 
	  public String getPrepare() { return this.prepare; } 
	  public void setMark(int s) { this.mark = s; } 
	  public int getMark() { return this.mark; } 
	  public void setDep(String s) { this.dep = s; } 
	  public String getDep() { return this.dep;}
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
	public ResultSet getPrepares(){
		String sql="select id,name from course ";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public String getPrepareDep(){
		String s="no";
		String sql="select dep from course where id='"+prepare+"' ";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){
				s=rs.getString("dep");
			}
		}catch(Exception e){e.getMessage();}
		return s;
	}
	public ResultSet getCourse(){
		String sql="select * from course ";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public int deleteCourse(String id){
		int num=0;
		String sql="delete from course where id ='"+id+"' ";
		sqlBean db =new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
	public String getPreparDep(String id){
		String dep="";
		String sql="select dep from course where id='"+id+"'";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next())dep=rs.getString("dep");
		}catch(SQLException e){System.out.print(e.toString());}
		return dep;
    }
	public void addCourse(){
		String sql="insert into classes(id,name,mark,prepare,dep) "+
			"values('"+id+"','"+name+"','"+mark+"','"+prepare+"','"+dep+"')";
			sqlBean db=new sqlBean();
			db.executeInsert(sql);
		}
	public void updateCourse(String id){
		String sql="update course "+
		" set name='"+name+"',prepare='"+prepare+"',"+
		"dep='"+dep+"',mark='"+mark+"' "+
		" where id='"+id+"' ";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public boolean hasLogin(String id){
		boolean f=true;
		String sql="select if from course where id ='"+id+"' ";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){f=false;}
		}catch(Exception e){e.getMessage();}
		return f;
		}
}
