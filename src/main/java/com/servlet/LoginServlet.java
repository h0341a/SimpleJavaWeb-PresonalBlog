package com.servlet;

import com.dao.PostDAO;
import com.dao.UserDAO;
import com.entity.Post;
import com.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("GBK");
        User user = new User(req.getParameter("username"), req.getParameter("password"));
        UserDAO userDAO = new UserDAO();
        PostDAO postDAO = new PostDAO();
        user = userDAO.login(user);
        if(user != null){
            List allPosts = postDAO.getAllPosts(user.getUserId());
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("allPosts", allPosts);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }else
            resp.getWriter().println("<script>window.alert('登录失败');window.location.href='login.jsp';</script>");
    }
}
