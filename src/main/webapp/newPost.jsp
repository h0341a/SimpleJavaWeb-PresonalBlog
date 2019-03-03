<%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 19-3-2
  Time: 下午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建</title>
</head>
<body>
<form action="createPostServlet" method="post">
    <label>
        标题<input type="text" name="title"><br>内容:<br>
    </label>
    <label>
        <textarea name="content"   cols="40"   rows="4"   style="OVERFLOW:hidden"></textarea>
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>
