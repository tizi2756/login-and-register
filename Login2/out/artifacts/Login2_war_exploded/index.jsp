<%--
  Created by IntelliJ IDEA.
  User: 浩
  Date: 2018/6/10
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <link rel="stylesheet" href="Css.css">
  </head>
  <body>
 <div class="Center">
   <form action="/Servlet" method="post">
     <table>
       <tr>
         <td>用户名：</td>
         <td><input type="text" name="username" value=""></td>
       </tr>
       <tr>
         <td>密码：</td>
         <td><input type="password" name="password" value=""></td>
       </tr>
       <tr>
         <td colspan="2"><a href="Register.jsp">还没有账号？</a> </td>
       </tr>
       <tr>
         <td><input type="submit" value="登录"></td>
       </tr>
     </table>
   </form>
 </div>
  </body>
</html>
