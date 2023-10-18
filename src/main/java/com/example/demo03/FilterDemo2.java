package com.example.demo03;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(value = "/ServletDemo1")
public class FilterDemo2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤2(前置）");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request,response);
        System.out.println("放行2（后置）");
    }
}
 
