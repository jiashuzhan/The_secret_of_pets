<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<%@ page import="tzc.bean.*"%>
<!DOCTYPE html>
<html>
<% String base = request.getContextPath() + "/"; %>
<head>
	<meta http-equiv="Content-Type" content="text/html"; charset=utf-8"/>
	<title>更新班级</title>

    <meta charset="utf-8">
    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

</head>
<jsp:useBean id="classp" scope="page" class="tzc.bean.classp"/>
<body bgcolor="#F5F5DC" TEXT="#4682B4" link="#4682B4">
    <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">选课系统</strong>
                             </span>  </span> </a>
                        
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                
                <li>
                    <a href="<%=base %>getClass.jsp"><i class="fa fa-pie-chart"></i> <span class="nav-label">班级管理</span>  </a>
                </li>
                <li>
                    <a href="<%=base %>getcourse.jsp"><i class="fa fa-flask"></i> <span class="nav-label">课程管理</span></a>
                </li>
                <li>
                    <a href="<%=base %>getStudent.jsp"><i class="fa fa-flask"></i> <span class="nav-label">学生管理</span></a>
                </li>
                <li>
                    <a href="<%=base %>getteacher.jsp"><i class="fa fa-flask"></i> <span class="nav-label">教师管理</span></a>
                </li>
                
            </ul>


        </div>
    </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">欢迎登录选课系统</span>
                </li>
                              <li>
                    <a href="login.jsp">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>    
            </ul>
                    
            <div class="ibox float-e-margins" >
        <div class="ibox-content">
      
		<%
			String id=request.getParameter("id");
			String tea_id="",cour_id="",room_id="",cour_time="",name="";
		%>
		<div align="center">
		<font color="#4682B4" size="+3" face="宋体">更新班级</font>
		<form method="post" action="servlet/ClassSvlt">
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="id" value="<%=id %>"/>
		<table width="40%" border="1"></table>
		<tr>
		<td width="34%">教师</td>
		<td width="66%"><select name="tea_id" size="1" id="tea_id">
		<%
		ResultSet rs=classp.getTeachars();
		while(rs.next())
		{
		id=rs.getString("id");
		name=rs.getString("name");
		 %>
		 <option value="<%=id %>"><%=name %></option>
		 <%} %>
		 </select>
		 </td>
		</tr>
		&nbsp
		<tr>
		<td>课程</td>
		<td><select name="cour_id" id="cour_id">
		<% 
		rs=classp.getCourses();
		while(rs.next())
		{
		id =rs.getString("id");
		name=rs.getString("name");
		%>
		<option value="<%=id %>"><%=name %></option>
		<%} %>
		 </select></td>
		 </tr>
		 &nbsp
		 <tr>
		 <td>教室</td>
		 <td><select name="room_id" size="1" id="room_id">
		<option>101></option>
		<option>102></option>
		<option>103></option>
		<option>104></option>
		<option>105></option>
		<option>201></option>
		<option>202></option>
		<option>203></option>
		<option>204></option>
		<option>205></option>
		<option>301></option>
		<option>302></option>
		<option>303></option>
		<option>304></option>
		<option>305></option>
		<option>306></option>    
		 </select></td>
		 </tr>
		 &nbsp
		 <td>上课时间</td>
		 <td><select name="cour_time" size="1" id="cour_time">
		 <option value="Mon_1">星期一/一节</option>
		 <option value="Mon_2">星期一/二节</option>
		 <option value="Mon_3">星期一/三节</option>
		 <option value="Tues_1">星期二/一节</option>
		 <option value="Tues_2">星期二/二节</option>
		 <option value="Tues_3">星期二/三节</option>
		 <option value="Wed_1">星期三/一节</option>
		 <option value="Wed_2">星期三/二节</option>
		 <option value="Wed_3">星期三/三节</option>
		 <option value="Thurs_1">星期四/一节</option>
		 <option value="Thurs_2">星期四/二节</option>
		 <option value="Thurs_3">星期四/三节</option>
		 <option value="Fri_1">星期五/一节</option>
		 <option value="Fri_2">星期五/二节</option>
		 <option value="Fri_3">星期五/三节</option>
		 </select>
		 </td>  
		
		<br/>
		<br/>
		<br/>
		<br/>
		 <p>
		 <input name="Submit" type="submit"value="确定">
		 </p>

		 <%
		 String tea_id0=request.getParameter("tea_id0");
		 String cour_time0=request.getParameter("cour_time0");
		  %>
		 <input type="hidden" name="tea_id0" value="<%=tea_id0%>">
		  <input type="hidden" name="cour_time0" value="<%=cour_time0 %>">
		  </form>

		  </div>
        
        
        
        
    </div>
    </div>
    </div>

    <!-- Mainly scripts -->
    <script src="<%=base %>js/jquery-3.1.1.min.js"></script>
    <script src="<%=base %>js/bootstrap.min.js"></script>
    <script src="<%=base %>js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=base %>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>


</body>
</html>

