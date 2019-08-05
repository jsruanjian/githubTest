<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allusers.jsp' starting page</title>
  
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	
	<script type="text/javascript">
	   $(function(){
	      $(".delete").click(function(){
	          var href=$(this).attr("href");
	          $("form").attr("action",href).submit();
	          return false;
	      
	      });
	   
	   })
	</script>
    
  </head>
  
  <body>
     <br>
     <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
     </form>
     
     <c:if test="${empty requestScope.users}">
                         没有用户信息
     </c:if>
     <c:if test="${!empty requestScope.users }">
         <table border="1" cellpadding="10" cellspacing="0">
            <tr>
               	<th>ID</th>
	            <th>userName</th>
	            <th>password</th>
	            <th>age</th>
	            <th>Edit</th>
	            <th>Delete</th>
            </tr>
            <c:forEach items="${requestScope.users }" var="user">
               <tr>
                  <td>${user.id}</td>
               <td>${user.username}</td>
               <td>${user.password}</td>
               <td>${user.age}</td>
               <td><a href="user/${user.id}">Edit</a></td>
               <td><a  class="delete" href="user/${user.id}">Delete</a></td>
               </tr>
            
            </c:forEach>
         
         </table>
        
     </c:if>
     <a href="user">新增用户</a>
  </body>
</html>
