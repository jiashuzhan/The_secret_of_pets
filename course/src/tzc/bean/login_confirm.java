package tzc.bean;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login_confirm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login_confirm() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
	
		String message=null;
		String id=null;
		//�����û��ĵ�¼��
		id=req.getParameter("id");
		//���� HttpSession����
		HttpSession session=req.getSession(true);
		//���û������� session��
		session. setAttribute("id", String.valueOf(id));
		String password=null;
		//�����û�����
		password= req.getParameter("password");
		String kind =null;
		//�����û�����
		kind=req.getParameter("kind");
		//���� getPassword����,��ȡ���ݿ��Ж�ѯ����������
		String temp=getPassword(req, res, id, kind);
		//����ѯ����������û�����������Ƿ�ƥ��
		if(password.equals(temp))
		//����������ȷ,����goo����
		goo(req, res, kind);
		else 
		{
		//�����������
		message="�û�������������";
		doError(req, res, message);
		}
	}
	
	
	public void goo(HttpServletRequest req, HttpServletResponse res,String kind)
	throws ServletException, IOException {
			//ת��ѧ������ҳ��
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
			if(kind.equals("student"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/DisplayCourse.jsp");
				rd.forward(req,res);	
			}
			//ת���ʦ����ҳ��
			if(kind.equals("teacher")){
			RequestDispatcher rd=getServletContext().getRequestDispatcher ("/home.jsp");
			rd.forward (req, res);
			}
			//ת�����Ա����ҳ��
			if(kind.equals("admin")){
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(req, res);
			}
	}

	//�����û��ļ����������û���,��ѯ��Ӧ������
	public String getPassword(HttpServletRequest req,HttpServletResponse res, String id, String kind) throws
	ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
	//�������ݿ�������sq1Bean��ʵ��
	sqlBean db= new sqlBean();
	String pw="";
	String sql="select password from "+kind+" where id='"+id+"'";
	try{
	//�������ݿ��ѯ����
	ResultSet rs=db.executeQuery (sql);
	if(rs.next()){
	pw= rs.getString("password");
	}}
	catch(Exception e){
	System.out.print (e.toString());}
	return pw;
	}

	public void doError(HttpServletRequest req,HttpServletResponse res, String str) throws
	ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		req.setAttribute("problem", str);
		RequestDispatcher rd=getServletContext().getRequestDispatcher ("/errorpage.jsp");
				rd.forward(req, res);
		}
				//��ӦGet����
				public void doget (HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException{
				String action = req. getParameter("action");
				//����û�����������Ƿ�����˳�����,���������ת��ϵͳ����ҳ
				if ("logout".equalsIgnoreCase (action)){
				HttpSession session=req.getSession(true);
				session.invalidate ();
				RequestDispatcher rd=getServletContext(). getRequestDispatcher("/login.jsp");
				rd.forward(req, res);
				}
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
