<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
<% String base = request.getContextPath() + "/"; %>
<head>
                    <jsp:useBean id="check" scope="page" class="tzc.bean.checkEnrol" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>选课系统</title>

    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

</head>

<body>
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
                    <a href="<%=base %>DisplayCourse.jsp"><i class="fa fa-pie-chart"></i> <span class="nav-label">选修课程</span>  </a>
                </li>
                <li>
                    <a href="<%=base %>checkmark.jsp"><i class="fa fa-flask"></i> <span class="nav-label">成绩查询</span></a>
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
        <p align="center"><font color="#4682B4" size="+3" face="宋体">您可以报选的课程为</font></p>
<table border="1" align="center">
<tr>
<td width="54">课程号</td>
<td width="54">课程名</td>
<td width="57">预修课</td>
<td width="58">系别</td>
<td width="59">班级号</td>
<td width="69">教室号</td>
<td width="88">上课时间</td>
<td width="88">教师</td>
<td width="83">选择</td>
</tr>
<p>
<%
String id=(String)session.getAttribute("id");
String cour_id,name,dep,prepare,class_id,room_id,cour_time;
String tea_name=null;
ResultSet rs=null;
rs=check.getCourse(id);
while(rs.next())
{
cour_id=rs.getString("id");
name=rs.getString("name");
prepare=rs.getString("prepare");
dep=rs.getString("dep");
class_id=rs.getString("class_id");
room_id=rs.getString("room_id");
cour_time=rs.getString("cour_time");
tea_name=rs.getString("tea_name");
 %>
 <tr>
 <td><%=cour_id %></td>
 <td><%=name %></td>
 <td><%=prepare %></td>
 <td><%=dep %></td>
 <td><%=class_id %></td>
 <td><%=room_id %></td>
 <td><%=cour_time %></td>
 <td><%=tea_name %></td>
 <td><a href="StudentLoginSvlt?action=enrol&id=<%=id %>&cour_id=<%=cour_id %>&class_id=<%=class_id %>&prepare=<%=prepare %> ">注册</a></td>
 </tr>
 <%} %>
</p>
</div>
</table>
  </div>

        </nav>
       </div>
     
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

