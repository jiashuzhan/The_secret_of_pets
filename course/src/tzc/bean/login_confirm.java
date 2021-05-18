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
		//接收用户的登录名
		id=req.getParameter("id");
		//创建 HttpSession对象
		HttpSession session=req.getSession(true);
		//将用户名存入 session中
		session. setAttribute("id", String.valueOf(id));
		String password=null;
		//接收用户密码
		password= req.getParameter("password");
		String kind =null;
		//接收用户级别
		kind=req.getParameter("kind");
		//调用 getPassword方法,获取数据库中査询出来的密码
		String temp=getPassword(req, res, id, kind);
		//检查查询出的密码和用户输入的密码是否匹配
		if(password.equals(temp))
		//密码输入正确,调用goo方法
		goo(req, res, kind);
		else 
		{
		//密码输入错误
		message="用户名或密码有误";
		doError(req, res, message);
		}
	}
	
	
	public void goo(HttpServletRequest req, HttpServletResponse res,String kind)
	throws ServletException, IOException {
			//转向学生功能页面
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
			if(kind.equals("student"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/DisplayCourse.jsp");
				rd.forward(req,res);	
			}
			//转向教师功能页面
			if(kind.equals("teacher")){
			RequestDispatcher rd=getServletContext().getRequestDispatcher ("/home.jsp");
			rd.forward (req, res);
			}
			//转向管理员功能页面
			if(kind.equals("admin")){
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(req, res);
			}
	}

	//根据用户的级别和输入的用户名,查询对应的密码
	public String getPassword(HttpServletRequest req,HttpServletResponse res, String id, String kind) throws
	ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
	//声明数据库连接类sq1Bean的实例
	sqlBean db= new sqlBean();
	String pw="";
	String sql="select password from "+kind+" where id='"+id+"'";
	try{
	//进行数据库查询操作
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
				//响应Get请求
				public void doget (HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException{
				String action = req. getParameter("action");
				//检查用户请求参数中是否包含退出参数,如果包含则转向系统的首页
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
