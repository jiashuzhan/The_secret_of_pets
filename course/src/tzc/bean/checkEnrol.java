package tzc.bean;

import java.sql.*;

public class checkEnrol {

	//判断是否已经完成预修课
	public boolean hasPassPrepare(String prepare){
	boolean f=false;
	int a=0;
	String temp=null;
	String sql="select score "+"from enrol, classes , course "+" where enrol.class_id=classes.id "+"and classes.cour_id=course.id "+"and course.id='"+prepare+"' ";
	sqlBean db=new sqlBean ();
	try{
	ResultSet rs= db.executeQuery(sql);
	if(rs.next ())
	temp=rs.getString("score");
	}
	catch(SQLException e){System. out. print (e.toString ());
	}
	if(temp==null|| temp.equals(""))
	return false;
	else{
		try{
			a=Integer.parseInt (temp);
		}
		catch(NumberFormatException e)
		{
		System.out.print(e.toString());}
		if(a>=60) f=true;}
		return f;
	}
	//该学生是否已经注册该课程
	public boolean hasLogin (String stu_id, String cour_id){
	boolean f=true;
	String sql="select stu_id, class_id "+"from enrol,classes "+"where stu_id='"+stu_id+"' "+"and classes.id=enrol.class_id "+"and cour_id='"+cour_id+"' ";
	sqlBean db =new sqlBean ();
	try{
	ResultSet rs=db.executeQuery (sql);
	if(rs.next()){
		f=false;
	}
	else {
		f=true; 
	}}
	catch(Exception e){
		e.getMessage(); }
	return f;
}
	//根据学生ID获取其选择的课程信息
	public ResultSet getCourse(String stu_id)
	{
		String sql="select DISTINCT course.id, course.name, course.prepare,course.dep, "+"classes.id as class_id, classes.room_id,classes.cour_time, teacher.name as tea_name "+
		"from course, classes, teacher "+"where classes.cour_id=course.id "+"and classes.tea_id=teacher.id "+"and classes.id in "+
		"( select classes.id from classes, student,course "+
		"where classes.id not in( select class_id from enrol where stu_id='"+stu_id+"') "+"and(student.department=course.dep or course.dep ='public')"+"and course.id=classes.cour_id and student.id='"+stu_id+"') ";
    sqlBean db=new sqlBean();
	ResultSet rs= db.executeQuery (sql);
	return rs;
}
	//根据学生的ID,获得其全部的学分
	public String getTotalMark(String id){
	String temp="0";
	sqlBean db= new sqlBean();
	String sql="select mark from student where id='"+id+"' ";
	ResultSet rs= db.executeQuery (sql);
	try{	
		if(rs.next())
	temp=rs.getString("mark");
	}
	catch(Exception e){}
	return temp;
	}
	
	//更新学生信息
	public int updatestu(String pw, String id, String e_mail, String tel){
	int num=0;
	String sql="update student set password='"+pw+"',e_mail='"+e_mail+"',+tel='"+tel+"' where id='"+id+"' ";
	sqlBean db= new sqlBean();
	num=db.executeInsert(sql);
	return num;
}
	public int enrol(String class_id,String stu_id)
	{
		int num=0;
		String sql="insert into enrol(stu_id,class_id) "+" values('"+stu_id+"','"+class_id+"') ";
		sqlBean db=new sqlBean();
		num=db.executeInsert(sql);
		return num;
	}
}
