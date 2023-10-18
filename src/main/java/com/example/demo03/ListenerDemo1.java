package com.example.demo03;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ListenerDemo1 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null){
            onlineCount = 1;
        }else {
            onlineCount = onlineCount + 1;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null){
            onlineCount = 0;
        }else {
            onlineCount = onlineCount - 1;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }
}
