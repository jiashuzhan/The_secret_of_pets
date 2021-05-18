package tzc.bean;
import java.sql.*;

import tzc.bean.sqlBean;
public class classp{
	private String id;
	private String cour_id;
	private String tea_id;
	private String room_id;
	private String cour_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String courId) {
		cour_id = courId;
	}
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String teaId) {
		tea_id = teaId;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String roomId) {
		room_id = roomId;
	}
	public String getCour_time() {
		return cour_time;
	}
	public void setCour_time(String courTime) {
		cour_time = courTime;
	}
	public ResultSet getTeachars(){
		String sql="select id,name from teacher ";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getCourses(){
		String sql="select id,name from course ";
		sqlBean db =new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public boolean hasLogin(String id){
		boolean f=false;
		String sql="select if from classes where id ='"+id+"' ";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){f=true;}
			else {f=false;}
		}catch(Exception e){e.getMessage();}
		return f;
	}
public String hasMoreclass(String tea_id,String cour_time){
	String temp="";
	String sql="select id from classes "+
	"where tea_id='"+tea_id+"' and cour_time='"+cour_time+"' ";
	sqlBean db=new sqlBean();
	try{
		ResultSet rs=db.executeQuery(sql);
		if(rs.next()){temp=rs.getString("id");}
		else {temp="no";}
	}catch(Exception e){System.out.print(e.getMessage());}
	return temp;
}
public void addClass(){
	String sql="insert into classes(id,tea_id,cour_id,room_id,cour_time) "
		+"values('"+id+"','"+tea_id+"','"+cour_id+"','"+room_id+"','"+cour_time+"')";
	try{
		sqlBean db=new sqlBean();
		db.executeInsert(sql);}catch(Exception e){System.out.print(e.toString());}
	}
public void updateClass(String id,String tea_id,String cour_id,String room_id,String cour_time){
	String sql="update classes "+
	" set tea_id='"+tea_id+"',cour_id='"+cour_id+"',"+
	"room_id='"+room_id+"',cour_time='"+cour_time+"' "+
	" where id='"+id+"' ";
	sqlBean db=new sqlBean();
	db.executeInsert(sql);
}
public void updateClass(String id,String cour_id,String room_id){
	String sql="update classes "+" set cour_id='"+cour_id+"',"+
	"room_id='"+room_id+"' "+" where id='"+id+"' ";
	sqlBean db=new sqlBean();
	db.executeInsert(sql);
}
public int deleteClass(String id){
	int num=0;
	String sql="delete from classes where id ='"+id+"' ";
	sqlBean db =new sqlBean();
	num=db.executeDelete(sql);
	return num;
}
public ResultSet getClasses(){
	String sql="select classes.id,tea_id,cour_id,room_id,cour_time, "+
	"course.name as cour_name,teacher.name as tea_name "+
	"from classes ,course, teacher "+
	"where classes.cour_id=course.id "+
	"and classes.tea_id=teacher.id ";
	sqlBean db=new sqlBean();
	ResultSet rs=db.executeQuery(sql);
	return rs;
  }
}