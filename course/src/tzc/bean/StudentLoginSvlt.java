package tzc.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.*;
import java.io.*;
import tzc.bean.*;

public class StudentLoginSvlt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentLoginSvlt() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//�����ύ�ĸ�ѡ����صĸ�����Ϣ
		String stu_id =req.getParameter("id");
		String cour_id=req.getParameter("cour_id");
		String class_id=req.getParameter ("class_id");
		String prepare=req.getParameter("prepare");
		String pw1=null;
		String pw2=null;
		String e_mail=null;
		String tel=null;
		//��������еĲ���
		String action=req.getParameter("action");
		ResultSet rs=null;
		//����������Ǹ��²���
		if ("update".equalsIgnoreCase(action))
		{
			stu_id = req.getParameter("id");
			pw1=req. getParameter("password1");
			pw2=req. getParameter("password2");
			if(pw1.equals("")||pw2.equals("")||pw1==null||pw2==null)
			doError(req,res,"���벻��Ϊ��!");
			e_mail=req.getParameter("e_mail");
			tel=req.getParameter("tel");
			doUpdate(req,res,pw1,pw2,e_mail,tel,stu_id);
			res.sendRedirect("student.jsp");
		}
		//����������Ǹ��ĳɼ�����
		if("checkmark".equalsIgnoreCase (action)) {
		rs=getScore(stu_id);
		sendResultSet (req, res, rs,"/checkmark.jsp");
		}
		//�����������ע��γ̲���
		if("enrol".equalsIgnoreCase(action)){
		doEnrol(req, res, stu_id, cour_id, class_id, prepare);
		res.sendRedirect("/course/DisplayCourse.jsp");}
		}
		
		public void doEnrol(HttpServletRequest req, HttpServletResponse res,String stu_id, String cour_id, String class_id, String prepare)
		throws ServletException, IOException {

				int num=0;
				//��ּ�� JavaBean����
				checkEnrol check=new checkEnrol();
				//���Ԥ�޿�ѧ��Ϊ0,��ע��
				if (prepare.equals("0"))
				{
				num= check.enrol(class_id, stu_id);
				}
				else 
				{
					//�ж�Ԥ�޿��Ƿ����Ҫ��
					if(check.hasPassPrepare(prepare))
					{
						num=check.enrol(class_id, stu_id);
					}
					else 
						doError(req,res,"�������Ԥ�޿�");}
				if(num==0)
				{
				doError(req,res,"ע��γ�ʧ��!!");
				}
		}
	
		//�޸�ѧ����Ϣ
		public void doUpdate(HttpServletRequest req, HttpServletResponse res,String pw1,String pw2,String e_mail,String tel,String id)
		throws ServletException,IOException {
			int num=0;
			if(!pw1.equals(pw2))
				doError(req, res, "���벻һ�£������䣡");
			checkEnrol check =new checkEnrol();
			sqlBean dbBean=new sqlBean();
			num=check.updatestu(pw1, id, e_mail, tel);
			if(num==0)
				doError(req,res,"����ʧ��");
		}
		
		public ResultSet getScore(String stu_id)
		{
			String sql="select enrol.score, course.name, course.mark "+"from enrol ,course ,classes "+"where stu_id='"+stu_id+"' "+"and enrol.class_id=classes.id "+"and classes.cour_id=course.id ";
			sqlBean db=new sqlBean();
			ResultSet rs=db.executeQuery(sql);
			return rs;
		}
		public void doError(HttpServletRequest req, HttpServletResponse res,String str)
		throws IOException, ServletException {
			req.setAttribute("problem", str);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
			rd.forward(req, res);
			return;
		}
		public void sendResultSet(HttpServletRequest req,HttpServletResponse res,java.sql.ResultSet rs,String target)
		throws IOException, ServletException {
			req.setAttribute("rs", rs);
			RequestDispatcher rd=getServletContext().getRequestDispatcher(target);
			rd.forward(req, res);
			return;
		}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
