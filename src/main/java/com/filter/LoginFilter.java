package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String reqURI = req.getRequestURI();
        if(reqURI.contains("login") || reqURI.contains("register")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //从session中取出已登录的凭证,凭证为用户ID;
        Integer userId = (Integer) session.getAttribute("userId");
        if(userId == null){
            resp.sendRedirect("login.jsp");
        }else{
            filterChain.doFilter(req, resp);
        }
    }
}
