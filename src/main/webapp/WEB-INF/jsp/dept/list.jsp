<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>部门列表</title>
</head>
<body>
    <center>
        <h3>部门列表</h3>

        <br>
        <table width="600px;" border="1">
           <tr><td>名称</td><td>位置</td><td>操作</td></tr>
            <c:forEach items="${deptList}" var="dept">
                <tr><td>${dept.dname}</td><td>${dept.loc}</td>
                    <td>
                        <a href="">更新</a>
                  &nbsp;&nbsp; <a href="">删除</a></td></tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
