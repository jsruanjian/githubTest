<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	
	-->
  </head>
  
  <body>
    
    This is my <h4> Spring Hibernate</h4>. <br>
    <a href="login/login?username=小王&password=111111">登陆</a>
    <br><br>
    <a href="login/getAll">显示所有用户</a>
    <br><br>
    
    
  </body>
</html>
