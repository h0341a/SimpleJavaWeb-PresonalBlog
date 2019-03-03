package com.servlet;

import com.dao.PostDAO;
import com.entity.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        PostDAO postDAO = new PostDAO();
        Post post = postDAO.getPost(postId);
        if(post != null){
            req.getSession().setAttribute("currPost", post);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/post.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
