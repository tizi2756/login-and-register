<%--
  Created by IntelliJ IDEA.
  User: 浩
  Date: 2018/6/22
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <div>
        <form action="/set_Register" method="post">
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
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
