package com.example.ajax;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/ajaxServlet")
public class ServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");

        if ("checkUsername".equals(action)) {
            //用户名检查逻辑
            String username = request.getParameter("username");
            if (username.isEmpty()) {
                response.getWriter().write("请输入用户名");
            } else {
                //用户存在时返回 "用户名存在，请填写密码"
                if ("login".equals(username)) {
                    response.getWriter().write("<span style='color: green;'>用户名存在，请填写密码</span>");
                } else {
                    response.getWriter().write("用户不存在");
                }
            }
        } else if ("login".equals(action)) {
            //登录逻辑
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("login".equals(username) && "123456".equals(password)) {
                response.getWriter().write("登录成功");
            } else {
                response.getWriter().write("<div style='color: red;'>密码错误</div>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
