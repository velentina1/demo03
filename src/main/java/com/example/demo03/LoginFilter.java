package com.example.demo03;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(value = "/success.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化success");
    }

    public void destroy() {
        System.out.println("销毁success");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);
        if (user == null){
            resp.sendRedirect("/test/error.jsp");
        }
        chain.doFilter(req,resp);
    }
}
 
