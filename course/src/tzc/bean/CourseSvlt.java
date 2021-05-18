package tzc.bean;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.course;

public class CourseSvlt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */


	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
		String cour_id =req.getParameter("id");
		int success=0;
		String action=action=req.getParameter("ation");
		course cour=null;
		String message="";
		if ("new".equalsIgnoreCase(action)){
		cour= doNew(req, res);
		sendBean(req,res,cour,"/getcourse.jsp");
		}
		if("update".equalsIgnoreCase(action)){
			try{
				cour=doUpdate(req,res,cour_id);
				sendBean(req,res,cour,"/getcourse.jsp");
			}
			catch(SQLException e){}
			}
		if("delete".equalsIgnoreCase (action)){
				
			try{
				success= doDelete(cour_id);
			}
			catch(SQLException e){}
				if(success !=1){
				doError(req, res, "CourseSvlt: Delete unsuccessful.Rows affected: "+success);
				}else{
					res.sendRedirect("http://localhost:8080/test/getcourse.jsp");
				}
		}
	}
		public course doNew(HttpServletRequest req ,HttpServletResponse res )
		throws ServletException, IOException{
		course cour= new course();
		String cour_id=req.getParameter("id");
		int mark;
		String name =new String(req.getParameter("name").getBytes("ISO8859_1"));
		try{
			mark=Integer.parseInt(req.getParameter("mark"));
		}catch(NumberFormatException e){mark=0;}
		String dep=new String(req.getParameter("dep").getBytes("ISO8859_1"));
		String prepare=req.getParameter("prepare");
		if(isTrue(req,res,cour_id,name)&& hasLogin(req,res,cour_id)&&isCompare(prepare,dep,req,res)){
		cour.setId(cour_id);
		cour.setName(name);
		cour.setDep(dep);
		cour.setMark(mark);
		cour.addCourse();
		}
		return cour;
	}
		public boolean isCompare(String prepare,String dep,HttpServletRequest req ,HttpServletResponse res)
		throws ServletException, IOException{
			boolean f=true;
			String tempDep=null;
			String message=null;
			course cour=new course();
			if(!prepare.equalsIgnoreCase("0")){
				tempDep=cour.getPreparDep(prepare);
				if(tempDep.equals("public"))return true;
				if(dep.equalsIgnoreCase(tempDep))
					f=true;
				else{
					f=false;
					message="错误，课程所在系与修课所在系不一致";
					doError(req, res, message);
				}}
			return f;
		}
		
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @
	 * throws IOException if an error occurred
	 */
		public course doUpdate(HttpServletRequest req ,HttpServletResponse res ,String id)
		throws ServletException, IOException,SQLException{
			course cour=new course();
			String name=new String(req.getParameter("name").getBytes("ISO8859_1"));
			int mark=Integer.parseInt(req.getParameter("mark"));
			String dep=req.getParameter("dep");
			String prepare=req.getParameter("prepare");
			if(isTrue(req,res,id,name)&&isCompare(prepare, dep, req, res)){
			cour.setName(name);
			cour.setMark(mark);
			cour.setDep(dep);
			cour.setPrepare(prepare);
			cour.updateCourse(id);
			}
			return cour;
		}
			//删除班级
			public int doDelete(String id) throws SQLException{
			int num=0;
			course cour=new course();
			num=cour.deleteCourse(id);
			return num;
		}
			
			public void sendBean(HttpServletRequest req ,HttpServletResponse res,course cour,String target)
			throws ServletException, IOException{
				req.setAttribute("cour", cour);
				RequestDispatcher rd=getServletContext().getRequestDispatcher(target);
				rd.forward(req, res);
			}
			public void doError(HttpServletRequest req ,HttpServletResponse res ,String str)
			throws ServletException, IOException{
				req.setAttribute("problem", str);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
				rd.forward(req, res);
			}
			public boolean hasLogin(HttpServletRequest req ,HttpServletResponse res,String id)
			throws ServletException, IOException{
				boolean f=true;
				String message="对不起，该课程号已经被注册过了！";
				course cour=new course();
				f=cour.hasLogin(id);
				if(f==false){
					doError(req, res, message);
				}
				return f;
			}
			public boolean isTrue(HttpServletRequest req ,HttpServletResponse res ,String id,String name)
			throws ServletException, IOException{
				boolean f=true;
				String message="";
				if(id==null || id.equals("")){
				f=false;
				message="错误,课程号不能为空!";
				doError(req, res, message);}
				
				if(name==null || name.equals("")){
					f=false;
					message="错误,课程名不能为空!";
					doError(req, res, message);}
				return f;
			}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doGet(req, res);
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Returns information about the servlet, such as 
	 * author, version, and copyright. 
	 *
	 * @return String information about this servlet
	 */
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
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
