<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/23
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <center>
        <h3>用户登录</h3>
        <div style="color: red;">${errorInfo}</div>
       <form action="${pageContext.request.contextPath}/user/login.do" method="post">
            <table width="600px;" border="1">
               <tr align="center"><td>用户名</td><td><input type="text" name="userName"></td></tr>
               <tr align="center"><td>密码</td><td><input type="text" name="passWord"></td></tr>
               <tr align="center"><td colspan="2"><input type="submit" value="登录" ></td></tr>
            </table>
       </form>
    </center>
</body>
</html>
