<%@ page import="com.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%out.println(session.getAttribute("username"));%>的主页</title>
</head>
<body>
<%
    List<Post> allPosts= (List<Post>) session.getAttribute("allPosts");
%>
<h2>欢迎你,<%out.println(session.getAttribute("username"));%></h2>
<a href="logoutServlet">登出</a>
<a href="newPost.jsp">新建帖子</a>
<hr>
<%
    if(allPosts != null) {
        for (Post post : allPosts) {
            out.println("<a href=\"posts?postId=" + post.getPostId() + "\">" + post.getTitle() +"</a></br>");
        }
    }
%>
</body>
</html>
