package com.servlet;

import com.dao.PostDAO;
import com.entity.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreatePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("GBK");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int authorId = (int) req.getSession().getAttribute ("userId");
        Post post = new Post(title, content, authorId);
        PostDAO postDAO = new PostDAO();
        int postId = postDAO.createPost(post);
        if(postId != -1){
            HttpSession session = req.getSession();
            List<Post> allPosts = (List<Post>) session.getAttribute("allPosts");
            post.setPostId(postId);
            allPosts.add(post);
            session.setAttribute("allPosts", allPosts);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            resp.getWriter().println("<script>window.alert('创建失败');window.location.href='index.jsp';</script>");
        }
    }
}
