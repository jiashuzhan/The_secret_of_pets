<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<jsp:useBean id="classp" scope="page" class="tzc.bean.classp"/>
<body>
    <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">选课系统——管理员登录</strong>
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
       
        <div>
            </ul>
          
        </nav>
        </div>
 <div class="ibox float-e-margins" >
        <div class="ibox-content">
        <%
String admin_id=(String)session.getAttribute("id");
if(admin_id==null){
response.sendRedirect("login.jsp");
}
String name="";
String id="";
 %></p>
 <p align="center"><font color="#4682B4" size="+3" face="宋体">新增班级</font></p>
 <form name="form1" method="post" action="servlet/ClassSvlt">
 <input type="hidden" name="action" value="new">
 <table width="38%" border="1" align="center">
 <tr>
 <td width="29%">班级号</td>
 <td width="71%"><input name="id" type="text" id="id2"></td>
 </tr>
 <tr>
 <td>教师</td>
 <td><select name="tea_id" size="1" id="tea_id">
 <%
 //获得全部老师的姓名和ID
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
 <tr>
 <td>课程</td>
 <td><select name="cour_id" id="cour_id">
 <%
 //获得全部课程的名称和ID
 rs=classp.getCourses();
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
 <tr>
 <td>教室ID</td>
 <td><select name="room_id" size="1" id="room_id">
 <option>101</option>
 <option>102</option>
 <option>103</option>
 <option>104</option>
 <option>105</option>
 <option>201</option>
 <option>202</option>
  <option>203</option> 
  <option>204</option>
  <option>205</option>
  <option>301</option>
  <option>302</option>
  <option>303</option>
  <option>304</option>
  <option>305</option>
 </select>
 </td>
 </tr>
 <tr>
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
 </tr>
 <p align="center">
 <input type="submit" name="Submit"  value="提交"></p>
        
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









