<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="errorpage.jsp" %>

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

</head>
<jsp:useBean id="check" scope="page" class="tzc.bean.checkEnrol"/>
<body bgcolor="#F5F5DC" text="#4682B4">
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
                    <a href="<%=base %>DisplsyCourse.jsp"><i class="fa fa-pie-chart"></i> <span class="nav-label">分类管理</span>  </a>
                </li>
                <li>
                    <a href="<%=base %>checkmark.jsp"><i class="fa fa-flask"></i> <span class="nav-label">文章管理</span></a>
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
  <p align="center"><font color="#4682B4" size="+3" faCe="宋体">学生成绩</font></p>
<p>&nbsp;</p>
<table width="463" border="1" align="center">
<tr>
<td><table width="207" height="34">课程</td>
<td><table width="85">学分</td><td width="149">成绩</td></tr>
<%
//从 session中得到学生的ID
String stu_id=(String)session.getAttribute("id");
if(stu_id==null)
{
response.sendRedirect("login.jsp");
}
String score, name;
int mark=0;
//从 session中获得查询的结果集
ResultSet rs =(ResultSet)request.getAttribute("rs");
//从结果集中得到学生的成绩和姓名
while(rs.next()){
score=rs.getString("score");
name=rs.getString("name");
mark=rs.getInt("mark");
if(score.equals("0"))
score="成绩未给出";
 %>
 <tr>
<td height="34"><%=name %></td><td><%=mark %></td><td><%=score %>
</td></tr>
<%} %>
</table>
<%
String temp=check.getTotalMark(stu_id);
 %>

您的总得分为:<%=temp %>
 
  
        <div class="footer">
            <div class="pull-right">
                <%= new java.util.Date() %>
            </div>
            <div>
                <strong>Copyright</strong> TZC &copy; 2018
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
