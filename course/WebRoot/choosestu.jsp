<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<html>
<% String base = request.getContextPath() + "/"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>选课系统</title>

    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>挑选你的学生</title>
</head>

<jsp:useBean id="deter" scope="page" class="tzc.bean.determine"/>
<body bgcolor="#F5F5DC" text="#4682B4" link="#4682B4">
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
                    <a href="<%=base %>choosestu.jsp"><i class="fa fa-pie-chart"></i> <span class="nav-label">选修课程人员</span>  </a>
                </li>
                <li>
                    <a href="<%=base %>checkmark.jsp"><i class="fa fa-flask"></i> <span class="nav-label">成绩登录</span></a>
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

        </nav>
        </div>

<div class="ibox float-e-margins" >
        <div class="ibox-content">
        <div>

<%
String tea_id=(String)session.getAttribute("id");
 %>
 <div align="center">
 <p><font color="#4682B4" size="+3" face="宋体">您所带的班级及学生</font></p>
 <p> &nbsp;</p>
 <table width="75%" border="1">
 <tr>
 <td>班级号</td>
 <td>课程号</td>
 <td>选择</td>
 </tr>
 <%
 String class_id=null;
 String cour_name=null;
 ResultSet rs=deter.getClass(tea_id);
 while(rs.next())
 {
 class_id=rs.getString("id");
 cour_name=rs.getString("name");
  %>
  <tr>
  <td><%=class_id%></td>
  <td><%=cour_name%></td>
  <td><a href="MarkSvlt?class_id=<%=class_id%>&cour_name=<%=cour_name%>&action=accept ">选择</a></td>
  </tr>
  <%} %>
  </div>
  </div>
 </table>
 </div>
        <div class="footer">
            <div class="pull-right">
                <%= new java.util.Date() %>
            </div>
            <div>
                <strong>Copyright</strong> TZC &copy; 2018
            </div>
        </div>
</body>


</html>