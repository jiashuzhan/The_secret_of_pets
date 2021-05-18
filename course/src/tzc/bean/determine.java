package tzc.bean;
import java.sql.*;
import tzc.bean.*;
public class determine {
	//根据教师ID查询班级和课程信息
	public ResultSet getClass(String tea_id){
	String sql="select classes.id, course.name "+"from classes,course "+"where course.id=classes.cour_id "+"and classes.tea_id='"+tea_id+"' ";
	sqlBean sqlbean=new sqlBean();
	ResultSet rs= sqlbean.executeQuery(sql);
	return rs;
	}
	
	//根据班级ID查询学生的具体信息
	public ResultSet getStudents(String class_id){
	String sql="select student.id, name ,department, sex, mark, e_mail,tel "+
	"from student,enrol,classes "+
	"where student.id=enrol.stu_id "+
	"and enrol.accept='0' "+
	"and classes.id=enrol.class_id "+
	"and classes.id='"+class_id+"' ";
	sqlBean sqlbean= new sqlBean();
	ResultSet rs= sqlbean.executeQuery(sql);
	return rs;
}
	
	public int enrol(String stu_id,String class_id)
	{
		int num=0;
		String sql="update enrol set accept=1 "+"where stu_id='"+stu_id+"' ";
		sqlBean DB=new sqlBean();
		return num;
	}
	//给选课的学生打分 
	public int marking(String stu_id, String class_id, String score){
	int num=0;
	String sql="update enrol set accept=1 "+
	"where stu_id='"+stu_id+"' "+
	"and class_id='" +class_id+"' ";
	sqlBean db= new sqlBean ();
	num=db.executeInsert(sql);
	return num;
}
	//修改学生成绩
	public int addMark(String stu_id, String class_id){
	int num=0;
	String sql="update student "+"set student.mark=student.mark+course.mark "+
    "from student,course,classes "+"where student.id='"+stu_id+"' "+"and course.id=classes.cour_id "+"and classes.id='"+class_id+"' ";
	sqlBean db= new sqlBean ();
	num=db.executeInsert(sql);
	return num;
}
}
