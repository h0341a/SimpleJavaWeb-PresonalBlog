<%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 19-2-28
  Time: 下午1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="registerServlet" method="post">
        <label>
            用户名:<input type="text" name="username"><br>
        </label>
        <label>
            密码:<input type="password" name="password"><br>
        </label>
        <input type="submit" value="注册">
    </form>
</body>
</html>
