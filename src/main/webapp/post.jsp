<%@ page import="com.entity.Post" %><%--
  Created by IntelliJ IDEA.
  User: ling
  Date: 19-3-3
  Time: 下午12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<% Post post = (Post) session.getAttribute("currPost"); %>
<body>
    <h1><% out.println(post.getTitle()); %></h1>
    <h3><% out.println(post.getContent()); %></h3>
    <hr>
    访问次数:<% out.println(post.getVisitors()); %><br>
    创建日期:<% out.println(post.getCreateDate()); %>
</body>
</html>
