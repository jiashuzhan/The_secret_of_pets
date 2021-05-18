<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
<% String base = request.getContextPath() + "/"; %>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=utf-8"/>
     <title>所有班级</title>
    <meta charset="utf-8">
    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

</head>
<jsp:useBean id="cla" scope="page" class="tzc.bean.classp"/>
<body bgcolor="#F5F5DC" TEXT="#4682B4" link="#4682B4">
    <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">选课系统——教师登录</strong>
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
                    <a href="<%=base %>login.jsp">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>    
            </ul>
                    
            <div class="ibox float-e-margins" >
        <div class="ibox-content">
        <div>
       <%
String id="",tea_id="",cour_id="",room_id="",cour_time="",cour_name="",tea_name="";
%>
<div align="center">
<p>
<font color="#4682B4" size="+3" face="宋体">所有班级</font></p>
<p align="left"><font color="#4682B4" SIZE="+1" face="宋体">
<a href="/course/AddClass.jsp">新增班级</a></font></p>
<table width="75%" border="1">
<tr>
<td>班级号</td>
<td>教师</td>
<td>教师号</td>
<td>课程</td>
<td>课程号</td>
<td>教师ID</td>
<td>上课时间</td>
<td>删除</td>
<td>更新</td>
</tr>
<%
ResultSet rs=cla.getClasses();
while(rs.next())
{
id=rs.getString("id");
tea_id=rs.getString("tea_id");
room_id=rs.getString("room_id");
cour_time=rs.getString("cour_time");
cour_name=rs.getString("cour_name");
tea_name=rs.getString("tea_name");
 %>
 <tr>
 <td><%=id %></td>
 <td><%=tea_name %></td> 
 <td><%=tea_id %></td>
 <td><%=cour_name %></td>
 <td><%=cour_id %></td>
 <td><%=room_id %></td>
 <td><%=cour_time %></td> 
 <td><a href="ClassSvlt?action=delete&id=<%=id %>">删除</a></td>
 <td><a href="/course/updateClass.jsp?id=<%=id %>&tea_id0=<%=tea_id %>&cour_time0=<%=cour_time %>">更新</a></td>
 </tr>
 <%} %>

        </nav>
       </div>
     
        <div class="footer">
            <div class="pull-right">
                <%= new java.util.Date() %>
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
