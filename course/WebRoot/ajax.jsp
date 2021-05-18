<%@ page contentType="text/html; charset=gb2312"  pageEncoding="UTF-8"%> 
<%@page import="java.sql.*"%>  
<% String base = request.getContextPath() + "/"; %>  
<%
String dbName = "TheSecretOfPet";
String username = "sa";
String password = "123456";
String host = "127.0.0.1";
int port = 1433;
String connectionUrl = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName + ";user=" + username
+ ";password=" + password;
//声明需要使用的资源
// 数据库连接，记得用完了一定要关闭
Connection con1 = null;
// Statement 记得用完了一定要关闭
Statement stmt = null;
// 结果集，记得用完了一定要关闭
ResultSet rs2 = null;
// 注册驱动
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
// 获得一个数据库连接
con1 = DriverManager.getConnection(connectionUrl);
String SQL = "SELECT * from PetInnerInformation";
// 创建查询
stmt = con1.createStatement();
// 执行查询，拿到结果集
rs2 = stmt.executeQuery(SQL);
%>
    <%  
    //设置输出信息的格式及字符集  
    response.setContentType("text/xml; charset=UTF-8");  
    response.setHeader("Cache-Control","no-cache");  
    out.println("<response>");  
      
    rs2.next();
    
    out.println("<name>"+ rs2.getString(4)+"</name>"); 
    out.println("<shiwen>"+ rs2.getString(3)+"</shiwen>"); 
    
    out.println("</response>");  

    %>   