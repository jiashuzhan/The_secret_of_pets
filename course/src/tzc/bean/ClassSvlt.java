package tzc.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassSvlt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ClassSvlt() {
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
		String class_id =req.getParameter("id");
		String action=req.getParameter("action");
		int success=0;
		classp cla=null;
		String message="";
		//如果请求中包含新建班级参数
		if ("new".equalsIgnoreCase(action)){
		//调用新建班级方法
		//并将新建班级存储在 request上下文中,然后转向getC1ass.jsp页面
		cla= doNew(req, res);
		sendBean(req,res,cla,"/getClass.jsp");
		}
		if("update".equalsIgnoreCase(action)){
			try{
				cla=doUpdate(req,res,class_id);
				sendBean(req,res,cla,"/getClass.jsp");
			}
			catch(SQLException e){}
			}
		if("delete".equalsIgnoreCase(action)){
				
			try{
				success= doDelete(class_id);
			}
			catch(SQLException e){}
			
				if(success !=1){
				doError(req, res, "ClassSvlt: Delete unsuccessful.Rows affected: "+success);
				}else{
					res.sendRedirect("/course/getClass.jsp");
				}
				//定义新建班级方法
		}
	}
		public classp doNew(HttpServletRequest req ,HttpServletResponse res )
		throws ServletException, IOException{
		classp cla= new classp();
		String class_id=req.getParameter("id");
		String tea_id=req.getParameter("tea_id");
		String cour_id=req.getParameter("cour_id");
		String room_id=req.getParameter("room_id");
		String cour_time=req.getParameter ("cour_time");
		if(isTrue(req,res,class_id)&& hasMoreclass(tea_id, cour_time, req,res)){
		cla.setId(class_id);
		cla.setTea_id(tea_id);
		cla.setCour_id(cour_id);
		cla.setRoom_id(room_id);
		cla.setCour_time(cour_time);
		cla.addClass();
		}
		return cla;
	}
		public boolean hasMoreclass(String tea_id,String cour_time,HttpServletRequest req ,HttpServletResponse res)
		throws ServletException, IOException{
			boolean f=true;
			String temp="";
			String message="";
			classp cla=new classp();
			temp=cla.hasMoreclass(tea_id, cour_time);
			if (temp=="no")f=true;
			else {
			f=false;
			message="对不起,该教师("+tea_id+")在"+cour_time+"时间已经安排有课"
			+temp+"";
			doError(req, res, message);
			}
			return f;
		}
		
		public boolean hasChange(String tea_id,String cour_time,HttpServletRequest req ,HttpServletResponse res)
		throws ServletException, IOException{
			boolean f=false;
			String tea_id0=req.getParameter("tea_id0");
			String cour_time0=req.getParameter("cour_time0");
			if(!tea_id.equals(tea_id0)||!cour_time.equals (cour_time0))
			f=true;
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
		public classp doUpdate(HttpServletRequest req ,HttpServletResponse res ,String id)
		throws ServletException, IOException,SQLException{
			classp cla=new classp();
			String tea_id=req.getParameter("tea_id");
			String cour_id=req.getParameter("cour_id");
			String room_id=req.getParameter("room_id");
			String cour_time=req.getParameter("cour_time");
			if(hasChange(tea_id, cour_time ,req,res)){
			if(hasMoreclass(tea_id, cour_time, req, res)){
			cla.updateClass(id,tea_id, cour_id, room_id, cour_time);
			}}else{
			cla.updateClass(id, cour_id, room_id);
			}
			return cla;
		}
			//删除班级
			public int doDelete(String id) throws SQLException{
			int num=0;
			classp cla=new classp();
			num=cla.deleteClass(id);
			return num;
		}
			
			
			public void sendBean(HttpServletRequest req ,HttpServletResponse res,classp cla,String target)
			throws ServletException, IOException{
				req.setAttribute("cla", cla);
				RequestDispatcher rd=getServletContext().getRequestDispatcher(target);
				rd.forward(req, res);
			}
			public void doError(HttpServletRequest req ,HttpServletResponse res ,String str)
			throws ServletException, IOException{
				req.setAttribute("problem", str);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
				rd.forward(req, res);
			}
			
			public boolean isTrue(HttpServletRequest req ,HttpServletResponse res ,String id)
			throws ServletException, IOException{
				
				classp cla= new classp();
				boolean f=true;
				String message="";
				if(id==null || id.equals("")){
				f=false;
				message="错误,班级号不能为空!";
				doError(req, res, message);}
				if(cla.hasLogin(id)){
				f=false;
				message="对不起,班级("+id+")已经注册了!";
				doError(req, res, message);
				}
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
