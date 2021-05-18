package tzc.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarkSvlt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MarkSvlt() {
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
	
		String tea_id=request.getParameter("id");
		String class_id=null;
		String score=null;
		String stu_id=null;
		//��������ύ�Ĳ���
		String action=request.getParameter("action");
		determine deter=null;
		//����������ύ�Ĳ���������ִ�в�ͬ�Ĺ���
		if("choosestu".equalsIgnoreCase(action))
		{
			deter=doChoose(tea_id);
			sendBean(request,response,deter,"/choosestu.jsp");
		}
		if("score".equalsIgnoreCase(action))
		{
			deter=doAccept2(tea_id);
			sendBean(request,response,deter,"/score.jsp");
		}
		if("marking".equalsIgnoreCase(action))
		{
			class_id=request.getParameter("class_id");
			score=request.getParameter("score");
			stu_id=request.getParameter("id");
			doMarking(request,response,stu_id,class_id,score);
			response.sendRedirect("score.jsp");
		}
		if("public".equalsIgnoreCase(action))
		{
			tea_id=request.getParameter("id");
			deter=doChoose(tea_id);
			sendBean(request,response,deter,"/public.jsp");
		}
		if("accept".equalsIgnoreCase(action))
		{
			class_id=request.getParameter("class_id");
			deter=doAccept(class_id);
			sendBean(request,response,deter,"/displaystu.jsp");
		}
		if("enrol".equalsIgnoreCase(action))
		{
			stu_id=request.getParameter("stu_id");
			class_id=request.getParameter("class_id");
			deter=doEnrol(request,response,stu_id,class_id);
			sendBean(request,response,deter,"/displaystu.jsp");
		}
	}

	
	//����ѧ���γ̵ĳɼ�
	public void doMarking(HttpServletRequest req,HttpServletResponse res,String stu_id, String class_id, String score)throws ServletException,
	IOException{
	int num=0;
	int temp=0;
	determine deter =new determine ();
	num=deter.marking(stu_id, class_id, score);
	if(num==0) 
		doError (req,res,"����ʧ��!");
	try{
	   temp=Integer.parseInt(score);
	}
	catch(NumberFormatException e){
		System.out.print(e.toString());
		doError(req,res,"��ʽ����,������!!");
	}
	if(temp>=60)
	    num=deter.addMark(stu_id, class_id);
	if(num==0) 
		doError(req,res,"����ʧ��!");
	}
	//����ѧ��ѡ��
	public determine doEnrol(HttpServletRequest req,HttpServletResponse res,String stu_id, String class_id)
	throws ServletException, IOException {
		int num=0;
		determine deter=new determine();
		num=deter.enrol(stu_id,class_id);
		if(num==0)
			doError(req,res,"����ʧ�ܣ�");
		return deter;
	}
	
	//���ݽ�ʦID,��ʾ��Ӧ�İ༶�Ϳγ���Ϣ
	public determine doChoose(String tea_id){
	determine deter =new determine();
	deter.getClass(tea_id);
	return deter;
	}
	public determine doAccept2(String class_id){
	determine deter= new determine();
	deter.getStudents(class_id);
	return deter;
	}
	//���ݰ༶ID,�õ�ѧ������ϸ��Ϣ
	public determine doAccept(String class_id){
	determine deter= new determine();
	deter.getStudents(class_id);
	return deter;
	}
    //��JavaBean����洢��request����������
	public void sendBean(HttpServletRequest req, HttpServletResponse res,determine deter,String target)
	throws ServletException,IOException{
		req.setAttribute("deter", deter);
		RequestDispatcher rd=getServletContext().getRequestDispatcher(target);
		rd.forward(req, res);
		return;
	}
	
	//������
	public void doError(HttpServletRequest req,HttpServletResponse res,String str)
	throws ServletException, IOException {
	req.setAttribute("problem", str);
	RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage jsp");
	//rd. forward(req,res);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
