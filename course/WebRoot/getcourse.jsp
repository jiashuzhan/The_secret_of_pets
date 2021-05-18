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
<jsp:useBean id="cla" scope="page" class="tzc.bean.course"/>
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
                    <a href="login.jsp">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>    
            </ul>
                    
            <div class="ibox float-e-margins" >
        <div class="ibox-content">
        <div>
       <%
String id="",name="",dep="",prepare="";
%>
<div align="center">
<p>
<font color="#4682B4" size="+3" face="宋体">所有课程</font></p>
<p align="left"><font color="#4682B4" SIZE="+1" face="宋体">
<a href="/course/AddClass.jsp">新增课程</a></font></p>
<table width="75%" border="1">
<tr>
<td>课程号</td>
<td>课程名</td>
<td>dep</td>
<td>prepare</td>
<td>删除</td>
<td>更新</td>
</tr>
<%
ResultSet rs=cla.getCourse();
while(rs.next())
{
id=rs.getString("id");
name=rs.getString("name");
dep=rs.getString("dep");
prepare=rs.getString("prepare");
 %>
 <tr>
 <td><%=id %></td>
 <td><%=name %></td> 
 <td><%=dep%></td>
 <td><%=prepare%></td> 
 <td><a href="CourseSvlt?action=delete&id=<%=id %>">删除</a></td>
 <td><a href="/course/updatecour.jsp?id=<%=id %>">更新</a></td>
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

