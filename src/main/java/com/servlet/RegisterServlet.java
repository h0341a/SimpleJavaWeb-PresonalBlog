package com.servlet;

import com.dao.UserDAO;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("GBK");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        UserDAO userDAO = new UserDAO();
        if (userDAO.register(user)){
            resp.getWriter().println("<script>window.alert('注册成功');window.location.href='login.jsp';</script>");
        }else {
            resp.getWriter().println("<script>window.alert('注册失败');window.location.href='login.jsp';</script>");
        }
    }
}
