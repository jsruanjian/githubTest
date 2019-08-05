<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <br><br>
    <form:form action="${pageContext.request.contextPath }/user" method="post"
       modelAttribute="user">
       <br><br>
       <c:if test="${user.id==null }">
          UserName:<form:input path="username"/>
       </c:if>
       
       <c:if test="${user.id!=null }">
           <form:hidden path="id"/>
           <input type="hidden" name="_method" value="PUT"/>
           <form:input path="username"/>
       </c:if>
       <br>
       PassWord:<form:input path="password"/>
       <br>
       Age:<form:input path="age"/>
       <br>
       <input type="submit" value="Submit">
    </form:form>
  </body>
</html>
